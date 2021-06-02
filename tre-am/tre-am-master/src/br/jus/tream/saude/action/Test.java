package br.jus.tream.saude.action;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private Long codigoProcedimento;
	private Integer quantidade;
	private List<Test> procedimentos = new ArrayList<Test>();

	public Long getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(Long codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Test> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Test> procedimentos) {
		this.procedimentos = procedimentos;
	}

}
