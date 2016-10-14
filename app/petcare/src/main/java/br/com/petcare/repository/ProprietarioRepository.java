package br.com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petcare.model.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
	

}
