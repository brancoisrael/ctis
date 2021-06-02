package br.jus.tream.saude.enumeration;

public enum RelatoriosFinanceiro {
	QT_BENEFICIARIO("Quantidade de Beneficiários"), 
	GRAFICO_QT_BENEFICIARIO_ANUAL("Gráfico Quantidade de Beneficiários - Anual"),
	GRAFICO_QT_BENEFICIARIO_POR_TIPO("Gráfico Quantidade de Beneficiários - Por Tipo"),
	MENSALIDADE("Mensalidades"), 
	GRAFICO_MENSALIDADE("Gráfico Mensalidades"), 
	COOPARTICIPACAO("Cooparticipação"), 
	GRAFICO_COOPARTICIPACAO("Gráfico Cooparticipação"), 
	DESPESAS("Despesas"), 
	GRAFICO_DESPESAS("Gráfico Despesas");

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
