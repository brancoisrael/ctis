package br.jus.tream.saude.enumeration;

/**
 * Enum com as consultas utilizadas no projeto.
 * 
 * @author vinicius
 *
 */
public enum ConsultaSistema {

	LISTAGEM_GUIA_PROCEDIMENTO_DASHBOARD("../sql/GuiasProcedimentosDashBoard.sql"),
	LISTAGEM_GUIA_PROCEDIMENTO_ODONTO_DASHBOARD("../sql/GuiasProcedimentosOdontoDashBoard.sql"),
	LISTAGEM_PROCEDIMENTO_POR_GUIA_DASHBOARD("../sql/ProcedimentosPorGuia.sql"),
	LISTAGEM_PROCEDIMENTO_ODONTO_POR_GUIA_DASHBOARD("../sql/ProcedimentosOdontoPorGuia.sql"),
	TOTAL_GUIA_PROCEDIMENTO_POR_PARAMS("../sql/TotalGuiasProcedimentosDashBoard.sql"),
	GUIA_PROCEDIMENTO_RELATORIO("../sql/GuiaProcedimentoRelatorio.sql"),
	TOTAL_GUIA_PROCEDIMENTO_ODONTO_POR_PARAMS("../sql/TotalGuiasProcedimentosoOdontoDashBoard.sql"),
	GUIA_PROCEDIMENTO_ODONTO_RELATORIO("../sql/GuiaProcedimentoOdontoRelatorio.sql");

	private String query;
	public static final String CONDICOES = "--[#condicoes#]";
	public static final String ORDENACAO = "--[#ordenacao#]";

	private ConsultaSistema(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

}
