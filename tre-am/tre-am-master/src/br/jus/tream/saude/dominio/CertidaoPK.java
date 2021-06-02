package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author vinicius
 *
 */
@Embeddable
public class CertidaoPK implements Serializable {

	private static final long serialVersionUID = -2564582874507975304L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CREDENCIADO")
	protected Credenciado credenciado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CERTIDAO_FISCAL")
	protected CertidaoFiscal certidaoFiscal;

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
		this.credenciado = credenciado;
	}

	public CertidaoFiscal getCertidaoFiscal() {
		return certidaoFiscal;
	}

	public void setCertidaoFiscal(CertidaoFiscal certidaoFiscal) {
		this.certidaoFiscal = certidaoFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certidaoFiscal == null) ? 0 : certidaoFiscal.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
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
		CertidaoPK other = (CertidaoPK) obj;
		if (certidaoFiscal == null) {
			if (other.certidaoFiscal != null)
				return false;
		} else if (!certidaoFiscal.equals(other.certidaoFiscal))
			return false;
		if (credenciado == null) {
			if (other.credenciado != null)
				return false;
		} else if (!credenciado.equals(other.credenciado))
			return false;
		return true;
	}

}
