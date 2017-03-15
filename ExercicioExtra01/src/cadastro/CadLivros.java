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