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
import br.cap7.petcare.service.EstabelecimentoService;
import br.cap7.petcare.service.ProprietarioService;
import br.cap7.petcare.service.ServicoService;

@Controller
@RequestMapping("/admin")
public class AdministracaoController {
	
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
		mav.addObject("proprietario", new Proprietario());
		return mav.addObject("proprietarios", proprietarioService.getAll());
	}
	
	@PostMapping("/proprietario/cadastrar")
	public ModelAndView cadastrarProprietario(Proprietario proprietario) {
		proprietarioService.cadastrar(proprietario);
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	@GetMapping("/proprietario/excluir/{id}")
	public ModelAndView excluirProprietario(@PathVariable("id") Proprietario proprietario) {
		if (proprietario != null) {
			try {
				proprietarioService.excluir(proprietario);
			} catch(Exception ex) {
				return new ModelAndView("redirect:/admin/proprietario/listar");
			}
		}
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	@GetMapping("/proprietario/editar/{id}")
	public ModelAndView editarForm(@PathVariable("id") Proprietario proprietario) {
		if (proprietario != null) {
			return new ModelAndView("listar-proprietario").addObject("proprietario", proprietario)
					.addObject("proprietarios", proprietarioService.getAll());
		}
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	@PostMapping("/proprietario/editar")
	public ModelAndView editar(Proprietario proprietario) {
		proprietarioService.atualizar(proprietario);
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	@GetMapping("/proprietario/ativar/{id}")
	public ModelAndView ativarProprietario(@PathVariable("id") Proprietario proprietario) {
		if (proprietario != null) {
			proprietarioService.ativar(proprietario);
		}
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	@GetMapping("/proprietario/desativar/{id}")
	public ModelAndView desativarProprietario(@PathVariable("id") Proprietario proprietario) {
		if (proprietario != null) {
			proprietarioService.desativar(proprietario);
		}
		return new ModelAndView("redirect:/admin/proprietario/listar");
	}
	
	
	@GetMapping("/proprietario/detalhes/{id}")
	public ModelAndView visualizarProprietario(@PathVariable("id")Proprietario proprietario) {
		if (proprietario == null) {
			return new ModelAndView("redirect:/admin/proprietario/listar");
		}
		ModelAndView mav = new ModelAndView("visualizar-proprietario");
		return mav.addObject("proprietario", proprietario);
	}
	
	/** Cadastrar novo estabelecimento para um proprietário */
	@GetMapping("/proprietario/{id}/cadastrar-estabelecimento")
	public ModelAndView cadastrarEstabelecimento(@PathVariable("id") Proprietario proprietario) {
		if (proprietario == null) {
			return new ModelAndView("redirect:/admin/proprietario/listar");
		}
		ModelAndView mav = new ModelAndView("cadastrar-estabelecimento");
		mav.addObject("proprietario", proprietario);
		mav.addObject("tipos", estabelecimentoService.getAllTipoEstabelecimento());
		return mav.addObject("estabelecimento", new Estabelecimento());
	}
	
	@PostMapping("/proprietario/cadastrar-estabelecimento")
	public ModelAndView cadastrarEstabelecimento(@RequestParam("proprietario") Proprietario proprietario, Estabelecimento estabelecimento) {
		if (proprietario == null) {
			return new ModelAndView("redirect:/admin/proprietario/listar");
		}
		estabelecimento.setProprietario(proprietario);
		estabelecimentoService.cadastrar(estabelecimento);
		return new ModelAndView("redirect:/admin/proprietario/detalhes/" + proprietario.getId());
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
		return new ModelAndView("redirect:/admin/estabelecimento/listar");
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
		return new ModelAndView("redirect:/admin/gerenciar");
	}
	
	@GetMapping("tipo-estabelecimento/excluir/{id}")
	public ModelAndView excluirTipoEstabelecimento(@PathVariable("id") TipoEstabelecimento tipoEstabelecimento) {
		if (tipoEstabelecimento != null) {
			try {
				estabelecimentoService.excluir(tipoEstabelecimento);
			} catch(Exception ex){
				return new ModelAndView("redirect:/admin/gerenciar");
			}
		}
		return new ModelAndView("redirect:/admin/gerenciar");
	}
	
	@PostMapping("tipo-servico/cadastrar")
	public ModelAndView cadastrarTipoServico(TipoServico tipoServico) {
		servicoService.cadastrar(tipoServico);
		return new ModelAndView("redirect:/admin/gerenciar");
	}
	
	@GetMapping("tipo-servico/excluir/{id}")
	public ModelAndView excluirTipoServico(@PathVariable("id") TipoServico tipoServico) {
		if (tipoServico != null) {
			try {
				servicoService.excluir(tipoServico);
			} catch(Exception ex) {
				return new ModelAndView("redirect:/admin/gerenciar");
			}
		}
		return new ModelAndView("redirect:/admin/gerenciar");
	}
	
}
