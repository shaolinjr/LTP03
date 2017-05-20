package cadastro;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import dados.Cliente;
import erros.SisVendasException;

/**
 * Classe Lista Clientes para receber e manipular os objetos da Classe Cliente 
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class ListaClientes {
	public static HashMap<String, Cliente>cadClientes = new HashMap<>(); //lembrar que on indice é o cpf
	 
	 /**
	  * Função para fazer a inclusão de um cliente em nosso hashMap
	  * Tomando como base o cpf para indice e o objeto como valor
	  * @param cliente: Objeto do tipo Cliente
	  */
	public static void incluirCliente (Cliente cliente){
		cadClientes.put(cliente.getCpf(), cliente);
	}
	 
	 /**
	  * Função para fazer a exclusão de um cliente de nosso HashMap
	  * @param cliente
	  */
	public static void excluirCliente(Cliente cliente){
		 	 
		cadClientes.remove(cliente.getCpf());
		 
	}
	 
	 /**
	  * Método para buscar cliente no hashmap de clientes dado um cpf
	  * @param cpf
	  * @return objeto do tipo cliente
	  * @throws SisVendasException
	  */
	public static Cliente buscarClienteCpf (String cpf) throws SisVendasException{
		 	
		 if (cadClientes.containsKey(cpf)){
			 return cadClientes.get(cpf);
		 }
		 else{
			 throw new SisVendasException("Cliente não encontrado para este CPF!");
		 }
	 }
	 
	/**
	 * Método para retornar os clientes em ordem alfabetica que possuem o nome especificado
	 * @param nome
	 * @return ArrayList de clientes ordenados que possuem o nome especificado
	 * @throws SisVendasException
	 */
	public static ArrayList<Cliente> clientesOrdemAlfabetica (String nome) throws SisVendasException{
		
		ArrayList<Cliente> nomesOrdenados = new ArrayList<>();
		
		for (Cliente cliente : cadClientes.values()) {
			if (cliente.getNome().contains(nome)) {
				nomesOrdenados.add(cliente);
			}
		}
		
		if(nomesOrdenados.size() != 0){
			Collections.sort(nomesOrdenados, new OrdenarClientesAlfabetica());
			return nomesOrdenados;
		}else {
			throw new SisVendasException("Não existe nenhum cliente para o nome fornecido!");
		}
	} 
}

// Classe que implementa a inteface Comparator para conseguimos fazer o sort
class OrdenarClientesAlfabetica implements Comparator<Cliente> {

	@Override
	public int compare(Cliente obj1, Cliente obj2) {
		return obj1.getNome().compareTo(obj2.getNome());
	}
	
}

