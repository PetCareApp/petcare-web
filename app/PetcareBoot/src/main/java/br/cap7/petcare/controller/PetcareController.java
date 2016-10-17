package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.cap7.petcare.model.Usuario;
import br.cap7.petcare.service.UsuarioService;

@Controller
public class PetcareController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/")
	public String index() {
		Usuario usuario = usuarioService.get(SecurityContextHolder.getContext().getAuthentication().getName());
		if (usuario.isProprietario()) {
			return "redirect:/proprietario/listar-estabelecimentos";
		}
		return "redirect:/admin/proprietario/listar";
	}

}
