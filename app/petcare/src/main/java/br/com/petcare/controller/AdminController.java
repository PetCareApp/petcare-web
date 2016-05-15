package br.com.petcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.model.Usuario;
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
	public String cadastrarEstabelecimentoForm(@PathVariable("id") Integer idProp, Model model) {
		model.addAttribute("proprietario", proprietarioService.find(idProp));
		model.addAttribute("estabelecimento", new Estabelecimento());
		model.addAttribute("tiposEst", estabelecimentoService.getAllTipoEstabelecimento());
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/cadastrar", method = RequestMethod.POST)
	public String cadastrarEstabelecimento(@ModelAttribute("estabelecimento") Estabelecimento estabelecimento, 
			@RequestParam("tipo") List<Integer> tipos, RedirectAttributes redirect) {
		for (Integer t : tipos) {
			TipoEstabelecimento tipo = estabelecimentoService.getTipoById(t);
			estabelecimento.addTipo(tipo);
		}
		estabelecimento.setHabilitado(true);
		estabelecimentoService.cadastrar(estabelecimento);
		redirect.addFlashAttribute("info", Constants.MSG_ESTABELECIMENTO_CADASTRADO_SUCESSO);
		return Constants.REDIRECT_DETALHE_PROPRIETARIO + estabelecimento.getProprietario().getId();
	}
	
	@RequestMapping(value = "estabelecimento/editar/{id}", method = RequestMethod.GET)
	public String editarEstabelecimentoForm(@PathVariable("id") Integer idEst, Model model) {
		Estabelecimento estabelecimento = estabelecimentoService.getEstabelecimento(idEst);
		model.addAttribute("estabelecimento", estabelecimento);
		model.addAttribute("proprietario", estabelecimento.getProprietario());
		model.addAttribute("tiposEst", estabelecimentoService.getAllTipoEstabelecimento());
		model.addAttribute("action", "editar");
		return Constants.PAGE_CADASTRAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/editar", method = RequestMethod.POST)
	public String editarEstabelecimento(@ModelAttribute("estabelecimento") Estabelecimento estabelecimento, 
			@RequestParam(value = "tipo", required = false) List<Integer> tipos, RedirectAttributes redirect) {
		Estabelecimento est = estabelecimentoService.getEstabelecimento(estabelecimento.getId());
		List<TipoEstabelecimento> tiposEst = new ArrayList<TipoEstabelecimento>();
		if (tipos != null) {
			for (Integer t : tipos) {
				TipoEstabelecimento tipo = estabelecimentoService.getTipoById(t);
				tiposEst.add(tipo);
			}
		}
		est.setTipos(tiposEst);
		est.setNome(estabelecimento.getNome());
		est.setCnpj(estabelecimento.getCnpj());
		//est.setEndereco(estabelecimento.getEndereco());
		estabelecimentoService.atualizar(est);
		redirect.addFlashAttribute("info", Constants.MSG_ESTABELECIMENTO_ATUALIZADO);
		return Constants.REDIRECT_DETALHE_PROPRIETARIO + estabelecimento.getProprietario().getId();
	}
	
	@RequestMapping(value = "estabelecimento/detalhes/{id}", method = RequestMethod.GET)
	public String visualizarEstabelecimento(@PathVariable("id") Integer idEst, Model model) {
		model.addAttribute("estabelecimento", estabelecimentoService.getEstabelecimento(idEst));
		return Constants.PAGE_DETALHE_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "estabelecimento/{idEst}/{status}", method = RequestMethod.GET)
	public String atualizarStatusEstabelecimento(@PathVariable("idEst") Integer idEst, 
			@PathVariable("status") boolean status, Model model, RedirectAttributes redirect) {
		Estabelecimento estabelecimento = estabelecimentoService.getEstabelecimento(idEst);
		estabelecimento.setHabilitado(status);
		estabelecimentoService.atualizar(estabelecimento);
		redirect.addFlashAttribute("info", Constants.MSG_STATUS_ESTABELECIMENTO_ATUALIZADO);
		return Constants.REDIRECT_DETALHE_PROPRIETARIO + estabelecimento.getProprietario().getId();
	}
	
	@RequestMapping(value = "estabelecimento/listar", method = RequestMethod.GET)
	public String listarEstabelecimentos(Model model) {
		model.addAttribute("estabelecimentos", estabelecimentoService.getAll());
		return Constants.PAGE_LISTAR_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento", method = RequestMethod.GET)
	public String cadastrarTipoEstabelecimentoForm(Model model) {
		model.addAttribute("tipo", new TipoEstabelecimento());
		model.addAttribute("tipos", estabelecimentoService.getAllTipoEstabelecimento());
		return Constants.PAGE_TIPO_ESTABELECIMENTO;
	}
	
	@RequestMapping(value = "tipo-estabelecimento", method = RequestMethod.POST)
	public String cadastrarTipoEstabelecimento(@ModelAttribute("tipo") TipoEstabelecimento tipo, 
			final RedirectAttributes redirectAttributes) {
		estabelecimentoService.cadastrar(tipo);
		return Constants.REDIRECT_CADASTRAR_TIPO_ESTABELECIMENTO;
	}

}
