package teste;



import java.awt.font.NumericShaper.Range;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import biblioteca.Biblioteca;

public class BibliotecaTeste {
	
	public static void validaEmail(){
		String email 		= "arthurclp@icloud.com";
		String email2 		= "arthur.pires@yeah.com.br";
		String emailFalse 	= "arthur@.com";
		
		System.out.println(Biblioteca.validarEmail(email));
		System.out.println(Biblioteca.validarEmail(emailFalse));
		System.out.println(Biblioteca.validarEmail(email2));
	}
	
	public static void validaContadorPalavras (){
		String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Praesent in tristique     tellus,  eu     viverra lorem. Aenean tortor libero, "
				+ "facilisis eget ipsum dapibus,      auctor ultrices orci. Vestibulum dapibus "
				+ "aliquet neque, id iaculis magna aliquet placerat. Nullam euismod lacus "
				+ "sit amet ipsum       malesuada finibus. Phasellus pulvinar quam nibh, ut faucibus "
				+ "est finibus quis.   Lorem     ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Duis ut felis nec  ligula  posuere mollis.";  // Possui 66 palavras
			
		System.out.println(Biblioteca.contarPalavras(texto));
	}
	
	public static void validaPadronizacaoTexto (){
		String textoEspacos = "   Arthur    de Castro    ";
		System.out.println(Biblioteca.padronizarTexto(textoEspacos));
	}
	
	public static void validaCPF (){
		String cpf = "09464525630";
		
		System.out.println(Biblioteca.validarCPF(cpf));
	}
	
	public static void validaData (){
		String data 	= "33/06/2007"; // should return false
		String data2	= "14/02/1963"; // should return true
		String data3    = "12.02..1998"; // should return false
		GregorianCalendar dt = new GregorianCalendar();
		System.out.println(Biblioteca.validarData(data));
		System.out.println(Biblioteca.validarData(data2));
		System.out.println(Biblioteca.validarData(data3));
		System.out.println(Biblioteca.validarData(data2, dt));
		System.out.println(new SimpleDateFormat("EEEE dd/MM/yyyy").format(dt.getTime()));
	}
	
	public static void validaSubtrairDatas (){
		GregorianCalendar dt1 = new GregorianCalendar(1998, GregorianCalendar.JANUARY, 12);
		GregorianCalendar dt2 = new GregorianCalendar(1998,GregorianCalendar.FEBRUARY, 12);
		
		System.out.println(Biblioteca.subtrairDatas(dt1, dt2));
	
	}
	
	public static void validaSubtrairHoras (){
		GregorianCalendar dt1 = new GregorianCalendar(1998, GregorianCalendar.JANUARY, 12);
		dt1.set(GregorianCalendar.HOUR_OF_DAY, 10);
		dt1.set(GregorianCalendar.MINUTE, 30);
		GregorianCalendar dt2 = new GregorianCalendar(1998,GregorianCalendar.JANUARY, 12);
		dt2.set(GregorianCalendar.HOUR_OF_DAY, 12);
		dt2.set(GregorianCalendar.MINUTE, 30);
		System.out.println(Biblioteca.subtrairHoras(dt1, dt2));
	}
	
	public static void validaValorPorExtenso (){
		System.out.println(Biblioteca.valorExtenso(5425.50));
	}
	public static void main(String[] args) {
		
	// Teste validação email
//		validaEmail();
		
	// Teste de contador de palavras
//		validaContadorPalavras();
	
	// Teste de padronização de texto
//		validaPadronizacaoTexto();
		
	// Teste validação cpf
		validaCPF();
		
		
	// Teste validacao data
//		validaData();
	
		// Teste subtrair datas
//		validaSubtrairDatas();
		
		// Teste subtrair horas
//		validaSubtrairHoras();
		
//		System.out.println(Biblioteca.validarCPNJ("61838318000130"));
		
		System.out.println(Biblioteca.validarPIS("11726295413"));
		
	}

public static String separarPartes (double valor){
	int aux = (int) Math.abs(valor);
	String valorStr = String.valueOf(aux);
	int tamanho = valorStr.length();
	String pt1 = "";
	String pt2 = "";
	String pt3 = "";
	
	if (tamanho > 3 && tamanho < 7){
		pt1 = valorStr.substring(0, valorStr.length() - 3);
		pt2 = valorStr.substring(valorStr.length() - 3, valorStr.length());
	}
	return pt1 + " " + pt2;
//	System.out.println("Parte 01: "+pt1+" Parte 02: "+pt2);
}
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
	    int inteiro    		= (int) Math.abs(valor);
	    String inteiroStr 	= String.valueOf(inteiro);
	    double racional		= (valor - inteiro);
	    int tamanho 		= inteiroStr.length();
	    int unidades;
	    int dezenas;
    	int centenas;
    	int milhares;
    	int u 	= 0;
    	int d 	= 0;
    	int c	= 0;
    	int pt1 = 0;
    	int pt2 = 0;
    	int pt3 = 0;
    	String extenso = "";
    	if(tamanho <= 3){
    		// estamos nos numeros menores
    		// 1 => 1
    		// 10 => 2
    		// 100 => 3
		}else if (tamanho > 3 && tamanho < 7){
	    	// estamos nos milhares
	    	// 1 000 => 4
	    	// 10 000 => 5
	    	// 100 000 => 6
			pt1 = Integer.parseInt(inteiroStr.substring(0, tamanho - 3));
			pt2 = Integer.parseInt(inteiroStr.substring(tamanho - 3, tamanho));
			// montando extenso dos milhares
			if(pt1 == 1){
				extenso += unidade[1] + " " + qualificaS[1]+", ";
			}else {
				c = (int) pt1 /100;
				d = (int) (pt1 % 100) / 10;
				u = (int) (pt1 % 100) % 10;

				if (c != 0 && u != 0 && d != 0){
					extenso += centena[c] + " e "+ dezena[d] + " e " + unidade[u];
				}else if (u != 0){
					extenso += dezena[d] + " e " + unidade[u];
				}else {
					extenso += dezena[d];
				}
				extenso += " "+qualificaS[1];
			}
	    }else if (tamanho > 6 && tamanho < 10){
	    	// estamos nos milhões
	    	// 1 000 000 => 7
	    	// 10 000 000 => 8
	    	// 100 000 000 => 9
	    }else if (tamanho > 9 && tamanho < 13){
	    	// estamos nos bilhões
	    	// 1 000 000 000 => 10
	    	// 10 000 000 000 => 11
	    	// 100 000 000 000 => 12
	    }else if (tamanho > 12 && tamanho < 16){
	    	// estamos nos trilhões
	    	// 1 000 000 000 000 => 13
	    	// 10 000 000 000 000 => 14
	    	// 100 000 000 000 000 => 15
	    }else {
	    	// numero muito grande
	    }
		return extenso; 
	}

}
