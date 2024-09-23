package com._ForEachGuys.Bitacora.services.jwt;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.repositories.entities.Persona;
import com._ForEachGuys.Bitacora.repositories.interfaces.PersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

	private final PersonaRepository personaRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Persona> persona = this.personaRepository.findByEmail(username)
							.or(() -> personaRepository.findByDni(Integer.parseInt(username)));

		if(persona.isPresent()) {
			return persona
				.map(usuario -> {
					System.out.println("Rol " + usuario.getRol().getNombre().name());
					Set<GrantedAuthority> authorities = new HashSet<>();
					authorities.add(new SimpleGrantedAuthority(
					usuario.getRol().getNombre().name()));
					return new User(usuario.getEmail(), usuario.getPassword(), authorities);
				})
				.orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
		}

		else {
			throw new UsernameNotFoundException("Usuario no encontrado con username: " + username);
		}
	}
}
