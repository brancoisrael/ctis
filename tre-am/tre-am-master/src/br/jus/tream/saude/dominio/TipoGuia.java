package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.jus.tream.saude.enumeration.ClassificacaoTipoGuia;

@Entity
@Table(name = "TIPO_GUIA")
public class TipoGuia implements Serializable {

	private static final long serialVersionUID = -6170471997820700743L;

	@Id
	@Column(name = "COD_TIP_GUIA")
	private Long id;
	@Column(name = "DES_TIP_GUIA", nullable = true, length = 40)
	private String descricao;
	@Column(name = "CUSTEIO", nullable = true)
	private BigDecimal custeio;
	@Column(name = "DAT_INICIO", nullable = true)
	private LocalDate dataInicio;
	@Column(name = "DAT_FIM", nullable = true)
	private LocalDate dataFim;
	@Enumerated(EnumType.STRING)
	@Column(name = "CLASSIFICACAO")
	private ClassificacaoTipoGuia classificacao;
	
	public TipoGuia() {
	}
	
	public TipoGuia(Long id) {
		this.id = id;
	}

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

	public BigDecimal getCusteio() {
		return custeio;
	}

	public void setCusteio(BigDecimal custeio) {
		this.custeio = custeio;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public ClassificacaoTipoGuia getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoTipoGuia classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((custeio == null) ? 0 : custeio.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TipoGuia other = (TipoGuia) obj;
		if (classificacao != other.classificacao)
			return false;
		if (custeio == null) {
			if (other.custeio != null)
				return false;
		} else if (!custeio.equals(other.custeio))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
