package model;
	//esqueleto do corpo do administrador
public class Administrador extends Pessoa {
	//atributos do administrador
	private int id;
	private String cargo;
	private String login;
	private String senha;
	//metodos do administrador gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
