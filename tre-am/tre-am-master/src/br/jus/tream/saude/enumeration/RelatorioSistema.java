package br.jus.tream.saude.enumeration;

import java.io.File;

/**
 * Representa as definições dos relatórios do sistema.
 * 
 * @author vinicius
 *
 */
public enum RelatorioSistema {

	GUIA_PDF("GuiaMedica.pdf", "Guia Médica", ".." + File.separator + "reports" + File.separator + "Guia.jasper", null,
			TipoRelatorio.PDF),
	GUIA_ODONTOLOGICA_PDF("GuiaOdontologica.pdf", "Guia Odontologica",
			".." + File.separator + "reports" + File.separator + "GuiaOdontologica.jasper", null, TipoRelatorio.PDF),
	RELATORIO_BENEFICIARIO_ANUAL("BeneficiarioAnual.pdf", "Relatório de Beneficiário Anual",
			".." + File.separator + "reports" + File.separator + "RelatorioBeneficiarioAnual.jasper",
			"RelatorioBeneficiarioMensal.jasper", TipoRelatorio.PDF),
	GRAFICO_BENEFICIARIO_ANUAL("BeneficiarioAnual.pdf", "Total de Beneficiários - Evolução Anual",
			".." + File.separator + "reports" + File.separator + "GraficoRelatorioBeneficiarioAnual.jasper", null,
			TipoRelatorio.PDF),
	GRAFICO_BENEFICIARIO_POR_TIPO_ANUAL("BeneficiarioAnual.pdf", "Tipo de Beneficiário - Evolução Anual",
			".." + File.separator + "reports" + File.separator + "GraficoRelatorioBeneficiarioPorTipoAnual.jasper",
			null, TipoRelatorio.PDF),
	RELATORIO_COPARTICIPACAO_ANUAL("Coparticicação.pdf", "Financeiro - Coparticipação",
			".." + File.separator + "reports" + File.separator + "RelatorioCoparticipacaoAnual.jasper",
			"RelatorioCoparticipacaoMensal.jasper", TipoRelatorio.PDF),
	GRAFICO_COPARTICIPACAO("Coparticicação.pdf", "Financeiro - Coparticipação",
			".." + File.separator + "reports" + File.separator + "GraficoCoparticipacao.jasper", null,
			TipoRelatorio.PDF),
	RELATORIO_MENSALIDADES_ANUAL("Mensalidades.pdf", "Financeiro - Mensalidades",
			".." + File.separator + "reports" + File.separator + "RelatorioTotalMensalidadesAnual.jasper",
			"RelatorioCoparticipacaoMensal.jasper", TipoRelatorio.PDF),
	GRAFICO_MENSALIDADES("Mensalidades.pdf", "Financeiro - Mensalidades",
			".." + File.separator + "reports" + File.separator + "GraficoMensalidades.jasper", null, TipoRelatorio.PDF),
	RELATORIO_DESPESAS_ANUAL("Despesas.pdf", "Financeiro - Mensalidades",
			".." + File.separator + "reports" + File.separator + "RelatorioDespesasAnual.jasper",
			"RelatorioDespesasMensal.jasper", TipoRelatorio.PDF),
	GRAFICO_DESPESAS("Despesas.pdf", "Financeiro - Mensalidades",
			".." + File.separator + "reports" + File.separator + "GraficoDespesas.jasper", null, TipoRelatorio.PDF);

	private String descricao;
	private String titulo;
	private String jasper;
	private String subReport;
	private TipoRelatorio tipo;

	private RelatorioSistema(String descricao, String titulo, String jasper, String subReport, TipoRelatorio tipo) {
		this.descricao = descricao;
		this.titulo = titulo.toUpperCase();
		this.jasper = jasper;
		this.subReport = subReport;
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getJasper() {
		return jasper;
	}

	public TipoRelatorio getTipo() {
		return tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSubReport() {
		return subReport;
	}

}