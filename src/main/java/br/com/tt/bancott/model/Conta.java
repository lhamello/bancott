package br.com.tt.bancott.model;

import java.util.LinkedList;
import java.util.List;

import br.com.tt.bancott.excecao.SaldoInsuficienteException;

public class Conta {

	private Integer agencia;
	private Integer numero;
	private Double saldo;
	// array []
//	private Movimento[] movimentos;
	private List<Movimento> movimentos;

	public Conta(Integer agencia, Integer numero) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = 0.0;
//		this.movimentos = new Movimento[1000];
		this.movimentos = new LinkedList<>();
	}

	public void incluirMovimento(Movimento movimento) throws SaldoInsuficienteException {
		if (TipoMovimento.CREDITO == movimento.getTipo()) {
			saldo = saldo + movimento.getValor();
		} else {
			Double operacao = saldo - movimento.getValor();
			
			if (operacao < 0) {
				throw new SaldoInsuficienteException(saldo);
			}
			
			saldo = operacao;
		}
		
		this.movimentos.add(movimento);
	}

//	public Movimento[] getMovimentos() {
	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	@Override
	public String toString() {
		return String.format("Conta[agencia=%s,numero=%s,saldo=R$ %.2f]", agencia, numero, saldo);
	}
}
