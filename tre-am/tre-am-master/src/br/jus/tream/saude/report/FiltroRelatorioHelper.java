package br.jus.tream.saude.report;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import br.jus.tream.saude.DTO.ReportParams;

/**
 * Classe utilitário para construção da visualização dos filtros dos relatórios
 * 
 * @author vinicius
 *
 */
public final class FiltroRelatorioHelper {

	/**
	 * Responsável por construir a visualização do período
	 * no cabeçalho dos relatórios
	 * 
	 * @param filtros 
	 * @return dos periodos de graduação separados por |
	 */
	public static String buildPeriodoCabecalho(ReportParams filtros) {
		String formattedString = "";
		if (!ObjectUtils.isEmpty(filtros.getDtIni()) && !ObjectUtils.isEmpty(filtros.getDtFim())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			formattedString = filtros.getDtIni().format(formatter);
			formattedString = formattedString + " até " + filtros.getDtFim().format(formatter);
			;
		}
		return formattedString;
	}

	/**
	 * Converte uma coleção de Objetos em uma string separada pelo separador
	 * definido.
	 * 
	 * @param lista     a ser convertida
	 * @param separador dos itens da lista
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String converteEmStringSeparadoPor(Collection lista, String separador) {
		String value = "";
		if (!lista.isEmpty()) {
			value = lista.stream().map(Object::toString).collect(Collectors.joining(separador)).toString();
			value = value.length() > 400 ? value.substring(0, 395) + "..." : value;
		}
		return !value.isEmpty() ? value : "Todos";
	}

}
