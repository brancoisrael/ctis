package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUXILIAR")
public class Auxiliar implements Serializable {

	private static final long serialVersionUID = 5203795566131616117L;
	@Id
	@Column(name = "COD_AUXILIAR")
	private Long id;
	@Column(name = "TAXA_HONORARIO", nullable = true)
	private BigDecimal taxaHonorario;
	@Column(name = "NOM_AUXILIAR", nullable = true, length = 15)
	private String nome;
	@Column(name = "DAT_ULT_ATUAL", nullable = true)
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTaxaHonorario() {
		return taxaHonorario;
	}

	public void setTaxaHonorario(BigDecimal taxaHonorario) {
		this.taxaHonorario = taxaHonorario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((taxaHonorario == null) ? 0 : taxaHonorario.hashCode());
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
		Auxiliar other = (Auxiliar) obj;
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
		if (taxaHonorario == null) {
			if (other.taxaHonorario != null)
				return false;
		} else if (!taxaHonorario.equals(other.taxaHonorario))
			return false;
		return true;
	}

}
