package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GuiaProcedimentoParamsDTO implements Serializable {

	private static final long serialVersionUID = -669124188008707564L;
	private Long numeroGuia;
	private String anoExercicio;
	private Short idSituacaoGuia;
	private BigDecimal valor;
	private String nomeProcedimento;
	private LocalDate dataInicial;
	private String dataInicialString;
	private LocalDate dataFinal;
	private String dataFinalString;
	private Long idCredenciada;
	private Long idTabela;
	private String codProcedimento;

	public GuiaProcedimentoParamsDTO() {
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

	public Short getIdSituacaoGuia() {
		return idSituacaoGuia;
	}

	public void setIdSituacaoGuia(Short idSituacaoGuia) {
		this.idSituacaoGuia = idSituacaoGuia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getIdCredenciada() {
		return idCredenciada;
	}

	public void setIdCredenciada(Long idCredenciada) {
		this.idCredenciada = idCredenciada;
	}

	public Long getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(Long idTabela) {
		this.idTabela = idTabela;
	}

	public String getCodProcedimento() {
		return codProcedimento;
	}

	public void setCodProcedimento(String codProcedimento) {
		this.codProcedimento = codProcedimento;
	}

	public String getDataInicialString() {
		return dataInicialString;
	}

	public void setDataInicialString(String dataInicialString) {
		this.dataInicialString = dataInicialString;
	}

	public String getDataFinalString() {
		return dataFinalString;
	}

	public void setDataFinalString(String dataFinalString) {
		this.dataFinalString = dataFinalString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((codProcedimento == null) ? 0 : codProcedimento.hashCode());
		result = prime * result + ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result + ((dataFinalString == null) ? 0 : dataFinalString.hashCode());
		result = prime * result + ((dataInicial == null) ? 0 : dataInicial.hashCode());
		result = prime * result + ((dataInicialString == null) ? 0 : dataInicialString.hashCode());
		result = prime * result + ((idCredenciada == null) ? 0 : idCredenciada.hashCode());
		result = prime * result + ((idSituacaoGuia == null) ? 0 : idSituacaoGuia.hashCode());
		result = prime * result + ((idTabela == null) ? 0 : idTabela.hashCode());
		result = prime * result + ((nomeProcedimento == null) ? 0 : nomeProcedimento.hashCode());
		result = prime * result + ((numeroGuia == null) ? 0 : numeroGuia.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		GuiaProcedimentoParamsDTO other = (GuiaProcedimentoParamsDTO) obj;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (codProcedimento == null) {
			if (other.codProcedimento != null)
				return false;
		} else if (!codProcedimento.equals(other.codProcedimento))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (dataFinalString == null) {
			if (other.dataFinalString != null)
				return false;
		} else if (!dataFinalString.equals(other.dataFinalString))
			return false;
		if (dataInicial == null) {
			if (other.dataInicial != null)
				return false;
		} else if (!dataInicial.equals(other.dataInicial))
			return false;
		if (dataInicialString == null) {
			if (other.dataInicialString != null)
				return false;
		} else if (!dataInicialString.equals(other.dataInicialString))
			return false;
		if (idCredenciada == null) {
			if (other.idCredenciada != null)
				return false;
		} else if (!idCredenciada.equals(other.idCredenciada))
			return false;
		if (idSituacaoGuia == null) {
			if (other.idSituacaoGuia != null)
				return false;
		} else if (!idSituacaoGuia.equals(other.idSituacaoGuia))
			return false;
		if (idTabela == null) {
			if (other.idTabela != null)
				return false;
		} else if (!idTabela.equals(other.idTabela))
			return false;
		if (nomeProcedimento == null) {
			if (other.nomeProcedimento != null)
				return false;
		} else if (!nomeProcedimento.equals(other.nomeProcedimento))
			return false;
		if (numeroGuia == null) {
			if (other.numeroGuia != null)
				return false;
		} else if (!numeroGuia.equals(other.numeroGuia))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
