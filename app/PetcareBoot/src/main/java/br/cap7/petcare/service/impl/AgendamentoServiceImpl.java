package br.cap7.petcare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.repository.AgendamentoRepository;
import br.cap7.petcare.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Override
	public List<Agendamento> getAgendamentos(Estabelecimento estabelecimento, Date data, StatusAgendamento status) {
		return agendamentoRepository.findByEstabelecimentoAndDataAndStatusOrderByHoraAsc(estabelecimento, data, status);
	}

	@Override
	public void cadastrar(Agendamento agendamento) {
		agendamento.setStatus(StatusAgendamento.DISPONIVEL);
		agendamentoRepository.save(agendamento);
	}
	
	

}
