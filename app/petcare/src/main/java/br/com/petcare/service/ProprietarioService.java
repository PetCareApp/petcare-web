package br.com.petcare.service;

import java.util.List;

import br.com.petcare.model.Papel;
import br.com.petcare.model.Proprietario;

public interface ProprietarioService {
	
	public List<Proprietario> getAll();

	public void cadastrar(Proprietario proprietario);
	
	public Papel getPapel(String nome);

}
