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

public class AdministradorDAO {
	// primeiro metodo para criar o administrador
	public void criar(Administrador administrador) throws SQLException {
		
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			//passando uma mensagem para o banco de dados para inserir os dados passado pelo o usuario
			stmt = con.prepareStatement("insert into administrador (id, nome, cargo, genero, login, senha) values (?,?,?,?,?,?)");
			stmt.setInt(1, administrador.getId());
			stmt.setString(2, administrador.getNome());
			stmt.setString(3, administrador.getCargo());
			stmt.setString(4, administrador.getGenero());
			stmt.setString(5, administrador.getLogin());
			stmt.setString(6, administrador.getSenha());
			//executando o metodo para inviar para o banco
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Administrador Salvo com Sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public List<Administrador> read() throws SQLException{
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		List<Administrador> administradores = new ArrayList<>();
		String sql = "select id, nome, cargo, genero from administrador";
		
		try (PreparedStatement stm = con.prepareStatement(sql);
		//pegando o que tem no banco e imprimindo na lista
		ResultSet rs = stm.executeQuery()){
			while(rs.next()){
				Administrador administrador = new Administrador();
				administrador.setId(rs.getInt("id"));
				administrador.setNome(rs.getString("nome"));
				administrador.setCargo(rs.getString("cargo"));
				administrador.setGenero(rs.getString("genero"));
				// administradores é a lista e o administrador é o objeto
				administradores.add(administrador);
			}
		}
		return administradores;
	}

	public void alterar(Administrador administrador) throws SQLException {
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para alterar no banco de dados usando o id passado pelo o usuario
		String sql = "update administrador set id=?, nome=?, cargo=?, genero=?, login=?, senha=? where id=?";
		//Só sera atualizado se o id do administrador for igual ao que tiver sendo passado
		PreparedStatement stmt = con.prepareStatement(sql);
		// os 6 atributos que seram atualizado
		stmt.setInt(1, administrador.getId());
		stmt.setString(2, administrador.getNome());
		stmt.setString(3, administrador.getCargo());
		stmt.setString(4, administrador.getGenero());
		stmt.setString(5, administrador.getLogin());
		stmt.setString(6, administrador.getSenha());
		//o id que terá que ser passado para ser atualizado
		stmt.setInt(7, administrador.getId());
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Administrador Atualizado Com Sucesso.");
		
	}

	public void deletar(int id) throws SQLException {
		Connection con;
		con = ConnectionFactory.getConnection();
		//passando a mensagem para o banco para deletar onde o id foi informado pelo usuario
		String sql = "delete from administrador where id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		//passando o id do administrador que será deletado
		stmt.setInt(1, id);
		//executando o metodo para inviar para o banco
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Administrador Deletado Com Sucesso.");
	}
		//metodo para entra no administrador
	public boolean checkLogin(String login, String senha) {
		//pedindo o nome do administrador e senha

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;

		try {
			//passando uma mensagem para o banco de dados selecionar todos os  administradores com a usuario e senha passado
			stmt = con.prepareStatement("SELECT * FROM administrador WHERE login = ? and senha = ?");
			//passando o usuario para o banco
			stmt.setString(1, login);
			//passando a senha para o banco
			stmt.setString(2, senha);
			rs = stmt.executeQuery();

			if (rs.next()) {

				check = true;

			}
		} catch (SQLException ex) {
			Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);

		}

		return check;
	}

}
