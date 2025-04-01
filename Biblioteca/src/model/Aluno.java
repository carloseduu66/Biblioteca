package model;
	//esqueleto da classe aluno
public class Aluno extends Pessoa{
	//atributos da classe aluno
	private String matricula;
	private String email;
	private String login;
	private String senha;
	private String curso;
	//construtor da classe aluno
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	// construtor herdando o construtor da classe pessoa
	public Aluno(String nome, String matricula, String email, String login, String senha, String genero, String curso) {
		super();
		this.matricula = matricula;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.curso = curso;
	}
	//metodo pra cadastra aluno
	public Aluno CadastrarAluno(Aluno aluno){
		
		return aluno;
	}
	//metodo para imprimir alunos
	public Aluno ImprimirAluno(Aluno aluno){
		
		return aluno;
	}
	//metodo para atualizar os alunos
	public Aluno AtualizarAluno(Aluno aluno){
		
		return aluno;
	}
	//metodo para deletar os alunos
	public Aluno DeleteAluno(Aluno aluno){
		
		return aluno;
	}
	//metodos gets e sets
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
