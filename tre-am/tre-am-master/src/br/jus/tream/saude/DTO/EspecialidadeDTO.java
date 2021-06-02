package br.jus.tream.saude.DTO;

import java.io.Serializable;

import br.jus.tream.saude.dominio.Especialidade;

/**
 * Representa os dados de uma {@link Especialidade}.
 * 
 * @author vinicius
 *
 */
public class EspecialidadeDTO implements Serializable {

	private static final long serialVersionUID = 6031614256060608155L;

	private Long id;
	private String nome;
	private String tipo;
	private Long codigoGrupo;
	
	public EspecialidadeDTO() {}
	
	/**
	 * Responsável por converter uma {@link Especialidade} para seu respectivo Dto.
	 * 
	 * @param especialidade que será convertida.
	 */
	public EspecialidadeDTO(Especialidade especialidade) {
		this.id = especialidade.getId();
		this.nome = especialidade.getNome();
		this.tipo = especialidade.getTipo().name();
		this.codigoGrupo = especialidade.getCodigoGrupo();
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoGrupo == null) ? 0 : codigoGrupo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		EspecialidadeDTO other = (EspecialidadeDTO) obj;
		if (codigoGrupo == null) {
			if (other.codigoGrupo != null)
				return false;
		} else if (!codigoGrupo.equals(other.codigoGrupo))
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
}
