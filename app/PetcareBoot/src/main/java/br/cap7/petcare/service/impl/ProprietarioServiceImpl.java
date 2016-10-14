package br.cap7.petcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Proprietario;
import br.cap7.petcare.repository.ProprietarioRepository;
import br.cap7.petcare.service.ProprietarioService;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Override
	public List<Proprietario> getAll() {
		return proprietarioRepository.findAll();
	}

	@Override
	public Proprietario get(Integer id) {
		return proprietarioRepository.findOne(id);
	}

}
