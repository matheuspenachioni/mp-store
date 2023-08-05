package br.com.matheus.mpstore.model.enums;

public enum StatusContaReceber {
	COBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada");
	
	private String descricao;
	
	//...Constructor
	private StatusContaReceber(String descricao) {
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
