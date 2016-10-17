package br.cap7.petcare.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.Servico;
import br.cap7.petcare.service.EstabelecimentoService;

@RestController
@RequestMapping("rest")
public class PetcareRestController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	// Todos os estabelecimentos
	@GetMapping("estabelecimentos")
	public List<Estabelecimento> getAllEstabelecimentos() {
		return estabelecimentoService.getAll();
	}
	
	// Serviços de um estabelecimento
	@GetMapping("servicos/{id}")
	public List<Servico> getServicosByEstabelecimento(@PathVariable("id") Estabelecimento estabelecimento) {
		return estabelecimento == null ? null : estabelecimento.getServicos();
	}
	
	// Agenda disponível de um estabelecimento de um determinado dia
	@GetMapping("agenda/{id}/{data}")
	public List<Agendamento> getAgendaByEstabelecimento(@PathVariable("id") Estabelecimento estabelecimento, 
			@PathVariable("data") Date data) {
		return estabelecimento == null ? null 
				: estabelecimentoService.getAgenda(estabelecimento, data, StatusAgendamento.DISPONIVEL);
		
	}

}
