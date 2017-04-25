package usuario;

import utilitarios.Console;

import dados.Visita;
import cadastro.CadastroVisita;

public class Usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int escolha;
			do {
				menu();
				do {
					escolha = Console.readInt("Digite sua escolha: ");
					
					if (escolha < 1 || escolha > 4){
						System.out.println("Erro! Opção inválida!");
					}else if (escolha == 4){
						System.out.println("Saindo...");
						System.exit(0);
					}
				}while(escolha < 1 || escolha > 4);
				switch (escolha){
				case 1:
					novaVisita();
					break;
				case 2:
					registrarSaida();
					break;
				case 3:
					consultarPorCPF();
					
					break;
			}
		}while(true);
			
		
	}
	
	public static void menu (){
		
		System.out.println("********** MENU: **********");
		
			
			System.out.println("1) Cadastrar nova visita");
			System.out.println("2) Cadastrar saída de visita");
			System.out.println("3) Pesquisar visita pelo CPF");
			System.out.println("4) Sair");
		
		
	}
	
	public static void novaVisita (){
		String cpf;
		do {
			cpf = Console.readLine("Digite seu cpf para novo cadastro: ");
			
			if (cpf.length() < 11 || cpf.length() > 11){
				System.out.println("CPF inválido!");
			}
		}while(cpf.length() < 11 || cpf.length() > 11);
		
		CadastroVisita.cadastrarVisita(cpf);
		
	}
	
	public static void consultarPorCPF (){
		String cpf;
		do {
			cpf = Console.readLine("Digite seu cpf para consulta: ");
			
			if (cpf.length() < 11 || cpf.length() > 11){
				System.out.println("CPF inválido!");
			}
		}while(cpf.length() < 11 || cpf.length() > 11);
		
		System.out.println(CadastroVisita.consultaPorCPF(cpf));
	}
	
	public static void registrarSaida (){
		String cpf;
		do {
			cpf = Console.readLine("Digite seu cpf para registrar saída: ");
			
			if (cpf.length() < 11 || cpf.length() > 11){
				System.out.println("CPF inválido!");
			}
		}while(cpf.length() < 11 || cpf.length() > 11);
		
		CadastroVisita.cadastrarSaida(cpf);
	}
}
