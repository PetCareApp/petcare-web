package br.com.petcare.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.Usuario;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.UsuarioService;

@Named
public class UsuarioServiceImpl implements UsuarioService {
	
	@Inject
	private GenericRepository<Usuario> usuarioRepository;
	
	@Override
	public Usuario getUsuario(Integer id) {
		return usuarioRepository.find(Usuario.class, id);
	}
	
	

}
