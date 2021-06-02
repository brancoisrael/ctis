package br.jus.tream.saude.enumeration;

/**
 * Enum com os tipos dos relatórios
 * 
 * @author vinicius
 *
 */
public enum TipoRelatorio {

	PDF("pdf"), XLS("xls"), DOC("doc");

	private String extensao;

	private TipoRelatorio(String descricao) {
		this.extensao = descricao;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

}