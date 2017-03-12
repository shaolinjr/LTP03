package cadastro;

import java.util.ArrayList;
import dados.Livro;

public class CadLivros {
	public static ArrayList<Object> listaLivros;
	
	public static void adicionarlivro(Livro livro){
		listaLivros.add(livro); //adicionamos a string que corresponde ao objeto livro
	}
	
//	public static Livro consultaPorCodigo (int codLivro){
//
//		
//		
//	}
	
	// public static void excluirLivro (Livro livro){}
	// public static [lista de livros] consultaPorNome (String tituloLivro){}
	
	
}
/*
 * 
 *Atributo: 
 *lista de livros da biblioteca pessoal. Usar a classe ArrayList (Atributo publico e estático). 
Métodos públicos e estáticos:
	Método para adicionar um livro na lista. Parâmetro: objeto do tipo Livro;
	Método para consultar livro pelo código na lista. Parâmetro: código do livro, 
	retornar o livro ou null caso não exista o livro na lista para o código.
	Método para excluir um livro da lista. Parâmetro: o objeto do tipo Livro.
	Método para consultar livro pelo nome na lista. Parâmetro: titulo do livro, 
	retornar uma lista de livros.   (Observação: Implementar um filtro do tipo “estar contido”) 

 */
 