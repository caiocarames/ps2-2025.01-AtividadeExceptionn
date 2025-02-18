package br.dev.joaquim.bank;

import br.dev.joaquim.exceptions.InsufficientFundsException;

/**
 * Classe que representa uma conta bancária com operações de depósito e saque.
 */
public class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    /**
     * Construtor.
     */
    public BankAccount() {
    }

    /**
     * Construtor que inicializa uma conta bancária com valores específicos.
     * 
     * @param accountNumber     Número da conta.
     * @param balance           Saldo inicial.
     * @param accountHolderName Nome do titular da conta.
     */
    public BankAccount(int accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    /**
     * Pegar número da conta.
     * 
     * @return Número da conta bancária.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Obtém o saldo disponível na conta.
     * 
     * @return Saldo atual da conta.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Obtém o nome do titular da conta.
     * 
     * @return Nome do titular.
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Deposita um valor na conta.
     * 
     * @param value Valor a ser depositado.
     * @throws IllegalArgumentException Se o valor for negativo.
     */
    public void deposit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }
        this.balance += value;
    }

    /**
     * Realiza um saque da conta bancária.
     * 
     * @param value Valor a ser sacado.
     * @throws IllegalArgumentException    Se o valor for negativo.
     * @throws InsufficientFundsException Se o saldo for insuficiente para o saque.
     */
    public void withdraw(double value) throws InsufficientFundsException {
        if (value < 0) {
            throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
        }

        if (value > this.balance) {
            throw new InsufficientFundsException("Saldo insuficiente! O valor R$ " + value + " é superior ao saldo disponível [R$ " + this.balance + "]");
        }

        this.balance -= value;
    }

    /**
     * Retorna conta bancária.
     * 
     * @return Informação da conta e saldo disponível.
     */
    @Override
    public String toString() {
        return "Conta " + accountNumber + " de " + accountHolderName + " tem R$ " + balance + " de saldo";
    }
}
