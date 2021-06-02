package br.jus.tream.saude.util;

import java.time.LocalTime;

public class ValidaHorarioUrgenciaUtil {

		private static LocalTime horaInicio = LocalTime.of(22, 00, 00);
		private static LocalTime horaFim = LocalTime.of(06, 00, 00);
		
		public static boolean validaHorarioPermitidoUrgencia() {
			
			LocalTime horaAgora =  LocalTime.now();
			
			if (horaAgora.isBefore(horaFim)) {
				return true;
			}
			if (horaAgora.isAfter(horaInicio)) {
				return true;
			}
			return false;
		}
}
