package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Livro {
     private int codigo;
     private String titulo;
     private String autor;
     private GregorianCalendar data;
     
     private static int numero = 0;

     // Construtor
     public Livro(String titulo, String autor) {
    	codigo = ++numero;
    	this.titulo = titulo;
		this.autor = autor;
		data = new GregorianCalendar();
	}

	public Livro(int codigo, String titulo, String autor, GregorianCalendar data) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
	}

	  //get e set

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public GregorianCalendar getData() {
		return data;
	}
    
	public String toString() {
		return
			"Código: " + codigo + "\n" +
			"Titulo: " + titulo + "\n" +
			"Autor:  " + autor + "\n" +
			"Data: " + LtpUtil.formatarData(data, "EEEE dd/MM/yyyy HH:mm") + "\n";
	}
	
	public Livro clone() {
		return new Livro(codigo, titulo, autor, data);
	}
	
	public boolean equals(Livro objLivro) {
		return 
				codigo == objLivro.codigo &&
				titulo.equals(objLivro.titulo) &&
				autor.equals(objLivro.autor) &&
				data.equals(objLivro.data);
	}
     
    
     
}


