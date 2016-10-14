package br.cap7.petcare.service;

import java.util.List;

import br.cap7.petcare.model.TipoServico;

public interface ServicoService {
	
	List<TipoServico> getAllTipoServico();
	
	void cadastrar(TipoServico tipoServico);

}
