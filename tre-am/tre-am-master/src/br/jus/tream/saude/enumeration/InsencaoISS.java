package br.jus.tream.saude.enumeration;

/**
 * 
 * @author vinicius
 *
 */
public enum InsencaoISS {
	S("SIM"), N("N�O");

	private String descricao;

	private InsencaoISS(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

}
