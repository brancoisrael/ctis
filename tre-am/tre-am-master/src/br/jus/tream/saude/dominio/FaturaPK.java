package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDate;

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
public class FaturaPK implements Serializable {

	private static final long serialVersionUID = -3238905660555002810L;

	@Column(name = "NUM_FATURA", nullable = false, length = 15)
	protected String numeroFatura;
	@Column(name = "DAT_FATURA", nullable = false)
	protected LocalDate dataFatura;
	@Column(name = "ANO_EXERCICIO", nullable = false, length = 4)
	protected String anoExercicio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CREDENCIADO")
	protected Credenciado credenciado;

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public LocalDate getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(LocalDate dataFatura) {
		this.dataFatura = dataFatura;
	}

	public String getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(String anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
		this.credenciado = credenciado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
		result = prime * result + ((dataFatura == null) ? 0 : dataFatura.hashCode());
		result = prime * result + ((numeroFatura == null) ? 0 : numeroFatura.hashCode());
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
		FaturaPK other = (FaturaPK) obj;
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
		if (dataFatura == null) {
			if (other.dataFatura != null)
				return false;
		} else if (!dataFatura.equals(other.dataFatura))
			return false;
		if (numeroFatura == null) {
			if (other.numeroFatura != null)
				return false;
		} else if (!numeroFatura.equals(other.numeroFatura))
			return false;
		return true;
	}

}
