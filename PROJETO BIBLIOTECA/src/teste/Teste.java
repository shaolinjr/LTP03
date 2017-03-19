package teste;

import java.util.Scanner;

import biblioteca.Biblioteca;

public class Teste {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o textO: ");
		String texto = entrada.nextLine();
		String texto1 = Biblioteca.padronizarTexto(texto);
		System.out.println("Texto: " + texto);		
		System.out.println("Resposta: " + texto1);

	}

}
