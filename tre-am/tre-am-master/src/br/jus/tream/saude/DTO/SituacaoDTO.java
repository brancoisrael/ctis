package br.jus.tream.saude.DTO;

import java.io.Serializable;

import br.jus.tream.saude.dominio.Situacao;

/**
 * Representa os dados de uma {@link Situacao}.
 * 
 * @author vinicius
 *
 */
public class SituacaoDTO implements Serializable {

	private static final long serialVersionUID = 6051640018776063390L;
	private Short id;
	private String descricao;

	public SituacaoDTO() {
	}

	/**
	 * Responsável por converter uma {@link Situacao} para seu respectivo Dto.
	 * 
	 * @param situacao que será convertida.
	 */
	public SituacaoDTO(Situacao situacao) {
		this.id = situacao.getId();
		this.descricao = situacao.getDescricao();
	}
	
	public SituacaoDTO(Short id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
		SituacaoDTO other = (SituacaoDTO) obj;
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
