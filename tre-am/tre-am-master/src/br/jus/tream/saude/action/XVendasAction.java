package br.jus.tream.saude.action;

import java.util.Date;
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

import br.jus.tream.saude.DAO.XVendaDAO;
import br.jus.tream.saude.DAO.XVendaDAOImpl;
import br.jus.tream.saude.DAO.XVendaItemDAO;
import br.jus.tream.saude.DAO.XVendaItemDAOImpl;
import br.jus.tream.saude.DTO.ProdutosMaisVendidos;
import br.jus.tream.saude.DTO.VendaSituacaoDTO;
import br.jus.tream.saude.dominio.BeanResult;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.dominio.XVenda;
import br.jus.tream.saude.dominio.XVendaItens;

@SuppressWarnings("serial")
@Namespace("/comandas")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class XVendasAction extends ActionSupport {
	private List<XVenda> lstVenda;
	private List<VendaSituacaoDTO> lstVendaSituacao;
	private List<XVendaItens> itens;
	private List<ProdutosMaisVendidos> lstProdutosMaisVendidos;
	
   // private VendaItens item;
	private XVenda venda;
	private int id = 0;
	private BeanResult result;
	private final static XVendaDAO daoVenda = XVendaDAOImpl.getInstance();
	private final static XVendaItemDAO daoItens = XVendaItemDAOImpl.getInstance();
	
	
	@Action(value = "frmSetupFechar", results = { @Result(name = "success", location = "/forms/frmFecharVenda.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")},
		   interceptorRefs = @InterceptorRef("authStack"))
	public String setupFechar() {
		try {
			 this.venda = daoVenda.getBean(this.getId());
		} catch (Exception e) {
			addActionError(getText("frmsetup.error") + " SystemError: " + e.getMessage() );
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "fechar", results = { 
			@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp")},
          	interceptorRefs = @InterceptorRef("authStack"))
	public String doFechar() {
		BeanResult res = new BeanResult();
		try {
			 this.venda = daoVenda.getBean(this.id);
//			 this.venda.setStatus(2);
			 res.setId(daoVenda.alterar(this.venda));
			 res.setMensagem(getText("fechameto.sucesso"));
		} catch (Exception e) {
			   res.setId(0);
			  res.setMensagem(getText("fechamento.erro") + " SystemError: " + e.getMessage());
			 this.result = res;
			return "error";
		}
		 this.result = res;
		return "success";
	}
	
	@Action(value = "mudarStatus", results = { 
			@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp")},
          	interceptorRefs = @InterceptorRef("authStack"))
	public String doMudarStatus() {
		BeanResult res = new BeanResult();
		try {
//			 this.venda = daoVenda.getBean(this.venda.getId());
//			 this.venda.setStatus(this.id);
			 res.setId(daoVenda.alterar(this.venda));
			 res.setMensagem(getText("pedir.conta"));
		} catch (Exception e) {
			   res.setId(0);
			  res.setMensagem(getText("error.label") + " SystemError: " + e.getMessage());
			 this.result = res;
			return "error";
		}
		 this.result = res;
		return "success";
	}
	
	@Action(value = "frmSetupNova", results = { @Result(name = "success", location = "/forms/frmNovaVenda.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")},
		   interceptorRefs = @InterceptorRef("authStack"))
	public String setupNova() {
		return "success";
	}
	
	@Action(value = "situacao", results = { @Result(name = "success", location = "/consultas/vendas-situacao.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")},
		   interceptorRefs = @InterceptorRef("authStack"))
	public String doListarSituacao() {
		return "success";
	}
	
	@Action(value = "inserir", results = { @Result(name = "success", location = "/pages/result.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")},
			interceptorRefs = @InterceptorRef("authStack"))
	public String doInserir() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			Usuario b = (Usuario)session.getAttribute("login");
			 for(XVendaItens item: this.itens) {
//				 item.setValor(item.getSubTotal());
//				 item.setDesconto(0.0);
//				 item.setVenda(this.venda);
//				 this.venda.getItens().add(item);	 
			 }
//			 this.venda.setUsuario(b);
//			 this.venda.setStatus(0);
//			 this.venda.setTotal(this.venda.getValorTotal());
//			 this.venda.setDatacad(new Date(System.currentTimeMillis()));
			 daoVenda.inserir(this.venda);
			 addActionMessage(getText("inserir.sucesso"));
		} catch (Exception e) {
			addActionError(getText("inserir.error") + " SystemError: " + e.getMessage() );
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmCadVendaItem", results = { @Result(name = "success", location = "/forms/frmCadVendaItem.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")},
			interceptorRefs = @InterceptorRef("authStack"))
	public String frmSetupVendaItem() {
		return "success";
	}
	
	@Action(value = "incluirItem", results = { @Result(name = "success", location = "/pages/result.jsp"),
			@Result(name = "error", location = "/pages/result.jsp")},
			interceptorRefs = @InterceptorRef("authStack"))
	public String doIncluirItem() {
		try {
			//HttpSession session = ServletActionContext.getRequest().getSession(true);
			//Usuario b = (Usuario)session.getAttribute("login");
			Double soma = 0.0;
			for(XVendaItens item: this.itens) {
//				 item.setValor(item.getSubTotal());
//				 item.setVenda(this.venda);
//				 soma += item.getValor();
//				 daoItens.insert(item);
				 //this.venda.getItens().add(item);	 
//				 System.out.println("Item " + item.getProduto().getId());
			 }
//			XVenda v = daoVenda.getBean(this.venda.getId());
		    // System.out.println("Venda " + v.getId() + " Cliente " + v.getCliente().getNome());
//		     soma += v.getTotal();
//			 v.setTotal(soma);
//			 daoVenda.alterar(v);
			 //daoItens.insert(it);
			 addActionMessage(getText("inserir.sucesso"));
		} catch (Exception e) {
			addActionError(getText("inserir.error") + " SystemError: " + e.getMessage() );
			return "error";
		}
		return "success";
	}
	
	@Action(value = "remover", results = {
			@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doExcluir() {
		BeanResult result = new BeanResult();
		int ret = 0;
		try {
			// SOMENTE ADMINISTRADORES PODEM EXCLUIR TODA A COMANDA
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			Usuario b = (Usuario)session.getAttribute("login");
			if (b.getCdPerfil() ==1) {
				ret = daoVenda.remover(this.venda);
				result.setId(ret);
				result.setMensagem(getText("remover.sucesso"));
			}else
			{	
				result.setId(0);
				result.setMensagem(getText("permissao.negada"));
			}
			this.result = result;
			
		} catch (Exception e) {
			    result.setId(0);
			   result.setMensagem(getText("remover.error") +" Error:" + e.getMessage());
			  this.result = result;
			 //addActionError(getText("remover.error") +" Error:" + e.getMessage());
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/vendas-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}, 
			interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			this.lstVenda = daoVenda.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstVenda" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarJson() {

		try {
			this.lstVenda = daoVenda.listar();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarSituacaoJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstVendaSituacao" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarSituacaoJson() {

		try {
			this.lstVendaSituacao = daoVenda.listarSituacao();
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarPorDataJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstVenda" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarPorDataJson() {

		try {
			this.lstVenda = daoVenda.listar("11/06/2018","11/06/2018");
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	

	@Action(value = "getBeanJson", results = { @Result(name = "success", type = "json", params = { "root", "venda" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	public String getBeanJson() {
		try {
			this.venda = daoVenda.getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
			return "error";
		}
		return "success";
	}

	@Action(value = "getBeanLimpo", results = { @Result(name = "success", location = "/consultas/vendas-bean-limpo.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}, 
			interceptorRefs = @InterceptorRef("authStack"))
	public String getBeanLimpo() {
		try {
			this.venda = daoVenda.getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "getProdutosMaisVendidos", results = { @Result(name = "success", location = "/consultas/produto-mais-vendidos.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")}, 
			interceptorRefs = @InterceptorRef("authStack"))
	public String getProdutosMaisVendidos() {
		try {
			this.lstProdutosMaisVendidos = daoVenda.ListarProdutosMaisVendidos();
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "getProdutosMaisVendidosJson", results = { @Result(name = "success", type = "json", params = { "root", "lstProdutosMaisVendidos" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	public String getProdutosMaisVendidosJson() {
		try {
			this.lstProdutosMaisVendidos = daoVenda.ListarProdutosMaisVendidos();
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
			return "error";
		}
		return "success";
	}
	
	public List<XVenda> getLstVenda() {
		return lstVenda;
	}

	public void setLstVenda(List<XVenda> lstVenda) {
		this.lstVenda = lstVenda;
	}

	public XVenda getVenda() {
		return venda;
	}

	public void setVenda(XVenda venda) {
		this.venda = venda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<XVendaItens> getItens() {
		return itens;
	}

	public void setItens(List<XVendaItens> itens) {
		this.itens = itens;
	}

	/*public VendaItens getItem() {
		return item;
	}

	public void setItem(VendaItens iten) {
		this.item = iten;
	}*/

	public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}

	public List<VendaSituacaoDTO> getLstVendaSituacao() {
		return lstVendaSituacao;
	}

	public void setLstVendaSituacao(List<VendaSituacaoDTO> lstVendaSituacao) {
		this.lstVendaSituacao = lstVendaSituacao;
	}


	public List<ProdutosMaisVendidos> getLstProdutosMaisVendidos() {
		return lstProdutosMaisVendidos;
	}


	public void setLstProdutosMaisVendidos(List<ProdutosMaisVendidos> lstProdutosMaisVendidos) {
		this.lstProdutosMaisVendidos = lstProdutosMaisVendidos;
	}


}