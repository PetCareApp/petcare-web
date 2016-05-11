package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Servico;
import br.com.petcare.model.ServicoCategoria;

public interface ServicoService {
	
	public void cadastrar(Estabelecimento estabelecimento);
	
	public void cadastrar(Servico servico);
	
	public List<Servico> getAllServicos();
	
	public List<ServicoCategoria> getAllServicoCategorias();
	
	public Servico find(Integer id);
	
	public void atualizar(Servico servico);
	
	public void deletar(Servico servico);
	
}
