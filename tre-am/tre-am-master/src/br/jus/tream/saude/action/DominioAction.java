package br.jus.tream.saude.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.business.DominioBusiness;
import br.jus.tream.saude.dominio.BeanResult;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Usuario;

@SuppressWarnings("serial")
@Namespace("/dominios")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class DominioAction extends ActionSupport {

	private List<Dominio> dominios;
	private Dominio dominio;
	private String flag;
	private BeanResult result;
	private Pagination pagination = new Pagination(10, 1);
	private DominioParamsDTO params;
	private List<String> tiposDominios;
	private Long id;

	private boolean success;
	private boolean danger;

	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "dominios" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarJson() {

		try {
			this.dominios = DominioBusiness.getInstance().findPaginado(this.pagination);
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}	
	
	@Action(value = "listar", results = {
			@Result(name = "success", location = "/configuracao/dominio/dominio-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			this.dominios = DominioBusiness.getInstance().findPaginado(pagination);
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "pesquisar", results = {
			@Result(name = "success", type = "json", params = { "root", "dominios" } ),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doPesquisar() {// interceptorRefs = @InterceptorRef("authStack")

		try {
			this.dominios = DominioBusiness.getInstance().findByParams(params, pagination);
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "tiposDominio", results = {
			@Result(name = "success", type = "json", params = { "root", "tiposDominios" }),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarTiposDominio() {// interceptorRefs = @InterceptorRef("authStack")

		try {
			this.tiposDominios = DominioBusiness.getInstance().findTiposDominio();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "frmSetupNovo", results = {
			@Result(name = "success", location = "/configuracao/dominio/frmDominio.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String frmSetupNovo() {
		try {
			this.flag = "inserir";
		} catch (Exception e) {
			addActionError(getText("frmsetup.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "remover", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String remover() {
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			Usuario b = (Usuario) session.getAttribute("login");
			//if (b.getCdPerfil()== 1) {
				ret = DominioBusiness.getInstance().remover(this.dominio);
				res.setMensagem("Dominio excluído com sucesso");
				res.setId(ret);
				this.result = res;
			/*} else {
				res.setId(0);
				res.setMensagem(getText("permissao.negada"));
			}*/
		} catch (Exception e) {
			addActionError(getText("remover.error"));
			res.setMensagem("Erro ao remover Dominio");
			res.setError(e.getMessage());
			this.result = res;
			return "error";
		}
		return "success";
	}

	@Action(value = "inserir", results = { 
			//@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "success", location = "listar", type="redirect"),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doInserir() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Usuario b = (Usuario) session.getAttribute("login");
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			//if (b.getCdPerfil() == 1) {
				/*params = new DominioParamsDTO(dominio);
				if (DominioBusiness.getInstance().isDominioCadastrado(params)) {
					res.setMensagem(getText("registro.existe"));
				} else {*/
					ret = DominioBusiness.getInstance().inserir(dominio);
					res.setMensagem(getText("inserir.sucesso"));
					res.setId(ret);
				//}
			/*} else {
				res.setId(0);
				res.setMensagem(getText("permissao.negada"));
			}*/
			this.result = res;
//			doListar();
		} catch (Exception e) {
			res.setMensagem(getText("inserir.error"));
			res.setError(e.getMessage());
			this.result = res;
			return "error";
		}
		return "success";
	}
	
	
	
	@Action(value = "frmSetupEditar", results = { 
			@Result(name = "success", location = "/configuracao/dominio/frmDominio.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String frmSetupEditar() {
		try {
			this.flag = "alterar";
			this.dominio = DominioBusiness.getInstance().getBean(id);
		} catch (Exception e) {
			addActionError(getText("frmsetup.error"));
			return "error";
		}
		return "success";
	}
	

	@Action(value = "alterar", results = { 
			//@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "success", location = "listar", type="redirect"),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, 
			interceptorRefs = @InterceptorRef("authStack"))
	public String doAlterar() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Usuario b = (Usuario) session.getAttribute("login");
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			//if (b.getCdPerfil() == 1) {
				ret = DominioBusiness.getInstance().alterar(dominio);
				res.setMensagem(getText("alterar.sucesso"));
				res.setId(ret);

			/*} else {
				res.setId(0);
				res.setMensagem(getText("permissao.negada"));
			}*/
			this.result = res;
		} catch (Exception e) {
			res.setMensagem(getText("alterar.error"));
			res.setError(e.getMessage());
			this.result = res;
			return "error";
		}
		return "success";
	}

	public List<Dominio> getDominios() {
		return dominios;
	}

	public void setDominios(List<Dominio> dominios) {
		this.dominios = dominios;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isDanger() {
		return danger;
	}

	public void setDanger(boolean danger) {
		this.danger = danger;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public DominioParamsDTO getParams() {
		return params;
	}

	public void setParams(DominioParamsDTO params) {
		this.params = params;
	}
	

	public List<String> getTiposDominios() {
		return tiposDominios;
	}

	public void setTiposDominios(List<String> tiposDominios) {
		this.tiposDominios = tiposDominios;
	}

	public String getBadgeSituacao(Dominio dominio) {
		return dominio.getSituacao().ordinal() == 1 ? "badge-success" : "badge-danger";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
