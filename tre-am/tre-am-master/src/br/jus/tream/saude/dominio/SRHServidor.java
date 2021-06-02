package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "vw_srh_lotacao", schema = "srh2" )
public class SRHServidor implements Serializable {

	@Id
	@Column(name = "mat_servidor")
	private String id;

	@Column(name = "num_tit_ele", length = 12)
	private String tituloEleitor;

	@Column(name = "nom")
	private String nome;
	
	@Column(name = "sigla_unid_tse")
	private String sigla;
	
	@Column(name = "unidade")
	private String descricao;
	
//	@Column(name = "ze")
//	private String zona;

	public SRHServidor() {

	}
	
	public SRHServidor(String id, String tituloEleitor, String nome) {
		super();
		this.id = id;
		this.tituloEleitor = tituloEleitor;
		this.nome = nome;
	}
	
	public SRHServidor(String id, String tituloEleitor, String nome, String sigla, String descricao, String ze) {
		super();
		this.id = id;
		this.tituloEleitor = tituloEleitor;
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
//		this.zona = ze;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
//	public String getZona() {
//		return zona;
//	}
//
//	public void setZona(String zona) {
//		this.zona = zona;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		SRHServidor other = (SRHServidor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
