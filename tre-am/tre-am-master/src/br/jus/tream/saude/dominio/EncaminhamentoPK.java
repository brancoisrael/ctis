package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author vinicius
 *
 */
@Embeddable
public class EncaminhamentoPK implements Serializable {

	private static final long serialVersionUID = -4845786519663229072L;

	@Column(name = "MES_REFERENCIA", nullable = false)
	private Integer mesReferencia;
	@Column(name = "ANO_REFERENCIA", nullable = false)
	private Integer anoReferencia;
	@NotFound(action = NotFoundAction.IGNORE)
	@MapsId("acompanhamentoGuiaPK")
	@JoinColumns({ @JoinColumn(name = "COD_CREDENCIADO", referencedColumnName = "COD_CREDENCIADO"),
			@JoinColumn(name = "ANO_EXERCICIO", referencedColumnName = "ANO_EXERCICIO") })
	@ManyToOne
	private AcompanhamentoGuia acompanhamentoGuia;

	public Integer getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Integer mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Integer getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public AcompanhamentoGuia getAcompanhamentoGuia() {
		return acompanhamentoGuia;
	}

	public void setAcompanhamentoGuia(AcompanhamentoGuia acompanhamentoGuia) {
		this.acompanhamentoGuia = acompanhamentoGuia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acompanhamentoGuia == null) ? 0 : acompanhamentoGuia.hashCode());
		result = prime * result + ((anoReferencia == null) ? 0 : anoReferencia.hashCode());
		result = prime * result + ((mesReferencia == null) ? 0 : mesReferencia.hashCode());
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
		EncaminhamentoPK other = (EncaminhamentoPK) obj;
		if (acompanhamentoGuia == null) {
			if (other.acompanhamentoGuia != null)
				return false;
		} else if (!acompanhamentoGuia.equals(other.acompanhamentoGuia))
			return false;
		if (anoReferencia == null) {
			if (other.anoReferencia != null)
				return false;
		} else if (!anoReferencia.equals(other.anoReferencia))
			return false;
		if (mesReferencia == null) {
			if (other.mesReferencia != null)
				return false;
		} else if (!mesReferencia.equals(other.mesReferencia))
			return false;
		return true;
	}

}
