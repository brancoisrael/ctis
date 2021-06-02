package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.jus.tream.saude.dominio.Guia;

/**
 * Representa os dados de um {@link Guia}.
 * 
 * @author vinicius
 *
 */
public class GuiaDTO implements Serializable {

	private static final long serialVersionUID = 2227718715240738123L;

	private Long numeroGuia;
	private String anoExercicio;
	private TipoGuiaDTO tipoGuia;
	private LocalDate dataEmissao;
	private String matriculaServidor;
	private Long codigoDependente;
	private CredenciadoDTO credenciado;
	private BigDecimal total;
	private Boolean urgencia;
	private Boolean apartamento;
	private Boolean internacao;
	private Boolean despesaHospitalar;
	private AuxiliarDTO auxiliar;
	private EspecialidadeDTO especialidade;
	private SituacaoDTO situacao;
	private String matriculaServidorAutorizado;
	private String funcao;
	private String observacaoDespesa;
	private String numeroFatura;
	private BigDecimal totalFaturado;
	private LocalDate dataFatura;
	private BigDecimal custeio;
	private SituacaoFuncionalDTO situacaoFuncional;
	private Boolean pagamentoAtendimento;
	private OrigemGuiaDTO origemGuia;
	private UsuarioAutorizadoDTO usuarioAutorizado;
	private String usuarioAutorizadoTRE;
	private LocalDate dataAutorizacaoTRE;
	private String justificativa;
	private String usuarioSolicitacaoWeb;
	private LocalDate dataSolicitacaoWeb;
	private String justificativaSolicitacao;
	private String numeroAtendimento;
	private String motivoCancelamento;
	private List<GuiaProcedimentoDTO> procedimentos = new ArrayList<GuiaProcedimentoDTO>();
	private List<GuiaProcedimentoOdontoDTO> procedimentosOdonto = new ArrayList<GuiaProcedimentoOdontoDTO>();
	private DespesaDTO despesa;

	public GuiaDTO() {
	}
	
	public GuiaDTO(Long numeroGuia, String anoExercicio, LocalDate dataEmissao, SituacaoDTO situacao, Long idTipoGuia) {
		this.numeroGuia = numeroGuia;
		this.anoExercicio = anoExercicio;
		this.dataEmissao = dataEmissao;
		this.situacao = situacao;
		this.tipoGuia = new TipoGuiaDTO(idTipoGuia);
	}

	/**
	 * Responsável por converter uma {@link Guia} para seu respectivo Dto.
	 * 
	 * @param guia que será convertida.
	 */
	public GuiaDTO(Guia guia) {
		this.numeroGuia = guia.getGuiaPK().getNumeroGuia();
		this.anoExercicio = guia.getGuiaPK().getAnoExercicio();
		this.tipoGuia = new TipoGuiaDTO(guia.getGuiaPK().getTipoGuia());
		this.dataEmissao = guia.getDataEmissao();
		this.matriculaServidor = guia.getMatriculaServidor();
		this.codigoDependente = guia.getCodigoDependente();
		this.credenciado = guia.getCredenciado() != null ? new CredenciadoDTO(guia.getCredenciado()) : null;
		this.total = guia.getTotal();
		this.urgencia = guia.getUrgencia();
		this.apartamento = guia.getApartamento();
		this.internacao = guia.getInternacao();
		this.despesaHospitalar = guia.getDespesaHospitalar();
		this.auxiliar = guia.getAuxiliar() != null ? new AuxiliarDTO(guia.getAuxiliar()) : null;
		this.especialidade = guia.getEspecialidade() != null ? new EspecialidadeDTO(guia.getEspecialidade()) : null;
		this.situacao = guia.getSituacao() != null ? new SituacaoDTO(guia.getSituacao()) : null;
		this.matriculaServidorAutorizado = guia.getMatriculaServidorAutorizado();
		this.funcao = guia.getFuncao();
		this.observacaoDespesa = guia.getObservacaoDespesa();
		this.numeroFatura = guia.getNumeroFatura();
		this.totalFaturado = guia.getTotalFaturado();
		this.dataFatura = guia.getDataFatura();
		this.custeio = guia.getCusteio();
		this.situacaoFuncional = guia.getSituacaoFuncional() != null
				? new SituacaoFuncionalDTO(guia.getSituacaoFuncional())
				: null;
		this.pagamentoAtendimento = guia.getPagamentoAtendimento();
		this.origemGuia = guia.getOrigemGuia() != null ? new OrigemGuiaDTO(guia.getOrigemGuia()) : null;
		this.usuarioAutorizado = guia.getUsuarioAutorizado() != null
				? new UsuarioAutorizadoDTO(guia.getUsuarioAutorizado())
				: null;
		this.usuarioAutorizadoTRE = guia.getUsuarioAutorizadoTRE();
		this.dataAutorizacaoTRE = guia.getDataAutorizacaoTRE();
		this.justificativa = guia.getJustificativa();
		this.usuarioSolicitacaoWeb = guia.getUsuarioSolicitacaoWeb();
		this.dataSolicitacaoWeb = guia.getDataSolicitacaoWeb();
		this.justificativaSolicitacao = guia.getJustificativaSolicitacao();
		this.numeroAtendimento = guia.getNumeroAtendimento();
		this.motivoCancelamento = guia.getMotivoCancelamento();
		//List<GuiaProcedimento> guias = GuiaProcedimentoDAOImpl.getInstance().findByGuia(guia.getGuiaPK());
		guia.getProcedimentos().forEach((g) -> this.procedimentos.add(new GuiaProcedimentoDTO(g, true)));
		guia.getProcedimentosOdonto().forEach((g) -> this.procedimentosOdonto.add(new GuiaProcedimentoOdontoDTO(g, true)));
		if (guia.getDespesa() != null) {
			this.despesa = new DespesaDTO(guia.getDespesa());
		}
	}

	public Long getNumeroGuia() {
		return numeroGuia;
	}

	public void setNumeroGuia(Long numeroGuia) {
		this.numeroGuia = numeroGuia;
	}

	public String getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(String anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public TipoGuiaDTO getTipoGuia() {
		return tipoGuia;
	}

	public void setTipoGuia(TipoGuiaDTO tipoGuia) {
		this.tipoGuia = tipoGuia;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getMatriculaServidor() {
		return matriculaServidor;
	}

	public void setMatriculaServidor(String matriculaServidor) {
		this.matriculaServidor = matriculaServidor;
	}

	public Long getCodigoDependente() {
		return codigoDependente;
	}

	public void setCodigoDependente(Long codigoDependente) {
		this.codigoDependente = codigoDependente;
	}

	public CredenciadoDTO getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(CredenciadoDTO credenciado) {
		this.credenciado = credenciado;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Boolean getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(Boolean urgencia) {
		this.urgencia = urgencia;
	}

	public Boolean getApartamento() {
		return apartamento;
	}

	public void setApartamento(Boolean apartamento) {
		this.apartamento = apartamento;
	}

	public Boolean getInternacao() {
		return internacao;
	}

	public void setInternacao(Boolean internacao) {
		this.internacao = internacao;
	}

	public Boolean getDespesaHospitalar() {
		return despesaHospitalar;
	}

	public void setDespesaHospitalar(Boolean despesaHospitalar) {
		this.despesaHospitalar = despesaHospitalar;
	}

	public AuxiliarDTO getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(AuxiliarDTO auxiliar) {
		this.auxiliar = auxiliar;
	}

	public EspecialidadeDTO getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeDTO especialidade) {
		this.especialidade = especialidade;
	}

	public SituacaoDTO getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDTO situacao) {
		this.situacao = situacao;
	}

	public String getMatriculaServidorAutorizado() {
		return matriculaServidorAutorizado;
	}

	public void setMatriculaServidorAutorizado(String matriculaServidorAutorizado) {
		this.matriculaServidorAutorizado = matriculaServidorAutorizado;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getObservacaoDespesa() {
		return observacaoDespesa;
	}

	public void setObservacaoDespesa(String observacaoDespesa) {
		this.observacaoDespesa = observacaoDespesa;
	}

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public BigDecimal getTotalFaturado() {
		return totalFaturado;
	}

	public void setTotalFaturado(BigDecimal totalFaturado) {
		this.totalFaturado = totalFaturado;
	}

	public LocalDate getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(LocalDate dataFatura) {
		this.dataFatura = dataFatura;
	}

	public BigDecimal getCusteio() {
		return custeio;
	}

	public void setCusteio(BigDecimal custeio) {
		this.custeio = custeio;
	}

	public SituacaoFuncionalDTO getSituacaoFuncional() {
		return situacaoFuncional;
	}

	public void setSituacaoFuncional(SituacaoFuncionalDTO situacaoFuncional) {
		this.situacaoFuncional = situacaoFuncional;
	}

	public Boolean getPagamentoAtendimento() {
		return pagamentoAtendimento;
	}

	public void setPagamentoAtendimento(Boolean pagamentoAtendimento) {
		this.pagamentoAtendimento = pagamentoAtendimento;
	}

	public OrigemGuiaDTO getOrigemGuia() {
		return origemGuia;
	}

	public void setOrigemGuia(OrigemGuiaDTO origemGuia) {
		this.origemGuia = origemGuia;
	}

	public UsuarioAutorizadoDTO getUsuarioAutorizado() {
		return usuarioAutorizado;
	}

	public void setUsuarioAutorizado(UsuarioAutorizadoDTO usuarioAutorizado) {
		this.usuarioAutorizado = usuarioAutorizado;
	}

	public String getUsuarioAutorizadoTRE() {
		return usuarioAutorizadoTRE;
	}

	public void setUsuarioAutorizadoTRE(String usuarioAutorizadoTRE) {
		this.usuarioAutorizadoTRE = usuarioAutorizadoTRE;
	}

	public LocalDate getDataAutorizacaoTRE() {
		return dataAutorizacaoTRE;
	}

	public void setDataAutorizacaoTRE(LocalDate dataAutorizacaoTRE) {
		this.dataAutorizacaoTRE = dataAutorizacaoTRE;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getUsuarioSolicitacaoWeb() {
		return usuarioSolicitacaoWeb;
	}

	public void setUsuarioSolicitacaoWeb(String usuarioSolicitacaoWeb) {
		this.usuarioSolicitacaoWeb = usuarioSolicitacaoWeb;
	}

	public LocalDate getDataSolicitacaoWeb() {
		return dataSolicitacaoWeb;
	}

	public void setDataSolicitacaoWeb(LocalDate dataSolicitacaoWeb) {
		this.dataSolicitacaoWeb = dataSolicitacaoWeb;
	}

	public String getJustificativaSolicitacao() {
		return justificativaSolicitacao;
	}

	public void setJustificativaSolicitacao(String justificativaSolicitacao) {
		this.justificativaSolicitacao = justificativaSolicitacao;
	}

	public String getNumeroAtendimento() {
		return numeroAtendimento;
	}

	public void setNumeroAtendimento(String numeroAtendimento) {
		this.numeroAtendimento = numeroAtendimento;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public List<GuiaProcedimentoDTO> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<GuiaProcedimentoDTO> procedimentos) {
		this.procedimentos = procedimentos;
	}	
	
	public List<GuiaProcedimentoOdontoDTO> getProcedimentosOdonto() {
		return procedimentosOdonto;
	}

	public void setProcedimentosOdonto(List<GuiaProcedimentoOdontoDTO> procedimentosOdonto) {
		this.procedimentosOdonto = procedimentosOdonto;
	}

	public DespesaDTO getDespesa() {
		return despesa;
	}

	public void setDespesa(DespesaDTO despesa) {
		this.despesa = despesa;
	}

	public boolean isDependente() {
		return this.getMatriculaServidor() != null && this.getCodigoDependente() != null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((apartamento == null) ? 0 : apartamento.hashCode());
		result = prime * result + ((auxiliar == null) ? 0 : auxiliar.hashCode());
		result = prime * result + ((codigoDependente == null) ? 0 : codigoDependente.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
		result = prime * result + ((custeio == null) ? 0 : custeio.hashCode());
		result = prime * result + ((dataAutorizacaoTRE == null) ? 0 : dataAutorizacaoTRE.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((dataFatura == null) ? 0 : dataFatura.hashCode());
		result = prime * result + ((dataSolicitacaoWeb == null) ? 0 : dataSolicitacaoWeb.hashCode());
		result = prime * result + ((despesaHospitalar == null) ? 0 : despesaHospitalar.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((internacao == null) ? 0 : internacao.hashCode());
		result = prime * result + ((justificativa == null) ? 0 : justificativa.hashCode());
		result = prime * result + ((justificativaSolicitacao == null) ? 0 : justificativaSolicitacao.hashCode());
		result = prime * result + ((matriculaServidor == null) ? 0 : matriculaServidor.hashCode());
		result = prime * result + ((matriculaServidorAutorizado == null) ? 0 : matriculaServidorAutorizado.hashCode());
		result = prime * result + ((motivoCancelamento == null) ? 0 : motivoCancelamento.hashCode());
		result = prime * result + ((numeroAtendimento == null) ? 0 : numeroAtendimento.hashCode());
		result = prime * result + ((numeroFatura == null) ? 0 : numeroFatura.hashCode());
		result = prime * result + ((numeroGuia == null) ? 0 : numeroGuia.hashCode());
		result = prime * result + ((observacaoDespesa == null) ? 0 : observacaoDespesa.hashCode());
		result = prime * result + ((origemGuia == null) ? 0 : origemGuia.hashCode());
		result = prime * result + ((pagamentoAtendimento == null) ? 0 : pagamentoAtendimento.hashCode());
		result = prime * result + ((procedimentos == null) ? 0 : procedimentos.hashCode());
		result = prime * result + ((procedimentosOdonto == null) ? 0 :procedimentosOdonto.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((situacaoFuncional == null) ? 0 : situacaoFuncional.hashCode());
		result = prime * result + ((tipoGuia == null) ? 0 : tipoGuia.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((totalFaturado == null) ? 0 : totalFaturado.hashCode());
		result = prime * result + ((urgencia == null) ? 0 : urgencia.hashCode());
		result = prime * result + ((usuarioAutorizado == null) ? 0 : usuarioAutorizado.hashCode());
		result = prime * result + ((usuarioAutorizadoTRE == null) ? 0 : usuarioAutorizadoTRE.hashCode());
		result = prime * result + ((usuarioSolicitacaoWeb == null) ? 0 : usuarioSolicitacaoWeb.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiaDTO other = (GuiaDTO) obj;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (apartamento == null) {
			if (other.apartamento != null)
				return false;
		} else if (!apartamento.equals(other.apartamento))
			return false;
		if (auxiliar == null) {
			if (other.auxiliar != null)
				return false;
		} else if (!auxiliar.equals(other.auxiliar))
			return false;
		if (codigoDependente == null) {
			if (other.codigoDependente != null)
				return false;
		} else if (!codigoDependente.equals(other.codigoDependente))
			return false;
		if (credenciado == null) {
			if (other.credenciado != null)
				return false;
		} else if (!credenciado.equals(other.credenciado))
			return false;
		if (custeio == null) {
			if (other.custeio != null)
				return false;
		} else if (!custeio.equals(other.custeio))
			return false;
		if (dataAutorizacaoTRE == null) {
			if (other.dataAutorizacaoTRE != null)
				return false;
		} else if (!dataAutorizacaoTRE.equals(other.dataAutorizacaoTRE))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (dataFatura == null) {
			if (other.dataFatura != null)
				return false;
		} else if (!dataFatura.equals(other.dataFatura))
			return false;
		if (dataSolicitacaoWeb == null) {
			if (other.dataSolicitacaoWeb != null)
				return false;
		} else if (!dataSolicitacaoWeb.equals(other.dataSolicitacaoWeb))
			return false;
		if (despesaHospitalar == null) {
			if (other.despesaHospitalar != null)
				return false;
		} else if (!despesaHospitalar.equals(other.despesaHospitalar))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (internacao == null) {
			if (other.internacao != null)
				return false;
		} else if (!internacao.equals(other.internacao))
			return false;
		if (justificativa == null) {
			if (other.justificativa != null)
				return false;
		} else if (!justificativa.equals(other.justificativa))
			return false;
		if (justificativaSolicitacao == null) {
			if (other.justificativaSolicitacao != null)
				return false;
		} else if (!justificativaSolicitacao.equals(other.justificativaSolicitacao))
			return false;
		if (matriculaServidor == null) {
			if (other.matriculaServidor != null)
				return false;
		} else if (!matriculaServidor.equals(other.matriculaServidor))
			return false;
		if (matriculaServidorAutorizado == null) {
			if (other.matriculaServidorAutorizado != null)
				return false;
		} else if (!matriculaServidorAutorizado.equals(other.matriculaServidorAutorizado))
			return false;
		if (motivoCancelamento == null) {
			if (other.motivoCancelamento != null)
				return false;
		} else if (!motivoCancelamento.equals(other.motivoCancelamento))
			return false;
		if (numeroAtendimento == null) {
			if (other.numeroAtendimento != null)
				return false;
		} else if (!numeroAtendimento.equals(other.numeroAtendimento))
			return false;
		if (numeroFatura == null) {
			if (other.numeroFatura != null)
				return false;
		} else if (!numeroFatura.equals(other.numeroFatura))
			return false;
		if (numeroGuia == null) {
			if (other.numeroGuia != null)
				return false;
		} else if (!numeroGuia.equals(other.numeroGuia))
			return false;
		if (observacaoDespesa == null) {
			if (other.observacaoDespesa != null)
				return false;
		} else if (!observacaoDespesa.equals(other.observacaoDespesa))
			return false;
		if (origemGuia == null) {
			if (other.origemGuia != null)
				return false;
		} else if (!origemGuia.equals(other.origemGuia))
			return false;
		if (pagamentoAtendimento == null) {
			if (other.pagamentoAtendimento != null)
				return false;
		} else if (!pagamentoAtendimento.equals(other.pagamentoAtendimento))
			return false;
		if (procedimentos == null) {
			if (other.procedimentos != null)
				return false;
		} else if (!procedimentos.equals(other.procedimentos))
			return false;		
		if (procedimentosOdonto == null) {
			if (other.procedimentosOdonto != null)
				return false;
		} else if (!procedimentosOdonto.equals(other.procedimentosOdonto))
			return false;		
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (situacaoFuncional == null) {
			if (other.situacaoFuncional != null)
				return false;
		} else if (!situacaoFuncional.equals(other.situacaoFuncional))
			return false;
		if (tipoGuia == null) {
			if (other.tipoGuia != null)
				return false;
		} else if (!tipoGuia.equals(other.tipoGuia))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (totalFaturado == null) {
			if (other.totalFaturado != null)
				return false;
		} else if (!totalFaturado.equals(other.totalFaturado))
			return false;
		if (urgencia == null) {
			if (other.urgencia != null)
				return false;
		} else if (!urgencia.equals(other.urgencia))
			return false;
		if (usuarioAutorizado == null) {
			if (other.usuarioAutorizado != null)
				return false;
		} else if (!usuarioAutorizado.equals(other.usuarioAutorizado))
			return false;
		if (usuarioAutorizadoTRE == null) {
			if (other.usuarioAutorizadoTRE != null)
				return false;
		} else if (!usuarioAutorizadoTRE.equals(other.usuarioAutorizadoTRE))
			return false;
		if (usuarioSolicitacaoWeb == null) {
			if (other.usuarioSolicitacaoWeb != null)
				return false;
		} else if (!usuarioSolicitacaoWeb.equals(other.usuarioSolicitacaoWeb))
			return false;
		return true;
	}

}
