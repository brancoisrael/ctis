package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_AUTORIZADO")
public class UsuarioAutorizado implements Serializable {

	private static final long serialVersionUID = 293456284672772784L;
	@Id
	@Column(name = "COD_USUARIO")
	private String id;
	@Column(name = "NOM_USUARIO", nullable = false, length = 70)
	private String nome;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CREDENCIADO")
	protected Credenciado credenciado;
	@Column(name = "SENHA_MD5", nullable = false, length = 32)
	private String senha;
	@Column(name = "COD_USUARIO_LOGIN", nullable = true, length = 20)
	private String idUsuarioLogin;
	@Column(name = "SENHA_MD5_LOGIN", nullable = true, length = 32)
	private String senhaLogin;
	@Column(name = "BLOQUEADO", nullable = false)
	private Boolean bloqueado;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "PERFIL", nullable = false, length = 4)
	private String perfil;

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

	public String getIdUsuarioLogin() {
		return idUsuarioLogin;
	}

	public void setIdUsuarioLogin(String idUsuarioLogin) {
		this.idUsuarioLogin = idUsuarioLogin;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloqueado == null) ? 0 : bloqueado.hashCode());
		result = prime * result + ((credenciado == null) ? 0 : credenciado.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idUsuarioLogin == null) ? 0 : idUsuarioLogin.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaLogin == null) ? 0 : senhaLogin.hashCode());
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
		UsuarioAutorizado other = (UsuarioAutorizado) obj;
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
		if (idUsuarioLogin == null) {
			if (other.idUsuarioLogin != null)
				return false;
		} else if (!idUsuarioLogin.equals(other.idUsuarioLogin))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaLogin == null) {
			if (other.senhaLogin != null)
				return false;
		} else if (!senhaLogin.equals(other.senhaLogin))
			return false;
		return true;
	}

}
