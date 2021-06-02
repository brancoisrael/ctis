package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "VALOR_PROCEDIMENTO")
public class ValorProcedimento implements Serializable {

	private static final long serialVersionUID = -6123415577336013168L;
	@EmbeddedId
	private ValorProcedimentoPK valorProcedimentoPK;
	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;

	public ValorProcedimentoPK getValorProcedimentoPK() {
		return valorProcedimentoPK;
	}

	public void setValorProcedimentoPK(ValorProcedimentoPK valorProcedimentoPK) {
		this.valorProcedimentoPK = valorProcedimentoPK;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorProcedimentoPK == null) ? 0 : valorProcedimentoPK.hashCode());
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
		ValorProcedimento other = (ValorProcedimento) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorProcedimentoPK == null) {
			if (other.valorProcedimentoPK != null)
				return false;
		} else if (!valorProcedimentoPK.equals(other.valorProcedimentoPK))
			return false;
		return true;
	}

}
