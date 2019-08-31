package br.com.tt.bancott.view;

import java.util.Scanner;

import br.com.tt.bancott.infra.BancoDados;
import br.com.tt.bancott.model.Conta;
import br.com.tt.bancott.model.Correntista;
import br.com.tt.bancott.model.CorrentistaPF;
import br.com.tt.bancott.model.CorrentistaPJ;
import br.com.tt.bancott.model.TipoDocumentoPF;
import br.com.tt.bancott.model.TipoPessoa;

public class TelaCorrentista implements Tela {

	private Scanner scanner = new Scanner(System.in);

	public void abrirTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			switch (opcaoUsuario) {
			case 1:
				this.cadastrarCorrentista();
				break;
			case 2:
				this.listarTodosCorrentistas();
				break;
			case 0:
				// encerra a execu��o do m�todo
				return;
			default:
				System.out.println("Op��o inv�lida! Selecione outra op��o.");
				break;
			}
		} while (true);
	}

	private void imprimirMenu() {
		System.out.println("========== TELA CORRENTISTA ==========");
		System.out.println(" Digite:                              ");
		System.out.println("  - [1] para Cadastrar Correntista    ");
		System.out.println("  - [2] para Listar Correntistas      ");
		System.out.println("  - [0] para retornar � Tela Principal");
		System.out.println("--------------------------------------");
	}

	private void cadastrarCorrentista() {
		// vari�vel tipoPessoa da classe TipoPessoa
		// que recebe o retorno do m�todo pedirTipoPessoa()
		TipoPessoa tipoPessoa = this.pedirTipoPessoa();
		
		TipoDocumentoPF tipoDocumento = null;
		String documento = "";
		String cnpj = "";
		
		if (tipoPessoa == TipoPessoa.PF) {
			System.out.println("Digite [CPF] ou [RG]:");
			String documentoSelecionado = scanner.nextLine();
			tipoDocumento = TipoDocumentoPF.valueOf(documentoSelecionado);
			
			System.out.println("Digite o n�mero do documento:");
			documento = scanner.nextLine();
		} else {
			System.out.println("Digite o CNPJ:");
			cnpj = scanner.nextLine();
		}
		
		System.out.println("Digite o nome do correntista:");
		String nomeCorrentista = scanner.nextLine();
		
		System.out.println("Digite a ag�ncia da conta do correntista:");
		int agenciaConta = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		System.out.println("Digite o n�mero da conta do correntista:");
		int numeroConta = scanner.nextInt(); 
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		Conta contaCorrentista = new Conta(agenciaConta, numeroConta);
		
		Correntista correntista;
		
		if (tipoPessoa == TipoPessoa.PF) {
			correntista = new CorrentistaPF(nomeCorrentista, contaCorrentista, 
					tipoDocumento, documento);
		} else {
			correntista = new CorrentistaPJ(nomeCorrentista, contaCorrentista, cnpj);
		}

		
		// pega inst�ncia de um singleton, que � �nica
		BancoDados bancoDeDados = BancoDados.getInstancia();
		bancoDeDados.cadastrarCorrentista(correntista);
		
		System.out.println("Correntista cadastrado com sucesso!");
	}
	
	private void listarTodosCorrentistas() {
		BancoDados bancoDeDados = BancoDados.getInstancia();
		Correntista[] correntistas = bancoDeDados.listarTodosCorrentistas();
		
		for (Correntista correntista : correntistas) {
			
			if (correntista != null) {
				System.out.println(correntista);
			}
		}
	}
	
	private TipoPessoa pedirTipoPessoa() {
		TipoPessoa tipoPessoa = null;

		do {
			System.out.println("Digite [PF] para Pessoa F�sica ou "
					+ "[PJ] para Pessoa Jur�dica:");
			String valorDigitado = scanner.nextLine();

			try {
				tipoPessoa = TipoPessoa.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("  >>> Tipo pessoa inv�lido, "
						+ "digite PF ou PJ.");
			}
		} while (tipoPessoa == null);

		return tipoPessoa;
	}
}
