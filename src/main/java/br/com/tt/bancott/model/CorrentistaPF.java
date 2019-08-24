package br.com.tt.bancott.model;

public class CorrentistaPF extends Correntista {

	private String tipoDocumento;
	private String documento;
	
	public CorrentistaPF(String nome, Conta conta, 
			             String tipoDocumento, String documento) {
		super(nome, conta);
		this.tipoDocumento = tipoDocumento;
	}
}
