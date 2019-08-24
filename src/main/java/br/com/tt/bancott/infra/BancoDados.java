package br.com.tt.bancott.infra;

import br.com.tt.bancott.model.Correntista;

// Esta classe � um sigleton para representar um banco de
// dados em mem�ria
// Uma classe singleton garante que esta classe s� ter� uma
// inst�ncia da mesma, no programa
public class BancoDados {

	private static BancoDados instancia;
	private Correntista[] correntistas;

	private BancoDados() {
		this.correntistas = new Correntista[100];
	}

	public static BancoDados getInstancia() {
		if (instancia == null) {
			instancia = new BancoDados();
		}

		return instancia;
	}

	public void cadastrarCorrentista(Correntista correntista) {
		for (int indice = 0; indice < correntistas.length; indice++) {

			if (correntistas[indice] == null) {
				correntistas[indice] = correntista;
				break;
			}
		}
	}

	public Correntista[] listarTodosCorrentistas() {
		return correntistas;
	}
	
	public Correntista selecionarCorrentista(int indiceCorrentista) {
		return correntistas[indiceCorrentista];
	}
}
