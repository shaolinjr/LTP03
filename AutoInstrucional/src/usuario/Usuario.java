package usuario;

import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	
	/**
	 * Método para apresentar um menu para facilitar o uso pelo usuário
	 */
	private static void menu (){
		int opcao = 0;
		
		do {
			System.out.println("********* MENU *********");
			System.out.println("----- Cliente -----");
			System.out.println("1. Incluir novo cliente");
			System.out.println("2. Alterar cliente pelo CPF");
			System.out.println("3. Excluir cliente pelo CPF");
			System.out.println("----- Produtos -----");
			System.out.println("4. Incluir novo produto");
			System.out.println("5. Alterar produto pelo código");
			System.out.println("6. Excluir produto pelo código");
			System.out.println("----- Vendas -----");
			System.out.println("7. Incluir uma venda");
			System.out.println("8. Excluir uma venda");
			System.out.println("9. Consultar vendas pelo período\n   de data decrescente");
			System.out.println("10. Consultar estatísticas de vendas\n    por período de vendas");
			System.out.println("11. Sair");
			
			opcao = Console.readInt("\nDigite sua opção: ");
			
			switch(opcao){
			// Cliente
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
			// Produtos				
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
			// Vendas					
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					System.out.println("Saindo...");
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		}while (opcao < 1 && opcao > 11);
	}

	// Métodos de leitura e gravação
	
	// Métodos para manipulação das classes ligadas à Cliente
	// Métodos para manipulação das classes ligadas à Produto
	// Métodos para manipulação das classes ligadas à Venda
}
