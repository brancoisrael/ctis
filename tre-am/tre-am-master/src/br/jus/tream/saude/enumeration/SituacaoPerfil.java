package br.jus.tream.saude.enumeration;

public enum SituacaoPerfil {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	private SituacaoPerfil(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
