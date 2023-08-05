package br.com.matheus.mpstore.model.enums;

public enum StatusContaPagar {
	COBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada"),
	NEGOCIADA("Renegociada"),
	ALUGUEL("Alugel"),
	FUNCIONARIO("Funcionário");
	
	private String descricao;
	
	//...Constructor
	private StatusContaPagar(String descricao) {
		this.descricao = descricao;
	}
		
	//...Getter
	public String getDescricao() {
		return descricao;
	}

	//...To String
	@Override
	public String toString() {
		return this.descricao;
	}
	
}
