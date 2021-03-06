package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import dados.Produto;
import erros.SisVendasException;

/**
 * Classe Lista Produtos para receber e manipular os objetos da classe Produto 
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class ListaProdutos {	
	public static HashMap<Integer, Produto> cadProdutos = new HashMap<>();
	
	/**
	 * Método para incluir um objetodo tipo Produto no hashmap de produtos
	 * @param produto
	 */
	public static void incluirProduto (Produto produto){
		cadProdutos.put(produto.getCodigo(), produto);
	}
	
	/**
	 * Método para excluir um objeto do tipo Produto do hashmap de produtos
	 * @param produto
	 */
	public static void excluirProduto(Produto produto){
		cadProdutos.remove(produto.getCodigo());
	}
	
	/**
	 * Método para buscar produto no hashmap de produtos dado código especificado
	 * @param codigo
	 * @return objeto do tipo produto
	 * @throws SisVendasException
	 */
	public static Produto buscarProdutoCodigo (int codigo) throws SisVendasException{
		if(cadProdutos.containsKey(codigo)){
			return cadProdutos.get(codigo);
		}else{
			throw new SisVendasException("Não existe produto para o código fornecido!");
		}
	}
	
	
	/**
	 * Método para retornar os produtos que têm o nome especificado em ordem alfabética
	 * @param nomeProduto
	 * @return
	 * @throws SisVendasException
	 */
	public static ArrayList<Produto> produtosOrdemAlfabetica (String nomeProduto) throws SisVendasException{
		ArrayList<Produto> produtosOrdenados = new ArrayList<>();
		
		for (Produto produto: cadProdutos.values()){
			if(produto.getNome().contains(nomeProduto)){
				produtosOrdenados.add(produto);
			}
		}
		
		if(produtosOrdenados.size() != 0){
			Collections.sort(produtosOrdenados, new OrdenarProdutosOrdemAlfabetica());
			return produtosOrdenados;
		}else{
			throw new SisVendasException("Não existe nenhum produto com o nome fornecido!");
		}
		
	}
}


class OrdenarProdutosOrdemAlfabetica implements Comparator<Produto>{
	
	@Override
	public int compare(Produto o1, Produto o2) {
		
		return o1.getNome().compareTo(o2.getNome());
	}
}