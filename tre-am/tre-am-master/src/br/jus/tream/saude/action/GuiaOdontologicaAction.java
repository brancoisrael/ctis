package br.jus.tream.saude.action;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DAO.BeneficiarioDAOImpl;
import br.jus.tream.saude.DAO.CredenciadoDAOImpl;
import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DAO.TipoGuiaDAOImpl;
import br.jus.tream.saude.DTO.ComboBoxDTO;
import br.jus.tream.saude.DTO.CredenciadoDTO;
import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.DTO.GuiaDTO;
import br.jus.tream.saude.DTO.ProcedimentoFormDTO;
import br.jus.tream.saude.DTO.ProcedimentoOdontologicoDTO;
import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.TabelaCredenciadoDTO;
import br.jus.tream.saude.business.BeneficiarioBusiness;
import br.jus.tream.saude.business.DespesaBusiness;
import br.jus.tream.saude.business.DominioBusiness;
import br.jus.tream.saude.business.GuiaBusiness;
import br.jus.tream.saude.business.GuiaProcedimentoOdontoBusiness;
import br.jus.tream.saude.business.ProcedimentoBusiness;
import br.jus.tream.saude.business.ProcedimentoOdontoBusiness;
import br.jus.tream.saude.business.TipoGuiaBusiness;
import br.jus.tream.saude.dominio.BeanResult;
import br.jus.tream.saude.dominio.Beneficiario;
import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimentoOdonto;
import br.jus.tream.saude.dominio.ProcedimentoPK;
import br.jus.tream.saude.dominio.Situacao;
import br.jus.tream.saude.dominio.TabelaCredenciado;
import br.jus.tream.saude.dominio.TipoGuia;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;
import br.jus.tream.saude.util.Mapeador;
import br.jus.tream.saude.util.ValidaHorarioUrgenciaUtil;

@SuppressWarnings("serial")
@Namespace("/guia-odontologica")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class GuiaOdontologicaAction extends ActionSupport {

	private List<Guia> guias;
	private Guia guia;
	private ProcedimentoOdontologicoDTO procedimento;
	private String flag;
	private BeanResult result;
	private Pagination pagination = new Pagination(10, 1);
	private DominioParamsDTO params;	
	private Long id;
	private List<Beneficiario> beneficiarios;
	private String matricula;
	private List<ComboBoxDTO> comboBoxDTO;
	
	private Mapeador map = new Mapeador();
	private Usuario usuario;
	public CredenciadoDTO credenciado;
	private Long idCredenciada = 740l;
	
	private List<ProcedimentoOdontologicoDTO> procedimentos;
	private ProcedimentoParamsDTO procedimentoParams;
	private ProcedimentoPK procedimentoPK;
	private String codigoProcedimento;
	
	private List<TipoGuia> tiposGuia = new ArrayList<TipoGuia>();
	private Long idTipoGuia = 101l;
	
	private TabelaCredenciadoDTO tabela;
	private TipoGuia tipoGuia;
	private GuiaDTO guiaDTO;
	private GuiaPK guiaPK;
	private FrmGuiaClinicaLaboratorialDTO  frmGuiaClinicaLaboratorialDTO;
	private boolean periodoUrgencia;
	private String procedimentoDespesa = "0";
	
	private String fileUpload;
	private String fileName;
	
	private static String GUIA_ODONTOLOGICA = "GUIA_ODONTOLOGICA";
	
	public void getCredenciadoSession() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		UsuarioCredenciadaVW credenciadaVW = (UsuarioCredenciadaVW) session.getAttribute("loginCredenciada");
		if (credenciadaVW != null) {
			usuario = new Usuario();
			usuario.setNome(credenciadaVW.getNomeInstituicao());
			usuario.setLogin(credenciadaVW.getUsuario());
			
			this.credenciado = map.paraDto(credenciadaVW.getCredenciado(),
					CredenciadoDTO.class);
			idCredenciada = this.credenciado.getId();
		}
	}
	
	@Action(value = "listarJson", results = { @Result(name = "success", type = "json", params = { "root", "comboBoxDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarJson() {
		this.comboBoxDTO = new ArrayList<ComboBoxDTO>();
		try {
			this.beneficiarios = BeneficiarioBusiness.getInstance().findBenenficiariosByMatricula(this.matricula);
			for (Beneficiario b : this.beneficiarios) {
				ComboBoxDTO combo = new ComboBoxDTO(b.getCodigoDependente(), b.getNome());
				this.comboBoxDTO.add(combo);
			}
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listaProcedimentosJson", results = { @Result(name = "success", type = "json", params = { "root", "procedimentos" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarProcedimentosJson() {
		try {
			//adicionar restri��o para tabela de pre�o
			getCredenciadoSession();
			this.procedimentoParams.setIdTabela(this.credenciado.getTabela().getId());
			this.procedimentos = map.paraListaDto(ProcedimentoOdontoBusiness.getInstance().findByParams(this.procedimentoParams), ProcedimentoOdontologicoDTO.class);
			
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listaProcedimentoJson", results = { @Result(name = "success", type = "json", params = { "root", "procedimento" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarProcedimentoJson() {
		try {
			
			getCredenciadoSession();
			
			TabelaCredenciado tabela = new TabelaCredenciado(this.credenciado.getTabela());			
			procedimentoPK = new ProcedimentoPK();
			procedimentoPK.setTabela(tabela);
			procedimentoPK.setCodigoProcedimento(codigoProcedimento);
			
			this.procedimento = map.paraDto(ProcedimentoOdontoBusiness.getInstance().findById(procedimentoPK), ProcedimentoOdontologicoDTO.class);
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	public void processaTiposGuia() throws Exception {
		Pagination pag = new Pagination(10, 1);
		DominioParamsDTO paramsDominio = new DominioParamsDTO();
		paramsDominio.setDominio(GUIA_ODONTOLOGICA);
		List<Dominio> dominios = DominioBusiness.getInstance().findByParams(paramsDominio, pag);
		for (Dominio dominio : dominios) {
			TipoGuia tipo = TipoGuiaBusiness.getInstance().findById(new Long(dominio.getValor()));
			tiposGuia.add(tipo);
		} 
	}
	
	@Action(value = "frmSetupNovo", results = {
			@Result(name = "success", location = "/credenciada/guias-odontologica/frmGuiaOdontologica.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
			//, interceptorRefs = @InterceptorRef("authStack")
	)
	public String frmSetupNovo() {
		try {
			this.flag = "inserir";
			
			//Pega o credenciado
			getCredenciadoSession();
			
			processaTiposGuia();
			
			this.tabela = this.credenciado.getTabela();
			
			//retorna peridodo de urgencia
			periodoUrgencia = ValidaHorarioUrgenciaUtil.validaHorarioPermitidoUrgencia();
			
		} catch (Exception e) {
			addActionError(getText("frmsetup.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarGuiaJson", results = { @Result(name = "success", type = "json", params = { "root", "guiaDTO" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doListarGuiaJson() {
		try {
			
			this.guiaDTO = map.paraDto(GuiaBusiness.getInstance().getBean(guiaPK), GuiaDTO.class);
			
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "retornaTipoJson", results = { @Result(name = "success", type = "json", params = { "root", "tipoGuia" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doRetornaTipoJson() {
		try {
			
			this.tipoGuia = TipoGuiaBusiness.getInstance().findById(idTipoGuia);
			
		} catch (Exception e) {
			addActionError(getText("listar.error"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmSetupEditar", results = {
			@Result(name = "success", location = "/credenciada/guias-odontologica/frmGuiaOdontologica.jsp"),
			@Result(name = "error", location = "/pages/error.jsp") }
			//, interceptorRefs = @InterceptorRef("authStack")
			)
	public String frmSetupEditar() {
		try {
			this.flag = "editar";
			
			processaTiposGuia();
			
			getCredenciadoSession();
			
			this.tabela = this.credenciado.getTabela();
			
			Guia guiaGerenciada = GuiaBusiness.getInstance().getBean(guiaPK);
			
			if (guiaGerenciada != null && !guiaGerenciada.getProcedimentosOdonto().isEmpty()) {
				this.tipoGuia = guiaGerenciada.getProcedimentosOdonto().get(0).getTipoGuia();
				if (this.tipoGuia != null) {
					idTipoGuia = this.tipoGuia.getId();
				}
			}
			
			this.guiaDTO = map.paraDto(guiaGerenciada, GuiaDTO.class);
			
			this.frmGuiaClinicaLaboratorialDTO = new FrmGuiaClinicaLaboratorialDTO();
			this.frmGuiaClinicaLaboratorialDTO.setMatriculaServidor(this.guiaDTO.getMatriculaServidor());
			this.frmGuiaClinicaLaboratorialDTO.setCodigoDependente(this.guiaDTO.getCodigoDependente());
			
			periodoUrgencia = ValidaHorarioUrgenciaUtil.validaHorarioPermitidoUrgencia();
			
		} catch (Exception e) {
			addActionError(getText("frmsetup.error"));
			return "error";
		}
		return "success";
	}
	@Action(value = "inserir", results = {	
			@Result(name = "success", type = "json", params = { "root", "result" }),		
			@Result(name = "error", location = "/pages/resultAjax.jsp") }, interceptorRefs = @InterceptorRef("authStack"))
	public String doInserir() {	
		
		int ret = 0;
		BeanResult res = new BeanResult();		
		try {
			
			getCredenciadoSession();
			
			Credenciado credenciado = CredenciadoDAOImpl.getInstance().findById(idCredenciada);
			
			List<ProcedimentoFormDTO> listaProcedimento = ProcedimentoOdontoBusiness.getInstance().buildListaProcedimentoDTO(frmGuiaClinicaLaboratorialDTO);
			guiaPK = GuiaBusiness.getInstance().buildGuiaPK(idTipoGuia);
			
			List<GuiaProcedimentoOdonto> guiasProcedimentos = ProcedimentoOdontoBusiness.getInstance().builListaProcedimento(listaProcedimento, credenciado, guiaPK);
			
			BigDecimal valorTotalGuia =  new BigDecimal("0");//verificar a urgencia			
			//calcula o valor total da guia
			valorTotalGuia = ProcedimentoOdontoBusiness.getInstance().calculaValorTotalGuia(valorTotalGuia, guiasProcedimentos,
					frmGuiaClinicaLaboratorialDTO.isGravarDespesa(), credenciado);
			//calcula o valor total da guia
			
			guia = GuiaBusiness.getInstance().buildNovaGuia(guia, valorTotalGuia, frmGuiaClinicaLaboratorialDTO, idTipoGuia, credenciado, false, false);
			
			ret = GuiaBusiness.getInstance().inserir(guia);
			
			//insere os guias procedimentos
			ret = GuiaProcedimentoOdontoBusiness.getInstance().inserirGuiaProcedimento(guiasProcedimentos, guia);
			//insere os guias procedimentos
			
			res.setId(ret);
			res.setMensagem(getText("inserir.sucesso"));
			this.result = res;
		} catch (Exception e) {
			res.setMensagem(getText("inserir.error"));
			res.setError(e.getMessage());
			this.result = res;
			return "error";
		}
		return "success";
	}
	
	@Action(value = "editar", results = {	
			@Result(name = "success", type = "json", params = { "root", "result" }),		
			@Result(name = "error", location = "/pages/resultAjax.jsp") },
			interceptorRefs={
			        @InterceptorRef(
			            params={"allowedTypes","image/jpeg,application/zip, application/pdf",
					    "maximumSize","10110823"}, 
			            value="fileUpload"
			        ),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")
				}
	)
	public String doEditar() {
		
		int ret = 0;
		BeanResult res = new BeanResult();
		BigDecimal valorTotalGuia = BigDecimal.ZERO;
		Boolean requerAutorizacao = false;
		
		try {
			getCredenciadoSession();
			//retorna o credendicado
			Credenciado credenciado = CredenciadoDAOImpl.getInstance().findById(idCredenciada);
			//retorna o credendicado
			
			//converte os procedimentos informados
			List<ProcedimentoFormDTO> listaProcedimento = ProcedimentoOdontoBusiness.getInstance().buildListaProcedimentoDTO(frmGuiaClinicaLaboratorialDTO);
			//guiaPK = GuiaBusiness.getInstance().buildGuiaPK(idTipoGuia);
			//converte os procedimentos informados
			
			//Retorna os procedimentos informados
			//retorna o tipo de guia
			this.tipoGuia = TipoGuiaDAOImpl.getInstance().findById(idTipoGuia);
			
			//Editar guiagerenciada
			guia = GuiaBusiness.getInstance().buildGuiaEditar(GuiaBusiness.getInstance().getBean(guiaPK), requerAutorizacao, valorTotalGuia, frmGuiaClinicaLaboratorialDTO);
			//Editar guiagerenciada
		
			List<GuiaProcedimentoOdonto> guiasProcedimentos = ProcedimentoOdontoBusiness.getInstance().builListaProcedimento(listaProcedimento, credenciado, guiaPK);
			//Retorna os procedimentos informados			
			
			//calcula o valor total da guia
			valorTotalGuia = ProcedimentoOdontoBusiness.getInstance().calculaValorTotalGuia(valorTotalGuia, guiasProcedimentos,
					frmGuiaClinicaLaboratorialDTO.isGravarDespesa(), credenciado);
			//calcula o valor total da guia
			
			// objeto despesa e anexo
			DespesaBusiness.getInstance().salvarDespesaAnexo(guia, frmGuiaClinicaLaboratorialDTO, fileUpload, fileName);
			// objeto despesa e anexo
			
			//Editar guia
			ret = GuiaBusiness.getInstance().alterar(guia);
			//Editar guia
			
			// Remove todos os guiasProcedimentos
			ret = GuiaProcedimentoOdontoBusiness.getInstance().removeProcedimentoByGuia(guiaPK);
			// Remove todos os guiasPRocedimentos
			
			//insere procedimento despesa
			ret = GuiaProcedimentoOdontoBusiness.getInstance().salvarProcedimentoDespesa(guia, frmGuiaClinicaLaboratorialDTO);
			//insere procedimento despesa
			
			//insere os guias procedimentos
			ret = GuiaProcedimentoOdontoBusiness.getInstance().inserirGuiaProcedimento(guiasProcedimentos, guia);
			//insere os guias procedimentos
			
			res.setId(ret);
			res.setMensagem(getText("alterar.sucesso"));
			this.result = res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setMensagem(getText("alterar.error"));
			res.setError(e.getMessage());
			this.result = res;
			return "error";
		}
		return "success";
	}
	

	public List<Guia> getGuias() {
		return guias;
	}

	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
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

	public DominioParamsDTO getParams() {
		return params;
	}

	public void setParams(DominioParamsDTO params) {
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<ComboBoxDTO> getComboBoxDTO() {
		return comboBoxDTO;
	}

	public void setComboBoxDTO(List<ComboBoxDTO> comboBoxDTO) {
		this.comboBoxDTO = comboBoxDTO;
	}

	public CredenciadoDTO getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(CredenciadoDTO credenciado) {
		this.credenciado = credenciado;
	}

	public Long getIdCredenciada() {
		return idCredenciada;
	}

	public void setIdCredenciada(Long idCredenciada) {
		this.idCredenciada = idCredenciada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<ProcedimentoOdontologicoDTO> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentoOdontologicoDTO> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public ProcedimentoParamsDTO getProcedimentoParams() {
		return procedimentoParams;
	}

	public void setProcedimentoParams(ProcedimentoParamsDTO procedimentoParams) {
		this.procedimentoParams = procedimentoParams;
	}

	public ProcedimentoOdontologicoDTO getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoOdontologicoDTO procedimento) {
		this.procedimento = procedimento;
	}

	public ProcedimentoPK getProcedimentoPK() {
		return procedimentoPK;
	}

	public void setProcedimentoPK(ProcedimentoPK procedimentoPK) {
		this.procedimentoPK = procedimentoPK;
	}

	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public List<TipoGuia> getTiposGuia() {
		return tiposGuia;
	}

	public void setTiposGuia(List<TipoGuia> tiposGuia) {
		this.tiposGuia = tiposGuia;
	}

	public Long getIdTipoGuia() {
		return idTipoGuia;
	}

	public void setIdTipoGuia(Long idTipoGuia) {
		this.idTipoGuia = idTipoGuia;
	}

	public TabelaCredenciadoDTO getTabela() {
		return tabela;
	}

	public void setTabela(TabelaCredenciadoDTO tabela) {
		this.tabela = tabela;
	}

	public TipoGuia getTipoGuia() {
		return tipoGuia;
	}

	public void setTipoGuia(TipoGuia tipoGuia) {
		this.tipoGuia = tipoGuia;
	}

	public GuiaDTO getGuiaDTO() {
		return guiaDTO;
	}

	public void setGuiaDTO(GuiaDTO guiaDTO) {
		this.guiaDTO = guiaDTO;
	}

	public GuiaPK getGuiaPK() {
		return guiaPK;
	}

	public void setGuiaPK(GuiaPK guiaPK) {
		this.guiaPK = guiaPK;
	}

	public FrmGuiaClinicaLaboratorialDTO getFrmGuiaClinicaLaboratorialDTO() {
		return frmGuiaClinicaLaboratorialDTO;
	}

	public void setFrmGuiaClinicaLaboratorialDTO(FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) {
		this.frmGuiaClinicaLaboratorialDTO = frmGuiaClinicaLaboratorialDTO;
	}

	public boolean isPeriodoUrgencia() {
		return periodoUrgencia;
	}

	public void setPeriodoUrgencia(boolean periodoUrgencia) {
		this.periodoUrgencia = periodoUrgencia;
	}

	public String getProcedimentoDespesa() {
		return procedimentoDespesa;
	}

	public void setProcedimentoDespesa(String procedimentoDespesa) {
		this.procedimentoDespesa = procedimentoDespesa;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	
	
	
}
