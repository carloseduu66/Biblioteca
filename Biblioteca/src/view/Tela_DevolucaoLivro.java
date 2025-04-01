package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LivroDAO;
import model.Aluno;
import model.Livro;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_DevolucaoLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txf_Nome;
	private JTextField txf_Matricula;
	private JTextField txf_Codigo_do_Livro;
	private JTextField txf_Titulo_Do_Livro;
	private JTextField txf_Autor;
	private JTextField txf_Genero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_DevolucaoLivro frame = new Tela_DevolucaoLivro();
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
	public Tela_DevolucaoLivro() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevolucaoDoLivro = new JLabel("Devolu\u00E7\u00E3o do Livro");
		lblDevolucaoDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDevolucaoDoLivro.setBounds(138, 23, 213, 14);
		contentPane.add(lblDevolucaoDoLivro);
		
		JLabel lbl_Nome = new JLabel("Nome:");
		lbl_Nome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Nome.setBounds(23, 49, 53, 14);
		contentPane.add(lbl_Nome);
		
		JLabel lbl_Matricula = new JLabel("Matr\u00EDcula:");
		lbl_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Matricula.setBounds(23, 74, 76, 14);
		contentPane.add(lbl_Matricula);
		
		JLabel lbl_Codigo_Do_Livro = new JLabel("C\u00F3digo do Livro:");
		lbl_Codigo_Do_Livro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Codigo_Do_Livro.setBounds(23, 99, 97, 14);
		contentPane.add(lbl_Codigo_Do_Livro);
		
		JLabel lbl_Titulo_Do_Livro = new JLabel("T\u00EDtulo do Livro:");
		lbl_Titulo_Do_Livro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Titulo_Do_Livro.setBounds(23, 124, 97, 14);
		contentPane.add(lbl_Titulo_Do_Livro);
		
		txf_Nome = new JTextField();
		txf_Nome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Nome.setBounds(64, 48, 346, 20);
		contentPane.add(txf_Nome);
		txf_Nome.setColumns(10);
		
		txf_Matricula = new JTextField();
		txf_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Matricula.setBounds(84, 71, 117, 20);
		contentPane.add(txf_Matricula);
		txf_Matricula.setColumns(10);
		
		txf_Codigo_do_Livro = new JTextField();
		txf_Codigo_do_Livro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Codigo_do_Livro.setBounds(115, 96, 86, 20);
		contentPane.add(txf_Codigo_do_Livro);
		txf_Codigo_do_Livro.setColumns(10);
		
		txf_Titulo_Do_Livro = new JTextField();
		txf_Titulo_Do_Livro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Titulo_Do_Livro.setBounds(115, 124, 295, 20);
		contentPane.add(txf_Titulo_Do_Livro);
		txf_Titulo_Do_Livro.setColumns(10);
		
		JLabel lbl_Autor = new JLabel("Autor:");
		lbl_Autor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Autor.setBounds(23, 151, 46, 14);
		contentPane.add(lbl_Autor);
		
		txf_Autor = new JTextField();
		txf_Autor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Autor.setBounds(115, 148, 295, 20);
		contentPane.add(txf_Autor);
		txf_Autor.setColumns(10);
		
		JLabel lbl_Genero = new JLabel("G\u00EAnero:");
		lbl_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Genero.setBounds(23, 176, 53, 14);
		contentPane.add(lbl_Genero);
		
		txf_Genero = new JTextField();
		txf_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Genero.setBounds(115, 179, 295, 20);
		contentPane.add(txf_Genero);
		txf_Genero.setColumns(10);
		
		JButton btn_DevolverLivro = new JButton("Devolver Livro");
		btn_DevolverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO livroDAO = new LivroDAO();
				Livro livro = new Livro();
				Aluno aluno = new Aluno();
				
				aluno.setNome(txf_Nome.getText());
				aluno.setMatricula(txf_Matricula.getText());
				livro.setCodigo(Integer.parseInt(txf_Codigo_do_Livro.getText()));
				livro.setTitulo_Livro(txf_Titulo_Do_Livro.getText());
				livro.setAutor_Livro(txf_Autor.getText());
				livro.setGenero(txf_Genero.getText());
				
				try {
					livroDAO.criar(livro);
					
					txf_Nome.setText("");
					txf_Matricula.setText("");
					txf_Codigo_do_Livro.setText("");
					txf_Titulo_Do_Livro.setText("");
					txf_Autor.setText("");
					txf_Genero.setText("");
				
					Tela_Administrador tela_Administrador = new Tela_Administrador();
					tela_Administrador.setVisible(true);
					setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_DevolverLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_DevolverLivro.setBounds(64, 213, 133, 23);
		contentPane.add(btn_DevolverLivro);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txf_Nome.setText("");
				txf_Matricula.setText("");
				txf_Codigo_do_Livro.setText("");
				txf_Titulo_Do_Livro.setText("");
				txf_Autor.setText("");
				txf_Genero.setText("");
			}
		});
		btn_Cancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Cancelar.setBounds(242, 213, 122, 23);
		contentPane.add(btn_Cancelar);
		
		setLocationRelativeTo(null);
	}
}
