package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.jus.tream.saude.DTO.TabelaCredenciadoDTO;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "TABELA")
public class TabelaCredenciado implements Serializable {

	private static final long serialVersionUID = 4030748844197622451L;
	@Id
	@Column(name = "COD_TABELA")
	private Long id;
	@Column(name = "NOM_TABELA", nullable = false, length = 30)
	private String nome;
	@Column(name = "TIP_TABELA", nullable = false, length = 1)
	private String tipo;
	@Column(name = "DAT_ULT_ATUAL")
	private LocalDateTime dataAtualizacao;
	@Column(name = "TIP_MEDICA", nullable = false)
	private Short tipoMedico;
	@Column(name = "TIP_ODONTO", nullable = false)
	private Short tipoOdonto;
	
	public TabelaCredenciado() {
	}	
	
	public TabelaCredenciado(Long id) {
		this.id = id;
	}
	
	public TabelaCredenciado(TabelaCredenciadoDTO tabelaCredenciadoDTO) {
		this.id = tabelaCredenciadoDTO.getId();
		this.nome = tabelaCredenciadoDTO.getNome();
		this.tipo = tabelaCredenciadoDTO.getTipo();
		this.tipoMedico = tabelaCredenciadoDTO.getTipoMedico();
		this.tipoOdonto = tabelaCredenciadoDTO.getTipoOdonto();
		this.dataAtualizacao = tabelaCredenciadoDTO.getDataAtualizacao();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Short getTipoMedico() {
		return tipoMedico;
	}

	public void setTipoMedico(Short tipoMedico) {
		this.tipoMedico = tipoMedico;
	}

	public Short getTipoOdonto() {
		return tipoOdonto;
	}

	public void setTipoOdonto(Short tipoOdonto) {
		this.tipoOdonto = tipoOdonto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoMedico == null) ? 0 : tipoMedico.hashCode());
		result = prime * result + ((tipoOdonto == null) ? 0 : tipoOdonto.hashCode());
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
		TabelaCredenciado other = (TabelaCredenciado) obj;
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoMedico == null) {
			if (other.tipoMedico != null)
				return false;
		} else if (!tipoMedico.equals(other.tipoMedico))
			return false;
		if (tipoOdonto == null) {
			if (other.tipoOdonto != null)
				return false;
		} else if (!tipoOdonto.equals(other.tipoOdonto))
			return false;
		return true;
	}

}
