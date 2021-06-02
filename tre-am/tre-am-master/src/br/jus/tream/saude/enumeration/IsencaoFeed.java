package br.jus.tream.saude.enumeration;

/**
 * 
 * @author vinicius
 *
 */
public enum IsencaoFeed {
	S("SIM"), N("N�O");

	private String descricao;

	private IsencaoFeed(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}
}
