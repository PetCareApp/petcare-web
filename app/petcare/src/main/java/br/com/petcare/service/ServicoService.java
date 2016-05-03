package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Servico;

public interface ServicoService {
	
	public void cadastrar(Estabelecimento estabelecimento);
	
	public void cadastrar(Servico servico);
	
	public List<Servico> getAll();

}
