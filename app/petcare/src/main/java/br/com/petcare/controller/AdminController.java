package br.com.petcare.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.Servico;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.model.Usuario;
import br.com.petcare.service.EstabelecimentoService;
import br.com.petcare.service.ProprietarioService;
import br.com.petcare.service.ServicoService;
import br.com.petcare.util.Constants;

@Controller
public class AdminController {
	
	@Inject
	private EstabelecimentoService estabelecimentoService;
	
	@Inject
	private ProprietarioService proprietarioService;
	
	@Inject
	private ServicoService servicoService;
	
	@RequestMapping(value = "proprietario/cadastrar", method = RequestMethod.GET)
	public String cadastrarProprietarioForm(Model model) {
		model.addAttribute("proprietario", new Proprietario());
		return Constants.PAGE_CADASTRAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/cadastrar", method = RequestMethod.POST)
	public String cadastrarProprietario(@ModelAttribute("proprietario") Proprietario proprietario, RedirectAttributes redirect) {
		proprietario.getUsuario().setHabilitado(true);
		proprietarioService.cadastrar(proprietario);
		redirect.addFlashAttribute("info", Constants.MSG_PROPRIETARIO_CADASTRADO);
		return Constants.REDIRECT_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/listar", method = RequestMethod.GET)
	public String listarProprietarios(Model model) {
		model.addAttribute("proprietarios", proprietarioService.getAll());
		return Constants.PAGE_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/detalhes/{id}", method = RequestMethod.GET)
	public String visualizarProprietario(@PathVariable("id") Integer idProp, Model model) {
		model.addAttribute("proprietario", proprietarioService.find(idProp));
		return Constants.PAGE_DETALHE_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/editar/{id}", method = RequestMethod.GET)
	public String editarProprietarioForm(@PathVariable("id") Integer idProp, Model model) {
		model.addAttribute("proprietario", proprietarioService.find(idProp));
		model.addAttribute("action", "editar");
		return Constants.PAGE_CADASTRAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/editar", method = RequestMethod.POST)
	public String editarProprietario(@ModelAttribute("proprietario") Proprietario proprietario, RedirectAttributes redirect) {
		Proprietario prop = proprietarioService.find(proprietario.getId());
		prop.setNome(proprietario.getNome());
		prop.setTelefone(proprietario.getTelefone());
		prop.getUsuario().setEmail(proprietario.getUsuario().getEmail());
		proprietarioService.atualizar(prop);
		redirect.addFlashAttribute("info", Constants.MSG_PROPRIETARIO_ATUALIZADO);
		return Constants.REDIRECT_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/{idUsuario}/{status}", method = RequestMethod.GET)
	public String atualizarStatusProprietario(@PathVariable("idUsuario") Integer idUsuario, 
			@PathVariable("status") boolean status, Model model, RedirectAttributes redirect) {
		Usuario usuario = proprietarioService.findUsuario(idUsuario);
		usuario.setHabilitado(status);
		proprietarioService.atualizar(usuario);
		redirect.addFlashAttribute("info", Constants.MSG_STATUS_PROPRIETARIO_ATUALIZADO);
		return Constants.REDIRECT_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "estabelecimento/cadastrar/{id}", method = RequestMethod.GET)
	public String cadastrarPetshopForm(@PathVariable("id") Integer idProp, Model model) {
		model.addAttribute("proprietario", proprietarioService.find(idProp));
		model.addAttribute("estabelecimento", new Estabelecimento());
		model.addAttribute("tipos", estabelecimentoService.getAllTipoEstabelecimento());
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/cadastrar", method = RequestMethod.POST)
	public String cadastrarPetshop(@ModelAttribute("estabelecimento") Estabelecimento estabelecimento) {
		estabelecimentoService.cadastrar(estabelecimento);
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/listar", method = RequestMethod.GET)
	public String listarEstabelecimentos(Model model) {
		model.addAttribute("estabelecimentos", estabelecimentoService.getAll());
		return Constants.PAGE_LISTAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento/cadastrar", method = RequestMethod.GET)
	public String cadastrarTipoEstabelecimentoForm(Model model) {
		model.addAttribute("tipo", new TipoEstabelecimento());
		model.addAttribute("tipos", estabelecimentoService.getAllTipoEstabelecimento());
		return Constants.PAGE_CADASTRAR_TIPO_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento/cadastrar", method = RequestMethod.POST)
	public String cadastrarTipoEstabelecimento(@ModelAttribute("tipo") TipoEstabelecimento tipo, 
			final RedirectAttributes redirectAttributes) {
		estabelecimentoService.cadastrar(tipo);
		redirectAttributes.addFlashAttribute("info", Constants.MSG_TIPO_ESTABELECIMENTO_CADASTRADO_SUCESSO);
		return Constants.REDIRECT_CADASTRAR_TIPO_ESTABELECIMENTO;
	}

	@RequestMapping(value = "servico/cadastrar", method = RequestMethod.GET)
	public String cadastrarServicoForm(Model model) {
		model.addAttribute("servico", new Servico());
		model.addAttribute("tipos", servicoService.getAll());
		return Constants.PAGE_CADASTRAR_SERVICO;
	}

	@RequestMapping(value = "servico/cadastrar", method = RequestMethod.POST)
	public String cadastrarServico(@ModelAttribute("servico") Servico servico) {
		servicoService.cadastrar(servico);
		return Constants.REDIRECT_CADASTRAR_SERVICO;
	}
	
	@RequestMapping(value = "servico/listar", method = RequestMethod.GET)
	public String listarServico(Model model) {
		model.addAttribute("servicos", servicoService.getAll());
		return Constants.PAGE_LISTAR_SERVICO;
	}
	
}
