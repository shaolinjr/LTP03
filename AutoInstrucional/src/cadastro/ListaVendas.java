package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import dados.Cliente;
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
	
	public static ArrayList<Venda> buscarVendaDataDecrescente (Cliente cliente) throws SisVendasException{
		ArrayList<Venda> vendasCliente = new ArrayList<>();
		
		for (Venda venda: regVendas.values()){
			if(venda.getCliente() == cliente){
				vendasCliente.add(venda); 
			}
		}
		
		// order arrayList
		Collections.sort(vendasCliente, new OrdenarVendasDataDecrescente());
		return vendasCliente;

	}	
}

	class OrdenarVendasDataDecrescente implements Comparator<Venda>{
		@Override
		public int compare(Venda o1, Venda o2) {
			return o2.getDataVenda().compareTo(o1.getDataVenda());
		}
	}
