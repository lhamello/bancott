package br.com.tt.bancott.view;

import java.util.Scanner;

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
				System.out.println("Opção inválida! Selecione outra opção.");
				break;
			}
		} while(true);
	}

	private void incluirMovimento() {
		// 1 - listar os correntistas
		this.listarTodosCorrentistas();

		// 2 - selecionar um correntista
		System.out.println("Digite o número do correntista:");
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
		
		System.out.println("Digite a descrição do movimento:");
		String descricao = scanner.nextLine();
		
		Movimento movimento = new Movimento(tipoMovimento, valor, descricao);
		
		// 3 - adicionar o movimento à conta do correntista selecionado
		correntista.incluirMovimentoAConta(movimento);
		
		System.out.println("Movimento cadastrado com sucesso!");
	}

	private void imprimirMenu() {
		System.out.println("================= TELA MOVIMENTO ================");
		System.out.println(" Digite:                                         ");
		System.out.println("  - [1] para incluir movimento                   ");
		System.out.println("  - [2] para listar movimentos de um correntista ");
		System.out.println("  - [0] para retornar à Tela Principal           ");
		System.out.println("-------------------------------------------------");
	}
	
	private void listarTodosCorrentistas() {
		BancoDados bancoDeDados = BancoDados.getInstancia();
		Correntista[] correntistas = bancoDeDados.listarTodosCorrentistas();
		
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
		System.out.println("Digite o número do correntista:");
		int indiceCorrentista = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		BancoDados bancoDeDados = BancoDados.getInstancia();
		Correntista correntista = bancoDeDados.selecionarCorrentista(indiceCorrentista);
		
		Movimento[] movimentos = correntista.listarMovimentosDaConta();
		
		for (Movimento movimento : movimentos) {
			
			if (movimento != null) {
				System.out.println(movimento);
			}
		}
	}
}
