package br.com.tt.bancott.model;

public class Correntista {

	private String nome;
	private Conta conta;
	
	public Correntista(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
	
	@Override
	public String toString() {
		return String.format("Correntista[nome=%s,conta=%s]", nome, conta);
	}
}
