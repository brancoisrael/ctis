package br.jus.tream.saude.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.business.RelatorioBusiness;
import br.jus.tream.saude.enumeration.RelatorioSistema;
import br.jus.tream.saude.exception.RelatorioJasperException;

/**
 * 
 * @author vinicius
 *
 */
@Namespace("/relatorio")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class RelatorioAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS PARA FAZER O DOWNLOAD DO ARQUIVO
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private InputStream inputStream;

	@Action(value = "/downloadReport", results = { @Result(name = "success", type = "stream", 
			params = { "contentType", "application/octet-stream", "inputName", "inputStream", "bufferSize", "1024", "contentDisposition",
			"filename=\"${uploadFileName}\"" }) })
	public String downloadRelatorio() {
//		try {
//			RelatorioSistema relatorio = RelatorioSistema.GUIA_PDF;
//			this.uploadFileName = relatorio.getDescricao();
//			byte[] buffer = RelatorioBusiness.getInstance().getPdfGuia(new ReportParams(), relatorio);
//			inputStream = new ByteArrayInputStream(buffer);
//		} catch (RelatorioJasperException e) {
//			e.printStackTrace();
//			return "error";
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
		return "success";
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

}