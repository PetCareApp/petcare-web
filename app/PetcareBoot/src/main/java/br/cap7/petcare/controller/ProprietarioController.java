package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.Servico;
import br.cap7.petcare.service.AgendamentoService;
import br.cap7.petcare.service.EstabelecimentoService;
import br.cap7.petcare.service.ServicoService;

@Controller
@RequestMapping("proprietario")
public class ProprietarioController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping("listar-estabelecimentos") 
	public ModelAndView listarEstabelecimentos() {
		ModelAndView mav = new ModelAndView("proprietario/listar-estabelecimentos");
		return mav.addObject("estabelecimentos", 
				estabelecimentoService.getAll(SecurityContextHolder.getContext().getAuthentication().getName()));
	}
	
	@GetMapping("visualizar-estabelecimento/{id}")
	public ModelAndView visualizarEstabelecimento(@PathVariable("id") Estabelecimento estabelecimento) {
		if (estabelecimento == null || 
				!estabelecimento.getProprietario().getUsuario().getEmail()
				.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			return new ModelAndView("redirect:/proprietario/listar-estabelecimentos");
		}
		ModelAndView mav = new ModelAndView("proprietario/visualizar-estabelecimento");
		mav.addObject("tipos", servicoService.getAllTipoServico());
		mav.addObject("servico", new Servico());
		return mav.addObject("estabelecimento", estabelecimento);
	}
	
	@PostMapping("cadastrar-servico")
	public ModelAndView cadastrarServico(@RequestParam("estabelecimento") Estabelecimento estabelecimento, Servico servico) {
		if (estabelecimento == null || 
				!estabelecimento.getProprietario().getUsuario().getEmail()
				.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			return new ModelAndView("redirect:/proprietario/listar-estabelecimentos");
		}
		servico.setEstabelecimento(estabelecimento);
		servicoService.cadastrar(servico);
		return new ModelAndView("redirect:/proprietario/visualizar-estabelecimento/" + estabelecimento.getId());
		
	}
	
	@GetMapping("agenda")
	public ModelAndView getAgenda() {
		ModelAndView mav = new ModelAndView("proprietario/agenda");
		mav.addObject("agendamento", new Agendamento());
		mav.addObject("tipos", servicoService.getAllTipoServico());
		return mav.addObject("estabelecimentos", estabelecimentoService.getAll(SecurityContextHolder.getContext().getAuthentication().getName()));
	}
	
	@PostMapping("cadastrar-agendamento")
	public ModelAndView cadastrarAgendamento(@RequestParam("estabelecimento") Estabelecimento estabelecimento, Agendamento agendamento) {
		if (estabelecimento == null || 
				!estabelecimento.getProprietario().getUsuario().getEmail()
				.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			return new ModelAndView("redirect:/proprietario/listar-estabelecimentos");
		}
		agendamento.setEstabelecimento(estabelecimento);
		agendamentoService.cadastrar(agendamento);
		return new ModelAndView("redirect:/proprietario/visualizar-estabelecimento/" + estabelecimento.getId());
	}
	
}
