package br.cap7.petcare.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Papel implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private NomePapel nome;
	
	public enum NomePapel {
		ADMINISTRACAO, PROPRIETARIO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NomePapel getNome() {
		return nome;
	}

	public void setNome(NomePapel nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome.toString();
	}
	
	

}
