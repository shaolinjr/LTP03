package biblioteca;

public class Biblioteca {

	/**
	 * Padronizar texto
	 * @param texto
	 * @return o texto conforme padr�o (sem espa�os na extremidade..
	 */
	public static String padronizarTexto(String texto) {
		String aux = texto.trim(); // retira espa��s na extremidade
		while (aux.contains("  ")) {
			aux = aux.replace("  ", " ");
		}
		return aux;
	}
}
