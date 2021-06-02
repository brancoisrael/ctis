package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.UsuarioAutorizado;

/**
 * Representa os dados de um {@link UsuarioAutorizado}.
 * 
 * @author vinicius
 *
 */
public class UsuarioAutorizadoDTO implements Serializable {

	private static final long serialVersionUID = -131358627890348152L;
	private String id;
	private String nome;
	protected CredenciadoDTO credenciado;
	private Boolean bloqueado;
	private LocalDateTime dataAtualizacao;
	private String perfil;

	public UsuarioAutorizadoDTO() {
	}

	/**
	 * Responsável por converter um {@link UsuarioAutorizado} para seu respectivo Dto.
	 * 
	 * @param usuario que será convertido.
	 */
	public UsuarioAutorizadoDTO(UsuarioAutorizado usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.credenciado = usuario.getCredenciado() != null ? new CredenciadoDTO(usuario.getCredenciado()) : null;
		this.bloqueado = usuario.getBloqueado();
		this.dataAtualizacao = usuario.getDataAtualizacao();
		this.perfil = usuario.getPerfil();
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

	public CredenciadoDTO getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(CredenciadoDTO credenciado) {
		this.credenciado = credenciado;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		UsuarioAutorizadoDTO other = (UsuarioAutorizadoDTO) obj;
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
		return true;
	}
	
	
}
