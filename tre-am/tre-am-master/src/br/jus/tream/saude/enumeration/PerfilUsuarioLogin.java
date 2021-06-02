package br.jus.tream.saude.enumeration;

public enum PerfilUsuarioLogin {

	CREDENCIADO("Credenciado"), SERVIDOR("Servidor"), ADM("Administrador");

	private String descricao;
	private String nome;

	private PerfilUsuarioLogin(String desc) {
		this.descricao = desc;
		this.nome = name();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static PerfilUsuarioLogin getSituacaoByDescricao(String descricao) {
		for (PerfilUsuarioLogin perfil : PerfilUsuarioLogin.values()) {
			if (perfil.getDescricao().equalsIgnoreCase(descricao)) {
				return perfil;
			}
		}
		return null;
	}	
	
}
