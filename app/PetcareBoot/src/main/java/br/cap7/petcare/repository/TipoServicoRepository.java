package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Integer> {
	
	TipoServico findByNomeIgnoreCase(String nome);

}
