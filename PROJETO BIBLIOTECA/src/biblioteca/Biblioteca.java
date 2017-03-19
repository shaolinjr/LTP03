package biblioteca;

public class Biblioteca {

	/**
	 * Padronizar texto
	 * @param texto
	 * @return o texto conforme padrão (sem espaços na extremidade..
	 */
	public static String padronizarTexto(String texto) {
		String aux = texto.trim(); // retira espaçõs na extremidade
		while (aux.contains("  ")) {
			aux = aux.replace("  ", " ");
		}
		return aux;
	}
}
