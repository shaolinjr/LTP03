package dados;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Classe Cliente para abstrair os dados necessários e formar o objeto 
 * @author arthurpires
 * @version 1.0
 * @since 05/05/2017
 */

public class Cliente implements Serializable{

	private String cpf, nome, telefone, email;
	private GregorianCalendar dataInclusao, dataUltAlteracao;
	
	
	public Cliente(String cpf, String nome, String telefone, String email, GregorianCalendar dataInclusao,
			GregorianCalendar dataUltAlteracao) {
		
		this.cpf 				= cpf;
		this.nome 				= nome;
		this.telefone 			= telefone;
		this.email 				= email;
		this.dataInclusao 		= dataInclusao;
		this.dataUltAlteracao	= dataUltAlteracao;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
		return "\nCPF..................: " + cpf + "\n"+
			   "Nome.................: " + nome + "\n"+
			   "Telefone.............: " + telefone + "\n"+
			   "Email................: " + email + "\n"+
			   "Data Inclusão........: " + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataInclusao.getTime()) + "\n"+
			   "Data Última Alteração: " + new SimpleDateFormat("dd/MM/YYYY hh:mm").format(dataUltAlteracao.getTime()) + "\n";
	}
	
	
	
}
