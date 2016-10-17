package br.cap7.petcare.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
	
	List<Agendamento> findByEstabelecimentoAndDataAndStatusOrderByHoraAsc(Estabelecimento estabelecimento, Date data, StatusAgendamento status);

}
