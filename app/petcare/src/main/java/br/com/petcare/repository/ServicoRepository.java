package br.com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petcare.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
