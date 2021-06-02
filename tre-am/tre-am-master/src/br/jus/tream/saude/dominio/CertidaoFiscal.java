package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CERTIDAO_FISCAL")
public class CertidaoFiscal implements Serializable {

	private static final long serialVersionUID = -4584237665191586558L;
	@Id
	@Column(name = "COD_CERTIDAO_FISCAL")
	private Long id;
	@Column(name = "NOM_CERTIDAO_FISCAL", nullable = false, length = 100)
	private String nome;
	@Column(name = "CERTIDAO_ATIVADA", nullable = false)
	private Boolean ativada;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivada() {
		return ativada;
	}

	public void setAtivada(Boolean ativada) {
		this.ativada = ativada;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativada == null) ? 0 : ativada.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		CertidaoFiscal other = (CertidaoFiscal) obj;
		if (ativada == null) {
			if (other.ativada != null)
				return false;
		} else if (!ativada.equals(other.ativada))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
