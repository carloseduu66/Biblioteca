package model;
	//esqueleto do corpo da pessoa
public abstract class Pessoa {
	//atributos da classe pessoa
	private String nome;
	private String genero;
	//metodos da classe pessoa
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
