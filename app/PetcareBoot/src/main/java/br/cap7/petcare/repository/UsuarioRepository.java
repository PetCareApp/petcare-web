package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cap7.petcare.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario getByEmail(String email);
	

}
