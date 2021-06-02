package br.jus.tream.saude.enumeration;

/**
 * 
 * @author vinicius
 *
 */
public enum IsencaoFeed {
	S("SIM"), N("NÃO");

	private String descricao;

	private IsencaoFeed(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}
}
