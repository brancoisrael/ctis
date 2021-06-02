package br.jus.tream.saude.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.jus.tream.saude.dominio.AnexoDespesa;
import br.jus.tream.saude.dominio.Despesa;
import br.jus.tream.saude.dominio.TipoGuia;

public class DespesaDTO {
	
	private Long id;	
	private GuiaDTO guia;
	private Long numeroGuia;	
	private String anoExercicio;
	private TipoGuia tipoGuia;
	private LocalDate dataCadastro;
	private String observacao;
	private BigDecimal valor;
	private AnexoDespesaDTO anexo;
	
	public DespesaDTO() {
	}	
	public DespesaDTO(Despesa despesa) {		
		this.id = despesa.getId();
		this.numeroGuia = despesa.getNumeroGuia();
		this.anoExercicio = despesa.getAnoExercicio();
		this.tipoGuia = despesa.getTipoGuia();
		this.dataCadastro = despesa.getDataCadastro();
		this.observacao = despesa.getObservacao();
		this.valor = despesa.getValor();
		if (despesa.getAnexo() != null) {
			this.anexo = new AnexoDespesaDTO(despesa.getAnexo());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GuiaDTO getGuia() {
		return guia;
	}

	public void setGuia(GuiaDTO guia) {
		this.guia = guia;
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
	
	public AnexoDespesaDTO getAnexo() {
		return anexo;
	}
	
	public void setAnexo(AnexoDespesaDTO anexo) {
		this.anexo = anexo;
	}

}
