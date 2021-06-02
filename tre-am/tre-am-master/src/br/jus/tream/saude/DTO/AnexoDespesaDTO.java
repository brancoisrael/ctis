package br.jus.tream.saude.DTO;

import br.jus.tream.saude.dominio.AnexoDespesa;

public class AnexoDespesaDTO {
	private Long id;
	private DespesaDTO despesa;
	private byte[] documento;
	private String nome;
	
	public AnexoDespesaDTO() {		
	}
	
	public AnexoDespesaDTO(AnexoDespesa anexoDespesa) {
		this.id = anexoDespesa.getId();
		this.documento = anexoDespesa.getDocumento();
		this.nome = anexoDespesa.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DespesaDTO getDespesa() {
		return despesa;
	}

	public void setDespesa(DespesaDTO despesa) {
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
	
	
}
