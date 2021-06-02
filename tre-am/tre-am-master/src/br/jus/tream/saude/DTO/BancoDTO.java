package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Banco;

/**
 * Representa os dados de um {@link Banco}.
 * 
 * @author vinicius
 *
 */
public class BancoDTO implements Serializable {

	private static final long serialVersionUID = 8151330324789695959L;
	private String id;
	private String nome;
	private String convenio;
	private String layout;
	private LocalDateTime dataAtualizacao;

	public BancoDTO() {
	}

	/**
	 * Responsável por converter um {@link Banco} para seu respectivo Dto.
	 * 
	 * @param banco que será convertido.
	 */
	public BancoDTO(Banco banco) {
		this.id = banco.getId();
		this.nome = banco.getNome();
		this.convenio = banco.getConvenio();
		this.layout = banco.getLayout();
		this.dataAtualizacao = banco.getDataAtualizacao();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
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
		result = prime * result + ((convenio == null) ? 0 : convenio.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((layout == null) ? 0 : layout.hashCode());
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
		BancoDTO other = (BancoDTO) obj;
		if (convenio == null) {
			if (other.convenio != null)
				return false;
		} else if (!convenio.equals(other.convenio))
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
		if (layout == null) {
			if (other.layout != null)
				return false;
		} else if (!layout.equals(other.layout))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
