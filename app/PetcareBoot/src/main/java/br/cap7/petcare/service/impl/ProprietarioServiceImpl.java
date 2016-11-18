package br.cap7.petcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Proprietario;
import br.cap7.petcare.model.Papel.NomePapel;
import br.cap7.petcare.repository.PapelRepository;
import br.cap7.petcare.repository.ProprietarioRepository;
import br.cap7.petcare.service.ProprietarioService;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;

	@Override
	public void cadastrar(Proprietario proprietario) {
		proprietario.getUsuario().setHabilitado(true);
		proprietario.getUsuario().setSenha("123");
		proprietario.getUsuario().addPapel(papelRepository.findByNome(NomePapel.PROPRIETARIO));
		proprietarioRepository.save(proprietario);
	}
	
	@Override
	public void atualizar(Proprietario proprietario) {
		proprietarioRepository.save(proprietario);
	}
	
	@Override
	public List<Proprietario> getAll() {
		return proprietarioRepository.findAll();
	}

	@Override
	public Proprietario get(Integer id) {
		return proprietarioRepository.findOne(id);
	}

	@Override
	public void excluir(Proprietario proprietario) {
		proprietarioRepository.delete(proprietario);
	}

	@Override
	public void ativar(Proprietario proprietario) {
		proprietario.getUsuario().setHabilitado(true);
		proprietarioRepository.save(proprietario);
	}
	
	@Override
	public void desativar(Proprietario proprietario) {
		proprietario.getUsuario().setHabilitado(false);
		proprietarioRepository.save(proprietario);
	}

}
