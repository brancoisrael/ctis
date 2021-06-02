package br.jus.tream.saude.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "DESPESA")
public class Despesa {

	@Id
	@SequenceGenerator(name = "DESPESA_SEQ_GENERATION", sequenceName = "SEQ_DESPESA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESPESA_SEQ_GENERATION")
	@Column(name = "COD_DESPESA")
	private Long id;
	@MapsId("guiaPK")
	@JoinColumns({
			@JoinColumn(name = "NUM_GUIA", referencedColumnName = "NUM_GUIA", insertable = false, updatable = false),
			@JoinColumn(name = "ANO_EXERCICIO", referencedColumnName = "ANO_EXERCICIO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TIP_GUIA", referencedColumnName = "COD_TIP_GUIA", insertable = false, updatable = false) })
	@OneToOne(optional = false, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Guia guia;

	@Column(name = "NUM_GUIA", nullable = false)
	private Long numeroGuia;
	@Column(name = "ANO_EXERCICIO", nullable = false, length = 4)
	private String anoExercicio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_TIP_GUIA", nullable = false)
	private TipoGuia tipoGuia;

	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDate dataCadastro;
	@Column(name = "OBSERVACAO", nullable = true, length = 255)
	private String observacao;
	@Column(name = "VALOR", nullable = false, length = 255)
	private BigDecimal valor;
	@OneToOne(optional = true, fetch = FetchType.LAZY, mappedBy = "despesa", cascade = CascadeType.ALL)
	private AnexoDespesa anexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public AnexoDespesa getAnexo() {
		return anexo;
	}

	public void setAnexo(AnexoDespesa anexo) {
		this.anexo = anexo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anexo == null) ? 0 : anexo.hashCode());
		result = prime * result + ((anoExercicio == null) ? 0 : anoExercicio.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroGuia == null) ? 0 : numeroGuia.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((tipoGuia == null) ? 0 : tipoGuia.hashCode());
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
		Despesa other = (Despesa) obj;
		if (anexo == null) {
			if (other.anexo != null)
				return false;
		} else if (!anexo.equals(other.anexo))
			return false;
		if (anoExercicio == null) {
			if (other.anoExercicio != null)
				return false;
		} else if (!anoExercicio.equals(other.anoExercicio))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
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
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (tipoGuia == null) {
			if (other.tipoGuia != null)
				return false;
		} else if (!tipoGuia.equals(other.tipoGuia))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
