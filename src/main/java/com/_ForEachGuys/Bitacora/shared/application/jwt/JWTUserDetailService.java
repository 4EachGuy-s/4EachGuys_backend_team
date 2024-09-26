package com._ForEachGuys.Bitacora.shared.application.jwt;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.persona.infrastructure.repository.PersonaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

	// Repositorio personas
	private final PersonaRepository personaRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, InvalidDataAccessResourceUsageException {

		Optional<Persona> persona = personaRepository.findByEmail(username);

		if (persona.isPresent()) {
			return persona
					.map(usuario -> {
						Set<GrantedAuthority> authorities = new HashSet<>();
						authorities.add(new SimpleGrantedAuthority(
								usuario.getRol().getNombreRol()));
						return new User(usuario.getContacto().getCorreoElectronico(), usuario.getPassword(), authorities);
					})
					.orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
		}

		else {
			throw new UsernameNotFoundException("Usuario no encontrado con username: " + username);
		}
	}
}