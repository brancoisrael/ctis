package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.jus.tream.saude.enumeration.TipoEspecialidade;

@Entity
@Table(name = "ESPECIALIDADE")
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 3495605033932599938L;
	@Id
	@Column(name = "COD_ESPECIALIDADE")
	private Long id;
	@Column(name = "NOM_ESPECIALIDADE", nullable = true, length = 250)
	private String nome;
	@Enumerated(EnumType.STRING)
	@Column(name = "TIP_ESPECIALIDADE")
	private TipoEspecialidade tipo;
	@Column(name = "COD_GRUPO", nullable = true)
	private Long codigoGrupo;

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

	public TipoEspecialidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspecialidade tipo) {
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
		Especialidade other = (Especialidade) obj;
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
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
