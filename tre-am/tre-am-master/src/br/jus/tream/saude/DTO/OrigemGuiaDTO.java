package br.jus.tream.saude.DTO;

import java.io.Serializable;

import br.jus.tream.saude.dominio.OrigemGuia;

/**
 * Representa os dados da {@link OrigemGuia}.
 * 
 * @author vinicius
 *
 */
public class OrigemGuiaDTO implements Serializable {

	private static final long serialVersionUID = -7841576288503081123L;

	private Short id;
	private String descricao;

	public OrigemGuiaDTO() {
	}

	/**
	 * Responsável por converter a {@link OrigemGuia} para seu respectivo Dto.
	 * 
	 * @param origem que será convertida.
	 */
	public OrigemGuiaDTO(OrigemGuia origem) {
		this.id = origem.getId();
		this.descricao = origem.getDescricao();
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OrigemGuiaDTO other = (OrigemGuiaDTO) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
