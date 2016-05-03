package br.com.petcare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstabelecimentoServicoId implements Serializable {

	private static final long serialVersionUID = -3697523293690657380L;
	
	@Column (name = "estabelecimento_id")
	private Integer estabelecimentoId;

	@Column (name = "servico_id")
	private Integer servicoId;

	public Integer getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Integer estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estabelecimentoId == null || servicoId == null) ? 0 : estabelecimentoId.hashCode() + servicoId.hashCode());
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
		EstabelecimentoServicoId other = (EstabelecimentoServicoId) obj;
		if (estabelecimentoId == null || servicoId == null) {
			if (other.estabelecimentoId != null || other.servicoId != null)
				return false;
		} else if (!estabelecimentoId.equals(other.estabelecimentoId) || !servicoId.equals(other.servicoId))
			return false;
		return true;
	}
	
}
