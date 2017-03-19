package biblioteca;
import java.util.GregorianCalendar;
import java.util.regex.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Biblioteca {
	
	/**
	 * Método para validar CPF
	 * @param cpf
	 * @return
	 */
	public static boolean validarCPF(String cpf){
		// TODO: Travar cpf com sequencia de numeros iguais!
		String[] numeros 	= cpf.split("");
		String dv 			= numeros[9]+numeros[10];
		int t1 				= 0;
		int t2 				= 0;
		int x;
		int y;
		String xy;
		// montando t1
		for (int i = 10; i > 1;i--){
			t1+= i * Integer.parseInt(numeros[(numeros.length - i) -1 ]);	
		}
		
		x = 11 - (t1 % 11);
		
		if (x > 9){x = 0;}
		// montando t2
		for (int i = 11; i > 1; i--){
			
			if (i <= 11){
				t2 += i * Integer.parseInt(numeros[(numeros.length - (i-1)) - 1 ]);
			}else {
				t2 += x * i;
			}
		}
		y = 11 - (t2 % 11);
		if (y > 9){y = 0;}
				
		xy = String.valueOf(x)+String.valueOf(y);

		return (dv.equals(xy)) ? true:false;
	}
	
	/**
	 * Método para validar CNPJ
	 * @param cpnj
	 * @return
	 */
	public static boolean validarCPNJ(String cpnj){
		return true;
	}
	
	/**
	 * Método para validar Email
	 * @param email
	 * @return
	 */
	public static boolean validarEmail (String email) { 
		String regex 	= "[A-Za-z0-9_]{1,}([.][A-Za-z0-9_]+){0,}+@[a-zA-Z0-9]{2,}[.][a-zA-Z0-9]{2,}([.][a-zA-Z0-9]{2,})?";
		boolean match 	= email.matches(regex);
		return (match) ? true: false; 
	}
	
	/**
	 * Método validarPIS - Validação do DV do PIS
	 * @param pis String com o PIS
	 * @return true para PIS com dv correto
	 */
	public static boolean validarPIS (String pis) { return true; }
	
	/**
	 * Método contarPalavras - Contar as palavras do texto
	 * @param s String com o Texto
	 * @return int com o número de palavras do texto
	 */
	public static int contarPalavras (String texto) {
		String padronizado 	= padronizarTexto(texto);
		String[] palavras 	= padronizado.split("\\s+"); //regex pega um ou mais espaços e da o split
		int contador = 0;
		for (String palavra:palavras){contador++;}
		return contador; 
	}
	
	/**
	 * Método padronizaTexto – Excluir espaços na extremidade e excesso entre palavras do texto
	 * @param texto String com o texto
	 * @return texto padronizado
	 */
	public static String padronizarTexto (String texto) { 
		String aux = texto.trim(); // Retira os espaços das extremidades 
		while (aux.contains("  ")) {
			aux = aux.replace("  ", " ");
		}
		return aux; 
	}
	
	/**
	 * Método validarData - Validação básica de Data
	 * @param s String com a Data
	 * @return true para data válida ou false para data inválida
	 */
	public static boolean validarData (String dataString) { 
		int dia;
		int mes;
		int ano;
		try {
			dia 	= Integer.valueOf(dataString.substring(0,2));
			mes  	= Integer.valueOf(dataString.substring(3,5)) - 1;
			ano		= Integer.valueOf(dataString.substring(6));
		}catch(NumberFormatException e){
			return false;
		}
		
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setLenient(false);
			c.set(ano,mes, dia);
			c.getTime();

		}catch (Exception e){
			return false;
		}
		return true;
		
		}
	
	/**
	 * validarData verifica se o conteúdo da String representa um data válida
	 * @param s - String com a data
	 * @param dt referência a um objeto da classe GregorianCalendar para receber a data válida
	 * @return true para data válida ou false para data inválida
	 */
	public static boolean validarData (String dataString, GregorianCalendar data) { 
		
		if (validarData(dataString)){
			int dia 	= Integer.valueOf(dataString.substring(0,2));
			int mes  	= Integer.valueOf(dataString.substring(3,5)) - 1;
			int ano		= Integer.valueOf(dataString.substring(6));
			data.set(ano, mes, dia);
			return true;
		}else {
			return false;
		}
		
		
	}

	/**
	 * Método subtrairDatas - Calcular diferença entre duas datas em dias
	 * @param dt1 - data de inicio do intervalo
	 * @param dt2 - data final do intervalo 
	 * @return inteiro tipo long com o número de dias entre as datas 
	 */	
	public static long subtrairDatas (GregorianCalendar dt1, GregorianCalendar dt2) {return 000;}
	
	/**
	 * Método subtrairHoras - Calcular a diferença entre duas datas em horas
	 * @param dt1 - data/hora de inicio do intervalo
	 * @param dt2 - data/hora final do intervalo 
	 * @return tipo double com o número de horas entre as datas 
	 */		
	public static double subtrairHoras (GregorianCalendar dt1, GregorianCalendar dt2) { return 00; }
	
	/**
	 * Método formatarMilisegundos - Mostrar as horas formatada
	 * @param miliseg - representa as horas em milisegundos
	 * @return um String formatado com hhh:mm:ss
	 */		
	public static String formatarMilissegundos(long miliseg) { return "x"; }
	
	/**
	 * Método valorExtenso - Mostrar o valor por extenso
	 * @param valor - representa o valor em reais
	 * @return um String formatado com o valor por extenso 
	 */		
	public static String valorExtenso (double valor) { return "x"; }
		
}


/* 	•	Tamanho da String tem que ser 11
	•	Todos os caracteres devem ser numéricos
	•	Não pode pertencer ao conjunto 111111111, 22222222222, 333333333, 444444444, 555555555, 666666666, 777777777, 888888888, 999999999
		[0-9]{11}
	
	Calculo do DV do CPF => CPF => abc.def.ghi-xy

		Passo-1:	       T1 = a*10 + b*9 + c*8 + d*7 + e*6 + f*5 + g*4 + h*3 + i*2
	       x = 11 – (T1 % 11)   ;    se  x > 9 então x = 0
	       
		Passo-2:	       T2 = a*11 + b*10 + c*9 + d*8 + e*7 + f*6 + g*5 + h*4 + i*3 + x*2
		
	       y = 11 – (T2 % 11)   ;     se  y > 9 então y = 0
		Passo-3:	       DV = xy

*/
