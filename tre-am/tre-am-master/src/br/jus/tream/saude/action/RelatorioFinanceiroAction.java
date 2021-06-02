package br.jus.tream.saude.action;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.business.RelatorioBusiness;
import br.jus.tream.saude.enumeration.RelatorioSistema;
import br.jus.tream.saude.enumeration.RelatoriosFinanceiro;

@Namespace("/relatorios-financeiro")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class RelatorioFinanceiroAction extends ActionSupport {
	private static final long serialVersionUID = 4566812143851929830L;
	private List<RelatoriosFinanceiro> relatoriosFinanceiro = new ArrayList<RelatoriosFinanceiro>();
	private String relatorio;
	// ATRIBUTOS PARA FAZER O DOWNLOAD
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private InputStream inputStream;
	private byte[] buffer;
	
	private Integer mes;
	private Integer ano; 
	
	@Action(value = "listar", 
			results = { @Result(name = "success", location = "/relatorios/financeiro/relatorio.financeiro.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			processaRelatoriosFinanceiro();

		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "imprimir",
            results = { @Result(name = "success", type = "stream",
                params = { "contentType", "application/octet-stream",
                            "inputName", "inputStream",
                            "contentCharSet", "ISO-8859-1",
                            "bufferSize", "4096",
                            "contentDisposition","filename=\"${uploadFileName}\"" }), 
            		@Result(name = "error", location = "/pages/error.jsp")  })
	public String downloadPDF() {
		try {
				buffer = gerarRelatorio();
				inputStream = new ByteArrayInputStream(buffer);
			} catch (Exception e) {
				return "error";
		}
		return "success";
	}
	
	@Action(value = "imprimirTela",
            results = { @Result(name = "success", type = "stream",
                params = { "contentType", "application/pdf",
                            "inputName", "inputStream",
                            "bufferSize", "1024",
                            "contentDisposition","filename=\"${uploadFileName}\"" }) })
	public String downloadPDF2() {
		try {
				buffer = gerarRelatorio();
				inputStream = new ByteArrayInputStream(buffer);
			} catch (Exception e) {
				return "error";
		}
		return "success";
	}
	
	public byte[] gerarRelatorio() throws Exception {
		ReportParams filtros = new ReportParams();
		filtros.setMes(mes);
		filtros.setAno(ano);
		
		byte[] arrayByte = null;
		RelatorioSistema rel;
				
		switch (relatorio) {
			case "QT_BENEFICIARIO":
				this.uploadFileName = RelatoriosFinanceiro.QT_BENEFICIARIO.getDescricao()+".pdf";
				rel = RelatorioSistema.RELATORIO_BENEFICIARIO_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfBeneficiarioAnual(filtros, rel);
			break;
			case "GRAFICO_QT_BENEFICIARIO_ANUAL":
				this.uploadFileName = RelatoriosFinanceiro.GRAFICO_QT_BENEFICIARIO_ANUAL.getDescricao()+".pdf";
				rel = RelatorioSistema.GRAFICO_BENEFICIARIO_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfGraficoBeneficiario(filtros, rel);
			break;
			case "GRAFICO_QT_BENEFICIARIO_POR_TIPO":
				this.uploadFileName = RelatoriosFinanceiro.GRAFICO_QT_BENEFICIARIO_POR_TIPO.getDescricao()+".pdf";
				rel = RelatorioSistema.GRAFICO_BENEFICIARIO_POR_TIPO_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfGraficoBeneficiario(filtros, rel);
			break;
			case "MENSALIDADE":
				this.uploadFileName = RelatoriosFinanceiro.MENSALIDADE.getDescricao()+".pdf";
				rel = RelatorioSistema.RELATORIO_MENSALIDADES_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfMensalidadeAnual(filtros, rel);
			break;
			case "GRAFICO_MENSALIDADE":
				this.uploadFileName = RelatoriosFinanceiro.GRAFICO_MENSALIDADE.getDescricao()+".pdf";
				rel = RelatorioSistema.GRAFICO_MENSALIDADES;
				arrayByte = RelatorioBusiness.getInstance().getPdfGraficoMensalidadeAnual(filtros, rel);
			break;
			case "COOPARTICIPACAO":
				this.uploadFileName = RelatoriosFinanceiro.COOPARTICIPACAO.getDescricao()+".pdf";
				rel = RelatorioSistema.RELATORIO_COPARTICIPACAO_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfCoparticipacaoAnual(filtros, rel);
			break;
			case "GRAFICO_COOPARTICIPACAO":
				this.uploadFileName = RelatoriosFinanceiro.GRAFICO_COOPARTICIPACAO.getDescricao()+".pdf";
				rel = RelatorioSistema.GRAFICO_COPARTICIPACAO;
				arrayByte = RelatorioBusiness.getInstance().getPdfGraficoCoparticipacaoAnual(filtros, rel);
			break;
			case "DESPESAS":
				this.uploadFileName = RelatoriosFinanceiro.DESPESAS.getDescricao()+".pdf";
				rel = RelatorioSistema.RELATORIO_DESPESAS_ANUAL;
				arrayByte = RelatorioBusiness.getInstance().getPdfDespesasAnual(filtros, rel);
			break;
			case "GRAFICO_DESPESAS":
				this.uploadFileName = RelatoriosFinanceiro.GRAFICO_DESPESAS.getDescricao()+".pdf";
				rel = RelatorioSistema.GRAFICO_DESPESAS;
				arrayByte = RelatorioBusiness.getInstance().getPdfGraficoDespesasAnual(filtros, rel);
			break;
		}		
		
		return arrayByte;
	}
	
	public void processaRelatoriosFinanceiro() {
		for (RelatoriosFinanceiro rel : RelatoriosFinanceiro.values()) {
			relatoriosFinanceiro.add(rel);
		}
	}
	
	public List<RelatoriosFinanceiro> getRelatoriosFinanceiro() {
		return relatoriosFinanceiro;
	}

	public void setRelatoriosFinanceiro(List<RelatoriosFinanceiro> relatoriosFinanceiro) {
		this.relatoriosFinanceiro = relatoriosFinanceiro;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}
	
	
	
}
