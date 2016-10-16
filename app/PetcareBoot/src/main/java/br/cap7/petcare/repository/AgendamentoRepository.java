package br.cap7.petcare.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Estabelecimento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	
	List<Agendamento> findByEstabelecimentoAndDataOrderByHoraAsc(Estabelecimento estabelecimento, LocalDate data);

}
