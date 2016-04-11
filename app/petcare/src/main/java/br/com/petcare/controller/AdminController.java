package br.com.petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petcare.util.Constants;

@Controller
public class AdminController {
	
	@RequestMapping(value = "petshop/cadastrar", method = RequestMethod.GET)
	public String cadastrarPetshopForm() {
		return Constants.PAGE_CADASTRAR_PETSHOP;
	}

}
