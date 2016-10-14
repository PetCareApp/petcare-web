package br.cap7.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.cap7.petcare.model.Proprietario;
import br.cap7.petcare.service.AdministracaoService;
import br.cap7.petcare.service.ProprietarioService;

@Controller
@RequestMapping("/admin")
public class AdministracaoController {
	
	@Autowired
	private AdministracaoService adminService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@GetMapping("/proprietario/listar")
	public String listarProprietario(Model model) {
		model.addAttribute("proprietarios", proprietarioService.getAll());
		return "listar-proprietario";
	}
	
	@GetMapping("/proprietario/cadastrar")
	public String cadastrarProprietario(Model model) {
		model.addAttribute("proprietario", new Proprietario());
		return "redirect:/admin/proprietario/listar";
	}
	
	@PostMapping("/proprietario/cadastrar")
	public String cadastrarProprietario(Proprietario proprietario) {
		adminService.cadastrar(proprietario);
		return "redirect:/admin/proprietario/cadastrar";
	}

}
