package br.com.petcare.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.EstabelecimentoService;

@Named
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Inject
	private GenericRepository<TipoEstabelecimento> tipoEstRepo;
	
	@Inject
	private GenericRepository<Estabelecimento> estabelecimentoRepo;
	
	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimentoRepo.save(estabelecimento);
	}
	
	@Override
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstRepo.save(tipoEstabelecimento);
		
	}

	@Override
	public List<TipoEstabelecimento> getAllTipoEstabelecimento() {
		return tipoEstRepo.find(TipoEstabelecimento.class);
	}

}
