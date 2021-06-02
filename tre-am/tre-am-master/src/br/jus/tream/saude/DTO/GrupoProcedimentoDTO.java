package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import br.jus.tream.saude.dominio.Auxiliar;
import br.jus.tream.saude.dominio.GrupoProcedimentoOdonto;

/**
 * Representa os dados de um {@link GrupoProcedimentoOdonto}.
 * 
 * @author vinicius
 *
 */
public class GrupoProcedimentoDTO implements Serializable {

	private static final long serialVersionUID = -1008121138768287614L;

	private Long id;
	private String descricao;
	private LocalDate dataAtualizacao;

	public GrupoProcedimentoDTO() {
	}

	/**
	 * Responsável por converter um {@link Auxiliar} para seu respectivo Dto.
	 * 
	 * @param aux que será convertido.
	 */
	public GrupoProcedimentoDTO(GrupoProcedimentoOdonto grupo) {
		this.id = grupo.getId();
		this.descricao = grupo.getDescricao();
		this.dataAtualizacao = grupo.getDataAtualizacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
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
		GrupoProcedimentoDTO other = (GrupoProcedimentoDTO) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
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
