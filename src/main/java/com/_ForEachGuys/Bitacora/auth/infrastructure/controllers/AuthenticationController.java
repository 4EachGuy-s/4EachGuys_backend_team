package com._ForEachGuys.Bitacora.auth.infrastructure.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com._ForEachGuys.Bitacora.auth.domain.entity.JWTRequest;
import com._ForEachGuys.Bitacora.auth.domain.entity.JWTResponse;
import com._ForEachGuys.Bitacora.shared.application.jwt.JWTService;
import com._ForEachGuys.Bitacora.shared.application.jwt.JWTUserDetailService;
import com._ForEachGuys.Bitacora.shared.infrastructure.security.ManagerCookies;
import com._ForEachGuys.Bitacora.shared.infrastructure.utils.exceptions.NotFoundException;
import com._ForEachGuys.Bitacora.shared.infrastructure.utils.validaciones.ValidarToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;


@RestController 
@RequestMapping("/api/v1/auth") 
@AllArgsConstructor 
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
            return ResponseEntity.badRequest().body(Map.of("message", "Solicitud inválida"));
        }
        else {
            this.authenticate(request);
            final var userDetails = this.jwtUserDetailService.loadUserByUsername(request.getUsername());

            final var token = this.jwtService.generateToken(userDetails);

            // Crear cookie
            ManagerCookies.crearCookieJWT(response, "auth_token", token, (int) JWTService.JWT_TOKEN_VALIDITY);

            return ResponseEntity.ok(new JWTResponse("Ingreso exitoso", 200));
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

    /**
     * Endpoint para validar si un usuario está autenticado basado en su token.
     * @param request Request desde el front
     * @return Respuesta HTTP con booleano que indica (true) si el usuario esta autenticado
     * o (false) en caso contrario
     */

    @GetMapping("/validar")
    public ResponseEntity<Boolean> validarSesion(HttpServletRequest request) {
        boolean authenticado = ValidarToken.validar(request.getCookies());

        return ResponseEntity.ok(authenticado);
    }
    
    /**
     * Endpoint para realizar un logout eliminando el token en el front.
     * @param request Request desde el front
     * @return Respuesta HTTP con booleano (true) que indica que la cookie se eliminó.
     */

    @GetMapping("/logout")
    public ResponseEntity<Boolean> getMethodName(HttpServletResponse response) {
        System.out.println(response);        
        ManagerCookies.eliminarCookie(response, "auth_token");
        return ResponseEntity.ok(true);
    }
    
}