package br.com.petcare.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.petcare.model.Usuario;
import br.com.petcare.service.UsuarioService;

@Controller
public class LoginController {
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("nome", "Spring Security Custom Login Form");
		model.addAttribute("email", "This is welcome page!");
		return "hello";
	}
	
	@RequestMapping(value = { "/hello"}, method = RequestMethod.GET)
	public String hello(Model model) {
		Usuario usuario = usuarioService.getUsuario(1);
		model.addAttribute("nome", usuario.getNome());
		model.addAttribute("email", usuario.getEmail());
		return "hello";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(Model model) {
		model.addAttribute("erro", "Usuário e/ou senha inválidos!");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
