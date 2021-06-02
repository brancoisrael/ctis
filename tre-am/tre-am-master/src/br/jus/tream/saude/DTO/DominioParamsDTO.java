package br.jus.tream.saude.DTO;

import br.jus.tream.saude.dominio.Dominio;

/**
 * Representa os dados da pesquisa da listagem de domínio.
 * 
 * @author vinicius
 *
 */
public class DominioParamsDTO {

	private Long id;
	private String descricao;
	private String valor;
	private String situacao;
	private String dominio;
	
	public DominioParamsDTO() {}
	
	/**
	 * Responsável por converter um {@link Dominio} para seu respectivo Dto.
	 * 
	 * @param dominio que será convertido.
	 */
	public DominioParamsDTO(Dominio dominio) {
		this.id = dominio.getId();
		this.descricao = dominio.getDescricao();
		this.valor = dominio.getValor();
		this.situacao = dominio.getSituacao().getDescricao();
		this.dominio = dominio.getDominio();
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

}
