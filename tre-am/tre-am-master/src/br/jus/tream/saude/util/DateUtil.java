package br.jus.tream.saude.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author vinicius
 *
 */
public class DateUtil {

	public static LocalDate converteData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00.0");
		return LocalDate.parse(data, formatter);
	}
	
	public static String converteData(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}
	
	public static String converteParaString(LocalDate data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}

}
