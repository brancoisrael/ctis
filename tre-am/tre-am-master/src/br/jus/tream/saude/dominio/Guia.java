package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "GUIA")
public class Guia implements Serializable {

	private static final long serialVersionUID = 1521458464329567455L;
	@EmbeddedId
	private GuiaPK guiaPK;
	@Column(name = "DAT_EMISSAO", nullable = false)
	private LocalDate dataEmissao;
	@Column(name = "MAT_SERVIDOR", nullable = false, length = 8)
	private String matriculaServidor;
	@Column(name = "COD_DEPEND", nullable = true)
	private Long codigoDependente;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CREDENCIADO", nullable = true)
	private Credenciado credenciado;
	@Column(name = "TOTAL", nullable = false)
	private BigDecimal total;
	@Column(name = "IND_URGENCIA", nullable = false)
	private Boolean urgencia;
	@Column(name = "IND_APARTAMENTO", nullable = false)
	private Boolean apartamento;
	@Column(name = "IND_INTERNACAO", nullable = false)
	private Boolean internacao;
	@Column(name = "IND_DESPESA_HOSPITALAR", nullable = false)
	private Boolean despesaHospitalar;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_AUXILIAR", nullable = true)
	private Auxiliar auxiliar;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESPECIALIDADE", nullable = true)
	private Especialidade especialidade;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SITUACAO", nullable = true)
	private Situacao situacao;
	@Column(name = "MAT_SERVIDOR_AUTORIZA", nullable = true, length = 20)
	private String matriculaServidorAutorizado;
	@Column(name = "FUNCAO", nullable = true, length = 15)
	private String funcao;
	@Column(name = "OBS_DESPESA", nullable = true, length = 15)
	private String observacaoDespesa;
	@Column(name = "NUM_FATURA", nullable = true, length = 15)
	private String numeroFatura;
	@Column(name = "TOTAL_FATURADO", nullable = true)
	private BigDecimal totalFaturado;
	@Column(name = "DAT_FATURA", nullable = true)
	private LocalDate dataFatura;
	@Column(name = "CUSTEIO", nullable = false)
	private BigDecimal custeio;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SIT_FUNC_TITULAR")
	private SituacaoFuncional situacaoFuncional;
	@Column(name = "IND_PAG_ATEND", nullable = false)
	private Boolean pagamentoAtendimento;
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ORIGEM_GUIA", nullable = true)
	private OrigemGuia origemGuia;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_USUARIO_AUTORIZA", nullable = true)
	private UsuarioAutorizado usuarioAutorizado;
	@Column(name = "USUARIO_AUTORIZACAO_TRE", nullable = true)
	private String usuarioAutorizadoTRE;
	@Column(name = "DATA_AUTORIZACAO_TRE", nullable = true)
	private LocalDate dataAutorizacaoTRE;
	@Column(name = "JUSTIFICATIVA", nullable = true)
	private String justificativa;
	@Column(name = "COD_USUARIO_SOLICITACAO_WEB", nullable = true)
	private String usuarioSolicitacaoWeb;
	@Column(name = "DATA_SOLICITACAO_WEB", nullable = true)
	private LocalDate dataSolicitacaoWeb;
	@Column(name = "JUSTIFICATIVA_SOLICITACAO", nullable = true)
	private String justificativaSolicitacao;
	@Column(name = "NUM_ATENDIMENTO", nullable = true)
	private String numeroAtendimento;
	@Column(name = "MOTIVO_CANCELAMENTO", nullable = true)
	private String motivoCancelamento;
	@OneToMany(mappedBy = "guia", fetch = FetchType.LAZY)
	private List<GuiaProcedimento> procedimentos;
	@OneToMany(mappedBy = "guia", fetch = FetchType.LAZY)
	private List<GuiaProcedimentoOdonto> procedimentosOdonto;
	
	@OneToOne( optional = true, fetch = FetchType.LAZY, mappedBy = "guia", cascade = CascadeType.ALL)
	private Despesa despesa;

	public GuiaPK getGuiaPK() {
		return guiaPK;
	}

	public void setGuiaPK(GuiaPK guiaPK) {
		this.guiaPK = guiaPK;
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

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
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

	public Auxiliar getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Auxiliar auxiliar) {
		this.auxiliar = auxiliar;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
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

	public SituacaoFuncional getSituacaoFuncional() {
		return situacaoFuncional;
	}

	public void setSituacaoFuncional(SituacaoFuncional situacaoFuncional) {
		this.situacaoFuncional = situacaoFuncional;
	}

	public Boolean getPagamentoAtendimento() {
		return pagamentoAtendimento;
	}

	public void setPagamentoAtendimento(Boolean pagamentoAtendimento) {
		this.pagamentoAtendimento = pagamentoAtendimento;
	}

	public OrigemGuia getOrigemGuia() {
		return origemGuia;
	}

	public void setOrigemGuia(OrigemGuia origemGuia) {
		this.origemGuia = origemGuia;
	}

	public UsuarioAutorizado getUsuarioAutorizado() {
		return usuarioAutorizado;
	}

	public void setUsuarioAutorizado(UsuarioAutorizado usuarioAutorizado) {
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

	public List<GuiaProcedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<GuiaProcedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public List<GuiaProcedimentoOdonto> getProcedimentosOdonto() {
		return procedimentosOdonto;
	}

	public void setProcedimentosOdonto(List<GuiaProcedimentoOdonto> procedimentosOdonto) {
		this.procedimentosOdonto = procedimentosOdonto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartamento == null) ? 0 : apartamento.hashCode());
		result = prime * result + ((auxiliar == null) ? 0 : auxiliar.hashCode());
		result = prime * result + ((codigoDependente == null) ? 0 : codigoDependente.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
		result = prime * result + ((custeio == null) ? 0 : custeio.hashCode());
		result = prime * result + ((dataAutorizacaoTRE == null) ? 0 : dataAutorizacaoTRE.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((dataFatura == null) ? 0 : dataFatura.hashCode());
		result = prime * result + ((dataSolicitacaoWeb == null) ? 0 : dataSolicitacaoWeb.hashCode());
		result = prime * result + ((despesa == null) ? 0 : despesa.hashCode());
		result = prime * result + ((despesaHospitalar == null) ? 0 : despesaHospitalar.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((guiaPK == null) ? 0 : guiaPK.hashCode());
		result = prime * result + ((internacao == null) ? 0 : internacao.hashCode());
		result = prime * result + ((justificativa == null) ? 0 : justificativa.hashCode());
		result = prime * result + ((justificativaSolicitacao == null) ? 0 : justificativaSolicitacao.hashCode());
		result = prime * result + ((matriculaServidor == null) ? 0 : matriculaServidor.hashCode());
		result = prime * result + ((matriculaServidorAutorizado == null) ? 0 : matriculaServidorAutorizado.hashCode());
		result = prime * result + ((motivoCancelamento == null) ? 0 : motivoCancelamento.hashCode());
		result = prime * result + ((numeroAtendimento == null) ? 0 : numeroAtendimento.hashCode());
		result = prime * result + ((numeroFatura == null) ? 0 : numeroFatura.hashCode());
		result = prime * result + ((observacaoDespesa == null) ? 0 : observacaoDespesa.hashCode());
		result = prime * result + ((origemGuia == null) ? 0 : origemGuia.hashCode());
		result = prime * result + ((pagamentoAtendimento == null) ? 0 : pagamentoAtendimento.hashCode());
		result = prime * result + ((procedimentos == null) ? 0 : procedimentos.hashCode());
		result = prime * result + ((procedimentosOdonto == null) ? 0 : procedimentosOdonto.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((situacaoFuncional == null) ? 0 : situacaoFuncional.hashCode());
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
		Guia other = (Guia) obj;
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
		if (despesa == null) {
			if (other.despesa != null)
				return false;
		} else if (!despesa.equals(other.despesa))
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
		if (guiaPK == null) {
			if (other.guiaPK != null)
				return false;
		} else if (!guiaPK.equals(other.guiaPK))
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
