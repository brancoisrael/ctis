package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.util.DateUtil;

/**
 * Representa os dados de um {@link GuiaProcedimento}.
 * 
 * @author vinicius
 *
 */
public class GuiaProcedimentoReportDTO implements Serializable {

	private static final long serialVersionUID = 6942780832038082080L;
	private String credenciado;
	private String numeroGuia;
	private String dataEmissao;
	private String dataValidade;
	private String funcao;
	private String nomeProcedimento;
	private String via;
	private String video;
	private Integer quantidade;
	private BigDecimal valor;
	private BigDecimal valorTotal;
	private String titular;
	private String paciente;
	private String especialidade;

	public GuiaProcedimentoReportDTO() {
	}

	public GuiaProcedimentoReportDTO(Object[] objeto) {
		this.credenciado = objeto[0] != null ? objeto[0].toString() : null;
		this.numeroGuia = objeto[1] != null ? objeto[1].toString() : null;
		LocalDate dataEm = objeto[2] != null ? DateUtil.converteData(objeto[2].toString()) : null;
		this.dataEmissao = DateUtil.converteParaString(dataEm);
		LocalDate dataVal = objeto[3] != null ? DateUtil.converteData(objeto[3].toString()) : null;
		this.dataValidade = DateUtil.converteParaString(dataVal);
		this.funcao = objeto[4] != null ? objeto[4].toString() : null;
		this.nomeProcedimento = objeto[5] != null ? objeto[5].toString() : null;
		this.via = objeto[6] != null ? objeto[6].toString() : null;
		this.video = objeto[7] != null ? objeto[7].toString() : null;
		this.quantidade = objeto[8] != null ? new Integer(objeto[8].toString()) : null;
		this.valor = objeto[9] != null ? new BigDecimal(objeto[9].toString()) : null;
		this.valorTotal = objeto[10] != null ? new BigDecimal(objeto[10].toString()) : null;
		this.titular = objeto[11] != null ? objeto[11].toString() : null;
		this.paciente = objeto[12] != null ? objeto[12].toString() : null;
		this.especialidade = objeto[13] != null ? objeto[13].toString() : null;
	}

	public String getCredenciado() {
		return credenciado;
	}

	public void setCredenciado(String credenciado) {
		this.credenciado = credenciado;
	}

	public String getNumeroGuia() {
		return numeroGuia;
	}

	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = numeroGuia;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
