package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.Servico;
import br.cap7.petcare.service.EstabelecimentoService;
import br.cap7.petcare.service.ServicoService;

@Controller
@RequestMapping("proprietario")
public class ProprietarioController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ServicoService servicoService;
	
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
			return this.listarEstabelecimentos();
		}
		ModelAndView mav = new ModelAndView("proprietario/visualizar-estabelecimento");
		return mav.addObject("estabelecimento", estabelecimento);
	}
	
	@GetMapping("cadastrar-servico/{id}")
	public ModelAndView cadastrarServico(@PathVariable("id") Estabelecimento estabelecimento) {
		if (estabelecimento == null || 
				!estabelecimento.getProprietario().getUsuario().getEmail()
				.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			return this.listarEstabelecimentos();
		}
		ModelAndView mav = new ModelAndView("proprietario/cadastrar-servico");
		mav.addObject("estabelecimento", estabelecimento);
		mav.addObject("tipos", servicoService.getAllTipoServico());
		return mav.addObject("servico", new Servico());
		
	}
	
	@PostMapping("cadastrar-servico/{id}")
	public ModelAndView cadastrarServico(@PathVariable("id") Estabelecimento estabelecimento, Servico servico) {
		if (estabelecimento == null || 
				!estabelecimento.getProprietario().getUsuario().getEmail()
				.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			return this.listarEstabelecimentos();
		}
		servico.setEstabelecimento(estabelecimento);
		servicoService.cadastrar(servico);
		return this.visualizarEstabelecimento(estabelecimento);
		
	}

}
