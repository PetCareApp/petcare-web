package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.TipoEstabelecimento;

public interface EstabelecimentoService {
	
	public void cadastrar(Estabelecimento estabelecimento);
	
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento);
	
	public List<TipoEstabelecimento> getAllTipoEstabelecimento();
	
	public TipoEstabelecimento getTipoById(Integer id);
	
	public List<Estabelecimento> getAll();
	
	public Estabelecimento getEstabelecimento(Integer id);
	
	public void atualizar(Estabelecimento estabelecimento);

}
