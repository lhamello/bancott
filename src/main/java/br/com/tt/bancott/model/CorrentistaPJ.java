package br.com.tt.bancott.model;

public class CorrentistaPJ extends Correntista {

	private String cnpj;

	public CorrentistaPJ(String nome, Conta conta, String cnpj) {
		super(nome, conta);
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return String.format("Correntista[nome=%s,conta=%s,"
				+ "cnpj=%s]", 
				nome, 
				conta, 
				cnpj);
	}
}
