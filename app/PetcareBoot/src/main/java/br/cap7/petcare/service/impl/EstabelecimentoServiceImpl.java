package br.cap7.petcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.TipoEstabelecimento;
import br.cap7.petcare.repository.EstabelecimentoRepository;
import br.cap7.petcare.repository.TipoEstabelecimentoRepository;
import br.cap7.petcare.service.EstabelecimentoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private TipoEstabelecimentoRepository tipoEstabelecimentoRepository;

	@Override
	public List<Estabelecimento> getAll() {
		return estabelecimentoRepository.findAll();
	}

	@Override
	public List<TipoEstabelecimento> getAllTipoEstabelecimento() {
		return tipoEstabelecimentoRepository.findAll();
	}

	@Override
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstabelecimentoRepository.save(tipoEstabelecimento);
	}

	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
	}

}
