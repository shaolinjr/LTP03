import java.util.*;
public class Exerc4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leia = new Scanner(System.in);
		
		String nomes[] = new String[100];
		
		int 	numeroPecas,
				codigoFuncionario[] = new int[100],
				funcionario = 0;
		
		float 	salarios[] = new float[100],
				somaSalarios = 0,
				mediaSalarios = 0;
		
		for (funcionario = 0; funcionario < nomes.length; funcionario++){
			
			do{
				System.out.print("Digite seu nome (digite fim para sair): ");
				nomes[funcionario] = leia.nextLine();
				
				if (nomes[funcionario].equals("")){
					System.out.println("Nome inválido. Digite novamente.");
				}else if (nomes[funcionario].equalsIgnoreCase("FIM")) {
					break;
				}
			}while(nomes[funcionario].equals(""));
			if (nomes[funcionario].equalsIgnoreCase("FIM")){
				System.out.println("Saindo...");
				nomes[funcionario] = null;
				funcionario--;
				break;
			}
			do {
				System.out.print("Digite seu código: ");
				codigoFuncionario[funcionario] = leia.nextInt();
				
				if (codigoFuncionario[funcionario] < 0 || codigoFuncionario[funcionario] > 999){
					System.out.println("Código inválido. Digite novamente.");
				}
			}while(codigoFuncionario[funcionario] < 0 || codigoFuncionario[funcionario] > 999);
			
			do {
				System.out.print("Digite o número de peças produzidas: ");
				numeroPecas = leia.nextInt();
				
				if (numeroPecas < 0){
					System.out.println("Número de peças inválido. Digite novamente.");
				}
			}while(numeroPecas < 0);
			
			salarios[funcionario] = calculaSalario(numeroPecas);
			somaSalarios += salarios[funcionario];
			
			leia.nextLine();
		}
		
		// imprimir resultados finais
		mediaSalarios = (float) somaSalarios/funcionario;
		System.out.println("Nome\tSalário\tMédia Salários\n--------\t---------\t-------");
		for (int x = 0; x < nomes.length; x++){
			System.out.print(nomes[x]+"\t");
			System.out.print(salarios[x]+"\t");
			System.out.print(mediaSalarios+"\t");
		}
	}
	
	public static float calculaSalario(int numeroPecas){
		// calcular salario
		float salario;
		if (numeroPecas <= 200){
			salario = (float) 2* numeroPecas;
		}else if (numeroPecas <= 400){
			salario = (float) 2.30 * numeroPecas;
		}else {
			salario = (float) 2.50 * numeroPecas;
		}
		 return salario;	
	}

}
