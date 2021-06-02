package br.jus.tream.saude.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.jus.tream.saude.enumeration.ClassificacaoTipoDependente;

@Entity
@Table(name = "TIPO_DEPENDENTE")
public class TipoDependente {

	@Id
	@Column(name = "COD_TIPO_DEPEND")
	private Long id;
	@Column(name = "NOM_TIPO_DEPEND", nullable = true, length = 255)
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(name = "CLASSIFICACAO")
	private ClassificacaoTipoDependente classificacao;
	@Column(name="PERCENTUAL")
	private Double percentual;
	@Column(name="VAL_MENS_FAIXA0")
	private BigDecimal valorFaixa0;
	@Column(name="VAL_MENS_FAIXA1")
	private BigDecimal valorFaixa1;
	@Column(name="VAL_MENS_FAIXA2")
	private BigDecimal valorFaixa2;
	@Column(name="VAL_MENS_FAIXA3")
	private BigDecimal valorFaixa3;
	@Column(name="VAL_MENS_FAIXA4")
	private BigDecimal valorFaixa4;
	@Column(name="VAL_MENS_FAIXA5")
	private BigDecimal valorFaixa5;
	@Column(name="VAL_MENS_FAIXA6")
	private BigDecimal valorFaixa6;
	@Column(name="VAL_MENS_FAIXA7")
	private BigDecimal valorFaixa7;
	@Column(name="VAL_MENS_FAIXA8")
	private BigDecimal valorFaixa8;
	@Column(name="VAL_MENS_FAIXA9")
	private BigDecimal valorFaixa9;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ClassificacaoTipoDependente getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoTipoDependente classificacao) {
		this.classificacao = classificacao;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public BigDecimal getValorFaixa0() {
		return valorFaixa0;
	}

	public void setValorFaixa0(BigDecimal valorFaixa0) {
		this.valorFaixa0 = valorFaixa0;
	}

	public BigDecimal getValorFaixa1() {
		return valorFaixa1;
	}

	public void setValorFaixa1(BigDecimal valorFaixa1) {
		this.valorFaixa1 = valorFaixa1;
	}

	public BigDecimal getValorFaixa2() {
		return valorFaixa2;
	}

	public void setValorFaixa2(BigDecimal valorFaixa2) {
		this.valorFaixa2 = valorFaixa2;
	}

	public BigDecimal getValorFaixa3() {
		return valorFaixa3;
	}

	public void setValorFaixa3(BigDecimal valorFaixa3) {
		this.valorFaixa3 = valorFaixa3;
	}

	public BigDecimal getValorFaixa4() {
		return valorFaixa4;
	}

	public void setValorFaixa4(BigDecimal valorFaixa4) {
		this.valorFaixa4 = valorFaixa4;
	}

	public BigDecimal getValorFaixa5() {
		return valorFaixa5;
	}

	public void setValorFaixa5(BigDecimal valorFaixa5) {
		this.valorFaixa5 = valorFaixa5;
	}

	public BigDecimal getValorFaixa6() {
		return valorFaixa6;
	}

	public void setValorFaixa6(BigDecimal valorFaixa6) {
		this.valorFaixa6 = valorFaixa6;
	}

	public BigDecimal getValorFaixa7() {
		return valorFaixa7;
	}

	public void setValorFaixa7(BigDecimal valorFaixa7) {
		this.valorFaixa7 = valorFaixa7;
	}

	public BigDecimal getValorFaixa8() {
		return valorFaixa8;
	}

	public void setValorFaixa8(BigDecimal valorFaixa8) {
		this.valorFaixa8 = valorFaixa8;
	}

	public BigDecimal getValorFaixa9() {
		return valorFaixa9;
	}

	public void setValorFaixa9(BigDecimal valorFaixa9) {
		this.valorFaixa9 = valorFaixa9;
	}

}
