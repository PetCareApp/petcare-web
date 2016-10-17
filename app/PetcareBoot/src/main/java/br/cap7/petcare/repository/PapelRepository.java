package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.Papel;
import br.cap7.petcare.model.Papel.NomePapel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {
	
	Papel findByNome(NomePapel nome);

}
