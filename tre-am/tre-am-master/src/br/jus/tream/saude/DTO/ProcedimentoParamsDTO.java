package br.jus.tream.saude.DTO;

import java.io.Serializable;

public class ProcedimentoParamsDTO implements Serializable {

	private static final long serialVersionUID = 6821648074722493618L;
	private String id;
	private String nome;
	private Long idTabela;

	public ProcedimentoParamsDTO() {
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

	public Long getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(Long idTabela) {
		this.idTabela = idTabela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idTabela == null) ? 0 : idTabela.hashCode());
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
		ProcedimentoParamsDTO other = (ProcedimentoParamsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idTabela == null) {
			if (other.idTabela != null)
				return false;
		} else if (!idTabela.equals(other.idTabela))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
