package dados;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Classe Produto para abstrair os dados necessários e formar o objeto para manipulação futura
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class Produto  implements Serializable{

	private int codigo; // sequencial gerado pelo programa
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataInclusao, dataUltAlteracao;
	private static int  numero = 0;
	
	public Produto( String nome, double precoUnitario, GregorianCalendar dataInclusao,
			GregorianCalendar dataUltAlteracao) {
	
		this.codigo 			= numero++;
		this.nome 				= nome;
		this.precoUnitario 		= precoUnitario;
		this.dataInclusao 		= dataInclusao;
		this.dataUltAlteracao 	= dataUltAlteracao;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public static void setNumero(int num) {
		numero = num;
	}
	public static int getNumero (){
		return numero;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}


	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}


	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	
	public String toString() {
		
		return "\tCódigo...............: " + codigo + "\n"+
			   "\tNome.................: " + nome + "\n"+
			   "\tPreço Unit...........: " + "R$ "+precoUnitario + "\n"+
			   "\tData Inclusão........: " + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataInclusao.getTime()) + "\n"+
			   "\tData Última Alteração: " + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataUltAlteracao.getTime());
	}
	
	
	
}
