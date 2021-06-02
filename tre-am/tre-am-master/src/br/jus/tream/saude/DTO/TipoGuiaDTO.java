package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.jus.tream.saude.dominio.TipoGuia;

public class TipoGuiaDTO implements Serializable {

	private static final long serialVersionUID = 6803445821455802721L;
	private Long id;
	private String descricao;
	private BigDecimal custeio;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String classificacao;
	
	public TipoGuiaDTO() {}
	
	public TipoGuiaDTO(Long id) {
		this.id = id;
	}
	
	public TipoGuiaDTO(TipoGuia tipo) {
		this.id = tipo.getId();
		this.descricao = tipo.getDescricao();
		this.custeio = tipo.getCusteio();
		this.dataInicio = tipo.getDataInicio();
		this.dataFim = tipo.getDataFim();
		this.classificacao = tipo.getClassificacao().name();
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

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
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
		TipoGuiaDTO other = (TipoGuiaDTO) obj;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
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
