package cadastro;

import java.util.ArrayList;

import org.omg.CORBA.RepositoryIdHelper;

import dados.Livro;

public class CadLivros {

	public static ArrayList<Livro> listaLivros = new ArrayList<>();
	
	/**
	 * Incluir Livro
	 * @param objLivro
	 */
	public static void incluirLivro(Livro objLivro) {
		listaLivros.add(objLivro);
	}
	
	/**
	 * Pesquisa livro pelo código
	 * @param codigo
	 * @return o livro
	 */
	public static Livro pesqLivroCodigo(int codigo) {
		/*
		for (int i=0; i < listaLivros.size(); i++) {
			if (listaLivros.get(i).getCodigo()==codigo) {
				return listaLivros.get(i);
			}
		}
		*/
		for (Livro objLivro : listaLivros) {
			if (objLivro.getCodigo()==codigo) {
				return objLivro;
			}
		}
		return null;
	}
	/**
	 * Excluir livro
	 * @param objLivro
	 */
	public static void excluirLivro(Livro objLivro) {
		listaLivros.remove(objLivro);
	}
	/**
	 * Pesquisa livros pelo titulo
	 * @param titulo
	 * @return livros selecionados
	 */
	public static ArrayList<Livro> pesqLivroTitulo(String titulo) {
		ArrayList<Livro> resposta = new ArrayList<>();
		for (Livro objLivro : listaLivros) {
			if (objLivro.getTitulo().contains(titulo)) {
				resposta.add(objLivro);
			}
		}
		return resposta;
	}
	
}
