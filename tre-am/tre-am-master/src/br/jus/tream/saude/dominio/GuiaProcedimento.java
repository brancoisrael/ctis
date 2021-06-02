package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

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

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "GUIA_PROCEDIMENTO")
public class GuiaProcedimento implements Serializable {

	private static final long serialVersionUID = 8860973568074644287L;
	@Id
	@SequenceGenerator(name = "GUIA_PROCEDIMENTO_SEQ_GENERATION", sequenceName = "SEQ_GUIA_PROCEDIMENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GUIA_PROCEDIMENTO_SEQ_GENERATION")
	@Column(name = "ID_GUIA_PROCEDIMENTO")
	private Long id;
	@MapsId("procedimentoPK")
	@JoinColumns({
			@JoinColumn(name = "COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TABELA", referencedColumnName = "COD_TABELA", insertable = false, updatable = false) })
	@ManyToOne(cascade = CascadeType.DETACH)
	@Fetch(FetchMode.SELECT)
	protected Procedimento procedimento;
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
	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;
	@Column(name = "VIA_ACESSO", nullable = false)
	private Integer viaAcesso;
	@Column(name = "VIDEO", nullable = false)
	private Integer video;
	@Column(name = "VALORCALC", nullable = false)
	private BigDecimal valorCalculado;

	public GuiaProcedimento() {
	}

	public GuiaProcedimento(Guia guia, Procedimento procedimento) {
		this.guia = guia;
		this.procedimento = procedimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getViaAcesso() {
		return viaAcesso;
	}

	public void setViaAcesso(Integer viaAcesso) {
		this.viaAcesso = viaAcesso;
	}

	public Integer getVideo() {
		return video;
	}

	public void setVideo(Integer video) {
		this.video = video;
	}

	public BigDecimal getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(BigDecimal valorCalculado) {
		this.valorCalculado = valorCalculado;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorCalculado == null) ? 0 : valorCalculado.hashCode());
		result = prime * result + ((viaAcesso == null) ? 0 : viaAcesso.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		GuiaProcedimento other = (GuiaProcedimento) obj;
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
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorCalculado == null) {
			if (other.valorCalculado != null)
				return false;
		} else if (!valorCalculado.equals(other.valorCalculado))
			return false;
		if (viaAcesso == null) {
			if (other.viaAcesso != null)
				return false;
		} else if (!viaAcesso.equals(other.viaAcesso))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

}
