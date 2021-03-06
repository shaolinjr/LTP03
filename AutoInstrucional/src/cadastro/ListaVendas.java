package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import dados.Cliente;
import dados.Estatistica;
import dados.ItemVenda;
import dados.Venda;
import erros.SisVendasException;
/**
 * Classe Lista Vendas para receber os objetos de Venda 
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */


public class ListaVendas {
	public static HashMap<Integer, Venda> regVendas = new HashMap<>();
	
	/**
	 * Método para incluir venda no HashMap de registro de Vendas 
	 * @param venda -> Objeto do tipo venda para adicionar ao hashmap
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
	 * @return Objeto do tipo venda
	 * @throws SisVendasException
	 */
	public static Venda buscarVendaCodigo (int codigo) throws SisVendasException{
		if(regVendas.containsKey(codigo)){
			return regVendas.get(codigo);
		}else{
			throw new SisVendasException("Não existe venda para o código fornecido");
		}
	}
	
	/**
	 * Método para buscar venda por cliente em ordem de data decrescente
	 * @param cliente
	 * @return ArrayList com as vendas do período
	 * @throws SisVendasException
	 */
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
	
	/**
	 * Método para retornar a lista de vendas ordenadas por nome e data em período especificado
	 * @param dataInicial
	 * @param dataFinal
	 * @return ArrayList ordenado com as vendas do período
	 */
	public static ArrayList<Venda> listaVendasOrdenada (GregorianCalendar dataInicial, GregorianCalendar dataFinal){
		//fazer um loop e adicionar no arraylist os itens de venda para o periodo, validar dataVenda pra estar dentro
		ArrayList<Venda> vendasNoPeriodo = new ArrayList<>();
		
		for (Venda venda: regVendas.values()){
			// se não está antes da data inicial e não está depois da data final, 
			// quer dizer que está no periodo que queremos 
			if (!venda.getDataVenda().before(dataInicial)){
				if(!venda.getDataVenda().after(dataFinal)){
					vendasNoPeriodo.add(venda);
				}
			}
		}
		
		Collections.sort(vendasNoPeriodo, new OrdenarVendasNomeData()); // ordenando
		
		return vendasNoPeriodo;
	}
	
	/**
	 * Método para gerar as estatísticas de vendas em dado período
	 * @param dataInicial
	 * @param dataFinal
	 * @return ArrayList em ordem alfabetica com as informações da estatística
	 */
	public static ArrayList<Estatistica> obterEstatisticasVenda (GregorianCalendar dataInicial, GregorianCalendar dataFinal){
		ArrayList<Venda> vendasOrdenadas = listaVendasOrdenada(dataInicial, dataFinal);
		String nome;
		int qtdCompras;
		float totalCompras;
		boolean jaExiste = false;	
		HashMap<String, Estatistica> estatisticas = new HashMap<>();
		
		for (Venda venda: vendasOrdenadas){
			qtdCompras 	 = 1;
			totalCompras = 0;
			
			nome = venda.getCliente().getNome();
			
			for (ItemVenda item:venda.getVendaItens()){
				totalCompras += item.getValorVenda();
			}
			
			for (Estatistica x: estatisticas.values()){
				if (nome.equals(x.getNome())){
					jaExiste =  true;
					qtdCompras++;
					break;
					
				}else {
					jaExiste = false;
					
				}
			}
			
			if(jaExiste){
				float valorAnterior = estatisticas.get(nome).getValorTotalCompras();
				estatisticas.get(nome).setValorTotalCompras(valorAnterior + totalCompras);
				estatisticas.get(nome).setNumComprasPeriodo(qtdCompras);
			}else{
				estatisticas.put(nome,new Estatistica(nome, qtdCompras, totalCompras));
			}
		}
		
		ArrayList<Estatistica> estats = new ArrayList<>(estatisticas.values());
		
		Collections.sort(estats, new OrdenarNome());
		
		return estats;
	}
}

	class OrdenarNome implements Comparator<Estatistica>{

		@Override
		public int compare(Estatistica o1, Estatistica o2) {
			// TODO Auto-generated method stub
			return o1.getNome().compareTo(o2.getNome());
		}
		
	}
	class OrdenarVendasDataDecrescente implements Comparator<Venda>{
		@Override
		public int compare(Venda o1, Venda o2) {
			return o2.getDataVenda().compareTo(o1.getDataVenda());
		}
	}
	
	class OrdenarVendasNomeData implements Comparator <Venda>{

		@Override
		public int compare(Venda o1, Venda o2) {
			int primaryKey = o1.getCliente().getNome().compareTo(o2.getCliente().getNome());
			if (primaryKey != 0){
				return primaryKey;
			}else{
				return o2.getDataVenda().compareTo(o1.getDataVenda());
			}
		}

		
	}
