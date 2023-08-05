package br.com.matheus.mpstore.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "status_rastreio")
@SequenceGenerator(name = "seq_status_rastreio", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
	private Long id;

	private String centroDistribuicao;
	
	private String cidade;
	
	private String estado;
	
	private String status;
	
	@ManyToOne(targetEntity = VendaCompraLoja.class)
	@JoinColumn(name = "venda_compra_loja_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_fk"))
	private VendaCompraLoja vendaCompraLoja;

	//...Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentroDistribuicao() {
		return centroDistribuicao;
	}

	public void setCentroDistribuicao(String centroDistribuicao) {
		this.centroDistribuicao = centroDistribuicao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//...Equals and Hash Code
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusRastreio other = (StatusRastreio) obj;
		return Objects.equals(id, other.id);
	}
	
}
