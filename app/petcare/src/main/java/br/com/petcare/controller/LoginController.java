package br.com.petcare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petcare.util.Constants;

@Controller
public class LoginController {
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index() {
		return Constants.REDIRECT_CADASTRAR_ESTABELECIMENTO;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(Model model) {
		model.addAttribute("erro", "Usu�rio e/ou senha inv�lidos!");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
