package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.lang.StringBuilder;
public class Livro {

	private int codigo;
	private String titulo;
	private ArrayList<String> autor = new ArrayList<String>(); // usamos arrayList para permitir mais de um autor em um mesmo livro 
	private GregorianCalendar data 	= new GregorianCalendar();
	
//	MÃ©todo Construtor
	public Livro(int codigo, String titulo, ArrayList<String> autor, GregorianCalendar data) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
	}

// Sets and Getters
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public ArrayList<String> getAutor() {
		return autor;
	}


	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}


	public GregorianCalendar getData() {
		return data;
	}


	public void setData(GregorianCalendar data) {
		this.data = data;
	}

// MÃ©todo toString	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		for (String value : autor) {
		  builder.append(value+", ");
		 
		}
		builder.deleteCharAt(builder.length()-1);
		
		return "Código...........: " + codigo + 
				"\nTítulo........: " + titulo + 
				"\nAutor(es).....: " + builder.toString() +
				"\nData..........: " + data.getTime();
	}
	
	
	
	
}
