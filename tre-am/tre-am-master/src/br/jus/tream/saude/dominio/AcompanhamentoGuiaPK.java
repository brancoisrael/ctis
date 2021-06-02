package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Column;
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
public class AcompanhamentoGuiaPK implements Serializable {

	private static final long serialVersionUID = 1265753918844979295L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CREDENCIADO")
	protected Credenciado credenciado;
	@Column(name = "ANO_EXERCICIO", nullable = false, length = 4)
	private String anoExercicio;

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
		this.credenciado = credenciado;
	}

	public String getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(String anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
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
		AcompanhamentoGuiaPK other = (AcompanhamentoGuiaPK) obj;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (credenciado == null) {
			if (other.credenciado != null)
				return false;
		} else if (!credenciado.equals(other.credenciado))
			return false;
		return true;
	}

}
