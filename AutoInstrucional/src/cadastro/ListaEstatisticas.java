package cadastro;



import java.util.ArrayList;

import dados.Estatistica;
public class ListaEstatisticas {
	ArrayList<Estatistica> estatisticas = new ArrayList<>();
	
	private void inserirEstatistica (Estatistica est){
		estatisticas.add(est);
	}
	
	private ArrayList<Estatistica> pegarEstatisticas (){
		return estatisticas;
	}
}
