package br.jus.tream.saude.enumeration;

/**
 * Indicar� se a guia � de titular ou de dependente.
 * 
 * @author vinicius
 *
 */
public enum TipoBeneficiario {

	TITULAR("Titular"), DEPENDENTE("Dependente");

	private String descricao;

	private TipoBeneficiario(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * Recupera o tipo pela descri��o
	 * 
	 * @param desc descri��o do tipo desejado
	 * @return tipo encontrado ou null;
	 */
	public static TipoBeneficiario findByDescricao(String desc) {
		for (TipoBeneficiario tipo : values()) {
			if (tipo.getDescricao().equalsIgnoreCase(desc)) {
				return tipo;
			}
		}
		return null;
	}

}
