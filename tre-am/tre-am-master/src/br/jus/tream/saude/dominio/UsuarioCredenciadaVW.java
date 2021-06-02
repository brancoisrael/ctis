package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTENTICACAO_CREDENCIADA")
public class UsuarioCredenciadaVW implements Serializable {

	private static final long serialVersionUID = -1930315373036728216L;

	@Id
	@OneToOne
	@JoinColumn(name = "COD_CREDENCIADO")
	private Credenciado credenciado;
	@Column(name = "SENHA", nullable = false, length = 32)
	private String senha;
	@Column(name = "USUARIO", nullable = false, length = 70)
	private String usuario;
	@Column(name = "NOM_INSTITUICAO", nullable = false, length = 60)
	private String nomeInstituicao;
	@Column(name = "BLOQUEADO", nullable = true, length = 1)
	private String bloqueado;

	public Credenciado getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(Credenciado credenciado) {
		this.credenciado = credenciado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloqueado == null) ? 0 : bloqueado.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
		result = prime * result + ((nomeInstituicao == null) ? 0 : nomeInstituicao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioCredenciadaVW other = (UsuarioCredenciadaVW) obj;
		if (bloqueado == null) {
			if (other.bloqueado != null)
				return false;
		} else if (!bloqueado.equals(other.bloqueado))
			return false;
		if (credenciado == null) {
			if (other.credenciado != null)
				return false;
		} else if (!credenciado.equals(other.credenciado))
			return false;
		if (nomeInstituicao == null) {
			if (other.nomeInstituicao != null)
				return false;
		} else if (!nomeInstituicao.equals(other.nomeInstituicao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
