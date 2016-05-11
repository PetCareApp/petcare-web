package br.com.petcare.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Servico;
import br.com.petcare.model.ServicoCategoria;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.ServicoService;

@Named
public class ServicoServiceImpl implements ServicoService {

	@Inject
	private GenericRepository<Servico> servicoRepo;
	
	@Inject
	private GenericRepository<Estabelecimento> estabelecimentoRepo;
	
	@Inject
	private GenericRepository<ServicoCategoria> servicoCategoriaRepo;
	
	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimentoRepo.save(estabelecimento);
	}
	
	@Override
	public void cadastrar(Servico servico) {
		servicoRepo.save(servico);
	}

	@Override
	public List<Servico> getAllServicos() {
		return servicoRepo.find(Servico.class);
	}

	@Override
	public List<ServicoCategoria> getAllServicoCategorias() {
		return servicoCategoriaRepo.find(ServicoCategoria.class);
	}

	@Override
	public Servico find(Integer id) {
		return servicoRepo.find(Servico.class, id);
	}

	@Override
	public void atualizar(Servico servico) {
		servicoRepo.update(servico);
	}

	@Override
	public void deletar(Servico servico) {
		servicoRepo.delete(servico);
	}
	
}
