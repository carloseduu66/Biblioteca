package model;

public class Emprestimo {
	private int id;
	Aluno aluno;
	Livro livro;
	private String data_Inicial;
	private String data_Final;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public String getData_Inicial() {
		return data_Inicial;
	}
	public void setData_Inicial(String data_Inicial) {
		this.data_Inicial = data_Inicial;
	}
	public String getData_Final() {
		return data_Final;
	}
	public void setData_Final(String data_Final) {
		this.data_Final = data_Final;
	}
}