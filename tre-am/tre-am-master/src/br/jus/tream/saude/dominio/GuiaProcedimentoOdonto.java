package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "GUIA_PROCEDIMENTO_ODO")
public class GuiaProcedimentoOdonto implements Serializable {
	 
	private static final long serialVersionUID = -221182400564008714L;
	@Id
	@SequenceGenerator(name = "GUIA_PROCEDIMENTO_ODO_SEQ_GENERATION", sequenceName = "SEQ_GUIA_PROCEDIMENTO_ODO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GUIA_PROCEDIMENTO_ODO_SEQ_GENERATION")
	@Column(name = "ID_GUIA_PROCEDIMENTO")
	private Long id;
	@MapsId("procedimentoPK")
	@JoinColumns({
			@JoinColumn(name = "COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TABELA", referencedColumnName = "COD_TABELA", insertable = false, updatable = false) })
	@ManyToOne(cascade = CascadeType.DETACH)
	@Fetch(FetchMode.SELECT)
	protected ProcedimentoOdonto procedimento;
	@MapsId("guiaPK")
	@JoinColumns({
			@JoinColumn(name = "NUM_GUIA", referencedColumnName = "NUM_GUIA", insertable = false, updatable = false),
			@JoinColumn(name = "ANO_EXERCICIO", referencedColumnName = "ANO_EXERCICIO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TIP_GUIA", referencedColumnName = "COD_TIP_GUIA", insertable = false, updatable = false) })
	@ManyToOne(cascade = CascadeType.DETACH)
	@Fetch(FetchMode.SELECT)
	protected Guia guia;

	@Column(name = "NUM_GUIA", nullable = false)
	private Long numeroGuia;
	@Column(name = "ANO_EXERCICIO", nullable = false, length = 4)
	private String anoExercicio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_TIP_GUIA")
	private TipoGuia tipoGuia;

	@Column(name = "COD_PROCEDIMENTO", nullable = false, length = 15)
	private String codigoProcedimento;
	@Column(name = "COD_TABELA")
	private Long codTabela;

	@Column(name = "QTDE", nullable = false, length = 3)
	private Integer quantidade;
	@Column(name = "VALOR_PROCEDIMENTO", nullable = false)
	private BigDecimal valorProcedimento;
	@Column(name = "VALOR_TOTAL", nullable = false)
	private BigDecimal valorTotal;

	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;

	public GuiaProcedimentoOdonto() {
	}

	public GuiaProcedimentoOdonto(Guia guia, ProcedimentoOdonto procedimento) {
		this.guia = guia;
		this.procedimento = procedimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProcedimentoOdonto getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoOdonto procedimento) {
		this.procedimento = procedimento;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Long getNumeroGuia() {
		return numeroGuia;
	}

	public void setNumeroGuia(Long numeroGuia) {
		this.numeroGuia = numeroGuia;
	}

	public String getAnoExercicio() {
		return anoExercicio;
	}

	public void setAnoExercicio(String anoExercicio) {
		this.anoExercicio = anoExercicio;
	}

	public TipoGuia getTipoGuia() {
		return tipoGuia;
	}

	public void setTipoGuia(TipoGuia tipoGuia) {
		this.tipoGuia = tipoGuia;
	}

	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public Long getCodTabela() {
		return codTabela;
	}

	public void setCodTabela(Long codTabela) {
		this.codTabela = codTabela;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorProcedimento() {
		return valorProcedimento;
	}

	public void setValorProcedimento(BigDecimal valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((codTabela == null) ? 0 : codTabela.hashCode());
		result = prime * result + ((codigoProcedimento == null) ? 0 : codigoProcedimento.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroGuia == null) ? 0 : numeroGuia.hashCode());
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((tipoGuia == null) ? 0 : tipoGuia.hashCode());
		result = prime * result + ((valorProcedimento == null) ? 0 : valorProcedimento.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		GuiaProcedimentoOdonto other = (GuiaProcedimentoOdonto) obj;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (codTabela == null) {
			if (other.codTabela != null)
				return false;
		} else if (!codTabela.equals(other.codTabela))
			return false;
		if (codigoProcedimento == null) {
			if (other.codigoProcedimento != null)
				return false;
		} else if (!codigoProcedimento.equals(other.codigoProcedimento))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (guia == null) {
			if (other.guia != null)
				return false;
		} else if (!guia.equals(other.guia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroGuia == null) {
			if (other.numeroGuia != null)
				return false;
		} else if (!numeroGuia.equals(other.numeroGuia))
			return false;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (tipoGuia == null) {
			if (other.tipoGuia != null)
				return false;
		} else if (!tipoGuia.equals(other.tipoGuia))
			return false;
		if (valorProcedimento == null) {
			if (other.valorProcedimento != null)
				return false;
		} else if (!valorProcedimento.equals(other.valorProcedimento))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}
