package br.com.tt.bancott.infra;

import java.util.LinkedList;
import java.util.List;

import br.com.tt.bancott.model.Correntista;

// Esta classe � um sigleton para representar um banco de
// dados em mem�ria
// Uma classe singleton garante que esta classe s� ter� uma
// inst�ncia da mesma, no programa
public class BancoDados {

	private static BancoDados instancia;
//	private Correntista[] correntistas;
	private List<Correntista> correntistas;

	private BancoDados() {
//		this.correntistas = new Correntista[100];
		this.correntistas = new LinkedList<>();
	}

	public static BancoDados getInstancia() {
		if (instancia == null) {
			instancia = new BancoDados();
		}

		return instancia;
	}

	public void cadastrarCorrentista(Correntista correntista) {
//		for (int indice = 0; indice < correntistas.length; indice++) {
//
//			if (correntistas[indice] == null) {
//				correntistas[indice] = correntista;
//				break;
//			}
//		}
		correntistas.add(correntista);
	}

//	public Correntista[] listarTodosCorrentistas() {
	public List<Correntista> listarTodosCorrentistas() {
		return correntistas;
	}
	
	public Correntista selecionarCorrentista(int indiceCorrentista) {
//		return correntistas[indiceCorrentista];
		return correntistas.get(indiceCorrentista);
	}
}
