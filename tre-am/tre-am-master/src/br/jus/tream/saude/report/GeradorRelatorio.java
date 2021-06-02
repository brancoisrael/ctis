package br.jus.tream.saude.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.ObjectUtils;

import br.jus.tream.saude.enumeration.RelatorioSistema;
import br.jus.tream.saude.exception.RelatorioJasperException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Responsável pela geração dos relatórios
 * 
 * @author vinicius
 *
 */
public class GeradorRelatorio implements Serializable {

	private static final long serialVersionUID = -5077561617338059275L;

	private Connection con;
	private RelatorioSistema relatorio;
	@SuppressWarnings("rawtypes")
	private Collection objetos;
	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * Constrói o relatório usando como parâetro a configuração do builder
	 * 
	 * @param builder
	 */
	private GeradorRelatorio(Builder builder) {
		this.relatorio = builder.relatorio;
		this.params = builder.params;
		this.con = builder.con;
		this.objetos = builder.objetos;
	}

	/**
	 * Responsável pela geraçã do relatório de acordo com os parâmetros informados
	 * na construção da instância.
	 * 
	 * @return relatório informado.
	 * @throws DomainException
	 * @throws IOException
	 */
	public byte[] downloadFile() throws RelatorioJasperException, IOException {
		byte[] output = null;
		try {

			switch (relatorio.getTipo()) {
			case PDF:
				output = pdf();
				break;
			case XLS:
				output = xls();
				break;
			case DOC:
				output = doc();
				break;
			default:
			}
			return output;
		} catch (JRException e) {
			e.printStackTrace();
			throw new RelatorioJasperException("Erro ao gerar relatório" + e, e);
		}
	}

	/**
	 * Responsável por gerar o arquivo PDF
	 * 
	 * @return relatrório PDF
	 * @throws JRException
	 * @throws IOException
	 */
	private byte[] pdf() throws JRException, IOException {
		ByteArrayResource resource = null;// LeitorArquivo.class.getClassLoader().getResourceAsStream(path);
		try (InputStream resourceAsStream = GeradorRelatorio.class.getClassLoader()
				.getResourceAsStream(this.relatorio.getJasper())) {
			JRBeanCollectionDataSource ds = null;
			JasperPrint printer = null;
			if (!ObjectUtils.isEmpty(objetos)) {
				ds = new JRBeanCollectionDataSource(objetos);
				printer = JasperFillManager.fillReport(resourceAsStream, params, ds);
			} else {
				printer = JasperFillManager.fillReport(resourceAsStream, params, con);
			}

			try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
				JasperExportManager.exportReportToPdfStream(printer, byteArrayOutputStream);
				resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());
			}
		}
		return resource.getByteArray();
	}

	/**
	 * Responsável por gerar o arquivo XLS
	 * 
	 * @return relatório XLS
	 * @throws JRException
	 */
	private byte[] xls() throws IOException, JRException {
		// TODO implementar se necess�rio
		return null;
	}

	/**
	 * Responsável por gerar o arquivo DOC
	 * 
	 * @return relatório DOC
	 * @throws JRException
	 */
	private byte[] doc() throws IOException, JRException {
		// TODO implementar se necess�rio
		return null;
	}

	/**
	 * Responsável por gerenciar a configuração da construção do relatório
	 * 
	 * @author vinicius
	 *
	 */
	public static class Builder {

		private RelatorioSistema relatorio;
		private Map<String, Object> params = new HashMap<String, Object>();
		private Connection con;
		@SuppressWarnings("rawtypes")
		private Collection objetos;

		public Builder(RelatorioSistema relatorio) throws RelatorioJasperException {
			if (relatorio == null) {
				throw new RelatorioJasperException("É preciso informar o relatório");
			}
			
			if (relatorio.getSubReport() != null) {
				this.addSubReport("SUBREPORT_DIR", relatorio.getSubReport());
			}
			this.relatorio = relatorio;
			this.params.put("nomeRelatorio", relatorio.getTitulo());
		}

		public Builder addParam(String name, Object value) {
			this.params.put(name, value);
			return this;
		}
		
		public Builder addImage(String name, String value) {
			String realPath = ServletActionContext.getServletContext()
					.getRealPath(File.separator + "images" + File.separator + value);
			this.params.put(name, realPath);
			return this;
		}
		
		public Builder addSubReport(String name, String value) {
			String realPath = ServletActionContext.getServletContext()
					.getRealPath( File.separator + "WEB-INF" + File.separator + "reports" + File.separator + value);
			this.params.put(name, realPath.substring(0, realPath.indexOf(value)));
			return this;
		}

		public Builder addConnection(Connection con) {
			this.con = con;
			return this;
		}

		@SuppressWarnings("rawtypes")
		public Builder addObjetos(Collection objetos) {
			this.objetos = objetos;
			return this;
		}

		public GeradorRelatorio build() {
			return new GeradorRelatorio(this);
		}

	}

	public RelatorioSistema getRelatorio() {
		return relatorio;
	}

	public Map<String, Object> getParams() {
		return params;
	}

}
