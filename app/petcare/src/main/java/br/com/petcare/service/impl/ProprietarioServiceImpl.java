package br.com.petcare.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.Papel;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.Usuario;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.ProprietarioService;
import br.com.petcare.util.Constants;

@Named
public class ProprietarioServiceImpl implements ProprietarioService {
	
	@Inject
	private GenericRepository<Proprietario> proprietarioRepository;
	
	@Inject
	private GenericRepository<Papel> papelRepository;
	
	@Inject
	private GenericRepository<Usuario> usuarioRepository;
	
	@Override
	public List<Proprietario> getAll() {
		return proprietarioRepository.find(Proprietario.class);
	}

	@Override
	public void cadastrar(Proprietario proprietario) {
		proprietario.addPapel(getPapel(Constants.PAPEL_PROPRIETARIO));
		proprietarioRepository.save(proprietario);
	}

	@Override
	public Papel getPapel(String nome) {
		Map<String, Object> namedParams = new HashMap<String, Object>();
		namedParams.put("nome", nome);
		return papelRepository.findFirst("from Papel where nome = :nome", namedParams);
	}

	@Override
	public Proprietario find(Integer id) {
		return proprietarioRepository.find(Proprietario.class, id);
	}

	@Override
	public void atualizar(Proprietario proprietario) {
		proprietarioRepository.update(proprietario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		usuarioRepository.update(usuario);
	}

	@Override
	public Usuario findUsuario(Integer id) {
		return usuarioRepository.find(Usuario.class, id);
	}
	
	@Override
	public Usuario findUsuario(String email, String password) {
		Map<String, Object> namedParams = new HashMap<String, Object>();
		namedParams.put("email", email);
		namedParams.put("password", password);
		return usuarioRepository.findFirst("FROM Usuario WHERE email = :email AND password = :password", namedParams);
	}

}
