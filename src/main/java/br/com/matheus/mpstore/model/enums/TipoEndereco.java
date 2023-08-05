package br.com.matheus.mpstore.model.enums;

public enum TipoEndereco {

	COBRANCA("Cobrança"), ENTREGA("Entrega");
	
	private String descricao;
	
	//...Constructor
	private TipoEndereco(String descricao) {
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
