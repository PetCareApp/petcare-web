package br.cap7.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cap7.petcare.model.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

}
