package usuario;

import dados.Livro;
import cadastro.CadLivros;

// importat LTPUtil.jar

public class Usuario {
	
	

	public static void main(String[] args) {
		menu();

	}
	
	private static void menu (){
		System.out.println("Menu:");
		System.out.println("1) Cadastrar novo livro");
		System.out.println("2) Alterar algumlivro");
		System.out.println("3) Excluir algum livro");
		System.out.println("4) Consultar livro pelo código");
		System.out.println("5) Consultar livro pelo título");
	}
	
}

/* Método main para apresentar o menu principal e antes de sair 
 * do programa imprimir mensagem de finalização.
	Métodos estáticos e privados para apresentar um menu com opções para métodos: 
	cadastrar um novo livro, alterar livro, excluir um livro, consultar o livro pelo código, 
	consultar o livro pelo nome (titulo).
*/