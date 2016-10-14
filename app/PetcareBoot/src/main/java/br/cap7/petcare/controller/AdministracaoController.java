package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String listarProprietario(Model model) {
		model.addAttribute("proprietarios", proprietarioService.getAll());
		return "listar-proprietario";
	}
	
	@GetMapping("/proprietario/cadastrar")
	public String cadastrarProprietario(Model model) {
		model.addAttribute("proprietario", new Proprietario());
		return "cadastrar-proprietario";
	}
	
	@PostMapping("/proprietario/cadastrar")
	public String cadastrarProprietario(Proprietario proprietario) {
		adminService.cadastrar(proprietario);
		return "redirect:/admin/proprietario/listar";
	}
	
	@GetMapping("/proprietario/detalhes/{id}")
	public String visualizarProprietario(@PathVariable("id")Integer idProprietario, Model model) {
		model.addAttribute("proprietario", proprietarioService.get(idProprietario));
		return "visualizar-proprietario";
	}
	
	/** Gerenciamento de Estabelecimentos */
	@GetMapping("/estabelecimento/listar")
	public String listarEstabelecimento(Model model) {
		model.addAttribute("estabelecimentos", estabelecimentoService.getAll());
		return "listar-estabelecimento";
	}
	
	@GetMapping("/estabelecimento/cadastrar")
	public String cadastrarEstabelecimento(Model model) {
		model.addAttribute("estabelecimento", new Estabelecimento());
		return "cadastrar-estabelecimento";
	}
	
	@PostMapping("/estabelecimento/cadastrar")
	public String cadastrarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoService.cadastrar(estabelecimento);
		return "redirect:/admin/estabelecimento/listar";
	}
	
	/** Gerenciamento de Tipos de Serviços e Estabelecimentos */
	@GetMapping("tipo-servico-estabelecimento")
	public String gerenciarTiposServicoEstabelecimento(Model model) {
		model.addAttribute("tipoServico", new TipoServico());
		model.addAttribute("tipoEstabelecimento", new TipoEstabelecimento());
		model.addAttribute("tiposServico", servicoService.getAllTipoServico());
		model.addAttribute("tiposEstabelecimento", estabelecimentoService.getAllTipoEstabelecimento());
		return "gerenciar-tipo-servico-estabelecimento";
	}
	
	@PostMapping("tipo-estabelecimento/cadastrar")
	public String cadastrarTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		estabelecimentoService.cadastrar(tipoEstabelecimento);
		return "redirect:/admin/tipo-servico-estabelecimento";
	}
	
	@PostMapping("tipo-servico/cadastrar")
	public String cadastrarTipoServico(TipoServico tipoServico) {
		servicoService.cadastrar(tipoServico);
		return "redirect:/admin/tipo-servico-estabelecimento";
	}
	

}
