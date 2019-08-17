package br.com.tt.bancott.view;

import java.util.Scanner;

public class TelaMovimento {

	private Scanner scanner = new Scanner(System.in);
	
	public void abrirTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			switch (opcaoUsuario) {
			case 1:
				System.out.println("Incluir movimento!");
				break;
			case 2:
				System.out.println("Listar movimentos do correntista!");
				break;
			case 0:
				return;
			default:
				System.out.println("Opção inválida! Selecione outra opção.");
				break;
			}
		} while(true);
	}

	private void imprimirMenu() {
		System.out.println("================= TELA MOVIMENTO ================");
		System.out.println(" Digite:                                         ");
		System.out.println("  - [1] para incluir movimento                   ");
		System.out.println("  - [2] para listar movimentos de um correntista ");
		System.out.println("  - [0] para retornar à Tela Principal           ");
		System.out.println("-------------------------------------------------");
	}
}
