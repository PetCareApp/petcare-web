package br.cap7.petcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Proprietario;
import br.cap7.petcare.repository.ProprietarioRepository;
import br.cap7.petcare.service.AdministracaoService;

@Service
public class AdministracaoServiceImpl implements AdministracaoService {
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Override
	public void cadastrar(Proprietario proprietario) {
		proprietario.getUsuario().setHabilitado(true);
		proprietario.getUsuario().setSenha("1234");
		proprietarioRepository.save(proprietario);
	}

}
