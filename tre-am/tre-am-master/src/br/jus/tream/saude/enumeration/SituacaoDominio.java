package br.jus.tream.saude.enumeration;

public enum SituacaoDominio {

	INATIVO("Inativo"), ATIVO("Ativo");

	private String descricao;

	private SituacaoDominio(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static SituacaoDominio getSituacaoByDescricao(String descricao) {
		for (SituacaoDominio situacao : SituacaoDominio.values()) {
			if (situacao.getDescricao().equalsIgnoreCase(descricao)) {
				return situacao;
			}
		}
		return null;
	}

}
