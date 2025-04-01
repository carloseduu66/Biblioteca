package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Aluno;

public class AlunoDAO {
	// criando um novo aluno
	public void criar(Aluno aluno) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try{
			//mandando uma mensagem para o banco para inserir os dados passado pelo o usuario
			stmt = con.prepareStatement("insert into aluno (nome, email, matricula, login, senha, genero, curso) values (?,?,?,?,?,?,?)");
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getMatricula());
			stmt.setString(4, aluno.getLogin());
			stmt.setString(5, aluno.getSenha());
			stmt.setString(6, aluno.getGenero());
			stmt.setString(7, aluno.getCurso());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno Salvo com Sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public List<Aluno> read() throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Aluno> alunos = new ArrayList<>();
		String sql = "select * from aluno";
		
		try (PreparedStatement stm = con.prepareStatement(sql);
				//pegando o que tem no banco e imprimindo na lista
		ResultSet rs = stm.executeQuery()){
			while(rs.next()){
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEmail(rs.getString("email"));
				aluno.setLogin(rs.getString("login"));
				aluno.setSenha(rs.getString("senha"));
				aluno.setGenero(rs.getString("genero"));
				aluno.setCurso(rs.getString("curso"));
				// alunos e a lista e o aluno é o objeto
				alunos.add(aluno);
			}
		}
		return alunos;
	}
	
	public void alterar (Aluno aluno) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para alterar no banco de dados usando a matricula passado pelo o usuario
		String sql = "update aluno set nome=?,email=?,matricula=?,login=?,senha=?,genero=?,curso=? where matricula=?";
		//Só sera atualizado se o matricula do aluno for igual ao que tiver sendo passado
		PreparedStatement stmt = con.prepareStatement(sql);
		// os 7 atributos que seram atualizado
		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getEmail());
		stmt.setString(3, aluno.getMatricula());
		stmt.setString(4, aluno.getLogin());
		stmt.setString(5, aluno.getSenha());
		stmt.setString(6, aluno.getGenero());
		stmt.setString(7, aluno.getCurso());
		//a matricula que terá que ser passado para ser atualizado
		stmt.setString(8, aluno.getMatricula());
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Aluno Atualizado Com Sucesso.");
		
	}
	
	public void deletar (String matricula) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para o banco para deletar onde a matricula foi informado pelo usuario
		String sql = "delete from aluno where matricula=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		//passando a matricula do aluno que será deletado
		stmt.setString(1, matricula);
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
	}
	//metodo para entra no aluno
	public boolean checkLogin(String login, String senha){
		//pedindo o nome do aluno e senha
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try{
			//passando uma mensagem para o banco de dados selecionar todos os alunos com a usuario e senha passado
			stmt = con.prepareStatement("SELECT * FROM aluno WHERE login = ? and senha = ?");
			stmt.setString(1, login);
			//passando o usuario para o banco
			stmt.setString(2, senha);
			//passando a senha para o banco
			rs = stmt.executeQuery();
			
			if(rs.next()){
				
				check = true;
				
			}
		}catch(SQLException ex){
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		
		return check;
	}
}