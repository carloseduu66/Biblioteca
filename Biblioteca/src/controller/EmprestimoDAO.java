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
import model.Emprestimo;
import model.Livro;

public class EmprestimoDAO {
	
	public void criar(Emprestimo emprestimo) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try{
			stmt = con.prepareStatement("insert into emprestimo (id, nome_aluno, nome_livro, data_inicial, data_final) values (?,?,?,?,?)");
			stmt.setInt(1, emprestimo.getId());
			stmt.setString(2, emprestimo.getAluno().getNome());
			stmt.setString(3, emprestimo.getLivro().getTitulo_Livro());
			stmt.setString(4, emprestimo.getData_Inicial());
			stmt.setString(5, emprestimo.getData_Final());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Empr�stimo Realizado Com Sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public boolean checkLivro(int codigo){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try{
			stmt = con.prepareStatement("SELECT * FROM livro WHERE codigo = ?");
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				
				check = true;
				
			}
		}catch(SQLException ex){
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);		
		}
		
		return check;
	}
	
	public static List<Emprestimo> read() throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Emprestimo> emprestimos = new ArrayList<>();
		String sql = "select * from emprestimos";
		
		try (PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery()){
			while(rs.next()){
				Emprestimo emprestimo = new Emprestimo();
				Aluno aluno = new Aluno();
				aluno.setNome("nome_aluno");
				Livro livro = new Livro();
				livro.setTitulo_Livro("nome_livro");
				emprestimo.setId(rs.getInt("id"));
				emprestimo.setAluno(aluno);
				emprestimo.setLivro(livro);
				emprestimo.setData_Inicial(rs.getString("data_inicial"));
				emprestimo.setData_Final(rs.getString("data_final"));
				emprestimos.add(emprestimo);
			}
		}
		return emprestimos;
	}
	
}
