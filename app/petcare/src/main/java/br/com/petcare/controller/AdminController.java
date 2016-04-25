package br.com.petcare.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.service.EstabelecimentoService;
import br.com.petcare.service.ProprietarioService;
import br.com.petcare.util.Constants;

@Controller
public class AdminController {
	
	@Inject
	private EstabelecimentoService estabelecimentoService;
	
	@Inject
	private ProprietarioService proprietarioService;
	
	@RequestMapping(value = "proprietario/cadastrar", method = RequestMethod.GET)
	public String cadastrarProprietarioForm(Model model) {
		model.addAttribute("proprietario", new Proprietario());
		return Constants.PAGE_CADASTRAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/cadastrar", method = RequestMethod.POST)
	public String cadastrarProprietario(@ModelAttribute("proprietario") Proprietario proprietario, RedirectAttributes redirect) {
		proprietarioService.cadastrar(proprietario);
		redirect.addFlashAttribute("info", Constants.MSG_PROPRIETARIO_CADASTRADO_SUCESSO);
		return Constants.REDIRECT_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "proprietario/listar", method = RequestMethod.GET)
	public String listarProprietarios(Model model) {
		model.addAttribute("proprietarios", proprietarioService.getAll());
		return Constants.PAGE_LISTAR_PROPRIETARIO;
	}
	
	@RequestMapping(value = "estabelecimento/cadastrar", method = RequestMethod.GET)
	public String cadastrarPetshopForm(Model model) {
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
		return Constants.PAGE_LISTAR_PROPRIETARIO;
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

}
