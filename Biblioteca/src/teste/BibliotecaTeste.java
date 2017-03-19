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
		String cpf = "46476806653";
		
		System.out.println(Biblioteca.validarCPF(cpf));
	}
	
	public static void validaData (){
		String data 	= "29/02/2007"; // should return false
		String data2	= "14/02/1963"; // should return true
		String data3    = "12.02..1998"; // should return false
		GregorianCalendar dt = new GregorianCalendar();
		System.out.println(Biblioteca.validarData(data));
		System.out.println(Biblioteca.validarData(data2));
		System.out.println(Biblioteca.validarData(data3));
		System.out.println(Biblioteca.validarData(data2, dt));
		System.out.println(new SimpleDateFormat("EEEE dd/MM/yyyy").format(dt.getTime()));
	}
	
	
	public static void main(String[] args) {
	// Teste validação email
//		validaEmail();
		
	// Teste de contador de palavras
//		validaContadorPalavras();
	
	// Teste de padronização de texto
//		validaPadronizacaoTexto();
		
	// Teste validação cpf
//		validaCPF();
		
		
	// Teste validacao data
		validaData();
	
	}

}
