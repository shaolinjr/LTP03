package teste;

import utilitarios.Console;

/**
 * Expressões Regulares
 * @author Erix Morato
*/
public class TesteExpRegular {
	
	public static void main(String[] args) {
		
		System.out.println("\nEXPRESSÕES REGULARES\n");
		
		expreg:
		while (true) {

			String expRegular = Console.readLine("\nINFORME A EXPRESSÃO REGULAR (§S-SAIR) : ");
			
			if (expRegular.equalsIgnoreCase("§S")) break; // flag §S para sair do aplicativo
			
			String dado;
			while (true) {

				System.out.println();
				dado = Console.readLine("INFORME O DADO (§S-SAIR ; §E-OUTRA EXPRESSÃO): ");
				
				if (dado.equalsIgnoreCase("§E")) break; // flag §E para sair para testar outra exp. regular
				if (dado.equalsIgnoreCase("§S")) break expreg; // flag §S para sair do aplicativo
				
				System.out.println("VERIFICAÇÃO DE CONFORMIDADE DO DADO EM RELAÇÃO A EXP. REGULAR: " 
				+ (validarDados(expRegular, dado)?"CORRETO":"INCORRETO"));
			}
		}
		
		System.out.println("\nFINAL DOS TESTES DE EXPRESSÕES REGULARES.");
		System.exit(0);
	}

	private static boolean validarDados(String expRegular, String dado) {
		
		try {
			return dado.matches(expRegular);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Escrever o erro na expressão regular
			return false;
		}
		
	}
}
