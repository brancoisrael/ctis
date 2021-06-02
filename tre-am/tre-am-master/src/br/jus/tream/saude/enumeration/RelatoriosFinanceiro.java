package br.jus.tream.saude.enumeration;

public enum RelatoriosFinanceiro {
	QT_BENEFICIARIO("Quantidade de Benefici�rios"), 
	GRAFICO_QT_BENEFICIARIO_ANUAL("Gr�fico Quantidade de Benefici�rios - Anual"),
	GRAFICO_QT_BENEFICIARIO_POR_TIPO("Gr�fico Quantidade de Benefici�rios - Por Tipo"),
	MENSALIDADE("Mensalidades"), 
	GRAFICO_MENSALIDADE("Gr�fico Mensalidades"), 
	COOPARTICIPACAO("Cooparticipa��o"), 
	GRAFICO_COOPARTICIPACAO("Gr�fico Cooparticipa��o"), 
	DESPESAS("Despesas"), 
	GRAFICO_DESPESAS("Gr�fico Despesas");

	private String descricao;
	private String nome;

	private RelatoriosFinanceiro(String desc) {
		this.descricao = desc;
		this.nome = this.name();
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
	
}
