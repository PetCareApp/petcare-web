package br.com.petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petcare.model.Endereco;
import br.com.petcare.model.Petshop;
import br.com.petcare.model.Usuario;
import br.com.petcare.util.Constants;

@Controller
public class AdminController {
	
	@RequestMapping(value = "petshop/cadastrar", method = RequestMethod.GET)
	public String cadastrarPetshopForm(Model model) {
		model.addAttribute("petshop", new Petshop());
		model.addAttribute("endereco", new Endereco());
		model.addAttribute("usuario", new Usuario());
		return Constants.PAGE_CADASTRAR_PETSHOP;
	}
	
	@RequestMapping(value = "petshop/cadastrar", method = RequestMethod.POST)
	public String cadastrarPetshop() {
		return Constants.PAGE_CADASTRAR_PETSHOP;
	}

}
