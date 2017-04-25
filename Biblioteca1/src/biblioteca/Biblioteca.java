package biblioteca;
import java.util.GregorianCalendar;
import java.lang.Math;
//import java.util.regex.*;
//import java.text.ParseException;
//import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Biblioteca {
	
	/**
	 * Método para validar CPF
	 * @param cpf
	 * @return
	 */
	public static boolean validarCPF(String cpf){
		// TODO: Travar cpf com sequencia de numeros iguais!
		//	   : Travar 11 caracteres de cpf
		
		String[] numeros 	= cpf.split("");
		String dv 			= numeros[9]+numeros[10];
		int t1 				= 0;
		int t2 				= 0;
		int x;
		int y;
		String xy;
		
		if (! (	cpf.length() > 11) && !(cpf.equals("11111111111") || 
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999") ||
				cpf.equals("00000000000"))){
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
		}else {
			return false;
		}
	}
	
	/**
	 * Método para validar CNPJ
	 * @param cpnj
	 * @return
	 */
	public static boolean validarCPNJ(String cnpj){
		//partest1
		String parte1[] = cnpj.substring(0,4).split("");
		String parte2[] = cnpj.substring(4,8).split("");
		String parte3[] = cnpj.substring(8,12).split("");
		
		//partes t2
		String parte1T2[] = cnpj.substring(0, 5).split("");
		String parte2T2[] = cnpj.substring(5, 8).split("");
		String parte3T2[] = cnpj.substring(8, 12).split("");
		
		String dv = cnpj.substring(12);
		int t1 = 0;
		int t2 = 0;
		int contadorUm 		= 0;
		int contadorDois 	= 0;
		int x;
		int y;
		if (!(cnpj.length() > 14)){
			// montando t1
			for (int i = 9; i > 1;i-- ){
							
				if (i == 9 || i > 5){
					t1 += Integer.parseInt(parte2[contadorUm])*i;
					contadorUm++;
				}else {
					t1 += (Integer.parseInt(parte1[contadorDois])+Integer.parseInt(parte3[contadorDois]))*i;
					contadorDois++;
				}
			}
			x = 11- (t1%11);
			if (x > 9){
				x = 0;
			}
			contadorUm	 = 0;
			contadorDois = 0;
			// montando t2
			for (int i = 9; i > 1;i-- ){
				if (i == 9 || i > 6){
					t2 += Integer.parseInt(parte2T2[contadorUm])*i;
					contadorUm++;
				}else if (i == 2){
					t2 += (Integer.parseInt(parte1T2[contadorDois])*i)+x*i;
					contadorDois++;
				}else {
					t2 += (Integer.parseInt(parte1T2[contadorDois])+Integer.parseInt(parte3T2[contadorDois]))*i;
					contadorDois++;
				}
			}
			
			y = 11 - (t2%11);
			if (y > 9){
				y = 0;
			}
			return (""+x+y).equals(dv) ? true:false;
		}else {
			return false;
		}
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
	public static boolean validarPIS (String pis) { 
		String parteUm[] 	= pis.substring(0,2).split("");
		String parteDois[] 	= pis.substring(2, 8).split("");
		String parteTres[]	= pis.substring(8,10).split("");

		int contador = 0;
		int contadorDois = 0;
		int t1 = 0;
		int dv = Integer.parseInt(pis.substring(10));
		int x;
		
		for (int i = 9; i > 1;i --){
			if (i == 9 || i > 3){
				t1 += Integer.parseInt(parteDois[contador]) * i;
				contador++;
			}else {
				t1 += Integer.parseInt(parteUm[contadorDois]) * i + Integer.parseInt(parteTres[contadorDois]) * i;
				contadorDois++;
			}
		}
		x = 11 - (t1 % 11);
		
		if (x > 9){
			x = 0;
		}
		
		return x == dv ? true:false;
	}
	
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
			c.setLenient(false); //faz com que não exista possibilidade de valores errados para mes,dia ou ano
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
	public static long subtrairDatas (GregorianCalendar dt1, GregorianCalendar dt2) {
		long msdt1 = dt1.getTimeInMillis();
		long msdt2 = dt2.getTimeInMillis();
		
		long days = (msdt2 - msdt1)/ (1000 * 60 * 60 * 24);
		
		return days;
	}
	
	/**
	 * Método subtrairHoras - Calcular a diferença entre duas datas em horas
	 * @param dt1 - data/hora de inicio do intervalo
	 * @param dt2 - data/hora final do intervalo 
	 * @return tipo double com o número de horas entre as datas 
	 */		
	public static double subtrairHoras (GregorianCalendar dt1, GregorianCalendar dt2) { 
		long msdt1 = dt1.getTimeInMillis();
		long msdt2 = dt2.getTimeInMillis();
		
		long hours = (msdt2 - msdt1)/(1000 * 60 * 60);
		
		return hours; 
	}
	
	/**
	 * Método formatarMilisegundos - Mostrar as horas formatada
	 * @param miliseg - representa as horas em milisegundos
	 * @return um String formatado com hhh:mm:ss
	 */		
	public static String formatarMilissegundos(long miliseg) { 
		
		SimpleDateFormat objFormatacao = new SimpleDateFormat("HH:mm:ss");
		String formatado = objFormatacao.format(miliseg);
		return formatado; 
	}
	
	/**
	 * Método valorExtenso - Mostrar o valor por extenso
	 * @param valor - representa o valor em reais
	 * @return um String formatado com o valor por extenso 
	 */		
	public static String valorExtenso (double valor) { 
		
		String[] unidade = {"", "um", "dois", "três", "quatro", "cinco",
	             "seis", "sete", "oito", "nove", "dez", "onze",
	             "doze", "treze", "quatorze", "quinze", "dezesseis",
	             "dezessete", "dezoito", "dezenove"};
	    String[] centena = {"", "cento", "duzentos", "trezentos",
	             "quatrocentos", "quinhentos", "seiscentos",
	             "setecentos", "oitocentos", "novecentos"};
	    String[] dezena = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
	             "sessenta", "setenta", "oitenta", "noventa"};
	    String[] qualificaS = {"", "mil", "milhão", "bilhão", "trilhão"};
	    String[] qualificaP = {"", "mil", "milhões", "bilhões", "trilhões"};
	   
		// primeiro temos que pegar a parte inteira e racional
	    double inteiro    	= (double) Math.abs(valor);
	    String inteiroStr 	= String.valueOf(inteiro);
	    double racional		= (valor - inteiro);
	    int tamanho 		= inteiroStr.length();
	    int unidades;
	    int dezenas;
    	int centenas;
    	int milhares;
    	int u = 0;
    	int d = 0;
    	int c = 0;
    	
	    if (tamanho > 3 && tamanho < 7){
	    	// estamos nos milhares
	    	unidades = Integer.parseInt(inteiroStr.substring(tamanho - 1));
	    	dezenas  = Integer.parseInt(inteiroStr.substring(tamanho - 2, tamanho - 1));
	    	centenas = Integer.parseInt(inteiroStr.substring(tamanho - 3 , tamanho - 2));
	    	milhares = Integer.parseInt(inteiroStr.substring(0 , tamanho - 3)); // milhares precisa de um tratamento extra
	    	
	    	if (String.valueOf(milhares).length() == 2){

	    		u 	= Integer.parseInt(String.valueOf(milhares).substring(1, 2));
	    		d  	= Integer.parseInt(String.valueOf(milhares).substring(0,1));
	    		
	    	}else if(String.valueOf(milhares).length() == 3){
	    		
	    		u 	= Integer.parseInt(String.valueOf(milhares).substring(2, 3));
	    		d  	= Integer.parseInt(String.valueOf(milhares).substring(1,2));
	    		c 	= Integer.parseInt(String.valueOf(milhares).substring(0,1));
	    	}else {
	    		u 	= Integer.parseInt(String.valueOf(milhares).substring(0, 1));
	    	}
	    	System.out.println(centena[c]+" e " +dezena[d]+" e " +unidade[u]+" mil "+ centena[centenas]+" e "+dezena[dezenas] +" e " + unidade[unidades]);
	    }else if (tamanho > 6 && tamanho < 10){
	    	// estamos nos milhões
	    }
		return "Inteiro: "+inteiro +" Racional: "+ racional; 
	}
	
}


