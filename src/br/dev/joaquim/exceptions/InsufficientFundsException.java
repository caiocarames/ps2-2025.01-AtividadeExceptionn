package br.dev.joaquim.exceptions;

/**
 * Indicar saldo insuficiente em uma conta bancária.
 */
public class InsufficientFundsException extends Exception {

    /**
     * Construtor da exceção.
     * 
     * @param message Mensagem de erro.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
