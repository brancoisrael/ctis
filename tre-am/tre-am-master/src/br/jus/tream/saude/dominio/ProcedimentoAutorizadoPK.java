package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * 
 * @author vinicius
 *
 */
@Embeddable
public class ProcedimentoAutorizadoPK implements Serializable {

	private static final long serialVersionUID = -8558204453530922850L;

	@MapsId("procedimentoPK")
	@JoinColumns({ @JoinColumn(name = "COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO"),
			@JoinColumn(name = "COD_TABELA", referencedColumnName = "COD_TABELA") })
	@ManyToOne
	private Procedimento procedimento;

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
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
		ProcedimentoAutorizadoPK other = (ProcedimentoAutorizadoPK) obj;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		return true;
	}

}
