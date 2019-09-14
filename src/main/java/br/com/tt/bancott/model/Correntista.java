package br.com.tt.bancott.model;

import java.util.List;

import br.com.tt.bancott.excecao.SaldoInsuficienteException;

public abstract class Correntista {

	protected String nome;
	protected Conta conta;
	
	public Correntista(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
	
	public void incluirMovimentoAConta(Movimento movimento) throws SaldoInsuficienteException {
		this.conta.incluirMovimento(movimento);
	}
	
	public List<Movimento> listarMovimentosDaConta() {
		return conta.getMovimentos();
	}
}
