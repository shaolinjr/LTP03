package usuario;

import dados.Livro;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.CadLivros;
import utilitarios.Console;
public class Usuario {
	
	private static int option;
	private static Console console = new Console();
	private static Livro livro;
	
	public static void main(String[] args) {
		
		while (true){
			menu();
			option = console.readInt("Qual op��o voc� deseja?: ");
			
			switch (option){
				case 1:
					livro = pegarDadosLivro();
					CadLivros.adicionarlivro(livro);
					break;
				case 2:
					// fazer menu com os campos que poder�o ser editados
					alterarDadosLivro();
					break;
				case 3:
					excluirLivro();
					break;
				case 4:
					consultarPorCodigo();
					break;
				case 5:
					consultarPorTitulo();
					break;
				case 6:
					System.out.println("Finalizando...");
					System.exit(0);
					break;
				default:
					System.out.println("Op��o n�o encontrada!");
					break;
			}
		}
	}
	
	private static void menu (){
		System.out.println("\n********  Menu: ********");
		System.out.println("1) Cadastrar novo livro");
		System.out.println("2) Alterar algum livro");
		System.out.println("3) Excluir algum livro");
		System.out.println("4) Consultar livro pelo c�digo");
		System.out.println("5) Consultar livro pelo t�tulo");
		System.out.println("6) Sair");
	}
	
	private static void dadosLivro (Livro livro){
		// modificar para usar o toString!
		if (livro != null){;
			System.out.println(livro.toString());
		}else {
			System.out.println("Nenhum livro foi encontrado!");
		}
	}
	
	private static Livro pegarDadosLivro (){
		int codigo;
		String titulo;
		String nome = "";
		ArrayList<String> autor = new ArrayList<String>();
		GregorianCalendar data 	= new GregorianCalendar();
		Livro livro;
		do {
			codigo = console.readInt("Digite o c�digo do livro: ");
			if (codigo <= 0){
				System.out.println("C�digo inv�lido, deve ser positivo e maior que zero!");
				
			}
		}while(codigo <= 0);
		
		do {
			titulo = console.readLine("Digite o t�tulo do livro: ");
			
			if (titulo.length() == 0){
				System.out.println("T�tulo inv�lido, n�o deve ser deixado em branco!");
			}
		}while(titulo.length() == 0);
		
		while(!nome.equals("0")) {
			// ver logica para permitir mais de um autor
			nome = console.readLine("Digite o nome do autor [0, para finalizar]: ");
			
			if (nome.isEmpty()){
				System.out.println("Nome inv�lido, n�o deve ser deixado em branco!");
				continue;
			}
			if (!nome.equals("0")){
				autor.add(nome);
			}
		}
		
		livro = new Livro(codigo, titulo, autor, data);
		
		return livro;
	}
	
	private static void excluirLivro (){
		int codigo;
		do {
			codigo = console.readInt("Digite o c�digo para buscar [0 para cancelar]: ");
			if (codigo < 0){
				System.out.println("C�digo inv�lido, deve ser positivo e maior que zero!");
				
			}else if (codigo == 0){
				break;
			}
			Livro livro = CadLivros.consultaPorCodigo(codigo);
			
		
			if (livro != null){
				CadLivros.excluirLivro(livro);
			}else{
				System.out.println("C�digo inv�lido, livro n�o cadastrado.");
			}
		
		}while(codigo <= 0 || livro == null);
		
		
	}
	
	private static void consultarPorCodigo (){
		int codigo;
		do {
			codigo = console.readInt("Digite o c�digo para busca: ");
			if (codigo <= 0){
				System.out.println("C�digo inv�lido, deve ser positivo e maior que zero!");
				
			}
		}while(codigo <= 0);
		Livro livro = CadLivros.consultaPorCodigo(codigo);
		dadosLivro(livro);
	}
	
	private static void consultarPorTitulo (){
		String titulo;
		
		do {
			titulo = console.readLine("Digite o t�tulo do livro: ");
			
			if (titulo.length() == 0){
				System.out.println("T�tulo inv�lido, n�o deve ser deixado em branco!");
			}
		}while(titulo.length() == 0);
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		livros = CadLivros.consultaPorNome(titulo);
		dadosLivro(livro);
	}

	private static void alterarDadosLivro (){
		int codigo;
		int opcao = 0;
		Livro livro;
		String escolha = "x";
		
		
		// Verifica o c�digo digitado
		do {
			codigo = console.readInt("Digite o c�digo para busca: ");
			if (codigo <= 0){
				System.out.println("C�digo inv�lido, deve ser positivo e maior que zero!");
				
			}
		}while(codigo <= 0);
		
		// Se o codigo for valido, buscamos o livro e seguimos
		livro = CadLivros.consultaPorCodigo(codigo);
		dadosLivro(livro); // Se encontrar exibe os dados, ou entao exibe que nao encontrou
		
		// menu de modificacao dos campos
		while (true){
			System.out.println("Qual campo deseja modificar?: ");
			System.out.println("1) T�tulo");
			System.out.println("2) Autor(es)");
			System.out.println("3) Cancelar");
			
			opcao = console.readInt("Digite sua op��o: ");
			
			switch (opcao){
			
				case 1:
					String titulo = "";
					// validacao do titulo
					do {
						titulo = console.readLine("Digite o novo t�tulo: ");
						
						if(titulo.isEmpty()){
							System.out.println("T�tulo em branco, digite novamente!");
						}
						
					}while(titulo.isEmpty());
					
					// confirmar mudan�a de titulo
					do {
						escolha = console.readLine("Deseja confirmar atualiza��o?: [S|N]");
						
						if (escolha.equalsIgnoreCase("S")){
							livro.setTitulo(titulo);
						}else if (escolha.equalsIgnoreCase("N")){
							System.out.println("Modifica��es desconsideradas.");
							break;
						}else {
							System.out.println("Op��o inv�lida, tente novamente.");
						}
					}while(!escolha.equalsIgnoreCase("S") && !escolha.equalsIgnoreCase("N"));
					
					break;
					
				case 2:
					
					ArrayList<String> autores = new ArrayList<String>();
					String nome = "";
					while(!nome.equals("0")) {
						// ver logica para permitir mais de um autor
						nome = console.readLine("Digite o nome do autor [0, para finalizar]: ");
						
						if (!nome.equals("0")){
							if (nome.isEmpty()){
								System.out.println("Nome inv�lido, n�o deve ser deixado em branco!");
								continue;
							}
							if (!nome.equals("0")){
								autores.add(nome);
							}
						}
					}

					// validacao atualizacao dos campos de autor(es)
					do {
						escolha = console.readLine("Deseja confirmar atualiza��o?: [S|N]");
						
						if (escolha.equalsIgnoreCase("S")){
							livro.setAutor(autores); //adicionando campo no livro atual
						}else if (escolha.equalsIgnoreCase("N")){
							System.out.println("Modifica��es desconsideradas.");
							break;
						}else {
							System.out.println("Op��o inv�lida, tente novamente.");
						}
					}while(!escolha.equalsIgnoreCase("S") && !escolha.equalsIgnoreCase("N"));
					
					break;
					
				case 3:
					break;
					
				default:
					System.out.println("Op��o inv�lida!");
					break;	
			}
			
			if (opcao == 3){
				break;
			}else{
				livro.setData(new GregorianCalendar());
			}
		}
		
	}
}

