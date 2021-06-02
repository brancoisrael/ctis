package br.jus.tream.saude.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DAO.XProdutoDAOImpl;
import br.jus.tream.saude.dominio.BeanResult;



@SuppressWarnings("serial")
@Namespace("/integracao")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class IntegracaoAction extends ActionSupport {
	
	private BeanResult result;
	private String fileUpload;
	private File file;
    private String contentType;
    private String filename;
    private List<String> erros = new ArrayList<String>();
    private List<String> sucessos = new ArrayList<String>();
     
    public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}
	
    public String getFileUpload() {
 		return fileUpload;
 	}

 	public void setFileUpload(String fileUpload) {
 		this.fileUpload = fileUpload;
 	}
     
    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadContentType(String contentType) {
       this.contentType = contentType;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }
    
    public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	public List<String> getSucessos() {
		return sucessos;
	}

	public void setSucessos(List<String> sucessos) {
		this.sucessos = sucessos;
	}

	@Action( value = "carregar",
    			results={@Result(name="success", location="/integracao/integracao-listar.jsp"),
    			         @Result(name="input", location="/integracao/integracao-listar.jsp"),
    			         @Result(name="error", location="/integracao/integracao-listar.jsp")
    				},
    			            interceptorRefs={
    				        @InterceptorRef(
    				            params={"allowedTypes","application/xml, text/xml",
    						    "maximumSize","1000000"}, 
    				            value="fileUpload"
    				        ),
    				        @InterceptorRef("authStack"),
    				        @InterceptorRef("validation")
    			    }
    			)
	public String doIncluir() {
        try {
        	if (file == null) {
        		this.erros.add("Xml não enviado!");
        	} else {
        		System.out.println(file.getName());
        		System.out.println(filename);
        		this.sucessos.add("Processado com sucesso");
        	}
            
        } catch (Exception e) {
        	 addActionError(getText("inserir.error"));
        	 return "error";
        }
        return SUCCESS;
	}	
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/integracao/integracao-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			this.sucessos.clear();
			//this.erros.add("error 1");
			//this.erros.add("error 2");
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
}
