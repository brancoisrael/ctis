package br.jus.tream.saude.DTO;

import java.io.Serializable;

import br.jus.tream.saude.dominio.Beneficiario;

public class InfoGuiaDTO implements Serializable {

	private static final long serialVersionUID = 1772325320741795428L;
	
	private GuiaDTO guia;
	private String titular = "";
	private String dependente = "";
	private String funcao;
	
	private CustoGuiaDTO custoGuiaDTO;
	
	public InfoGuiaDTO() {
		
	}
	
	public InfoGuiaDTO(GuiaDTO guia,Beneficiario beneficiarioTitular, Beneficiario beneficiarioDependente, CustoGuiaDTO custoGuiaDTO) {
		this.guia = guia;
		if (beneficiarioTitular != null) {
			this.titular = beneficiarioTitular.getNome();
		}
		if (beneficiarioDependente != null) {
			this.dependente = beneficiarioDependente.getNome();
		}
		this.funcao = guia.getFuncao();
		this.custoGuiaDTO = custoGuiaDTO;
	}

	public GuiaDTO getGuia() {
		return guia;
	}

	public void setGuia(GuiaDTO guia) {
		this.guia = guia;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDependente() {
		return dependente;
	}

	public void setDependente(String dependente) {
		this.dependente = dependente;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public CustoGuiaDTO getCustoGuiaDTO() {
		return custoGuiaDTO;
	}

	public void setCustoGuiaDTO(CustoGuiaDTO custoGuiaDTO) {
		this.custoGuiaDTO = custoGuiaDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custoGuiaDTO == null) ? 0 : custoGuiaDTO.hashCode());
		result = prime * result + ((dependente == null) ? 0 : dependente.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
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
		InfoGuiaDTO other = (InfoGuiaDTO) obj;
		if (custoGuiaDTO == null) {
			if (other.custoGuiaDTO != null)
				return false;
		} else if (!custoGuiaDTO.equals(other.custoGuiaDTO))
			return false;
		if (dependente == null) {
			if (other.dependente != null)
				return false;
		} else if (!dependente.equals(other.dependente))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (guia == null) {
			if (other.guia != null)
				return false;
		} else if (!guia.equals(other.guia))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}	
	
}
