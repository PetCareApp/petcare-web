package br.cap7.petcare.service;

import java.util.Date;
import java.util.List;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.TipoEstabelecimento;

public interface EstabelecimentoService {
	
	List<Estabelecimento> getAll();
	
	List<TipoEstabelecimento> getAllTipoEstabelecimento();
	
	List<Estabelecimento> getAll(String emailProprietario);
	
	void cadastrar(TipoEstabelecimento tipoEstabelecimento);
	
	void excluir(TipoEstabelecimento tipoEstabelecimento);
	
	void cadastrar(Estabelecimento estabelecimento);
	
	List<Agendamento> getAgenda(Estabelecimento estabelecimento, Date data, StatusAgendamento status);

}
