package br.cap7.petcare.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String telefone;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;
	
	@OneToMany(mappedBy = "proprietario")
	private List<Estabelecimento> estabelecimentos;
	
	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}
	
	public void addEstabelecimento(Estabelecimento estabelecimento) {
		if (this.estabelecimentos == null) {
			this.estabelecimentos = new ArrayList<Estabelecimento>();
		}
		if (!this.estabelecimentos.contains(estabelecimento)) {
			this.estabelecimentos.add(estabelecimento);
		}
	}
	
	public void removeEstabelecimento(Estabelecimento estabelecimento) {
		if (this.estabelecimentos != null) {
			this.estabelecimentos.remove(estabelecimento);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietario other = (Proprietario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}