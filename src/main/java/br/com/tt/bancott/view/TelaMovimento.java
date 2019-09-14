package br.com.tt.bancott.view;

import java.util.List;
import java.util.Scanner;

import br.com.tt.bancott.excecao.SaldoInsuficienteException;
import br.com.tt.bancott.infra.BancoDados;
import br.com.tt.bancott.model.Correntista;
import br.com.tt.bancott.model.Movimento;
import br.com.tt.bancott.model.TipoMovimento;

public class TelaMovimento implements Tela {

	private Scanner scanner = new Scanner(System.in);
	
	public void abrirTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			switch (opcaoUsuario) {
			case 1:
				this.incluirMovimento();
				break;
			case 2:
				this.listarMovimentosCorrentista();
				break;
			case 0:
				return;
			default:
				System.out.println("Op��o inv�lida! Selecione outra op��o.");
				break;
			}
		} while(true);
	}

	private void incluirMovimento() {
		// 1 - listar os correntistas
		this.listarTodosCorrentistas();

		// 2 - selecionar um correntista
		System.out.println("Digite o n�mero do correntista:");
		int indiceCorrentista = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		BancoDados bancoDeDados = BancoDados.getInstancia();
		Correntista correntista = bancoDeDados.selecionarCorrentista(indiceCorrentista); 
		
		System.out.println("Digite o movimento desejado (CREDITO, DEBITO, "
				+ "SAQUE, TRANSFERENCIA):");
		String movimentoDesejado = scanner.nextLine();
		TipoMovimento tipoMovimento = TipoMovimento.valueOf(movimentoDesejado);
		
		System.out.println("Digite o valor do movimento:");
		Double valor = scanner.nextDouble();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		System.out.println("Digite a descri��o do movimento:");
		String descricao = scanner.nextLine();
		
		Movimento movimento = new Movimento(tipoMovimento, valor, descricao);
		
		// 3 - adicionar o movimento � conta do correntista selecionado
		try {
			correntista.incluirMovimentoAConta(movimento);
		} catch (SaldoInsuficienteException excecao) {
			System.out.println(excecao.getMessage());
		}
		
		System.out.println("Movimento cadastrado com sucesso!");
	}

	private void imprimirMenu() {
		System.out.println("================= TELA MOVIMENTO ================");
		System.out.println(" Digite:                                         ");
		System.out.println("  - [1] para incluir movimento                   ");
		System.out.println("  - [2] para listar movimentos de um correntista ");
		System.out.println("  - [0] para retornar � Tela Principal           ");
		System.out.println("-------------------------------------------------");
	}
	
	private void listarTodosCorrentistas() {
		BancoDados bancoDeDados = BancoDados.getInstancia();
		List<Correntista> correntistas = bancoDeDados.listarTodosCorrentistas();
		
		int indice = 0;
		
		for (Correntista correntista : correntistas) {
			
			if (correntista != null) {
				System.out.println(String.format("%d - %s", 
						indice, 
						correntista));
			}
			
			indice++;
		}
	}
	
	private void listarMovimentosCorrentista() {
		this.listarTodosCorrentistas();
		System.out.println("Digite o n�mero do correntista:");
		int indiceCorrentista = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		BancoDados bancoDeDados = BancoDados.getInstancia();
		Correntista correntista = bancoDeDados.selecionarCorrentista(indiceCorrentista);
		
		List<Movimento> movimentos = correntista.listarMovimentosDaConta();
		
		for (Movimento movimento : movimentos) {
			
			if (movimento != null) {
				System.out.println(movimento);
			}
		}
	}
}
