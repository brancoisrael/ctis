package br.jus.tream.saude.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.YearMonth;
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

import br.jus.tream.saude.DAO.AnexoDespesaDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DAO.SituacaoDAOImpl;
import br.jus.tream.saude.DTO.CredenciadoDTO;
import br.jus.tream.saude.DTO.CustoGuiaDTO;
import br.jus.tream.saude.DTO.GuiaDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.InfoGuiaDTO;
import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.business.BeneficiarioBusiness;
import br.jus.tream.saude.business.GuiaBusiness;
import br.jus.tream.saude.business.GuiaProcedimentoBusiness;
import br.jus.tream.saude.business.RelatorioBusiness;
import br.jus.tream.saude.dominio.AnexoDespesa;
import br.jus.tream.saude.dominio.BeanResult;
import br.jus.tream.saude.dominio.Beneficiario;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.Situacao;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;
import br.jus.tream.saude.enumeration.ClassificacaoTipoGuia;
import br.jus.tream.saude.enumeration.RelatorioSistema;
import br.jus.tream.saude.enumeration.TipoBeneficiario;
import br.jus.tream.saude.util.Mapeador;

@SuppressWarnings("serial")
@Namespace("/credenciado")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class GuiaAction extends ActionSupport {

	private List<GuiaDTO> guias;
	private List<GuiaProcedimentoDashBoardDTO> guiaProcedimentoDashBoardDTO;
	private List<GuiaProcedimentoDTO> guiasProcedimento;
	private GuiaDTO guia;
	private String flag;
	private BeanResult result;
	private Pagination pagination = new Pagination(10, 1);
	private GuiaProcedimentoParamsDTO params = new GuiaProcedimentoParamsDTO();;
	private Long idCredenciada = 0l;
	private Long id;
	private GuiaPK guiaPK;
	private Usuario usuario = new Usuario();
	public CredenciadoDTO credenciado;
	private Mapeador map = new Mapeador();

	private Long totalGuiaEmtidaMes = 0l;
	private Long totalGuiasAutorizadaMes = 0l;
	private Long totalGuiasEmAutorizacaoMes = 0l;
	private Long totalGuiasCanceladasMes = 0l;

	private Beneficiario beneficiarioTitular;
	private Beneficiario beneficiarioDependente;
	
	private InfoGuiaDTO infoGuiaDTO;
	
	private List<Situacao> situacoes;
	
	// ATRIBUTOS PARA FAZER O DOWNLOAD DA IMAGEM
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private InputStream inputStream;
	
	private Long idAnexoDespesa;

	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "pagination", "guiaProcedimentoDashBoardDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarJson() {
		long tempoInicial = System.currentTimeMillis();
		try {
			getCredenciadoSession();
			
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

	public void getCredenciadoSession() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		UsuarioCredenciadaVW credenciadaVW = (UsuarioCredenciadaVW) session.getAttribute("loginCredenciada");
		if (credenciadaVW != null) {
			usuario.setNome(credenciadaVW.getNomeInstituicao());
			usuario.setLogin(credenciadaVW.getUsuario());
			
			this.credenciado = map.paraDto(credenciadaVW.getCredenciado(),
					CredenciadoDTO.class);
			idCredenciada = this.credenciado.getId();
		}
	}
	
	@Action(value = "infoGuiaJson", results = { @Result(name = "success", type = "json", params = { "root", "infoGuiaDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
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

	@Action(value = "despesa-json",
            results = { @Result(name = "success", type = "stream",
                params = { "contentType", "application/octet-stream",
                            "inputName", "inputStream",
                            "bufferSize", "1024",
                            "contentDisposition","filename=\"${uploadFileName}\"" }) }, interceptorRefs = @InterceptorRef("authStack"))
	public String downloadDespesa() {
		try {
				AnexoDespesa anexo = AnexoDespesaDAOImpl.getInstance().findById(idAnexoDespesa);
				this.uploadFileName = anexo.getNome();
				byte[] buffer = anexo.getDocumento();
				inputStream = new ByteArrayInputStream(buffer);
			}catch (Exception e) {
				return "error";
			}
		return "success";
	}
	
	@Action(value = "imprimirJson",
            results = { @Result(name = "success", type = "stream",
                params = { "contentType", "application/octet-stream",
                            "inputName", "inputStream",
                            "bufferSize", "1024",
                            "contentDisposition","filename=\"${uploadFileName}\"" }) }, interceptorRefs = @InterceptorRef("authStack"))
	public String downloadPDF() {
		try {
				RelatorioSistema relatorio = RelatorioSistema.GUIA_PDF;
				
				Guia guiaGerenciada = GuiaBusiness.getInstance().getBean(guiaPK);
				
				ReportParams filtros = new ReportParams();
				filtros.setAnoExercicio(guiaGerenciada.getGuiaPK().getAnoExercicio());
				filtros.setNumeroGuia(guiaGerenciada.getGuiaPK().getNumeroGuia());
				filtros.setIdTipoGuia(guiaGerenciada.getGuiaPK().getTipoGuia().getId());
				String tipoBeneficiario = guiaGerenciada.getCodigoDependente() == null ? TipoBeneficiario.TITULAR.getDescricao() :  TipoBeneficiario.DEPENDENTE.getDescricao();
				filtros.setTipoBeneficiario(tipoBeneficiario);
				
				this.uploadFileName = "Guia.pdf";
				byte[] buffer = RelatorioBusiness.getInstance().getPdfGuia(filtros, relatorio);
				inputStream = new ByteArrayInputStream(buffer);
			}catch (Exception e) {
				return "error";
		}
		return "success";
	}
	
	@Action(value = "imprimirJsonTela",
            results = { @Result(name = "success", type = "stream",
                params = { "contentType", "application/pdf",
                            "inputName", "inputStream",
                            "bufferSize", "1024",
                            "contentDisposition","filename=\"${uploadFileName}\"" }) }, interceptorRefs = @InterceptorRef("authStack"))
	public String downloadPDFTela() {
		try {
				RelatorioSistema relatorio = RelatorioSistema.GUIA_PDF;
				
				Guia guiaGerenciada = GuiaBusiness.getInstance().getBean(guiaPK);
				
				ReportParams filtros = new ReportParams();
				filtros.setAnoExercicio(guiaGerenciada.getGuiaPK().getAnoExercicio());
				filtros.setNumeroGuia(guiaGerenciada.getGuiaPK().getNumeroGuia());
				filtros.setIdTipoGuia(guiaGerenciada.getGuiaPK().getTipoGuia().getId());
				String tipoBeneficiario = guiaGerenciada.getCodigoDependente() == null ? TipoBeneficiario.TITULAR.getDescricao() :  TipoBeneficiario.DEPENDENTE.getDescricao();
				filtros.setTipoBeneficiario(tipoBeneficiario);
				
				this.uploadFileName = "Guia.pdf";
				byte[] buffer = RelatorioBusiness.getInstance().getPdfGuia(filtros, relatorio);
				inputStream = new ByteArrayInputStream(buffer);
			}catch (Exception e) {
				return "error";
		}
		return "success";
	}
	
	@Action(value = "listaSituacaoJson", results = { @Result(name = "success", type = "json", params = { "root", "situacoes" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarProcedimentoJson() {
		try {
		
			this.situacoes = SituacaoDAOImpl.getInstance().findAll();
		
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/credenciada/guias/guia-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListar() {

		try {
			getCredenciadoSession();
			params.setIdCredenciada(idCredenciada);
			this.guiaProcedimentoDashBoardDTO = GuiaProcedimentoBusiness.getInstance().findByParamsNative(params, pagination);
			//totais cards
			this.totalGuiaEmtidaMes = GuiaBusiness.getInstance().getTotalGuiasAnoMes(YearMonth.from(LocalDate.now()), idCredenciada, ClassificacaoTipoGuia.M);
			this.totalGuiasAutorizadaMes = GuiaBusiness.getInstance().getTotalGuiasAutorizadas(YearMonth.from(LocalDate.now()), idCredenciada, ClassificacaoTipoGuia.M);
			this.totalGuiasEmAutorizacaoMes = GuiaBusiness.getInstance().getTotalGuiasEmAutorizacao(YearMonth.from(LocalDate.now()), idCredenciada, ClassificacaoTipoGuia.M);
			this.totalGuiasCanceladasMes = GuiaBusiness.getInstance().getTotalGuiasCanceladas(YearMonth.from(LocalDate.now()), idCredenciada,ClassificacaoTipoGuia.M);
			//totais cards
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("listar.error"));
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

	public List<Situacao> getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(List<Situacao> situacoes) {
		this.situacoes = situacoes;
	}

	public Long getTotalGuiasAutorizadaMes() {
		return totalGuiasAutorizadaMes;
	}

	public void setTotalGuiasAutorizadaMes(Long totalGuiasAutorizadaMes) {
		this.totalGuiasAutorizadaMes = totalGuiasAutorizadaMes;
	}

	public Long getTotalGuiasEmAutorizacaoMes() {
		return totalGuiasEmAutorizacaoMes;
	}

	public void setTotalGuiasEmAutorizacaoMes(Long totalGuiasEmAutorizacaoMes) {
		this.totalGuiasEmAutorizacaoMes = totalGuiasEmAutorizacaoMes;
	}

	public Long getTotalGuiasCanceladasMes() {
		return totalGuiasCanceladasMes;
	}

	public void setTotalGuiasCanceladasMes(Long totalGuiasCanceladasMes) {
		this.totalGuiasCanceladasMes = totalGuiasCanceladasMes;
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

	public Long getIdAnexoDespesa() {
		return idAnexoDespesa;
	}

	public void setIdAnexoDespesa(Long idAnexoDespesa) {
		this.idAnexoDespesa = idAnexoDespesa;
	}	
	
}
