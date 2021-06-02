package br.jus.tream.saude.exception;

public class MapeamentoDTOException extends RuntimeException {

    private static final long serialVersionUID = -1569794829166859970L;
    
    public MapeamentoDTOException(String message, Exception e) {
        super(message, e);
    }


}
