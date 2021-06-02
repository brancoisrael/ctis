package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Auxiliar;

/**
 * Representa os dados de um {@link Auxiliar}.
 * 
 * @author vinicius
 *
 */
public class AuxiliarDTO implements Serializable {

	private static final long serialVersionUID = -1008121138768287614L;

	private Long id;
	private BigDecimal taxaHonorario;
	private String nome;
	private LocalDateTime dataAtualizacao;

	public AuxiliarDTO() {
	}

	/**
	 * Responsável por converter um {@link Auxiliar} para seu respectivo Dto.
	 * 
	 * @param aux que será convertido.
	 */
	public AuxiliarDTO(Auxiliar aux) {
		this.id = aux.getId();
		this.taxaHonorario = aux.getTaxaHonorario();
		this.nome = aux.getNome();
		this.dataAtualizacao = aux.getDataAtualizacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTaxaHonorario() {
		return taxaHonorario;
	}

	public void setTaxaHonorario(BigDecimal taxaHonorario) {
		this.taxaHonorario = taxaHonorario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((taxaHonorario == null) ? 0 : taxaHonorario.hashCode());
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
		AuxiliarDTO other = (AuxiliarDTO) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (taxaHonorario == null) {
			if (other.taxaHonorario != null)
				return false;
		} else if (!taxaHonorario.equals(other.taxaHonorario))
			return false;
		return true;
	}

}
