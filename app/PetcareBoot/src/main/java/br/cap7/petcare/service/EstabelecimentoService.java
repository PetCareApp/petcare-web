package br.cap7.petcare.service;

import java.util.List;

import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.TipoEstabelecimento;

public interface EstabelecimentoService {
	
	List<Estabelecimento> getAll();
	
	List<TipoEstabelecimento> getAllTipoEstabelecimento();
	
	void cadastrar(TipoEstabelecimento tipoEstabelecimento);
	
	void cadastrar(Estabelecimento estabelecimento);

}
