package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * 
 * @author vinicius
 *
 */
@Embeddable
public class ValorProcedimentoPK implements Serializable {

	private static final long serialVersionUID = 7129888439798710528L;

	@MapsId("procedimentoPK")
	@JoinColumns({ @JoinColumn(name = "COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO"),
			@JoinColumn(name = "COD_TABELA", referencedColumnName = "COD_TABELA") })
	@ManyToOne
	private Procedimento procedimento;
	@Column(name = "DAT_ALTERACAO", nullable = false)
	private LocalDateTime dataAlteracao;

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
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
		ValorProcedimentoPK other = (ValorProcedimentoPK) obj;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
			return false;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		return true;
	}

}
