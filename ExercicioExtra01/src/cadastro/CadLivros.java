package cadastro;

import java.util.ArrayList;
import dados.Livro;

public class CadLivros {
	public static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
	
	public static void adicionarlivro(Livro livro){
		listaLivros.add(livro); //adicionamos a string que corresponde ao objeto livro
		
	}
	
	public static Livro consultaPorCodigo (int codLivro){
		Livro livro;
		
		for (int index =0; index < listaLivros.size();index++){
			if (codLivro == listaLivros.get(index).getCodigo()){
				return listaLivros.get(index);
			}
		}
		return null;
		
	}
	
	 public static void excluirLivro (Livro livro){
		 listaLivros.remove(livro);
	 }
	 
	 public static ArrayList<Livro> consultaPorNome (String tituloLivro){
		 ArrayList<Livro> livros = new ArrayList<Livro>();
		 
		 for (int index = 0; index < listaLivros.size();index++){
			 if (listaLivros.get(index).getTitulo().contains(tituloLivro)){
				 livros.add(listaLivros.get(index));
			 }
		 }
		 
		 return livros;
	 }
	
	
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
 