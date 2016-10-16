package br.cap7.petcare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@DateTimeFormat(pattern = "hh:mm")
	private Date hora;
	
	private StatusAgendamento status;
	
	@ManyToOne
	private TipoServico tipo;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	public enum StatusAgendamento {
		DISPONIVEL("DISPONÍVEL"), AGENDADO("AGENDADO"), CONFIRMADO("CONFIRMADO"), CANCELADO("CANCELADO");
		
		private String descricao;

		private StatusAgendamento(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
	}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public StatusAgendamento getStatus() {
		return status;
	}

	public void setStatus(StatusAgendamento status) {
		this.status = status;
	}

	public TipoServico getTipo() {
		return tipo;
	}

	public void setTipo(TipoServico tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	

}
