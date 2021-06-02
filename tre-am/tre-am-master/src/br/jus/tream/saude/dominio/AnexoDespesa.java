package br.jus.tream.saude.dominio;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "ANEXO_DESPESA")
public class AnexoDespesa {

	@Id
	@SequenceGenerator(name = "ANEXO_DESPESA_SEQ_GENERATION", sequenceName = "SEQ_DESPESA_ANEXO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANEXO_DESPESA_SEQ_GENERATION")
	@Column(name = "COD_ANEXO_DESPESA")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_DESPESA", nullable = false)
	private Despesa despesa;
	@Column(name = "DOCUMENTO", nullable = false)
	private byte[] documento;
	@Column(name = "NOME", nullable = true)
	private String nome;
	@Column(name = "TIPO", nullable = true)
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((despesa == null) ? 0 : despesa.hashCode());
		result = prime * result + Arrays.hashCode(documento);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		AnexoDespesa other = (AnexoDespesa) obj;
		if (despesa == null) {
			if (other.despesa != null)
				return false;
		} else if (!despesa.equals(other.despesa))
			return false;
		if (!Arrays.equals(documento, other.documento))
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
		return true;
	}

}
