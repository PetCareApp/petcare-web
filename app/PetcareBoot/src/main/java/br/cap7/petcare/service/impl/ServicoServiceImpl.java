package br.cap7.petcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.TipoServico;
import br.cap7.petcare.repository.TipoServicoRepository;
import br.cap7.petcare.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;

	@Override
	public List<TipoServico> getAllTipoServico() {
		return tipoServicoRepository.findAll();
	}

	@Override
	public void cadastrar(TipoServico tipoServico) {
		tipoServicoRepository.save(tipoServico);
	}

}
