package br.com.tt.bancott.model;

public class Correntista {

	private String nome;
	private Conta conta;
	
	public Correntista(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
	
	public void incluirMovimentoAConta(Movimento movimento) {
		this.conta.incluirMovimento(movimento);
	}
	
	public Movimento[] listarMovimentosDaConta() {
		return conta.getMovimentos();
	}
	
	@Override
	public String toString() {
		return String.format("Correntista[nome=%s,conta=%s]", nome, conta);
	}
}
