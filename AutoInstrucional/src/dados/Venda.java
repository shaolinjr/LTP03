package dados;

import java.util.GregorianCalendar;
import dados.Cliente;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import dados.ItemVenda;

/**
 * Classe Venda para abstrair os dados necessários e formar o objeto de venda e ser 
 * posteriormente implementado na classe listaVendas
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */
public class Venda implements Serializable{
	private int 					numVenda;
	private static int num = 0; //sequencial gerado pelo sistema
	private Cliente 				cliente;
	private GregorianCalendar 		dataVenda;
	private ArrayList<ItemVenda>	vendaItens = new ArrayList<>();
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda, ArrayList<ItemVenda> vendaItens) {
		this.numVenda 	= num++;
		this.cliente	= cliente;
		this.dataVenda 	= dataVenda;
		this.vendaItens = vendaItens;
	}

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}
	
	public static void setNumero (int numero){
		num = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}

	
	public String toString() {
		StringBuilder itens = new StringBuilder(); // testar a visualizacao desse bagulho depois
		for(ItemVenda item: vendaItens){
			itens.append("\n- "+item+"\n");
		}
		return "Num. Venda....: " + numVenda + "\n" +
			   "Cliente.......: " + cliente.getNome() + "\n" +
			   "Data Venda....: " + new SimpleDateFormat("dd/MM/YYYY").format(dataVenda.getTime()) + "\n" +
			   "Venda Itens...: " + itens;	
	}	
	
}
