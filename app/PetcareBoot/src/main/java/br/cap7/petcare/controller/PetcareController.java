package br.cap7.petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetcareController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
