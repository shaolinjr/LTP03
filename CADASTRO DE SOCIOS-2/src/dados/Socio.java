package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import erros.SocioException;
import utilitarios.LtpUtil;

public class Socio implements Serializable{
	
	private String cpf;
	private String nome;
	private GregorianCalendar entrada;
	private GregorianCalendar saida;
	//
	private ArrayList<Dependente> dependentes;
	//
	public Socio(String cpf, String nome, GregorianCalendar entrada,
			ArrayList<Dependente> dependentes) {
		this.cpf = cpf;
		this.nome = nome;
		this.entrada = entrada;
		this.dependentes = dependentes;
	}
	//
	public Socio(String cpf, String nome, GregorianCalendar entrada) {
		this.cpf = cpf;
		this.nome = nome;
		this.entrada = entrada;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public GregorianCalendar getEntrada() {
		return entrada;
	}
	public void setEntrada(GregorianCalendar entrada) {
		this.entrada = entrada;
	}
	public GregorianCalendar getSaida() {
		return saida;
	}
	public void setSaida(GregorianCalendar saida) {
		this.saida = saida;
	}
	public String getCpf() {
		return cpf;
	}
	public ArrayList<Dependente> getDependentes() {
		return dependentes;
	}
	
	//
	public void incluirDependente(Dependente obj) {
		dependentes.add(obj);
	}
	public void excluirDependente(Dependente obj) {
		dependentes.remove(obj);
	}
	
    public Dependente pesqDependenteNome(String nome) throws SocioException {
    	for (Dependente obj : dependentes) {
    		if (obj.getNome().equalsIgnoreCase(nome) ) {
      			return obj;
    		}
    	}
    	throw new SocioException("NÃO EXISTE DEPENDENTE PARA O NOME");
    }
    
    public String toString() {
    	return 
    			"CPF : " + cpf + "\n" +
    			"Nome : " + nome + "\n" +
    			"Entrada : " + LtpUtil.formatarData(entrada, "dd/MM/yyyy") + "\n" +
    			"Saida : " + (saida==null?"":LtpUtil.formatarData(saida, "dd/MM/yyyy")) + "\n";
    }


}











