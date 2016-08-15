package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Endereco;
import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.TipoEstabelecimento;

public interface EstabelecimentoService {
	
	public void cadastrar(Estabelecimento estabelecimento);
	
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento);
	
	public void cadastrarEndereco(Endereco endereco);
	
	public List<TipoEstabelecimento> getAllTipoEstabelecimento();
	
	public List<Estabelecimento> getAll();
	
	public Estabelecimento find(Integer id);

	public void atualizar(Estabelecimento estabelecimento);

}
