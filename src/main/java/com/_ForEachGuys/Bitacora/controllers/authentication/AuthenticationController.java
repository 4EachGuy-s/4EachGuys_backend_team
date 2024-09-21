package com._ForEachGuys.Bitacora.controllers.authentication;

import java.util.Map;
import org.springframework.http.HttpStatus;
// Importaciones necesarias para las clases y servicios usados en el controlador
import org.springframework.http.ResponseEntity; // Para manejar respuestas HTTP
import org.springframework.security.authentication.AuthenticationManager; // Para autenticar usuarios
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Token de autenticación basado en nombre de usuario y contraseña
import org.springframework.web.bind.annotation.*; // Anotaciones para controlar solicitudes HTTP
import org.springframework.web.server.ResponseStatusException;

import com._ForEachGuys.Bitacora.config.security.ManagerCookies;
import com._ForEachGuys.Bitacora.repositories.models.jwt.JWTRequest;
import com._ForEachGuys.Bitacora.services.jwt.JWTService;
import com._ForEachGuys.Bitacora.services.jwt.JWTUserDetailService;
import com._ForEachGuys.Bitacora.utils.exceptions.NotFoundException;
import com._ForEachGuys.Bitacora.utils.validaciones.ValidarToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor; // Genera un constructor con todos los campos como parámetros



@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/api/v1/auth") // Mapea las solicitudes a la ruta base "/auth"
@AllArgsConstructor // Genera un constructor con todos los campos como parámetros
public class AuthenticationController {

    //* Servicios */
    private final AuthenticationManager authenticationManager; // Se usa para autenticar a los usuarios
    private final JWTService jwtService; // Se usa para generar tokens JWT
    private final JWTUserDetailService jwtUserDetailService;

    /**
     * Endpoint para manejar el inicio de sesión de los usuarios.
     * @param username Nombre de usuario proporcionado en la solicitud.
     * @param password Contraseña proporcionada en la solicitud.
     * @return Respuesta HTTP con el token JWT si la autenticación es exitosa, o un mensaje de error en caso contrario.
     */
    @PostMapping("/login")
    public ResponseEntity<?> postToken(@RequestBody JWTRequest request, HttpServletResponse response) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("Message", "Solicitud inválida"));
        }
        else {
            this.authenticate(request);
            final var userDetails = this.jwtUserDetailService.loadUserByUsername(request.getUsername());

            final var token = this.jwtService.generateToken(userDetails);

            // Crear cookie
            ManagerCookies.crearCookieJWT(response, "auth_token", token, (int) JWTService.JWT_TOKEN_VALIDITY);

            // Redirigir a la página de inicio
            return ResponseEntity.ok(Map.of("Message", "Ingreso exitoso", "status", 200));
        }
    }

    private void authenticate(JWTRequest request) {
        try {
            this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword())
            );
        } catch (BadCredentialsException bc) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
        } catch (DisabledException ds) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuario deshabilitado");
        } catch (NotFoundException nf) {
            System.out.println(nf.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró");
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<Boolean> validarSesion(HttpServletRequest request) {
        boolean authenticado = ValidarToken.validar(request.getCookies());

        return ResponseEntity.ok(authenticado);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<Boolean> getMethodName(HttpServletResponse response) {
        System.out.println(response);        
        ManagerCookies.eliminarCookie(response, "auth_token");
        return ResponseEntity.ok(true);
    }
    
}