package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LivroDAO;
import model.Livro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_Livro extends JFrame {

	private JPanel contentPane;
	private JTextField txf_TituloLivro;
	private JTextField txf_AutorDoLivro;
	private JTextField txf_Genero;
	private JTextField txf_CodigoDoLivro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Livro frame = new Tela_Livro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Livro() {
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarLivro = new JLabel("Cadastrar Livro");
		lblCadastrarLivro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCadastrarLivro.setBounds(149, 21, 203, 14);
		contentPane.add(lblCadastrarLivro);
		
		JLabel lblTituloDoLivro = new JLabel("T\u00EDtulo do Livro:");
		lblTituloDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTituloDoLivro.setBounds(10, 73, 102, 14);
		contentPane.add(lblTituloDoLivro);
		
		JLabel lblAutorDoLivro = new JLabel("Autor do Livro:");
		lblAutorDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAutorDoLivro.setBounds(10, 98, 83, 14);
		contentPane.add(lblAutorDoLivro);
		
		txf_TituloLivro = new JTextField();
		txf_TituloLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_TituloLivro.setBounds(100, 70, 228, 20);
		contentPane.add(txf_TituloLivro);
		txf_TituloLivro.setColumns(10);
		
		txf_AutorDoLivro = new JTextField();
		txf_AutorDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_AutorDoLivro.setBounds(100, 95, 228, 20);
		contentPane.add(txf_AutorDoLivro);
		txf_AutorDoLivro.setColumns(10);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO livroDAO = new LivroDAO();
				Livro livro = new Livro();
				livro.setCodigo(Integer.parseInt(txf_CodigoDoLivro.getText()));
				livro.setTitulo_Livro(txf_TituloLivro.getText());
				livro.setAutor_Livro(txf_AutorDoLivro.getText());
				livro.setGenero(txf_Genero.getText());
				try {
					livroDAO.criar(livro);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txf_CodigoDoLivro.getText();
				txf_TituloLivro.getText();
				txf_AutorDoLivro.getText();
				txf_Genero.getText();
				
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarLivro.setBounds(39, 164, 121, 23);
		contentPane.add(btnCadastrarLivro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_TituloLivro.setText("");
				txf_AutorDoLivro.setText("");
				txf_Genero.setText("");
				txf_CodigoDoLivro.setText("");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(220, 164, 124, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGenero.setBounds(10, 123, 46, 14);
		contentPane.add(lblGenero);
		
		txf_Genero = new JTextField();
		txf_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Genero.setBounds(100, 120, 228, 20);
		contentPane.add(txf_Genero);
		txf_Genero.setColumns(10);
		
		JLabel lblCodigoDoLivro = new JLabel("C\u00F3digo do Livro:");
		lblCodigoDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCodigoDoLivro.setBounds(10, 52, 102, 14);
		contentPane.add(lblCodigoDoLivro);
		
		txf_CodigoDoLivro = new JTextField();
		txf_CodigoDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_CodigoDoLivro.setBounds(100, 46, 228, 20);
		contentPane.add(txf_CodigoDoLivro);
		txf_CodigoDoLivro.setColumns(10);
		
		setLocationRelativeTo(null);
		
	}
}
