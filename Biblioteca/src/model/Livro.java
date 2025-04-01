package model;
	//Esqueleto do corpo do livro
public class Livro {
	//atributos da classe livros
	private int codigo;
	private String titulo_Livro;
	private String autor_Livro;
	private String genero;
	
	// metodos da classe livro
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo_Livro() {
		return titulo_Livro;
	}

	public void setTitulo_Livro(String titulo_Livro) {
		this.titulo_Livro = titulo_Livro;
	}

	public String getAutor_Livro() {
		return autor_Livro;
	}

	public void setAutor_Livro(String autor_Livro) {
		this.autor_Livro = autor_Livro;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
