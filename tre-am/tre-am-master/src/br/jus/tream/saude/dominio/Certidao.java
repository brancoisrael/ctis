package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CERTIDAO_CREDENCIADO")
public class Certidao implements Serializable {

	private static final long serialVersionUID = -4584237665191586558L;
	@EmbeddedId
	private CertidaoPK certidaoPK;
	@Column(name = "DAT_VALIDADE", nullable = false)
	private LocalDate dataValidade;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "NUM_FOLHA_CERTIDAO", nullable = true, length = 10)
	private String numeroFolha;
	@Column(name = "NUM_DOC_SEI", nullable = true)
	private Long numeroDocumentoSei;

	public CertidaoPK getCertidaoPK() {
		return certidaoPK;
	}

	public void setCertidaoPK(CertidaoPK certidaoPK) {
		this.certidaoPK = certidaoPK;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getNumeroFolha() {
		return numeroFolha;
	}

	public void setNumeroFolha(String numeroFolha) {
		this.numeroFolha = numeroFolha;
	}

	public Long getNumeroDocumentoSei() {
		return numeroDocumentoSei;
	}

	public void setNumeroDocumentoSei(Long numeroDocumentoSei) {
		this.numeroDocumentoSei = numeroDocumentoSei;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certidaoPK == null) ? 0 : certidaoPK.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result + ((numeroDocumentoSei == null) ? 0 : numeroDocumentoSei.hashCode());
		result = prime * result + ((numeroFolha == null) ? 0 : numeroFolha.hashCode());
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
		Certidao other = (Certidao) obj;
		if (certidaoPK == null) {
			if (other.certidaoPK != null)
				return false;
		} else if (!certidaoPK.equals(other.certidaoPK))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataValidade == null) {
			if (other.dataValidade != null)
				return false;
		} else if (!dataValidade.equals(other.dataValidade))
			return false;
		if (numeroDocumentoSei == null) {
			if (other.numeroDocumentoSei != null)
				return false;
		} else if (!numeroDocumentoSei.equals(other.numeroDocumentoSei))
			return false;
		if (numeroFolha == null) {
			if (other.numeroFolha != null)
				return false;
		} else if (!numeroFolha.equals(other.numeroFolha))
			return false;
		return true;
	}

}
