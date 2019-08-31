package br.com.tt.bancott.view;

import java.util.Scanner;

public class TelaPrincipal implements Tela {

	private void imprimirMenu() {
		System.out.println("======== TELA PRINCIPAL ========");
		System.out.println(" Digite:");
		System.out.println("  - [1] para Tela Correntista");
		System.out.println("  - [2] para Tela Movimento");
		System.out.println("  - [0] para encerrar programa");
		System.out.println("--------------------------------");
	}

	public void abrirTela() {
		Scanner scanner = new Scanner(System.in);

		do {
			this.imprimirMenu();

			// ler a entrada do usuário
			int opcaoUsuario = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			switch (opcaoUsuario) {
			case 1:
				Tela tela = new TelaCorrentista();
				tela.abrirTela();
				break;
			case 2:
				tela = new TelaMovimento();
				tela.abrirTela();
				break;
			case 0:
				System.out.println("Encerrar programa!");
				// fecha o scanner
				scanner.close();
				// encerra o programa
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida! Selecione outra opção.");
				break;
			}
		} while (true);
	}
}
