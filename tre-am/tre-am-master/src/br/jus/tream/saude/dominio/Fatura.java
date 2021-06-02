package br.jus.tream.saude.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FATURA")
public class Fatura {

	@EmbeddedId
	private FaturaPK faturaPK;
	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;
	@Column(name = "NUM_NF", nullable = true, length = 15)
	private String notaFiscal;
	@Column(name = "DAT_NF", nullable = true)
	private LocalDate dataNotaFiscal;
	@Column(name = "DAT_PROTOCOLO", nullable = true)
	private LocalDate dataProtocolo;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SITUACAO")
	private SituacaoFatura situacaoFatura;
	@Column(name = "MES_REFERENCIA", nullable = true)
	private Short mes;
	@Column(name = "ANO_REFERENCIA", nullable = true)
	private Short ano;
	@Column(name = "NUM_FOLHA_FATURA", nullable = true, length = 10)
	private String numeroFolha;
	@Column(name = "NUM_FOLHA_GUIAS_MEDICAS", nullable = true, length = 20)
	private String numeroFolhasGuias;
	@Column(name = "GLOSA", nullable = true)
	private Double glosa;
	@Column(name = "NUM_DOC_SEI", nullable = true)
	private Long numeroSei;
	@Column(name = "DAT_ATESTO", nullable = true)
	private LocalDate dataAtesto;
	@Column(name = "GLOSAESPECIAL", nullable = true)
	private Double glosaEspecial;

	public FaturaPK getFaturaPK() {
		return faturaPK;
	}

	public void setFaturaPK(FaturaPK faturaPK) {
		this.faturaPK = faturaPK;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public LocalDate getDataNotaFiscal() {
		return dataNotaFiscal;
	}

	public void setDataNotaFiscal(LocalDate dataNotaFiscal) {
		this.dataNotaFiscal = dataNotaFiscal;
	}

	public LocalDate getDataProtocolo() {
		return dataProtocolo;
	}

	public void setDataProtocolo(LocalDate dataProtocolo) {
		this.dataProtocolo = dataProtocolo;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public SituacaoFatura getSituacaoFatura() {
		return situacaoFatura;
	}

	public void setSituacaoFatura(SituacaoFatura situacaoFatura) {
		this.situacaoFatura = situacaoFatura;
	}

	public Short getMes() {
		return mes;
	}

	public void setMes(Short mes) {
		this.mes = mes;
	}

	public Short getAno() {
		return ano;
	}

	public void setAno(Short ano) {
		this.ano = ano;
	}

	public String getNumeroFolha() {
		return numeroFolha;
	}

	public void setNumeroFolha(String numeroFolha) {
		this.numeroFolha = numeroFolha;
	}

	public String getNumeroFolhasGuias() {
		return numeroFolhasGuias;
	}

	public void setNumeroFolhasGuias(String numeroFolhasGuias) {
		this.numeroFolhasGuias = numeroFolhasGuias;
	}

	public Double getGlosa() {
		return glosa;
	}

	public void setGlosa(Double glosa) {
		this.glosa = glosa;
	}

	public Long getNumeroSei() {
		return numeroSei;
	}

	public void setNumeroSei(Long numeroSei) {
		this.numeroSei = numeroSei;
	}

	public LocalDate getDataAtesto() {
		return dataAtesto;
	}

	public void setDataAtesto(LocalDate dataAtesto) {
		this.dataAtesto = dataAtesto;
	}

	public Double getGlosaEspecial() {
		return glosaEspecial;
	}

	public void setGlosaEspecial(Double glosaEspecial) {
		this.glosaEspecial = glosaEspecial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((dataAtesto == null) ? 0 : dataAtesto.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataNotaFiscal == null) ? 0 : dataNotaFiscal.hashCode());
		result = prime * result + ((dataProtocolo == null) ? 0 : dataProtocolo.hashCode());
		result = prime * result + ((faturaPK == null) ? 0 : faturaPK.hashCode());
		result = prime * result + ((glosa == null) ? 0 : glosa.hashCode());
		result = prime * result + ((glosaEspecial == null) ? 0 : glosaEspecial.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((notaFiscal == null) ? 0 : notaFiscal.hashCode());
		result = prime * result + ((numeroFolha == null) ? 0 : numeroFolha.hashCode());
		result = prime * result + ((numeroFolhasGuias == null) ? 0 : numeroFolhasGuias.hashCode());
		result = prime * result + ((numeroSei == null) ? 0 : numeroSei.hashCode());
		result = prime * result + ((situacaoFatura == null) ? 0 : situacaoFatura.hashCode());
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
		Fatura other = (Fatura) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (dataAtesto == null) {
			if (other.dataAtesto != null)
				return false;
		} else if (!dataAtesto.equals(other.dataAtesto))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataNotaFiscal == null) {
			if (other.dataNotaFiscal != null)
				return false;
		} else if (!dataNotaFiscal.equals(other.dataNotaFiscal))
			return false;
		if (dataProtocolo == null) {
			if (other.dataProtocolo != null)
				return false;
		} else if (!dataProtocolo.equals(other.dataProtocolo))
			return false;
		if (faturaPK == null) {
			if (other.faturaPK != null)
				return false;
		} else if (!faturaPK.equals(other.faturaPK))
			return false;
		if (glosa == null) {
			if (other.glosa != null)
				return false;
		} else if (!glosa.equals(other.glosa))
			return false;
		if (glosaEspecial == null) {
			if (other.glosaEspecial != null)
				return false;
		} else if (!glosaEspecial.equals(other.glosaEspecial))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (notaFiscal == null) {
			if (other.notaFiscal != null)
				return false;
		} else if (!notaFiscal.equals(other.notaFiscal))
			return false;
		if (numeroFolha == null) {
			if (other.numeroFolha != null)
				return false;
		} else if (!numeroFolha.equals(other.numeroFolha))
			return false;
		if (numeroFolhasGuias == null) {
			if (other.numeroFolhasGuias != null)
				return false;
		} else if (!numeroFolhasGuias.equals(other.numeroFolhasGuias))
			return false;
		if (numeroSei == null) {
			if (other.numeroSei != null)
				return false;
		} else if (!numeroSei.equals(other.numeroSei))
			return false;
		if (situacaoFatura == null) {
			if (other.situacaoFatura != null)
				return false;
		} else if (!situacaoFatura.equals(other.situacaoFatura))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
