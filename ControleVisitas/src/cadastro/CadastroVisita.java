package cadastro;

import dados.Visita;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CadastroVisita {
	private static ArrayList<Visita> visitas = new ArrayList<>();
	/**
	 * Method to create a new Visita object
	 * @param cpf
	 * @return new visita object
	 */ 
	public static void cadastrarVisita (String cpf){
		Visita novaVisita = new Visita(cpf);
		visitas.add(novaVisita);
	}
	
	public static String consultaPorCPF (String cpf){
		for (Visita v : visitas){
			if (v.getCpf().equals(cpf)){
				return v.toString();
			}
		}
		return "Registro não encontrado!";
	}
	
	public static void cadastrarSaida (String cpf){
		for (Visita v : visitas){
			if (v.getCpf().equals(cpf)){
				GregorianCalendar saida = new GregorianCalendar(); 
				v.setSaida(saida);
			}
		}
		
		
	}
	
	
}
