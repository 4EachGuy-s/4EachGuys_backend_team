package com._ForEachGuys.Bitacora.shared.infrastructure.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com._ForEachGuys.Bitacora.shared.application.jwt.JWTUserDetailService;
import com._ForEachGuys.Bitacora.shared.infrastructure.security.filtros.JWTValidationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private final String[] AUTHENTICATED_PATHS = {};

        private final String[] WHITE_LIST = {
                "/api/v1/auth/login",
                "/api/v1/auth/logout",
                "/error"
        };

        private final String[] COLABORADOR_PATHS = {};

        private final String[] ADMINISTRADOR_PATHS = {};

        @Autowired
        public JWTValidationFilter jwtValidationFilter;

        @SuppressWarnings("unused")
        private final JWTUserDetailService jwtUserDetailService;

        public SecurityConfig(JWTUserDetailService jwtUserDetailService) {
                this.jwtUserDetailService = jwtUserDetailService;
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http)
                        throws Exception {

                http.csrf(csrf -> csrf.disable());
                http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                http.authorizeHttpRequests(auth -> auth
                                .requestMatchers(AUTHENTICATED_PATHS).authenticated()
                                .requestMatchers(ADMINISTRADOR_PATHS).hasRole("ADMINISTRADOR")
                                .requestMatchers(COLABORADOR_PATHS).hasRole("COLABORADOR")
                                .requestMatchers(WHITE_LIST).permitAll()
                                .anyRequest().authenticated())
                                .addFilterBefore(jwtValidationFilter, BasicAuthenticationFilter.class);

                http.httpBasic(
                                basic -> basic.disable());
                http.formLogin(
                                form -> form.disable());
                http.cors(cors -> corsConfigurationSource());

                return http.build();
        }

        @SuppressWarnings("deprecation")
        @Bean
        PasswordEncoder passwordEncoder() {
                return NoOpPasswordEncoder.getInstance();
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                var config = new CorsConfiguration();

                config.setAllowedOrigins(List.of("http://localhost:4200"));
                config.setAllowedMethods(List.of("*"));
                config.setAllowedHeaders(List.of("*"));
                config.setAllowCredentials(true);

                var source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", config);

                return source;
        }

        @Bean
        AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
                return configuration.getAuthenticationManager();
        }
}
