package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Papel;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.Usuario;

public interface ProprietarioService {
	
	public List<Proprietario> getAll();

	public void cadastrar(Proprietario proprietario);
	
	public void atualizar(Proprietario proprietario);
	
	public Papel getPapel(String nome);
	
	public Proprietario find(Integer id);
	
	public Usuario findUsuario(Integer id);
	
	public void atualizar(Usuario usuario);

}
