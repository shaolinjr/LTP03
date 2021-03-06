package dados;

import java.io.Serializable;

import dados.Produto;

/**
 * Classe ItemVenda para abstrair os dados necessários e formar o objeto de item de venda 
 * a ser implementado na classe Venda 
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class ItemVenda implements Serializable{
	
	private Produto produto;
	private double precoUnitario, valorVenda;
	private int quantVenda;
	
	public ItemVenda(Produto produto, double precoUnitario, double valorVenda, int quantVenda) {
		
		this.produto 		= produto;
		this.precoUnitario 	= precoUnitario;
		this.valorVenda 	= valorVenda;
		this.quantVenda 	= quantVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	
	public String toString() {
		return "Produto........:\n" + produto + "\n"+
			   "Preco Unit.....: R$" + precoUnitario + "\n"+ 
			   "Valor Venda....: R$" + valorVenda+ "\n"+
			   "Quant. Venda...: " + quantVenda;
	}
	
	
	
	
}
