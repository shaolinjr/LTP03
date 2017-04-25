package cadastro;

import java.util.HashMap;

import dados.Venda;
import erros.SisVendasException;

public class ListaVendas {
	public static HashMap<Integer, Venda> regVendas = new HashMap<>();
	
	/**
	 * Método para incluir venda no HashMap de registro de Vendas 
	 * @param venda
	 */
	public static void incluirVenda (Venda venda){
		regVendas.put(venda.getNumVenda(), venda);
	}
	
	
	/** 
	 * Método para excluir registro de vendas dado um objeto do tipo Venda
	 * @param venda
	 */
	public static void excluirVenda (Venda venda){
		regVendas.remove(venda.getNumVenda());
	}
	
	
	/**
	 * Método para buscar o item da venda através do código
	 * @param codigo
	 * @return
	 * @throws SisVendasException
	 */
	public static Venda buscarVendaCodigo (int codigo) throws SisVendasException{
		if(regVendas.containsKey(codigo)){
			return regVendas.get(codigo);
		}else{
			throw new SisVendasException("Não existe venda para o código fornecido");
		}
	}
	
	
	
	
}
