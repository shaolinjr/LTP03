package dados;

/**
 * Classe Estatística para abstrair os dados necessários e formar o objeto para manipulação
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class Estatistica {
private String nome;
private int numComprasPeriodo;
float valorTotalCompras;

public Estatistica(String nome, int numComprasPeriodo, float valorTotalCompras) {
	super();
	this.nome = nome;
	this.numComprasPeriodo = numComprasPeriodo;
	this.valorTotalCompras = valorTotalCompras;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getNumComprasPeriodo() {
	return numComprasPeriodo;
}

public void setNumComprasPeriodo(int numComprasPeriodo) {
	this.numComprasPeriodo = numComprasPeriodo;
}

public float getValorTotalCompras() {
	return valorTotalCompras;
}

public void setValorTotalCompras(float valorTotalCompras) {
	this.valorTotalCompras = valorTotalCompras;
}

@Override
public String toString() {
	return  "Nome.......................: " + nome + "\n"+
			"Nº Compras neste período...: "+numComprasPeriodo + "\n"+
			"Valor total de compras.....: R$"+ valorTotalCompras;
}



}
