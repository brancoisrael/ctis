package br.jus.tream.saude.DTO;

import java.io.Serializable;

public class ProcedimentoFormDTO  implements Serializable {

	private static final long serialVersionUID = 2649157806812515124L;
	
	private String codigoProcedimento;
	private Integer quantidade;
	private String valor;
	
	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}
	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProcedimento == null) ? 0 : codigoProcedimento.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		ProcedimentoFormDTO other = (ProcedimentoFormDTO) obj;
		if (codigoProcedimento == null) {
			if (other.codigoProcedimento != null)
				return false;
		} else if (!codigoProcedimento.equals(other.codigoProcedimento))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
	
}
