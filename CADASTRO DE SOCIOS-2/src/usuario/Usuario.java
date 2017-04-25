 package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import cadastro.CadSocios;
import dados.Dependente;
import dados.Socio;
import erros.SocioException;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class Usuario {


	public static void main(String[] args) {

		if (new File("SOCIOS.obj").exists()) {
			lerArquivo();
		}
		
		menu();
		
		gravarArquivo();
		System.out.println("\n" + "Finalização do aplicativo");
		System.exit(0);
	}

	private static void lerArquivo() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream("SOCIOS.obj"));
			CadSocios.cadSocios = (HashMap<String,Socio>)inp.readObject();
			inp.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void gravarArquivo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SOCIOS.obj"));
			out.writeObject(CadSocios.cadSocios);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\n1-Incluir Sócio");
			System.out.println("2-Pesquisar socio pelo CPF");
			System.out.println("3-Pesquisar sócios pelo nome");
			System.out.println("4-Incluir dependente");
			System.out.println("5-Excluir dependente");
			System.out.println("0-Sair");
			opcao=Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluirSocio();
					break;
				case 2:
					pesqSocioCpf();
					break;
				case 3:
					pesqSocioNome();
					break;
				case 4:
					incluirDep();
					break;
				case 0 :
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
		} while (opcao!=0);
		
	}

	private static void incluirSocio() {
		
		System.out.println("\n" + "Incluir Sócio" + "\n");
		
		// Dados do Sócio
		
		String cpf;
		
		while (true) {
			cpf = Console.readLine("CPF: ");
			if (!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF Inválido.");
				continue;
			}
			try {
				Socio obj = CadSocios.pesqSocioCpf(cpf);	
				System.out.println("Já existe Sócio para o CPF com os dados abaixo:\n" );
				System.out.println(obj.toString());
			} catch (SocioException e) {
				break;
			}
		}
		
		String nome;
		
		while (true) {
			nome = Console.readLine("Nome: ").trim();
			if (nome.isEmpty()) {
				System.out.println("Falta informar o nome.");
			} else break;
			
		}
		
		GregorianCalendar entrada = new GregorianCalendar();
		
		while (true) {
			String data = Console.readLine("Entrada: ");
			if ( !LtpUtil.validarData(data, entrada)) {
				System.out.println("Data de entrada inválida.");
				continue;
			}
			if (entrada.after(new GregorianCalendar())) {
				System.out.println("Data de entrada superior a data de hoje.");
			} else break;
		}
		
		// Dados dos Dependentes
		
		System.out.println("\nDependentes\n");
		
		int numDependentes = Console.readInt("Número de dependentes: ");
		
		ArrayList<Dependente> dependentes = new ArrayList<>();
		
		for (int i = 1 ; i <= numDependentes; i++ ) {
			System.out.println();
			String nomeDep;
			while (true) {
				nomeDep = Console.readLine("Nome do dependente: ").trim();
				if (nomeDep.isEmpty()) {
					System.out.println("Falta informar o nome do dependente.");
				} else break;
			}
			GregorianCalendar nascimento = new GregorianCalendar();
			
			while (true) {
				String nasc = Console.readLine("Nascimento: ");
				if ( !LtpUtil.validarData(nasc, nascimento)) {
					System.out.println("Data de nasc. inválida.");
					continue;
				}
				if (nascimento.after(new GregorianCalendar())) {
					System.out.println("Data de nasc. superior a data de hoje.");
				} else break;
			}
			
			String tipo = Console.readLine("Tipo da dependência: ");
			
			Dependente objDep = new Dependente(nomeDep, nascimento, tipo);
			dependentes.add(objDep);
		}
		
		// Finalização do metodo
		
		Socio objSocio = new Socio(cpf, nome, entrada, dependentes);
		
		CadSocios.incluirSocio(objSocio);
		
		System.out.println("\n" + "Sócio cadastrado com Sucesso." + "\n");
	}
	
	private static void pesqSocioCpf() {
		
		System.out.println("\n" + "Pesquisar Sócio pelo CPF" + "\n");
		
		String cpf = Console.readLine("CPF: ");
		try {
			Socio obj = CadSocios.pesqSocioCpf(cpf);
			
			System.out.println("\nDados do Sócio\n");
			System.out.println(obj.toString());
			
			if (!obj.getDependentes().isEmpty()) {
				
				System.out.println("\nDados dos Dependentes\n");
				for (Dependente objDep : obj.getDependentes() ) {
					System.out.println(objDep.toString());
				}
				System.out.println("TOTAL DE DEPENDENTES: " + obj.getDependentes().size());
			}
			
			System.out.println("\nPesquisa concluída\n");
			
		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void pesqSocioNome() {
		
		System.out.println("\n" + "Pesquisar Sócio pelo NOME" + "\n");
		
		ArrayList<Socio> sociosSelecionados = CadSocios.pesqSociosNome(Console.readLine("Nome: "));
		for (Socio obj : sociosSelecionados) System.out.println(obj.toString());
		System.out.println("TOTAL: " + sociosSelecionados.size());
		
		
	}
	

	private static void incluirDep() {
		System.out.println("\n" + "Incluir Dependente para o Sócio" + "\n");
		
		try {
			// SOCIO
			
			String cpf = Console.readLine("CPF DO SÓCIO: ");
			Socio objSocio = CadSocios.pesqSocioCpf(cpf);
			System.out.println(objSocio.toString());
			
			// DEPENDENTE

			System.out.println("\nDADOS DO NOVO DEPENDENTE\n");
			
			String nomeDep;
			while (true) {
				nomeDep = Console.readLine("Nome do dependente: ").trim();
				if (nomeDep.isEmpty()) {
					System.out.println("Falta informar o nome do dependente.");
					continue;
				} 
				try {
					Dependente objDep = objSocio.pesqDependenteNome(nomeDep);	
					System.out.println("Já existe Dependente para o Sócio com os dados abaixo:\n" );
					System.out.println(objDep.toString());
				} catch (SocioException e) {
					break;
				}
				
			}
			GregorianCalendar nascimento = new GregorianCalendar();
			
			while (true) {
				String nasc = Console.readLine("Nascimento: ");
				if ( !LtpUtil.validarData(nasc, nascimento)) {
					System.out.println("Data de nasc. inválida.");
					continue;
				}
				if (nascimento.after(new GregorianCalendar())) {
					System.out.println("Data de nasc. superior a data de hoje.");
				} else break;
			}
			
			String tipo = Console.readLine("Tipo da dependência: ");
			
			objSocio.incluirDependente(new Dependente(nomeDep, nascimento, tipo));
			
			System.out.println("\n" + "Novo Dependente do Sócio cadastrado com Sucesso." + "\n");
			
		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}







