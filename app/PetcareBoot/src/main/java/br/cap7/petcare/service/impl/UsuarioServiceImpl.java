package br.cap7.petcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Usuario;
import br.cap7.petcare.repository.UsuarioRepository;
import br.cap7.petcare.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario get(String email) {
		return usuarioRepository.getByEmail(email);
	}

}
