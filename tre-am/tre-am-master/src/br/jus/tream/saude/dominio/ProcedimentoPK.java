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
public class ProcedimentoPK implements Serializable {

	private static final long serialVersionUID = 8920201049152446088L;
	@Column(name = "COD_PROCEDIMENTO", nullable = false, length = 15)
	private String codigoProcedimento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TABELA", nullable = false)
	private TabelaCredenciado tabela;

	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public TabelaCredenciado getTabela() {
		return tabela;
	}

	public void setTabela(TabelaCredenciado tabela) {
		this.tabela = tabela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProcedimento == null) ? 0 : codigoProcedimento.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		ProcedimentoPK other = (ProcedimentoPK) obj;
		if (codigoProcedimento == null) {
			if (other.codigoProcedimento != null)
				return false;
		} else if (!codigoProcedimento.equals(other.codigoProcedimento))
			return false;
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		return true;
	}

}
