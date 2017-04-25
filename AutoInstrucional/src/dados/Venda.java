package dados;

import java.util.GregorianCalendar;
import dados.Cliente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import dados.ItemVenda;


public class Venda {
	private int 					numVenda = 0; //sequencial gerado pelo sistema
	private Cliente 				cliente;
	private GregorianCalendar 		dataVenda;
	private ArrayList<ItemVenda>	vendaItens = new ArrayList<>();
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda, ArrayList<ItemVenda> vendaItens) {
		this.numVenda 	= this.numVenda++;
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
			itens.append("- "+item+"\n");
		}
		return "Num. Venda....:" + numVenda + "\n" +
			   "Cliente.......:" + cliente + "\n" +
			   "Data Venda....:" + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataVenda) + "\n" +
			   "Venda Itens...:" + itens;	
	}	
	
}
