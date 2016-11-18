package br.cap7.petcare.service;

import java.util.Date;
import java.util.List;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;

public interface AgendamentoService {

	List<Agendamento> getAgendamentos(Estabelecimento estabelecimento, Date localDate, StatusAgendamento status);

	void cadastrar(Agendamento agendamento);
	
	void excluir(Agendamento agendamento);
	

}
