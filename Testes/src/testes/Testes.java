package testes;
import java.util.GregorianCalendar;
public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String dataFalsa = "12/05/17";
		String dataVerdadeira = "12/05/2017";
	
		System.out.println("Falsa: "+ validarData(dataFalsa));
		System.out.println("Verdadeira: "+ validarData(dataVerdadeira));
	}
	
	
	private static boolean validarData (String data){
		
		if(data.length() == 10 && data.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
			return true;
		}
		return false;
	}
}
