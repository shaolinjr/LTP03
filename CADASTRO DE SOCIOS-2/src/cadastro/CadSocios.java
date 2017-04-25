package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import dados.Socio;
import erros.SocioException;

public class CadSocios {

	public static HashMap<String,Socio> cadSocios = new HashMap<>();
	
	/**
	 * Incluir Socio
	 * @param obj
	 */
	public static void incluirSocio(Socio obj) {
		cadSocios.put(obj.getCpf(), obj);
	}
	/**
	 * Excluir Socio
	 * @param obj
	 */
	public static void excluirSocio(Socio obj) {
		cadSocios.remove(obj.getCpf());
	}
	/**
	 * Pesquisar o socio pelo cpf
	 * @param cpf
	 * @return
	 */
	public static Socio pesqSocioCpf (String cpf) throws SocioException{
		if (cadSocios.containsKey(cpf)){
			return cadSocios.get(cpf);
		} else{
			throw new SocioException("NÃO EXISTE SÓCIO PARA O CPF");
		}
		
	}
	/**
	 * Pesquisar socios pelo nome
	 * @param nome
	 * @return lista de socios selecionados
	 */
	public static ArrayList<Socio> pesqSociosNome (String nome) {
		ArrayList<Socio> resposta = new ArrayList<>();
		for (Socio obj : cadSocios.values()) {
			if (obj.getNome().contains(nome)) {
				resposta.add(obj);
			}
		}
		//Ordenar os socios selecionados pelo nome

		Collections.sort(resposta, new OrdenarSocioNome());
		return resposta;
	}
	
}

class OrdenarSocioNome implements Comparator<Socio> {

	@Override	
	public int compare (Socio obj1, Socio obj2) {
		return obj1.getNome().compareTo(obj2.getNome());
	}
}
