package br.jus.tream.saude.dominio;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.jus.tream.saude.enumeration.SituacaoDominio;

@Entity
@SequenceGenerator(name = "SEQ_DOMINIO", sequenceName = "SEQ_DOMINIO", allocationSize = 1)
@Table(name = "dominio")
public class Dominio {

	@Id
	@SequenceGenerator(name = "DOMINIO_SEQ_GENERATION", sequenceName = "SEQ_DOMINIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOMINIO_SEQ_GENERATION")
	@Column(name = "COD_DOMINIO")
	private Long id;
	@Column(name = "descricao", nullable = true, length = 255)
	private String descricao;
	@Column(name = "valor", nullable = true, length = 255)
	private String valor;
	@Column(name = "situacao")
	@Enumerated(EnumType.ORDINAL)
	private SituacaoDominio situacao;
	@Column(name = "dominio", nullable = true, length = 255)
	private String dominio;
	
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public SituacaoDominio getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDominio situacao) {
		this.situacao = situacao;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	@Transient
	public String getBadgeSituacao() {
		return this.getSituacao().ordinal() == 1 ? "badge-success" : "badge-danger";
	}
	

}
