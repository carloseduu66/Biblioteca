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

import model.Administrador;
import model.Aluno;
import model.Livro;

public class LivroDAO {
	// primeiro metodo para cria o livro
	public void criar(Livro livro) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try{
			//passando uma mensagem para o banco de dados para inserir os dados passado pelo o usuario
			stmt = con.prepareStatement("insert into livro (codigo, titulo, autor, genero) values (?,?,?,?)");
			
			stmt.setInt(1, livro.getCodigo());
			stmt.setString(2, livro.getTitulo_Livro());
			stmt.setString(3, livro.getAutor_Livro());
			stmt.setString(4, livro.getGenero());
			//executando o metodo para inviar para o banco
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Livro Salvo com Sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public List<Livro> read() throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Livro> livros = new ArrayList<>();
		String sql = "select * from livro";
		
		try (PreparedStatement stm = con.prepareStatement(sql);
			//pegando o que tem no banco e imprimindo na lista
		ResultSet rs = stm.executeQuery()){
			while(rs.next()){
				Livro livro = new Livro();
				livro.setCodigo(rs.getInt("codigo"));
				livro.setTitulo_Livro(rs.getString("titulo"));
				livro.setAutor_Livro(rs.getString("autor"));
				livro.setGenero(rs.getString("genero"));
				// livros é a lista e o livro é o objeto
				livros.add(livro);
			}
		}
		return livros;
	}
	
	public void alterar (Livro livro) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para alterar no banco de dados usando o codigo passado pelo o usuario
		String sql = "update livro set codigo=?,titulo=?,autor=?,genero=? where codigo=?";
		//Só sera atualizado se o codigo do livro for igual ao que tiver sendo passado
		PreparedStatement stmt = con.prepareStatement(sql);
		//os 4 atributos que seram atualizado
		stmt.setInt(1, livro.getCodigo());
		stmt.setString(2, livro.getTitulo_Livro());
		stmt.setString(3, livro.getAutor_Livro());
		stmt.setString(4, livro.getGenero());
		//o codigo que terá que ser passado para ser atualizado
		stmt.setInt(5, livro.getCodigo());
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Livro Alterado Com Sucesso.");
		
	}
	
	public void deletar (int codigo) throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para o banco para deletar onde o codigo foi informado pelo usuario
		String sql = "delete from livro where codigo=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		//passando a matricula do aluno que será deletado
		stmt.setInt(1, codigo);
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Livro Deletado Com Sucesso.");
	}
}
