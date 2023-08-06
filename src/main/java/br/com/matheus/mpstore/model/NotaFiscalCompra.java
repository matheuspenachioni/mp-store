package br.com.matheus.mpstore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "nota_fiscal_compra")
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
	private Long id;

	@Column(nullable = false)
	private String numeroNota;
	
	@Column(nullable = false)
	private String serieNota;

	private String descricaoObs;

	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;

	@Column(nullable = false)
	private BigDecimal valorIcms;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCompra;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	
	@ManyToOne(targetEntity = ContaPagar.class)
	@JoinColumn(name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
	private ContaPagar contaPagar;

	//...Getters and Setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumeroNota() {
		return numeroNota;
	}


	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}


	public String getSerieNota() {
		return serieNota;
	}


	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}


	public String getDescricaoObs() {
		return descricaoObs;
	}


	public void setDescricaoObs(String descricaoObs) {
		this.descricaoObs = descricaoObs;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}


	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	public BigDecimal getValorIcms() {
		return valorIcms;
	}


	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}


	public Date getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public ContaPagar getContaPagar() {
		return contaPagar;
	}


	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
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
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}
	
}
