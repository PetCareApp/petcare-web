package br.com.petcare.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import br.com.petcare.model.Usuario;
import br.com.petcare.repository.UsuarioRepository;
import br.com.petcare.util.Constants;

@Named
public class PetcareAuthenticationProvider implements AuthenticationProvider {
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Usuario usuario = usuarioRepository.getByEmailAndHabilitadoTrue(username);

		if (usuario == null || !usuario.autentica(password)|| usuario.getAuthorities() == null || usuario.getAuthorities().isEmpty()) {
			throw new BadCredentialsException(Constants.LOGIN_INVALIDO);
		}
		
		return new UsernamePasswordAuthenticationToken(usuario, password, usuario.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
