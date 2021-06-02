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
public class GuiaPK implements Serializable {

	private static final long serialVersionUID = -7739054971887882961L;
	@Column(name = "NUM_GUIA", nullable = false)
	private Long numeroGuia;
	@Column(name = "ANO_EXERCICIO", nullable = false, length = 4)
	private String anoExercicio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_TIP_GUIA")
	private TipoGuia tipoGuia;

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

	public TipoGuia getTipoGuia() {
		return tipoGuia;
	}

	public void setTipoGuia(TipoGuia tipoGuia) {
		this.tipoGuia = tipoGuia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((numeroGuia == null) ? 0 : numeroGuia.hashCode());
		result = prime * result + ((tipoGuia == null) ? 0 : tipoGuia.hashCode());
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
		GuiaPK other = (GuiaPK) obj;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (numeroGuia == null) {
			if (other.numeroGuia != null)
				return false;
		} else if (!numeroGuia.equals(other.numeroGuia))
			return false;
		if (tipoGuia == null) {
			if (other.tipoGuia != null)
				return false;
		} else if (!tipoGuia.equals(other.tipoGuia))
			return false;
		return true;
	}

}
