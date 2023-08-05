package br.com.matheus.mpstore.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;

	@CPF(message = "CPF inválido")
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	//...Getters and Setters
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
