package br.com.tt.bancott.model;

public class CorrentistaPF extends Correntista {

	private TipoDocumentoPF tipoDocumento;
	private String documento;
	
	public CorrentistaPF(String nome, Conta conta, 
			             TipoDocumentoPF tipoDocumento, String documento) {
		super(nome, conta);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}
	
	@Override
	public String toString() {
		return String.format("Correntista[nome=%s,conta=%s,"
				+ "tipoDocumento=%s,documento=%s]", 
				nome, 
				conta, 
				tipoDocumento,
				documento);
	}
}
