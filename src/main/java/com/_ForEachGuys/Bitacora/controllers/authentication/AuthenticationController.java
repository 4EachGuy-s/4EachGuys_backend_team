package com._ForEachGuys.Bitacora.controllers.authentication;

// Importaciones necesarias para las clases y servicios usados en el controlador
import org.springframework.http.ResponseEntity; // Para manejar respuestas HTTP
import org.springframework.security.authentication.AuthenticationManager; // Para autenticar usuarios
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Token de autenticación basado en nombre de usuario y contraseña
import org.springframework.security.core.Authentication; // Representa una autenticación de un usuario
import org.springframework.security.core.AuthenticationException; // Excepción lanzada durante la autenticación
import org.springframework.security.core.userdetails.UserDetails; // Proporciona detalles del usuario
import org.springframework.web.bind.annotation.*; // Anotaciones para controlar solicitudes HTTP

import com._ForEachGuys.Bitacora.services.jwt.JWTService;

import lombok.AllArgsConstructor; // Genera un constructor con todos los campos como parámetros

@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/api/v1/auth") // Mapea las solicitudes a la ruta base "/auth"
@AllArgsConstructor // Genera un constructor con todos los campos como parámetros
public class AuthenticationController {

    //* Servicios */
    private final AuthenticationManager authenticationManager; // Se usa para autenticar a los usuarios
    private final JWTService jwtService; // Se usa para generar tokens JWT
    //private final PersonasService personasService;

    /**
     * Endpoint para manejar el inicio de sesión de los usuarios.
     * @param username Nombre de usuario proporcionado en la solicitud.
     * @param password Contraseña proporcionada en la solicitud.
     * @return Respuesta HTTP con el token JWT si la autenticación es exitosa, o un mensaje de error en caso contrario.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            // Intentar autenticar al usuario usando el AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            // Obtener detalles del usuario autenticado
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Generar un token JWT usando el JWTService
            String jwt = jwtService.generateToken(userDetails);

            // Devolver una respuesta HTTP 200 con el token JWT en el encabezado "Authorization"
            return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).body("Login successful");

        } catch (AuthenticationException e) {
            // Manejar la excepción de autenticación fallida
            return ResponseEntity.status(401).body("Authentication failed: " + e.getMessage());
        }
    }

}