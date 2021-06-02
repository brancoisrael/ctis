package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "ENCAMINHAMENTO")
public class Encaminhamento implements Serializable {

	private static final long serialVersionUID = -2870448002587810380L;
	@EmbeddedId
	private EncaminhamentoPK encaminhamentoPk;
	@Column(name = "NOM_EXECUTOR_CONTRATO", nullable = false, length = 50)
	private String nomeExecutor;
	@Column(name = "NUM_FOLHA_REL_EXEC_CONTRATOS", nullable = true, length = 10)
	private String numeroFolhaExecutor;
	@Column(name = "DAT_ENCAMINHAMENTO", nullable = false)
	private LocalDate dataEncaminhamento;
	@Column(name = "DAT_RETORNO", nullable = true)
	private LocalDate dataRetorno;
	@Column(name = "OBS_ENCAMINHAMENTO", nullable = true, length = 350)
	private String observacaoEncaminhamento;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "ALIQ_FED", nullable = true)
	private BigDecimal aliquotaFed;
	@Column(name = "ALIQ_ISS", nullable = true)
	private BigDecimal aliquotaIss;
	@Column(name = "VLR_FED", nullable = true)
	private BigDecimal valorFed;
	@Column(name = "VLR_ISS", nullable = true)
	private BigDecimal valorIss;
	@Column(name = "VLR_TOTAL", nullable = true)
	private BigDecimal valorTotal;
	@Column(name = "ALIQ_IR", nullable = true)
	private BigDecimal aliquotaIR;
	@Column(name = "VLR_IR", nullable = true)
	private BigDecimal valorIR;
	@Column(name = "ALIQ_CSLL", nullable = true)
	private BigDecimal aliquotaCsll;
	@Column(name = "VLR_CSLL", nullable = true)
	private BigDecimal valorCsll;
	@Column(name = "ALIQ_COFINS", nullable = true)
	private BigDecimal aliquotaCofins;
	@Column(name = "VLR_COFINS", nullable = true)
	private BigDecimal valorCofins;
	@Column(name = "ALIQ_PIS_PASEP", nullable = true)
	private BigDecimal aliquotaPisPasep;
	@Column(name = "VLR_PIS_PASEP", nullable = true)
	private BigDecimal valorPisPasep;
	@Column(name = "COD_BARRAS_ISS", nullable = true, length = 48)
	private String codigoBarrasIss;
	@Column(name = "COD_REMESSA", nullable = true)
	private Integer codigoRemessa;
	@Column(name = "COD_SIT_CORF", nullable = true)
	private Integer codigoSituacaoCorf;
	@Column(name = "USR_CORF", nullable = true, length = 15)
	private String usuarioCorf;
	@Column(name = "DAT_CORF", nullable = true)
	private LocalDate dataCorf;
	@Column(name = "COD_IMPOSTOS_FEDERAIS", nullable = true, length = 6)
	private String codigoImpostosFederais;
	@Column(name = "VLR_TOTALNF", nullable = true)
	private BigDecimal valorTotalNF;
	@Column(name = "VLR_GLOSA", nullable = true)
	private BigDecimal valorGlosa;

	public EncaminhamentoPK getEncaminhamentoPk() {
		return encaminhamentoPk;
	}

	public void setEncaminhamentoPk(EncaminhamentoPK encaminhamentoPk) {
		this.encaminhamentoPk = encaminhamentoPk;
	}

	public String getNomeExecutor() {
		return nomeExecutor;
	}

	public void setNomeExecutor(String nomeExecutor) {
		this.nomeExecutor = nomeExecutor;
	}

	public String getNumeroFolhaExecutor() {
		return numeroFolhaExecutor;
	}

	public void setNumeroFolhaExecutor(String numeroFolhaExecutor) {
		this.numeroFolhaExecutor = numeroFolhaExecutor;
	}

	public LocalDate getDataEncaminhamento() {
		return dataEncaminhamento;
	}

	public void setDataEncaminhamento(LocalDate dataEncaminhamento) {
		this.dataEncaminhamento = dataEncaminhamento;
	}

	public LocalDate getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public String getObservacaoEncaminhamento() {
		return observacaoEncaminhamento;
	}

	public void setObservacaoEncaminhamento(String observacaoEncaminhamento) {
		this.observacaoEncaminhamento = observacaoEncaminhamento;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public BigDecimal getAliquotaFed() {
		return aliquotaFed;
	}

	public void setAliquotaFed(BigDecimal aliquotaFed) {
		this.aliquotaFed = aliquotaFed;
	}

	public BigDecimal getAliquotaIss() {
		return aliquotaIss;
	}

	public void setAliquotaIss(BigDecimal aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public BigDecimal getValorFed() {
		return valorFed;
	}

	public void setValorFed(BigDecimal valorFed) {
		this.valorFed = valorFed;
	}

	public BigDecimal getValorIss() {
		return valorIss;
	}

	public void setValorIss(BigDecimal valorIss) {
		this.valorIss = valorIss;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getAliquotaIR() {
		return aliquotaIR;
	}

	public void setAliquotaIR(BigDecimal aliquotaIR) {
		this.aliquotaIR = aliquotaIR;
	}

	public BigDecimal getValorIR() {
		return valorIR;
	}

	public void setValorIR(BigDecimal valorIR) {
		this.valorIR = valorIR;
	}

	public BigDecimal getAliquotaCsll() {
		return aliquotaCsll;
	}

	public void setAliquotaCsll(BigDecimal aliquotaCsll) {
		this.aliquotaCsll = aliquotaCsll;
	}

	public BigDecimal getValorCsll() {
		return valorCsll;
	}

	public void setValorCsll(BigDecimal valorCsll) {
		this.valorCsll = valorCsll;
	}

	public BigDecimal getAliquotaCofins() {
		return aliquotaCofins;
	}

	public void setAliquotaCofins(BigDecimal aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}

	public BigDecimal getValorCofins() {
		return valorCofins;
	}

	public void setValorCofins(BigDecimal valorCofins) {
		this.valorCofins = valorCofins;
	}

	public BigDecimal getAliquotaPisPasep() {
		return aliquotaPisPasep;
	}

	public void setAliquotaPisPasep(BigDecimal aliquotaPisPasep) {
		this.aliquotaPisPasep = aliquotaPisPasep;
	}

	public BigDecimal getValorPisPasep() {
		return valorPisPasep;
	}

	public void setValorPisPasep(BigDecimal valorPisPasep) {
		this.valorPisPasep = valorPisPasep;
	}

	public String getCodigoBarrasIss() {
		return codigoBarrasIss;
	}

	public void setCodigoBarrasIss(String codigoBarrasIss) {
		this.codigoBarrasIss = codigoBarrasIss;
	}

	public Integer getCodigoRemessa() {
		return codigoRemessa;
	}

	public void setCodigoRemessa(Integer codigoRemessa) {
		this.codigoRemessa = codigoRemessa;
	}

	public Integer getCodigoSituacaoCorf() {
		return codigoSituacaoCorf;
	}

	public void setCodigoSituacaoCorf(Integer codigoSituacaoCorf) {
		this.codigoSituacaoCorf = codigoSituacaoCorf;
	}

	public String getUsuarioCorf() {
		return usuarioCorf;
	}

	public void setUsuarioCorf(String usuarioCorf) {
		this.usuarioCorf = usuarioCorf;
	}

	public LocalDate getDataCorf() {
		return dataCorf;
	}

	public void setDataCorf(LocalDate dataCorf) {
		this.dataCorf = dataCorf;
	}

	public String getCodigoImpostosFederais() {
		return codigoImpostosFederais;
	}

	public void setCodigoImpostosFederais(String codigoImpostosFederais) {
		this.codigoImpostosFederais = codigoImpostosFederais;
	}

	public BigDecimal getValorTotalNF() {
		return valorTotalNF;
	}

	public void setValorTotalNF(BigDecimal valorTotalNF) {
		this.valorTotalNF = valorTotalNF;
	}

	public BigDecimal getValorGlosa() {
		return valorGlosa;
	}

	public void setValorGlosa(BigDecimal valorGlosa) {
		this.valorGlosa = valorGlosa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aliquotaCofins == null) ? 0 : aliquotaCofins.hashCode());
		result = prime * result + ((aliquotaCsll == null) ? 0 : aliquotaCsll.hashCode());
		result = prime * result + ((aliquotaFed == null) ? 0 : aliquotaFed.hashCode());
		result = prime * result + ((aliquotaIR == null) ? 0 : aliquotaIR.hashCode());
		result = prime * result + ((aliquotaIss == null) ? 0 : aliquotaIss.hashCode());
		result = prime * result + ((aliquotaPisPasep == null) ? 0 : aliquotaPisPasep.hashCode());
		result = prime * result + ((codigoBarrasIss == null) ? 0 : codigoBarrasIss.hashCode());
		result = prime * result + ((codigoImpostosFederais == null) ? 0 : codigoImpostosFederais.hashCode());
		result = prime * result + ((codigoRemessa == null) ? 0 : codigoRemessa.hashCode());
		result = prime * result + ((codigoSituacaoCorf == null) ? 0 : codigoSituacaoCorf.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataCorf == null) ? 0 : dataCorf.hashCode());
		result = prime * result + ((dataEncaminhamento == null) ? 0 : dataEncaminhamento.hashCode());
		result = prime * result + ((dataRetorno == null) ? 0 : dataRetorno.hashCode());
		result = prime * result + ((encaminhamentoPk == null) ? 0 : encaminhamentoPk.hashCode());
		result = prime * result + ((nomeExecutor == null) ? 0 : nomeExecutor.hashCode());
		result = prime * result + ((numeroFolhaExecutor == null) ? 0 : numeroFolhaExecutor.hashCode());
		result = prime * result + ((observacaoEncaminhamento == null) ? 0 : observacaoEncaminhamento.hashCode());
		result = prime * result + ((usuarioCorf == null) ? 0 : usuarioCorf.hashCode());
		result = prime * result + ((valorCofins == null) ? 0 : valorCofins.hashCode());
		result = prime * result + ((valorCsll == null) ? 0 : valorCsll.hashCode());
		result = prime * result + ((valorFed == null) ? 0 : valorFed.hashCode());
		result = prime * result + ((valorGlosa == null) ? 0 : valorGlosa.hashCode());
		result = prime * result + ((valorIR == null) ? 0 : valorIR.hashCode());
		result = prime * result + ((valorIss == null) ? 0 : valorIss.hashCode());
		result = prime * result + ((valorPisPasep == null) ? 0 : valorPisPasep.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		result = prime * result + ((valorTotalNF == null) ? 0 : valorTotalNF.hashCode());
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
		Encaminhamento other = (Encaminhamento) obj;
		if (aliquotaCofins == null) {
			if (other.aliquotaCofins != null)
				return false;
		} else if (!aliquotaCofins.equals(other.aliquotaCofins))
			return false;
		if (aliquotaCsll == null) {
			if (other.aliquotaCsll != null)
				return false;
		} else if (!aliquotaCsll.equals(other.aliquotaCsll))
			return false;
		if (aliquotaFed == null) {
			if (other.aliquotaFed != null)
				return false;
		} else if (!aliquotaFed.equals(other.aliquotaFed))
			return false;
		if (aliquotaIR == null) {
			if (other.aliquotaIR != null)
				return false;
		} else if (!aliquotaIR.equals(other.aliquotaIR))
			return false;
		if (aliquotaIss == null) {
			if (other.aliquotaIss != null)
				return false;
		} else if (!aliquotaIss.equals(other.aliquotaIss))
			return false;
		if (aliquotaPisPasep == null) {
			if (other.aliquotaPisPasep != null)
				return false;
		} else if (!aliquotaPisPasep.equals(other.aliquotaPisPasep))
			return false;
		if (codigoBarrasIss == null) {
			if (other.codigoBarrasIss != null)
				return false;
		} else if (!codigoBarrasIss.equals(other.codigoBarrasIss))
			return false;
		if (codigoImpostosFederais == null) {
			if (other.codigoImpostosFederais != null)
				return false;
		} else if (!codigoImpostosFederais.equals(other.codigoImpostosFederais))
			return false;
		if (codigoRemessa == null) {
			if (other.codigoRemessa != null)
				return false;
		} else if (!codigoRemessa.equals(other.codigoRemessa))
			return false;
		if (codigoSituacaoCorf == null) {
			if (other.codigoSituacaoCorf != null)
				return false;
		} else if (!codigoSituacaoCorf.equals(other.codigoSituacaoCorf))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataCorf == null) {
			if (other.dataCorf != null)
				return false;
		} else if (!dataCorf.equals(other.dataCorf))
			return false;
		if (dataEncaminhamento == null) {
			if (other.dataEncaminhamento != null)
				return false;
		} else if (!dataEncaminhamento.equals(other.dataEncaminhamento))
			return false;
		if (dataRetorno == null) {
			if (other.dataRetorno != null)
				return false;
		} else if (!dataRetorno.equals(other.dataRetorno))
			return false;
		if (encaminhamentoPk == null) {
			if (other.encaminhamentoPk != null)
				return false;
		} else if (!encaminhamentoPk.equals(other.encaminhamentoPk))
			return false;
		if (nomeExecutor == null) {
			if (other.nomeExecutor != null)
				return false;
		} else if (!nomeExecutor.equals(other.nomeExecutor))
			return false;
		if (numeroFolhaExecutor == null) {
			if (other.numeroFolhaExecutor != null)
				return false;
		} else if (!numeroFolhaExecutor.equals(other.numeroFolhaExecutor))
			return false;
		if (observacaoEncaminhamento == null) {
			if (other.observacaoEncaminhamento != null)
				return false;
		} else if (!observacaoEncaminhamento.equals(other.observacaoEncaminhamento))
			return false;
		if (usuarioCorf == null) {
			if (other.usuarioCorf != null)
				return false;
		} else if (!usuarioCorf.equals(other.usuarioCorf))
			return false;
		if (valorCofins == null) {
			if (other.valorCofins != null)
				return false;
		} else if (!valorCofins.equals(other.valorCofins))
			return false;
		if (valorCsll == null) {
			if (other.valorCsll != null)
				return false;
		} else if (!valorCsll.equals(other.valorCsll))
			return false;
		if (valorFed == null) {
			if (other.valorFed != null)
				return false;
		} else if (!valorFed.equals(other.valorFed))
			return false;
		if (valorGlosa == null) {
			if (other.valorGlosa != null)
				return false;
		} else if (!valorGlosa.equals(other.valorGlosa))
			return false;
		if (valorIR == null) {
			if (other.valorIR != null)
				return false;
		} else if (!valorIR.equals(other.valorIR))
			return false;
		if (valorIss == null) {
			if (other.valorIss != null)
				return false;
		} else if (!valorIss.equals(other.valorIss))
			return false;
		if (valorPisPasep == null) {
			if (other.valorPisPasep != null)
				return false;
		} else if (!valorPisPasep.equals(other.valorPisPasep))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (valorTotalNF == null) {
			if (other.valorTotalNF != null)
				return false;
		} else if (!valorTotalNF.equals(other.valorTotalNF))
			return false;
		return true;
	}

}
