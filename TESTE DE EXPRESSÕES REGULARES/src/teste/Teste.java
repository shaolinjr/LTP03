package teste;

import utilitarios.Console;


/**
 * Expressões Regulares
 * @author Erix Morato
*/
public class Teste {
	
	public static void main(String[] args) {
		
		
		System.out.println("\nTESTE DE EXPRESSÕES REGULARES\n");
		
		expreg:
		while (true) {

			String expRegular = Console.readLine("\nEXPRESSÃO REGULAR: ");
			
			if (expRegular.equalsIgnoreCase("§S")) break; // flag §S para sair do aplicativo
			
			String dado;
			while (true) {

				dado = Console.readLine("\nDADO (§E-OUTRA EXPRESSÃO,§S-SAIR) : ");
				
				if (dado.equalsIgnoreCase("§E")) break; // flag §E para sair para testar outra exp. regular
				if (dado.equalsIgnoreCase("§S")) break expreg; // flag §S para sair do aplicativo
				
				System.out.println("VALIDAÇÃO DO DADO EM CONFORMIDADE COM A EXPRESSÃO REGULAR: " 
				                   + validarDados(expRegular, dado));
			}
		}
		
		System.out.println("\nFINAL DOS TESTES DAS EXPRESSÕES REGULARES.");
		System.exit(0);
	}
	
	/**
	 * VALIDAÇÃO DO DADO EM CONFORMIDADE COM A EXPRESSÃO REGULAR
	 * @param expRegular
	 * @param dado
	 * @return true para dado correto ou false para incorreto
	 */
	private static boolean validarDados(String expRegular, String dado) {
		
		try {
			return dado.matches(expRegular);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Escrever o erro na expressão regular
			return false;
		}
		
	}
	
	// Exemplo exp. reg. para e-mail: "[A-Za-z0-9_]{1,}([.][A-Za-z0-9_]+){0,}+@[a-zA-Z0-9]{2,}[.][a-zA-Z0-9]{2,}([.][a-zA-Z0-9]{2,})?"
}
