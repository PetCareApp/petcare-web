package br.cap7.petcare.service;

import java.util.List;

import br.cap7.petcare.model.Proprietario;

public interface ProprietarioService {
	
	List<Proprietario> getAll();
	
	Proprietario get(Integer id);

}
