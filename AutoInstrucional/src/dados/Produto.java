package dados;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Produto {

	private int codigo = 0; // sequencial gerado pelo programa
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataInclusao, dataUltAlteracao;
	
	
	public Produto( String nome, double precoUnitario, GregorianCalendar dataInclusao,
			GregorianCalendar dataUltAlteracao) {
	
		this.codigo 			= this.codigo ++;
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
		
		return "Código...............:" + codigo + "\n"+
			   "Nome.................:" + nome + "\n"+
			   "Preço Unit...........:" + precoUnitario + "\n"+
			   "Data Inclusão........:" + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataInclusao.getTime()) + "\n"+
			   "Data Última Alteração:" + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataUltAlteracao.getTime());
	}
	
	
	
}
