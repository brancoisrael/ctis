package br.jus.tream.saude.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.annotations.NotFound;
import org.hibernate.jdbc.Work;

import br.jus.tream.saude.DAO.EntityManagerProvider;
import br.jus.tream.saude.DAO.GuiaProcedimentoDAOImpl;
import br.jus.tream.saude.DTO.CustoGuiaDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoReportDTO;
import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.TipoGuia;
import br.jus.tream.saude.enumeration.RelatorioSistema;
import br.jus.tream.saude.report.GeradorRelatorio;


/**
 * Responsável por definir as necessidades na geração dos relatórios
 * 
 * @author vinicius
 *
 */
public class RelatorioBusiness {
	
	private Connection con;
	private static RelatorioBusiness bo;

	public static RelatorioBusiness getInstance() {
		if (bo == null) {
			bo = new RelatorioBusiness();
		}
		return bo;
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório da  {@link Guia}
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGuia(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		GuiaPK gpk = new GuiaPK();
		gpk.setAnoExercicio(filtros.getAnoExercicio());
		gpk.setNumeroGuia(filtros.getNumeroGuia());
		gpk.setTipoGuia(new TipoGuia(filtros.getIdTipoGuia()));
		Guia guia = GuiaBusiness.getInstance().getBean(gpk);
		CustoGuiaDTO custosGuia = GuiaProcedimentoBusiness.getInstance().getCustosGuia(guia);
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("acrescimos", custosGuia.getTotalAcrescimo())
				.addParam("parcelaServidor", custosGuia.getParcelaServidor())
				.addParam("parcelaTRE", custosGuia.getParcelaTRE())
				.addParam("total", custosGuia.getTotal())
				.addImage("logo", "brasao-peq2.png")
				.addObjetos(getDadosPorRelatorio(filtros, relatorio))
				.build().downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório da  {@link Guia} Odontológica
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGuiaOdonto(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		GuiaPK gpk = new GuiaPK();
		gpk.setAnoExercicio(filtros.getAnoExercicio());
		gpk.setNumeroGuia(filtros.getNumeroGuia());
		gpk.setTipoGuia(new TipoGuia(filtros.getIdTipoGuia()));
		Guia guia = GuiaBusiness.getInstance().getBean(gpk);
		CustoGuiaDTO custosGuia = GuiaProcedimentoOdontoBusiness.getInstance().getCustosGuia(guia);
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("acrescimos", custosGuia.getTotalAcrescimo())			
				.addParam("parcelaServidor", custosGuia.getParcelaServidor())
				.addParam("parcelaTRE", custosGuia.getParcelaTRE())
				.addParam("total", custosGuia.getTotal())
				.addImage("logo", "brasao-peq2.png")
				.addObjetos(getDadosPorRelatorio(filtros, relatorio))
				.build().downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório do Beneficiário anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfBeneficiarioAnual(ReportParams filtros, RelatorioSistema relatorio) throws Exception {
		return new GeradorRelatorio.Builder(relatorio)
								   .addParam("dataFiltro", filtros.getFromYearAndMonth())
								   .addImage("logo", "brasao-peq2.png")
								   .addConnection(getConnection())
								   .build()
								   .downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório com o gráfico do Beneficiário anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGraficoBeneficiario(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("dataFiltro", filtros.getFromYearAndMonth())
				.addImage("logo", "brasao-peq2.png")
				.addConnection(getConnection())
				.build().downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório de Coparticiáção anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfCoparticipacaoAnual(ReportParams filtros, RelatorioSistema relatorio) throws Exception {
		return new GeradorRelatorio.Builder(relatorio)
								   .addParam("dataFiltro", filtros.getFromYearAndMonth())
								   .addImage("logo", "brasao-peq2.png")
								   .addConnection(getConnection())
								   .build()
								   .downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório com o gráfico de Coparticiáção anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGraficoCoparticipacaoAnual(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("dataFiltro", filtros.getFromYearAndMonth())
				.addImage("logo", "brasao-peq2.png")
				.addConnection(getConnection())
				.build().downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório das Mensalidades anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfMensalidadeAnual(ReportParams filtros, RelatorioSistema relatorio) throws Exception {
		return new GeradorRelatorio.Builder(relatorio)
								   .addParam("dataFiltro", filtros.getFromYearAndMonth())
								   .addImage("logo", "brasao-peq2.png")
								   .addConnection(getConnection())
								   .build()
								   .downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório com o gráfico das Mensalidades anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGraficoMensalidadeAnual(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("dataFiltro", filtros.getFromYearAndMonth())
				.addImage("logo", "brasao-peq2.png")
				.addConnection(getConnection())
				.build().downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório das Despesas anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfDespesasAnual(ReportParams filtros, RelatorioSistema relatorio) throws Exception {
		return new GeradorRelatorio.Builder(relatorio)
								   .addParam("dataFiltro", filtros.getFromYearAndMonth())
								   .addImage("logo", "brasao-peq2.png")
								   .addConnection(getConnection())
								   .build()
								   .downloadFile();
	}
	
	/**
	 * Responsável por definir as informações necessárias para <br>
	 *  geração do relatório com o gráfico das Despesas anual
	 * 
	 * @param params parâmetros necessários para geração do relatório.
	 * @return relatório para download
	 * @throws Exception 
	 */
	public byte[] getPdfGraficoDespesasAnual(ReportParams filtros, RelatorioSistema relatorio)
			throws  Exception {
		return new GeradorRelatorio.Builder(relatorio)
				.addParam("dataFiltro", filtros.getFromYearAndMonth())
				.addImage("logo", "brasao-peq2.png")
				.addConnection(getConnection())
				.build().downloadFile();
	}

	/**
	 * Responsável por identificar os dados necessários para o relatório informado.
	 * @param filtros utilizados para gerar o relatório.
	 * @param relatorio que será gerado.
	 * @return dados do relatório selecionado.
	 * @throws Exception 
	 * @throws DomainException 
	 * @throws NotFound 
	 */
	@SuppressWarnings("rawtypes")
	private Collection getDadosPorRelatorio(ReportParams filtros, RelatorioSistema relatorio) throws Exception {
		Collection objetos = null;
		switch (relatorio) {
		case GUIA_PDF:
			objetos = findDadosGuiaProcedimentoRelatorio(filtros);
			break;
		case GUIA_ODONTOLOGICA_PDF:
			objetos = findDadosGuiaOdontoProcedimentoRelatorio(filtros);
			break;
		case RELATORIO_BENEFICIARIO_ANUAL:
			break;
		case GRAFICO_BENEFICIARIO_ANUAL:
			break;
		case GRAFICO_BENEFICIARIO_POR_TIPO_ANUAL:
			break;
		default:
			break;
		}
		return objetos;
	}
	
	/**
	 * Obtém a conexão do BD.
	 * @return
	 */
	private Connection getConnection() {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		Session session = (Session) em.getDelegate();
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				con = connection;
			}
		});
		return con;
	}
	
	/**
	 * 
	 * @param filtros
	 * @return
	 * @throws Exception 
	 */
	public List<GuiaProcedimentoReportDTO> findDadosGuiaProcedimentoRelatorio(ReportParams filtros) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().findDadosRelatorioGuia(filtros);
	}
	public List<GuiaProcedimentoReportDTO> findDadosGuiaOdontoProcedimentoRelatorio(ReportParams filtros) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().findDadosRelatorioGuiaOdonto(filtros);
	}
}
