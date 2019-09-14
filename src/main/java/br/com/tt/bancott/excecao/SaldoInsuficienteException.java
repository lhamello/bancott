package br.com.tt.bancott.excecao;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(Double saldo) {
		super(String.format("Saldo insuficiente para realizar sua opera��o. "
				+ "Seu saldo atual �: R$ %.2f.", saldo));
	}
}
