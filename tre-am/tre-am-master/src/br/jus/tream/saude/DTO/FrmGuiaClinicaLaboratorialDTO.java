package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FrmGuiaClinicaLaboratorialDTO implements Serializable {
	private static final long serialVersionUID = 7535910308999808860L;
	private String procedimentos;
	private String matriculaServidor;
	private Long codigoDependente;
	private Boolean urgencia;
	private Boolean apartamento;
	private Boolean internacao;
	private String valor;
	private String observacao;
	
	public String getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(String procedimentos) {
		this.procedimentos = procedimentos;
	}
	public String getMatriculaServidor() {
		return matriculaServidor;
	}
	public void setMatriculaServidor(String matriculaServidor) {
		this.matriculaServidor = matriculaServidor;
	}
	public Long getCodigoDependente() {
		return codigoDependente;
	}
	public void setCodigoDependente(Long codigoDependente) {
		this.codigoDependente = codigoDependente;
	}
	public Boolean getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(Boolean urgencia) {
		this.urgencia = urgencia;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Boolean getApartamento() {
		return apartamento;
	}
	public void setApartamento(Boolean apartamento) {
		this.apartamento = apartamento;
	}
	public Boolean getInternacao() {
		return internacao;
	}
	public void setInternacao(Boolean internacao) {
		this.internacao = internacao;
	}
	public String getValorLimpo() {
		return this.valor.replace(".", "").replace(",", ".");
	}
	
	public boolean isGravarDespesa() {		
		if (this.getValor() != null && this.getValor().length() > 0) {
			return true;
		}
		if (this.getObservacao() != null && this.getObservacao().length() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartamento == null) ? 0 : apartamento.hashCode());
		result = prime * result + ((codigoDependente == null) ? 0 : codigoDependente.hashCode());
		result = prime * result + ((internacao == null) ? 0 : internacao.hashCode());
		result = prime * result + ((matriculaServidor == null) ? 0 : matriculaServidor.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((procedimentos == null) ? 0 : procedimentos.hashCode());
		result = prime * result + ((urgencia == null) ? 0 : urgencia.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		FrmGuiaClinicaLaboratorialDTO other = (FrmGuiaClinicaLaboratorialDTO) obj;
		if (apartamento == null) {
			if (other.apartamento != null)
				return false;
		} else if (!apartamento.equals(other.apartamento))
			return false;
		if (codigoDependente == null) {
			if (other.codigoDependente != null)
				return false;
		} else if (!codigoDependente.equals(other.codigoDependente))
			return false;
		if (internacao == null) {
			if (other.internacao != null)
				return false;
		} else if (!internacao.equals(other.internacao))
			return false;
		if (matriculaServidor == null) {
			if (other.matriculaServidor != null)
				return false;
		} else if (!matriculaServidor.equals(other.matriculaServidor))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (procedimentos == null) {
			if (other.procedimentos != null)
				return false;
		} else if (!procedimentos.equals(other.procedimentos))
			return false;
		if (urgencia == null) {
			if (other.urgencia != null)
				return false;
		} else if (!urgencia.equals(other.urgencia))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}	
	
}
