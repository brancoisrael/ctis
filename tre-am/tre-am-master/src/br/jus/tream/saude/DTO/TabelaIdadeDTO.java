package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.TabelaIdade;

/**
 * Representa os dados de uma {@link TabelaIdade}.
 * 
 * @author vinicius
 *
 */
public class TabelaIdadeDTO implements Serializable {

	private static final long serialVersionUID = -3901209381069249297L;
	private String idTabela;
	private BancoDTO banco;
	private String descricao;
	private LocalDateTime dataAtualizacao;
	private String digitoVerificador;

	public TabelaIdadeDTO() {
	}

	/**
	 * Responsável por converter uma {@link TabelaIdade} para seu respectivo Dto.
	 * 
	 * @param tabela que será convertida.
	 */
	public TabelaIdadeDTO(TabelaIdade tabela) {
		this.idTabela = tabela.getTabelaIdadePK().getIdTabela();
		this.banco = new BancoDTO(tabela.getTabelaIdadePK().getBanco());
		this.descricao = tabela.getDescricao();
		this.dataAtualizacao = tabela.getDataAtualizacao();
		this.digitoVerificador = tabela.getDigitoVerificador();
	}

	public String getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(String idTabela) {
		this.idTabela = idTabela;
	}

	public BancoDTO getBanco() {
		return banco;
	}

	public void setBanco(BancoDTO banco) {
		this.banco = banco;
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
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((digitoVerificador == null) ? 0 : digitoVerificador.hashCode());
		result = prime * result + ((idTabela == null) ? 0 : idTabela.hashCode());
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
		TabelaIdadeDTO other = (TabelaIdadeDTO) obj;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
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
		if (idTabela == null) {
			if (other.idTabela != null)
				return false;
		} else if (!idTabela.equals(other.idTabela))
			return false;
		return true;
	}

}
