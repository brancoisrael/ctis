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
public class TabelaIdadePK implements Serializable {

	private static final long serialVersionUID = 133554974989025330L;

	@Column(name = "CD", nullable = false, length = 5)
	private String idTabela;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CD_BCO")
	private Banco banco;

	public String getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(String idTabela) {
		this.idTabela = idTabela;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((idTabela == null) ? 0 : idTabela.hashCode());
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
		TabelaIdadePK other = (TabelaIdadePK) obj;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		if (idTabela == null) {
			if (other.idTabela != null)
				return false;
		} else if (!idTabela.equals(other.idTabela))
			return false;
		return true;
	}

}
