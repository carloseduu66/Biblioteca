package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoDAO;
import model.Aluno;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class Tela_AtualizarAlunoCompleto extends JFrame {

	private JPanel contentPane;
	private JTextField txf_NomeDoAluno;
	private JTextField txf_Matricula;
	private JTextField txf_Email;
	private JTextField txf_Login;
	private JPasswordField pass_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_AtualizarAlunoCompleto frame = new Tela_AtualizarAlunoCompleto();
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
	public Tela_AtualizarAlunoCompleto() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarAluno = new JLabel("Atualizar Aluno");
		lblAtualizarAluno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAtualizarAluno.setBounds(151, 22, 202, 14);
		contentPane.add(lblAtualizarAluno);
		
		JLabel lblNomeDoAluno = new JLabel("Nome:");
		lblNomeDoAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomeDoAluno.setBounds(25, 50, 54, 14);
		contentPane.add(lblNomeDoAluno);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatricula.setBounds(25, 75, 70, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(25, 100, 54, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLogin.setBounds(25, 125, 54, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSenha.setBounds(25, 150, 54, 14);
		contentPane.add(lblSenha);
		
		txf_NomeDoAluno = new JTextField();
		txf_NomeDoAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_NomeDoAluno.setBounds(68, 47, 182, 20);
		contentPane.add(txf_NomeDoAluno);
		txf_NomeDoAluno.setColumns(10);
		
		txf_Matricula = new JTextField();
		txf_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Matricula.setBounds(88, 72, 86, 20);
		contentPane.add(txf_Matricula);
		txf_Matricula.setColumns(10);
		
		txf_Email = new JTextField();
		txf_Email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Email.setBounds(68, 97, 182, 20);
		contentPane.add(txf_Email);
		txf_Email.setColumns(10);
		
		txf_Login = new JTextField();
		txf_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Login.setBounds(68, 125, 182, 20);
		contentPane.add(txf_Login);
		txf_Login.setColumns(10);
		
		JLabel lbl_Genero = new JLabel("G\u00EAnero:");
		lbl_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Genero.setBounds(260, 50, 64, 14);
		contentPane.add(lbl_Genero);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtn_Feminino = new JRadioButton("Feminino");
		rdbtn_Feminino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtn_Feminino.setBounds(254, 71, 80, 23);
		contentPane.add(rdbtn_Feminino);
		
		rdbtn_Feminino.setSelected(true);
		
		JRadioButton rdbtn_Masculino = new JRadioButton("Masculino");
		rdbtn_Masculino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtn_Masculino.setBounds(333, 71, 86, 23);
		contentPane.add(rdbtn_Masculino);
		
		bg.add(rdbtn_Feminino);
		bg.add(rdbtn_Masculino);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCurso.setBounds(260, 100, 46, 14);
		contentPane.add(lblCurso);
		
		JComboBox comboBox_Curso = new JComboBox();
		comboBox_Curso.setModel(new DefaultComboBoxModel(new String[] {"Ci\u00EAncia da Computa\u00E7\u00E3o", "Design Digital", "Engenharia da Computa\u00E7\u00E3o", "Engenharia de Software", "Sistemas de Informa\u00E7\u00E3o", "Redes de Computadores"}));
		comboBox_Curso.setSelectedIndex(4);
		comboBox_Curso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_Curso.setBounds(260, 125, 159, 20);
		contentPane.add(comboBox_Curso);
		
		JButton btnAtualizarAluno = new JButton("Atualizar Aluno");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoDAO alunoDAO = new AlunoDAO();
				Aluno aluno = new Aluno();
				aluno.setNome(txf_NomeDoAluno.getText());
				aluno.setMatricula(txf_Matricula.getText());
				aluno.setEmail(txf_Email.getText());
				aluno.setLogin(txf_Login.getText());
				aluno.setSenha(pass_Senha.getText());
				aluno.setCurso((String)comboBox_Curso.getSelectedItem());
				
				if(rdbtn_Masculino.isSelected()){
					aluno.setGenero("Masculino");
				}else{
					aluno.setGenero("Feminino");
				}
				
				try {
					alunoDAO.alterar(aluno);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarAluno.setBounds(25, 190, 160, 23);
		contentPane.add(btnAtualizarAluno);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_NomeDoAluno.setText(" ");
				txf_Matricula.setText(" ");
				txf_Email.setText(" ");
				txf_Login.setText("");
				pass_Senha.setText("");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(216, 190, 118, 23);
		contentPane.add(btnCancelar);
		
		pass_Senha = new JPasswordField();
		pass_Senha.setBounds(68, 150, 182, 20);
		contentPane.add(pass_Senha);

		setLocationRelativeTo(null);
	}
}
