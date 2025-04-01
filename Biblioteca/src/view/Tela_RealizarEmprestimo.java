package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EmprestimoDAO;
import controller.LivroDAO;
import model.Aluno;
import model.Emprestimo;
import model.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_RealizarEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField txf_TituloDoLivro;
	private JTextField txf_Aluno;
	private JTextField txf_Matricula;
	private JTextField txf_Id;
	private JTextField txf_DataInicial;
	private JTextField txf_DataFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_RealizarEmprestimo frame = new Tela_RealizarEmprestimo();
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
	public Tela_RealizarEmprestimo() {
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RealizarEmprestimo = new JLabel("Realizar Empr\u00E9stimo");
		lbl_RealizarEmprestimo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_RealizarEmprestimo.setBounds(135, 9, 181, 14);
		contentPane.add(lbl_RealizarEmprestimo);
		
		JLabel lbl_TituloDoLivro = new JLabel("T\u00EDtulo do Livro:");
		lbl_TituloDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_TituloDoLivro.setBounds(10, 65, 99, 14);
		contentPane.add(lbl_TituloDoLivro);
		
		JLabel lbl_DataInicial = new JLabel("Data Inicial:");
		lbl_DataInicial.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_DataInicial.setBounds(10, 146, 74, 14);
		contentPane.add(lbl_DataInicial);
		
		JLabel lbl_DataFinal = new JLabel("Data Final:");
		lbl_DataFinal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_DataFinal.setBounds(10, 171, 74, 14);
		contentPane.add(lbl_DataFinal);
		
		txf_TituloDoLivro = new JTextField();
		txf_TituloDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_TituloDoLivro.setBounds(106, 62, 237, 20);
		contentPane.add(txf_TituloDoLivro);
		txf_TituloDoLivro.setColumns(10);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAluno.setBounds(10, 96, 46, 14);
		contentPane.add(lblAluno);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatricula.setBounds(10, 121, 74, 14);
		contentPane.add(lblMatricula);
		
		txf_Aluno = new JTextField();
		txf_Aluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Aluno.setBounds(48, 90, 237, 20);
		contentPane.add(txf_Aluno);
		txf_Aluno.setColumns(10);
		
		txf_Matricula = new JTextField();
		txf_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Matricula.setBounds(74, 115, 211, 20);
		contentPane.add(txf_Matricula);
		txf_Matricula.setColumns(10);
		
		JButton btn_RealizarEmprestimo = new JButton("Realizar Empr\u00E9stimo");
		btn_RealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emprestimo emprestimo = new Emprestimo();
				EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
				LivroDAO livroDAO = new LivroDAO();
				Aluno aluno = new Aluno();
				aluno.setNome(txf_Aluno.getText());
				Livro livro = new Livro();
				livro.setTitulo_Livro(txf_TituloDoLivro.getText());
				livro.setCodigo(Integer.parseInt(txf_Id.getText()));
				
				
				if(emprestimoDAO.checkLivro(Integer.parseInt(txf_Id.getText()))){
				
					emprestimo.setId(Integer.parseInt(txf_Id.getText()));
					emprestimo.setAluno(aluno);
					emprestimo.setLivro(livro);
					emprestimo.setData_Inicial(txf_DataInicial.getText());
					emprestimo.setData_Final(txf_DataFinal.getText());
				
					try {
						emprestimoDAO.criar(emprestimo);
						livroDAO.deletar(livro.getCodigo());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					txf_Id.setText("");
					txf_Aluno.setText("");
					txf_TituloDoLivro.setText("");
					txf_DataInicial.setText("");
					txf_DataFinal.setText("");
					
					Tela_ListarLivros tela_ListarLivros = new Tela_ListarLivros();
					tela_ListarLivros.setVisible(true);
					setVisible(false);
					
				}else{
					JOptionPane.showMessageDialog(null, "Código do Livro inválido");
					txf_Id.setText("");
					txf_TituloDoLivro.setText("");
					txf_Aluno.setText("");
					txf_Matricula.setText("");
					txf_DataInicial.setText("");
					txf_DataFinal.setText("");					
				}
			}
		});
		btn_RealizarEmprestimo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_RealizarEmprestimo.setBounds(35, 207, 163, 23);
		contentPane.add(btn_RealizarEmprestimo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_Id.setText("");
				txf_TituloDoLivro.setText("");
				txf_Aluno.setText("");
				txf_Matricula.setText("");
				txf_DataInicial.setText("");
				txf_DataFinal.setText("");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(208, 207, 163, 23);
		contentPane.add(btnCancelar);
		
		JLabel lbl_Id = new JLabel("C\u00F3digo do Livro:");
		lbl_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Id.setBounds(10, 38, 99, 14);
		contentPane.add(lbl_Id);
		
		txf_Id = new JTextField();
		txf_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Id.setBounds(105, 34, 238, 20);
		contentPane.add(txf_Id);
		txf_Id.setColumns(10);
		
		txf_DataInicial = new JTextField();
		txf_DataInicial.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_DataInicial.setBounds(84, 143, 86, 20);
		contentPane.add(txf_DataInicial);
		txf_DataInicial.setColumns(10);
		
		txf_DataFinal = new JTextField();
		txf_DataFinal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_DataFinal.setBounds(74, 171, 94, 20);
		contentPane.add(txf_DataFinal);
		txf_DataFinal.setColumns(10);
		
		setLocationRelativeTo(null);
	}

}
