package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LivroDAO;
import model.Livro;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_AtualizarLivroCompleto extends JFrame {

	private JPanel contentPane;
	private JTextField txf_CodigoLivro;
	private JTextField txf_TituloLivro;
	private JTextField txf_AutorDoLivro;
	private JTextField txf_Genero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_AtualizarLivroCompleto frame = new Tela_AtualizarLivroCompleto();
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
	public Tela_AtualizarLivroCompleto() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarLivro = new JLabel("Atualizar Livro");
		lblAtualizarLivro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAtualizarLivro.setBounds(149, 21, 216, 14);
		contentPane.add(lblAtualizarLivro);
		
		JLabel lblCdigoDoLivro = new JLabel("C\u00F3digo do Livro:");
		lblCdigoDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCdigoDoLivro.setBounds(25, 48, 93, 14);
		contentPane.add(lblCdigoDoLivro);
		
		JLabel lblTituloDoLivro = new JLabel("T\u00EDtulo do Livro:");
		lblTituloDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTituloDoLivro.setBounds(25, 73, 93, 14);
		contentPane.add(lblTituloDoLivro);
		
		JLabel lblAutorDoLivro = new JLabel("Autor do Livro:");
		lblAutorDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAutorDoLivro.setBounds(25, 98, 79, 14);
		contentPane.add(lblAutorDoLivro);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGenero.setBounds(25, 133, 55, 14);
		contentPane.add(lblGenero);
		
		txf_CodigoLivro = new JTextField();
		txf_CodigoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_CodigoLivro.setBounds(116, 46, 86, 20);
		contentPane.add(txf_CodigoLivro);
		txf_CodigoLivro.setColumns(10);
		
		txf_TituloLivro = new JTextField();
		txf_TituloLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_TituloLivro.setBounds(116, 70, 271, 20);
		contentPane.add(txf_TituloLivro);
		txf_TituloLivro.setColumns(10);
		
		txf_AutorDoLivro = new JTextField();
		txf_AutorDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_AutorDoLivro.setBounds(116, 98, 271, 20);
		contentPane.add(txf_AutorDoLivro);
		txf_AutorDoLivro.setColumns(10);
		
		txf_Genero = new JTextField();
		txf_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Genero.setBounds(116, 130, 271, 20);
		contentPane.add(txf_Genero);
		txf_Genero.setColumns(10);
		
		JButton btnAtualizarLivro = new JButton("Atualizar Livro");
		btnAtualizarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO livroDAO = new LivroDAO();
				Livro livro = new Livro();
				livro.setCodigo(Integer.parseInt(txf_CodigoLivro.getText()));
				livro.setTitulo_Livro(txf_TituloLivro.getText());
				livro.setAutor_Livro(txf_AutorDoLivro.getText());
				livro.setGenero(txf_Genero.getText());
				try {
					livroDAO.alterar(livro);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txf_CodigoLivro.setText("");
				txf_TituloLivro.setText("");
				txf_AutorDoLivro.setText("");
				txf_Genero.setText("");
				
				try {
					livroDAO.alterar(livro);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarLivro.setBounds(60, 179, 142, 23);
		contentPane.add(btnAtualizarLivro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_CodigoLivro.setText("");
				txf_TituloLivro.setText("");
				txf_AutorDoLivro.setText(" ");
				txf_Genero.setText(" ");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(240, 179, 125, 23);
		contentPane.add(btnCancelar);
		setLocationRelativeTo(null);
	}
}
