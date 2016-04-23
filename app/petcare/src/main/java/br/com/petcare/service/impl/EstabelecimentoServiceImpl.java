package br.com.petcare.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.EstabelecimentoService;

@Named
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Inject
	private GenericRepository<TipoEstabelecimento> tipoEstService;
	
	@Override
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstService.save(tipoEstabelecimento);
		
	}

	@Override
	public List<TipoEstabelecimento> getAllTipoEstabelecimento() {
		return tipoEstService.find(TipoEstabelecimento.class);
	}

}
