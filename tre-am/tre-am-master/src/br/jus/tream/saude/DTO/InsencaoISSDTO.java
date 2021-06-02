package br.jus.tream.saude.DTO;

import java.io.Serializable;

import br.jus.tream.saude.enumeration.InsencaoISS;

/**
 * Representa os dados da {@link InsencaoISS}.
 * 
 * @author vinicius
 *
 */
public class InsencaoISSDTO implements Serializable {

	private static final long serialVersionUID = -4787289551088292106L;
	private Integer id;
	private String descricao;

	public InsencaoISSDTO() {
	}

	/**
	 * Responsável por converter {@link InsencaoISS} para seu respectivo Dto.
	 * 
	 * @param isencao que será convertida.
	 */
	public InsencaoISSDTO(InsencaoISS isencao) {
		this.id = isencao.ordinal();
		this.descricao = isencao.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		InsencaoISSDTO other = (InsencaoISSDTO) obj;
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
