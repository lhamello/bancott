package br.com.tt.bancott.model;

public class CorrentistaPJ extends Correntista {

	private String cnpj;

	public CorrentistaPJ(String nome, Conta conta, String cnpj) {
		super(nome, conta);
		this.cnpj = cnpj;
	}
}
