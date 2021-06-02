package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import br.jus.tream.saude.util.DateUtil;

/**
 * Responsável por centralizar os filtros dos relatórios do sistema.
 * 
 * @author vinicius
 *
 */
public class ReportParams implements Serializable {

	private static final long serialVersionUID = 2504071269119978265L;
	private LocalDateTime dtIni;
	private LocalDateTime dtFim;
	private Long numeroGuia;
	private String anoExercicio;
	private Long idTipoGuia;
	private String tipoBeneficiario;
	private Integer mes;
	private Integer ano;

	public LocalDateTime getDtIni() {
		return dtIni;
	}

	public void setDtIni(LocalDateTime dtIni) {
		this.dtIni = dtIni;
	}

	public LocalDateTime getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDateTime dtFim) {
		this.dtFim = dtFim;
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

	public Long getIdTipoGuia() {
		return idTipoGuia;
	}

	public void setIdTipoGuia(Long idTipoGuia) {
		this.idTipoGuia = idTipoGuia;
	}

	public String getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(String tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	/**
	 * Converte ano e mês em {@link DateUtil}
	 * @return Retorna uma instância de Date de acordo com os par
	 */
	public Date getFromYearAndMonth() {
		return Date.from(LocalDate.of(this.ano, this.mes, 01).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}