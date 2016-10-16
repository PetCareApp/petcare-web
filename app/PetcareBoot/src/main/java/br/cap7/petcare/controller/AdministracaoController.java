package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.Proprietario;
import br.cap7.petcare.model.TipoEstabelecimento;
import br.cap7.petcare.model.TipoServico;
import br.cap7.petcare.service.AdministracaoService;
import br.cap7.petcare.service.EstabelecimentoService;
import br.cap7.petcare.service.ProprietarioService;
import br.cap7.petcare.service.ServicoService;

@Controller
@RequestMapping("/admin")
public class AdministracaoController {
	
	@Autowired
	private AdministracaoService adminService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ServicoService servicoService;
	
	/** Gerenciamento de Proprietários */
	@GetMapping("/proprietario/listar")
	public ModelAndView listarProprietario() {
		ModelAndView mav = new ModelAndView("listar-proprietario");
		return mav.addObject("proprietarios", proprietarioService.getAll());
	}
	
	@GetMapping("/proprietario/cadastrar")
	public ModelAndView cadastrarProprietario() {
		ModelAndView mav = new ModelAndView("cadastrar-proprietario");
		return mav.addObject("proprietario", new Proprietario());
	}
	
	@PostMapping("/proprietario/cadastrar")
	public ModelAndView cadastrarProprietario(Proprietario proprietario) {
		adminService.cadastrar(proprietario);
		return this.listarProprietario();
	}
	
	@GetMapping("/proprietario/detalhes/{id}")
	public ModelAndView visualizarProprietario(@PathVariable("id")Proprietario proprietario) {
		if (proprietario == null) {
			return this.listarProprietario();
		}
		ModelAndView mav = new ModelAndView("visualizar-proprietario");
		return mav.addObject("proprietario", proprietario);
	}
	
	/** Cadastrar novo estabelecimento para um proprietário */
	@GetMapping("/proprietario/{id}/cadastrar-estabelecimento")
	public ModelAndView cadastrarEstabelecimento(@PathVariable("id") Proprietario proprietario) {
		if (proprietario == null) {
			return this.listarProprietario();
		}
		ModelAndView mav = new ModelAndView("cadastrar-estabelecimento");
		mav.addObject("proprietario", proprietario);
		mav.addObject("tipos", estabelecimentoService.getAllTipoEstabelecimento());
		return mav.addObject("estabelecimento", new Estabelecimento());
	}
	
	@PostMapping("/proprietario/cadastrar-estabelecimento")
	public ModelAndView cadastrarEstabelecimento(@RequestParam("proprietario") Proprietario proprietario, Estabelecimento estabelecimento) {
		if (proprietario == null) {
			return this.listarProprietario();
		}
		estabelecimento.setProprietario(proprietario);
		estabelecimentoService.cadastrar(estabelecimento);
		return this.visualizarProprietario(proprietario);
	}
	
	/** Gerenciamento de Estabelecimentos */
	@GetMapping("/estabelecimento/listar")
	public ModelAndView listarEstabelecimento() {
		ModelAndView mav = new ModelAndView("listar-estabelecimento");
		return mav.addObject("estabelecimentos", estabelecimentoService.getAll());
	}
	
	@GetMapping("/estabelecimento/cadastrar")
	public ModelAndView cadastrarEstabelecimento(Model model) {
		ModelAndView mav = new ModelAndView("cadastrar-estabelecimento");
		return mav.addObject("estabelecimento", new Estabelecimento());
	}
	
	@PostMapping("/estabelecimento/cadastrar")
	public ModelAndView cadastrarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoService.cadastrar(estabelecimento);
		return this.listarEstabelecimento();
	}
	
	/** Gerenciamento de Tipos de Serviços, Estabelecimentos e Agendamentos*/
	@GetMapping("gerenciar")
	public ModelAndView gerenciar() {
		ModelAndView mav = new ModelAndView("gerenciar");
		mav.addObject("tipoServico", new TipoServico());
		mav.addObject("tipoEstabelecimento", new TipoEstabelecimento());
		mav.addObject("tiposServico", servicoService.getAllTipoServico());
		return mav.addObject("tiposEstabelecimento", estabelecimentoService.getAllTipoEstabelecimento());
	}
	
	@PostMapping("tipo-estabelecimento/cadastrar")
	public ModelAndView cadastrarTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		estabelecimentoService.cadastrar(tipoEstabelecimento);
		return this.gerenciar();
	}
	
	@PostMapping("tipo-servico/cadastrar")
	public ModelAndView cadastrarTipoServico(TipoServico tipoServico) {
		servicoService.cadastrar(tipoServico);
		return this.gerenciar();
	}
	
}
