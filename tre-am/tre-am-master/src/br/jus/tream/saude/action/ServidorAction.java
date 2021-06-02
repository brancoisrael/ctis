package br.jus.tream.saude.action;

import java.time.LocalDate;
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

import br.jus.tream.saude.DAO.CredenciadoDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.CredenciadoDTO;
import br.jus.tream.saude.DTO.CustoGuiaDTO;
import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.DTO.GuiaDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.InfoGuiaDTO;
import br.jus.tream.saude.business.BeneficiarioBusiness;
import br.jus.tream.saude.business.DominioBusiness;
import br.jus.tream.saude.business.GuiaBusiness;
import br.jus.tream.saude.business.GuiaProcedimentoBusiness;
import br.jus.tream.saude.dominio.BeanResult;
import br.jus.tream.saude.dominio.Beneficiario;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.util.Mapeador;

@SuppressWarnings("serial")
@Namespace("/servidor")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ServidorAction extends ActionSupport {

	private List<GuiaDTO> guias;
	private List<GuiaProcedimentoDTO> guiasProcedimento;
	private List<GuiaProcedimentoDashBoardDTO> guiaProcedimentoDashBoardDTO;
	private GuiaDTO guia;
	private String flag;
	private BeanResult result;
	private Pagination pagination = new Pagination(10, 1);
	private GuiaProcedimentoParamsDTO params;
	private Long idCredenciada = 744l;
	private Long id;
	private GuiaPK guiaPK;
	private Usuario usuario;
	public CredenciadoDTO credenciado;
	private Mapeador map = new Mapeador();

	private Long totalGuiaEmtidaMes = 40l;

	private Beneficiario beneficiarioTitular;
	private Beneficiario beneficiarioDependente;
	
	private InfoGuiaDTO infoGuiaDTO;

	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "guiaProcedimentoDashBoardDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarJson() {
		long tempoInicial = System.currentTimeMillis();
		try {
			if (params == null) {
				params = new GuiaProcedimentoParamsDTO();
			}
			params.setIdCredenciada(idCredenciada);
			this.guiaProcedimentoDashBoardDTO = GuiaProcedimentoBusiness.getInstance().findByParamsNative(params, pagination);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("listar.error"));
			return "error";
		}
		System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial) / 1000);
		return "success";
	}

	@Action(value = "infoGuiaJson", results = { @Result(name = "success", type = "json", params = { "root", "infoGuiaDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doInfoGuiaJson() {
		long tempoInicial = System.currentTimeMillis();
		try {
			Guia guiaGerenciada = GuiaBusiness.getInstance().getBean(guiaPK);
			this.guia = map.paraDto(guiaGerenciada, GuiaDTO.class);
			if (this.guia != null && this.guia.getMatriculaServidor() != null) {
				this.beneficiarioTitular = BeneficiarioBusiness.getInstance().getTitular(this.guia.getMatriculaServidor());
			}
			if (this.guia != null && this.guia.isDependente()) {
				this.beneficiarioDependente = BeneficiarioBusiness.getInstance().findDependente(this.guia.getMatriculaServidor(), this.guia.getCodigoDependente().intValue());
			} else {
				this.beneficiarioDependente = this.beneficiarioTitular;
			}
			
			CustoGuiaDTO custoGuiaDTO = GuiaProcedimentoBusiness.getInstance().getCustosGuia(guiaGerenciada);
			this.infoGuiaDTO = new InfoGuiaDTO(this.guia, this.beneficiarioTitular, this.beneficiarioDependente, custoGuiaDTO);
			
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial));
		return "success";
	}

	@Action(value = "listar", results = { @Result(name = "success", location = "/servidor/guias/guia-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			this.usuario = (Usuario) session.getAttribute("login");
			this.credenciado = map.paraDto(CredenciadoDAOImpl.getInstance().findById(idCredenciada),
					CredenciadoDTO.class);
			if (params == null) {
				params = new GuiaProcedimentoParamsDTO();
			}
			LocalDate hoje = LocalDate.now();
			params.setDataInicial(LocalDate.of(hoje.getYear(), hoje.getMonthValue(), 1));
			params.setDataFinal(LocalDate.of(hoje.getYear(), hoje.getMonthValue(), 30));
			List<GuiaProcedimento> lista = GuiaProcedimentoBusiness.getInstance().findByParams(params, pagination);
			this.totalGuiaEmtidaMes = (long) lista.size();

		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "inserir", results = { 
			@Result(name = "success", type = "json", params = { "root", "result" }),
			//@Result(name = "success", location = "listar", type="redirect"),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doInserir() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Usuario b = (Usuario) session.getAttribute("login");
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			if (b.getCdPerfil() == 1) {
				
			} else {
				res.setId(0);
				res.setMensagem(getText("permissao.negada"));
			}
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

	public List<GuiaDTO> getGuias() {
		return guias;
	}

	public void setGuias(List<GuiaDTO> guias) {
		this.guias = guias;
	}

	public GuiaDTO getGuia() {
		return guia;
	}

	public void setGuia(GuiaDTO guia) {
		this.guia = guia;
	}

	public CredenciadoDTO getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(CredenciadoDTO credenciado) {
		this.credenciado = credenciado;
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

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	
	public GuiaProcedimentoParamsDTO getParams() {
		return params;
	}

	public void setParams(GuiaProcedimentoParamsDTO params) {
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Beneficiario getBeneficiarioTitular() {
		return beneficiarioTitular;
	}

	public void setBeneficiarioTitular(Beneficiario beneficiarioTitular) {
		this.beneficiarioTitular = beneficiarioTitular;
	}

	public Beneficiario getBeneficiarioDependente() {
		return beneficiarioDependente;
	}

	public void setBeneficiarioDependente(Beneficiario beneficiarioDependente) {
		this.beneficiarioDependente = beneficiarioDependente;
	}

	public Long getIdCredenciada() {
		return idCredenciada;
	}

	public void setIdCredenciada(Long idCredenciada) {
		this.idCredenciada = idCredenciada;
	}

	public GuiaPK getGuiaPK() {
		return guiaPK;
	}

	public void setGuiaPK(GuiaPK guiaPK) {
		this.guiaPK = guiaPK;
	}

	public Long getTotalGuiaEmtidaMes() {
		return totalGuiaEmtidaMes;
	}

	public void setTotalGuiaEmtidaMes(Long totalGuiaEmtidaMes) {
		this.totalGuiaEmtidaMes = totalGuiaEmtidaMes;
	}

	public InfoGuiaDTO getInfoGuiaDTO() {
		return infoGuiaDTO;
	}

	public void setInfoGuiaDTO(InfoGuiaDTO infoGuiaDTO) {
		this.infoGuiaDTO = infoGuiaDTO;
	}

	public List<GuiaProcedimentoDTO> getGuiasProcedimento() {
		return guiasProcedimento;
	}

	public void setGuiasProcedimento(List<GuiaProcedimentoDTO> guiasProcedimento) {
		this.guiasProcedimento = guiasProcedimento;
	}

	public List<GuiaProcedimentoDashBoardDTO> getGuiaProcedimentoDashBoardDTO() {
		return guiaProcedimentoDashBoardDTO;
	}

	public void setGuiaProcedimentoDashBoardDTO(List<GuiaProcedimentoDashBoardDTO> guiaProcedimentoDashBoardDTO) {
		this.guiaProcedimentoDashBoardDTO = guiaProcedimentoDashBoardDTO;
	}
	

}
