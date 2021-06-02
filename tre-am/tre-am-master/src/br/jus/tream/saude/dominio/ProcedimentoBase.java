package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author vinicius
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ProcedimentoBase implements Serializable {

	private static final long serialVersionUID = 9040772490459458179L;
	@EmbeddedId
	protected ProcedimentoPK procedimentoPK;
	@Column(name = "NOM_PROCEDIMENTO", nullable = false, length = 260)
	protected String nome;
	@Column(name = "VALOR_PROCEDIMENTO", nullable = false)
	protected BigDecimal valor;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	protected LocalDateTime dataAtualizacao;
	@Column(name = "PROCEDIMENTO_ATIVO", nullable = true)
	protected Integer procedimentoAtivo;
	@Column(name = "PRAZO_CARENCIA_MIN", nullable = true)
	protected Integer prazoCarencia;

	public abstract ProcedimentoPK getProcedimentoPK();

	public abstract void setProcedimentoPK(ProcedimentoPK procedimentoPK);

	public abstract String getNome();

	public abstract void setNome(String nome);

	public abstract BigDecimal getValor();

	public abstract void setValor(BigDecimal valor);

	public abstract LocalDateTime getDataAtualizacao();

	public abstract void setDataAtualizacao(LocalDateTime dataAtualizacao);

	public abstract Integer getProcedimentoAtivo();

	public abstract void setProcedimentoAtivo(Integer procedimentoAtivo);

	public abstract Integer getPrazoCarencia();

	public abstract void setPrazoCarencia(Integer prazoCarencia);

}
