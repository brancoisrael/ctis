package br.jus.tream.saude.dominio;

import java.io.Serializable;
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
@Table(name = "PA_ACOMPANHAMENTO_GUIAS")
public class AcompanhamentoGuia implements Serializable {

	private static final long serialVersionUID = -3706063320228553977L;
	@EmbeddedId
	private AcompanhamentoGuiaPK acompanhamentoGuiaPK;
	@Column(name = "NUM_PA", nullable = false, length = 30)
	private String numeroPA;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;

	public AcompanhamentoGuiaPK getAcompanhamentoGuiaPK() {
		return acompanhamentoGuiaPK;
	}

	public void setAcompanhamentoGuiaPK(AcompanhamentoGuiaPK acompanhamentoGuiaPK) {
		this.acompanhamentoGuiaPK = acompanhamentoGuiaPK;
	}

	public String getNumeroPA() {
		return numeroPA;
	}

	public void setNumeroPA(String numeroPA) {
		this.numeroPA = numeroPA;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acompanhamentoGuiaPK == null) ? 0 : acompanhamentoGuiaPK.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((numeroPA == null) ? 0 : numeroPA.hashCode());
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
		AcompanhamentoGuia other = (AcompanhamentoGuia) obj;
		if (acompanhamentoGuiaPK == null) {
			if (other.acompanhamentoGuiaPK != null)
				return false;
		} else if (!acompanhamentoGuiaPK.equals(other.acompanhamentoGuiaPK))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (numeroPA == null) {
			if (other.numeroPA != null)
				return false;
		} else if (!numeroPA.equals(other.numeroPA))
			return false;
		return true;
	}

}
