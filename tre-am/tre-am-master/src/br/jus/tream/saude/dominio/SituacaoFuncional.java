package br.jus.tream.saude.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITUACAO_FUNCIONAL")
public class SituacaoFuncional {

	@Id
	@Column(name = "COD_SIT_FUNC")
	private Long id;
	@Column(name = "NOM_SIT_FUNC", nullable = false, length = 50)
	private String descricao;
	@Column(name = "SGL_SIT_FUNC", nullable = false, length = 3)
	private String sigla;
	@Column(name = "DAT_ULT_ATUAL")
	private LocalDate dataUltimaAtualizacao;
	@Column(name = "IND_SIT_TITULAR")
	private Short situacaoTitular;

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
		SituacaoFuncional other = (SituacaoFuncional) obj;
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
