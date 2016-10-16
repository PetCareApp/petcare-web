package br.cap7.petcare.service;

import java.time.LocalDate;
import java.util.List;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Estabelecimento;

public interface AgendamentoService {

	List<Agendamento> getAgendamentos(Estabelecimento estabelecimento, LocalDate localDate);

	void cadastrar(Agendamento agendamento);
	

}
