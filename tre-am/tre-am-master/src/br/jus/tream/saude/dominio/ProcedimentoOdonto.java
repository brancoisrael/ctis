package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "PROCEDIMENTO_ODO")
public class ProcedimentoOdonto extends ProcedimentoBase implements Serializable {

	private static final long serialVersionUID = 9040772490459458179L;
//	@EmbeddedId
//	private ProcedimentoPK procedimentoPK;
//	@Column(name = "NOM_PROCEDIMENTO", nullable = false, length = 260)
//	private String nome;
//	@Column(name = "VALOR_PROCEDIMENTO", nullable = false)
//	private BigDecimal valor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_GRUPO", nullable = false)
	private GrupoProcedimentoOdonto grupo;
//	@Column(name = "DAT_ULT_ATUAL", nullable = false)
//	private LocalDateTime dataAtualizacao;
//	@Column(name = "PROCEDIMENTO_ATIVO", nullable = true)
//	private Boolean procedimentoAtivo;
//	@Column(name = "PRAZO_CARENCIA_MIN", nullable = true)
//	private Integer prazoCarencia;

	@Override
	public ProcedimentoPK getProcedimentoPK() {
		return procedimentoPK;
	}

	@Override
	public void setProcedimentoPK(ProcedimentoPK procedimentoPK) {
		this.procedimentoPK = procedimentoPK;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public GrupoProcedimentoOdonto getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoProcedimentoOdonto grupo) {
		this.grupo = grupo;
	}

	@Override
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	@Override
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public Integer getProcedimentoAtivo() {
		return procedimentoAtivo;
	}

	@Override
	public void setProcedimentoAtivo(Integer procedimentoAtivo) {
		this.procedimentoAtivo = procedimentoAtivo;
	}

	@Override
	public Integer getPrazoCarencia() {
		return prazoCarencia;
	}

	@Override
	public void setPrazoCarencia(Integer prazoCarencia) {
		this.prazoCarencia = prazoCarencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prazoCarencia == null) ? 0 : prazoCarencia.hashCode());
		result = prime * result + ((procedimentoAtivo == null) ? 0 : procedimentoAtivo.hashCode());
		result = prime * result + ((procedimentoPK == null) ? 0 : procedimentoPK.hashCode());
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
		ProcedimentoOdonto other = (ProcedimentoOdonto) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prazoCarencia == null) {
			if (other.prazoCarencia != null)
				return false;
		} else if (!prazoCarencia.equals(other.prazoCarencia))
			return false;
		if (procedimentoAtivo == null) {
			if (other.procedimentoAtivo != null)
				return false;
		} else if (!procedimentoAtivo.equals(other.procedimentoAtivo))
			return false;
		if (procedimentoPK == null) {
			if (other.procedimentoPK != null)
				return false;
		} else if (!procedimentoPK.equals(other.procedimentoPK))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
