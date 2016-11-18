package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.TipoEstabelecimento;

@Repository
public interface TipoEstabelecimentoRepository extends JpaRepository<TipoEstabelecimento, Integer> {
	
	TipoEstabelecimento findByNomeIgnoreCase(String nome);

}
