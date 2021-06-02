package br.jus.tream.saude.enumeration;

public enum ClassificacaoTipoDependente {
	P("P"), I("I"), O("O"), F("F"), E("E");

	private String descricao;

	private ClassificacaoTipoDependente(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
