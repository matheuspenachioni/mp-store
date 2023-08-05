package br.com.matheus.mpstore.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "marca_produto")
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
	private Long id;

	@Column(nullable = false)
	private String nomeDesc;
	
	//...Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDesc() {
		return nomeDesc;
	}

	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
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
		MarcaProduto other = (MarcaProduto) obj;
		return Objects.equals(id, other.id);
	}
	
}
