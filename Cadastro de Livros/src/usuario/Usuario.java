package usuario;

import java.util.ArrayList;

import cadastro.CadLivros;
import dados.Livro;
import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
		menu();
		System.out.println("\n"+ "Final do aplicativo");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("1-Incluir Livro");
			System.out.println("2-Pesquisar livro pelo código");
			System.out.println("3-Pesquisar livros pelo titulo");
			System.out.println("4-Excluir Livro");
			System.out.println("5-Alterar Livro");
			System.out.println("0-Sair");
			opcao = Console.readInt("Informe a opção: ");
			switch (opcao) {
				case 1:
					incluirLivro();
					break;
				case 2:
					pesqLivroCodigo();
					break;
				case 3:	
					pesqLivroTitulo();
					break;
				case 0:
					
					break;
	
				default:
					System.out.println("Opção inválida.");
					break;
			}
			
		} while (opcao!=0);
		
	}



	private static void pesqLivroTitulo() {
		System.out.println("\n" + "Pesquisar Livros Pelo Título" + "\n");
		String nome = Console.readLine("Informe o titulo: ");
		ArrayList<Livro> resp = CadLivros.pesqLivroTitulo(nome);
		if (resp.isEmpty()) {
			System.out.println("Não existe livro para o titulo.\n");
		} else {
			for (Livro obj : resp) {
				System.out.println(obj.toString());
			}
		}
		
	}

	private static void pesqLivroCodigo() {
		System.out.println("\n" + "Pesquisar Livro Pelo Código" + "\n");
		int codigo = Console.readInt("Informe o código: ");
		Livro obj = CadLivros.pesqLivroCodigo(codigo);
		if (obj==null) {
			System.out.println("Não existe livro para o código.\n" );
		} else {
			System.out.println(obj.toString());
		}
	}

	private static void incluirLivro() {
		System.out.println("\n" + "Incluir Livro" + "\n");
		
		// Entrada e validação de dados
		String titulo;
		String autor;
		
		while (true) {
			titulo = Console.readLine("Titulo: ").trim();
			if (titulo.isEmpty()) {
				System.out.println("Falta informar o titulo.");
			} else break;
		}
		
		while (true) {
			autor = Console.readLine("Autor: ").trim();
			if (autor.isEmpty()) {
				System.out.println("Falta o autor.");
			} else break;
		}
		
		//Criar o objeto com os dados0
		Livro obj = new Livro(titulo, autor);

		CadLivros.incluirLivro(obj);
		
		System.out.println("Livro incluido." + "\n");
		
		
	}

}
