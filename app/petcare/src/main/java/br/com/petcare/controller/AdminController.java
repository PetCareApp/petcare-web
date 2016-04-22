package br.com.petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.petcare.model.Endereco;
import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.model.Usuario;
import br.com.petcare.util.Constants;

@Controller
public class AdminController {
	
	@RequestMapping(value = "estabelecimento/cadastrar", method = RequestMethod.GET)
	public String cadastrarPetshopForm(Model model) {
		model.addAttribute("estabelecimento", new Estabelecimento());
		model.addAttribute("endereco", new Endereco());
		model.addAttribute("usuario", new Usuario());
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/cadastrar", method = RequestMethod.POST)
	public String cadastrarPetshop() {
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento/cadastrar", method = RequestMethod.GET)
	public String cadastrarTipoEstabelecimentoForm(Model model) {
		model.addAttribute("tipo", new TipoEstabelecimento());
		return Constants.PAGE_CADASTRAR_TIPO_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento/cadastrar", method = RequestMethod.POST)
	public String cadastrarTipoEstabelecimento(@ModelAttribute("tipo") TipoEstabelecimento tipo, 
			final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("info", "Tipo de estabelecimento cadastrado com sucesso");
		return Constants.REDIRECT_CADASTRAR_TIPO_ESTABELECIMENTO;
	}

}
