package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    // método de conexão do Java com o banco de dados
    public static Connection getConnection() {

        Connection con = null;

        try {
            // Caminho de conexão do driver
            Class.forName("org.postgresql.Driver");
            // requisitos de autenticação
            String url = "jdbc:postgresql://localhost:5432/biblioteca";
            // usuário
            String usuario = "postgres"; // ou o usuário do seu banco
            // senha do banco
            String senha = "carlos0408"; // senha do seu banco
            // conectando o driver com os requisitos de autenticação
            con = DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException e) {
            System.out.println("Erro no Banco de Dados.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return con;
    }
}
