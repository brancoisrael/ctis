package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_AGE")
public class TabelaIdade implements Serializable {

	private static final long serialVersionUID = -7113792724293791070L;
	@EmbeddedId
	private TabelaIdadePK tabelaIdadePK;
	@Column(name = "DS", nullable = false, length = 50)
	private String descricao;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "DV", nullable = true, length = 1)
	private String digitoVerificador;

	public TabelaIdadePK getTabelaIdadePK() {
		return tabelaIdadePK;
	}

	public void setTabelaIdadePK(TabelaIdadePK tabelaIdadePK) {
		this.tabelaIdadePK = tabelaIdadePK;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((digitoVerificador == null) ? 0 : digitoVerificador.hashCode());
		result = prime * result + ((tabelaIdadePK == null) ? 0 : tabelaIdadePK.hashCode());
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
		TabelaIdade other = (TabelaIdade) obj;
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
		if (digitoVerificador == null) {
			if (other.digitoVerificador != null)
				return false;
		} else if (!digitoVerificador.equals(other.digitoVerificador))
			return false;
		if (tabelaIdadePK == null) {
			if (other.tabelaIdadePK != null)
				return false;
		} else if (!tabelaIdadePK.equals(other.tabelaIdadePK))
			return false;
		return true;
	}

}
