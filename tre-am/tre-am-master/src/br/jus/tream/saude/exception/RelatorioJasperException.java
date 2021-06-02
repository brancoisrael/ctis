package br.jus.tream.saude.exception;

/**
 * Responsável por facilitar os erros gerados pelo jasper
 * 
 * @author vinicius
 *
 */
public class RelatorioJasperException extends Exception {

	private static final long serialVersionUID = 9132805191726651867L;

	public RelatorioJasperException(String messagem) {
		super(messagem);
	}

	public RelatorioJasperException(String messagem, Throwable e) {
		super(messagem, e);
	}
}
