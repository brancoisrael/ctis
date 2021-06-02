package br.jus.tream.saude.enumeration;

/**
 * Respons�vel por definir e facilitar as situa��es da Guia
 * @author vinicius
 *
 */
public enum SituacaoGuia {

	CANCELADA((short)1),
	EM_ABERTO((short)2),
	EM_ANALISE((short)3),
	ANALISADA((short)4),
	PAGA((short)5),
	FATURADA((short)6),
	EM_AUTORIZACAO((short)7),
	AUTORIZADA((short)8),
	REJEITADA((short)9);
	
	private Short idSituacao;
	
	private SituacaoGuia(Short id) {
		this.idSituacao = id;
	}

	public Short getIdSituacao() {
		return idSituacao;
	}
}
