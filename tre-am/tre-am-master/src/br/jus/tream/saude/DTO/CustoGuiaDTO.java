package br.jus.tream.saude.DTO;

import java.math.BigDecimal;

public class CustoGuiaDTO {

	private BigDecimal parcelaServidor;
	private BigDecimal parcelaTRE;
	private BigDecimal total;
	private BigDecimal totalAcrescimo;

	public CustoGuiaDTO(BigDecimal parcelaServidor, BigDecimal parcelaTRE, BigDecimal total,
			BigDecimal totalAcrescimo) {
		this.parcelaServidor = parcelaServidor;
		this.parcelaTRE = parcelaTRE;
		this.total = total;
		this.totalAcrescimo = totalAcrescimo;
	}

	public BigDecimal getParcelaServidor() {
		return parcelaServidor;
	}

	public void setParcelaServidor(BigDecimal parcelaServidor) {
		this.parcelaServidor = parcelaServidor;
	}

	public BigDecimal getParcelaTRE() {
		return parcelaTRE;
	}

	public void setParcelaTRE(BigDecimal parcelaTRE) {
		this.parcelaTRE = parcelaTRE;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalAcrescimo() {
		return totalAcrescimo;
	}

	public void setTotalAcrescimo(BigDecimal totalAcrescimo) {
		this.totalAcrescimo = totalAcrescimo;
	}

}
