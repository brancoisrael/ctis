package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENCIADO_AUTORIZADO")
public class CredenciadoAutorizado implements Serializable {

	private static final long serialVersionUID = -4584237665191586558L;

	@Id
	@OneToOne
	@JoinColumn(name = "COD_CREDENCIADO")
	private Credenciado id;
	@Column(name = "SENHA_MD5", nullable = false, length = 32)
	private String senha;
	@Column(name = "COD_CREDENCIADO_LOGIN", nullable = true)
	private Long loginCredenciado;
	@Column(name = "SENHA_MD5_LOGIN", nullable = true, length = 32)
	private String senhaLogin;
	@Column(name = "BLOQUEADO", nullable = false)
	private Boolean bloqueado;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "PERFIL", nullable = false, length = 3)
	private String perfil;

	public Credenciado getId() {
		return id;
	}

	public void setId(Credenciado id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getLoginCredenciado() {
		return loginCredenciado;
	}

	public void setLoginCredenciado(Long loginCredenciado) {
		this.loginCredenciado = loginCredenciado;
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
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginCredenciado == null) ? 0 : loginCredenciado.hashCode());
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
		CredenciadoAutorizado other = (CredenciadoAutorizado) obj;
		if (bloqueado == null) {
			if (other.bloqueado != null)
				return false;
		} else if (!bloqueado.equals(other.bloqueado))
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
		if (loginCredenciado == null) {
			if (other.loginCredenciado != null)
				return false;
		} else if (!loginCredenciado.equals(other.loginCredenciado))
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
