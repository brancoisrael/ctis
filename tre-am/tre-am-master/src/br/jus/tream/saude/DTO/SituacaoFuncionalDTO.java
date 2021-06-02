package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import br.jus.tream.saude.dominio.SituacaoFuncional;

/**
 * Representa os dados de uma {@link SituacaoFuncional}.
 * 
 * @author vinicius
 *
 */
public class SituacaoFuncionalDTO implements Serializable {

	private static final long serialVersionUID = -8607868381195557215L;
	private Long id;
	private String descricao;
	private String sigla;
	private LocalDate dataUltimaAtualizacao;
	private Short situacaoTitular;

	public SituacaoFuncionalDTO() {}

	/**
	 * Responsável por converter uma {@link SituacaoFuncional} para seu respectivo
	 * Dto.
	 * 
	 * @param situacao que será convertido.
	 */
	public SituacaoFuncionalDTO(SituacaoFuncional situacao) {
		this.id = situacao.getId();
		this.descricao = situacao.getDescricao();
		this.sigla = situacao.getSigla();
		this.dataUltimaAtualizacao = situacao.getDataUltimaAtualizacao();
		this.situacaoTitular = situacao.getSituacaoTitular();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public LocalDate getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Short getSituacaoTitular() {
		return situacaoTitular;
	}

	public void setSituacaoTitular(Short situacaoTitular) {
		this.situacaoTitular = situacaoTitular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUltimaAtualizacao == null) ? 0 : dataUltimaAtualizacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((situacaoTitular == null) ? 0 : situacaoTitular.hashCode());
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
		SituacaoFuncionalDTO other = (SituacaoFuncionalDTO) obj;
		if (dataUltimaAtualizacao == null) {
			if (other.dataUltimaAtualizacao != null)
				return false;
		} else if (!dataUltimaAtualizacao.equals(other.dataUltimaAtualizacao))
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
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (situacaoTitular == null) {
			if (other.situacaoTitular != null)
				return false;
		} else if (!situacaoTitular.equals(other.situacaoTitular))
			return false;
		return true;
	}

}
