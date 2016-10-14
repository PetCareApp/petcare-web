package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
