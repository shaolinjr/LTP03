package teste;

import utilitarios.Console;


/**
 * Express�es Regulares
 * @author Erix Morato
*/
public class Teste {
	
	public static void main(String[] args) {
		
		
		System.out.println("\nTESTE DE EXPRESS�ES REGULARES\n");
		
		expreg:
		while (true) {

			String expRegular = Console.readLine("\nEXPRESS�O REGULAR: ");
			
			if (expRegular.equalsIgnoreCase("�S")) break; // flag �S para sair do aplicativo
			
			String dado;
			while (true) {

				dado = Console.readLine("\nDADO (�E-OUTRA EXPRESS�O,�S-SAIR) : ");
				
				if (dado.equalsIgnoreCase("�E")) break; // flag �E para sair para testar outra exp. regular
				if (dado.equalsIgnoreCase("�S")) break expreg; // flag �S para sair do aplicativo
				
				System.out.println("VALIDA��O DO DADO EM CONFORMIDADE COM A EXPRESS�O REGULAR: " 
				                   + validarDados(expRegular, dado));
			}
		}
		
		System.out.println("\nFINAL DOS TESTES DAS EXPRESS�ES REGULARES.");
		System.exit(0);
	}
	
	/**
	 * VALIDA��O DO DADO EM CONFORMIDADE COM A EXPRESS�O REGULAR
	 * @param expRegular
	 * @param dado
	 * @return true para dado correto ou false para incorreto
	 */
	private static boolean validarDados(String expRegular, String dado) {
		
		try {
			return dado.matches(expRegular);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Escrever o erro na express�o regular
			return false;
		}
		
	}
	
	// Exemplo exp. reg. para e-mail: "[A-Za-z0-9_]{1,}([.][A-Za-z0-9_]+){0,}+@[a-zA-Z0-9]{2,}[.][a-zA-Z0-9]{2,}([.][a-zA-Z0-9]{2,})?"
}
