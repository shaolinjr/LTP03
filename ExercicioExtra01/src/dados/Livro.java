package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Livro {

	private int codigo;
	private String titulo;
	private ArrayList<String> autor = new ArrayList<String>(); // usamos arrayList para permitir mais de um autor em um mesmo livro 
	private GregorianCalendar data 	= new GregorianCalendar();
	
//	Método Construtor
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

// Método toString	
	public String toString() {
		return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", data=" + data + "]";
	}
	
	
	
	
}
