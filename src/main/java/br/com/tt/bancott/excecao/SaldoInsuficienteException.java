package br.com.tt.bancott.excecao;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(Double saldo) {
		super(String.format("Saldo insuficiente para realizar sua operação. "
				+ "Seu saldo atual é: R$ %.2f.", saldo));
	}
}
