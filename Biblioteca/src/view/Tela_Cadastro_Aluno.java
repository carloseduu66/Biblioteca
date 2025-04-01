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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Tela_Cadastro_Aluno extends JFrame {

	private JPanel contentPane;
	private JTextField txf_Nome;
	private JTextField txf_Matricula;
	private JTextField txf_Email;
	private JTextField txt_Login;
	private JPasswordField pass_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Aluno frame = new Tela_Cadastro_Aluno();
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
	public Tela_Cadastro_Aluno() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_CadastroAluno = new JLabel("Cadastro do Aluno");
		lbl_CadastroAluno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_CadastroAluno.setBounds(132, 11, 208, 14);
		contentPane.add(lbl_CadastroAluno);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome.setBounds(10, 43, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatricula.setBounds(10, 70, 62, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(10, 95, 62, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLogin.setBounds(10, 120, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSenha.setBounds(10, 143, 46, 14);
		contentPane.add(lblSenha);
		
		txf_Nome = new JTextField();
		txf_Nome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Nome.setBounds(55, 40, 173, 20);
		contentPane.add(txf_Nome);
		txf_Nome.setColumns(10);
		
		txf_Matricula = new JTextField();
		txf_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Matricula.setBounds(75, 67, 153, 20);
		contentPane.add(txf_Matricula);
		txf_Matricula.setColumns(10);
		
		txf_Email = new JTextField();
		txf_Email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Email.setBounds(55, 95, 173, 20);
		contentPane.add(txf_Email);
		txf_Email.setColumns(10);
		
		txt_Login = new JTextField();
		txt_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txt_Login.setBounds(55, 120, 173, 20);
		contentPane.add(txt_Login);
		txt_Login.setColumns(10);
		
		pass_Senha = new JPasswordField();
		pass_Senha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pass_Senha.setBounds(55, 145, 173, 20);
		contentPane.add(pass_Senha);
		
		
		JComboBox cbx_Curso = new JComboBox();
		cbx_Curso.setModel(new DefaultComboBoxModel(new String[] {"Ci\u00EAncia da Computa\u00E7\u00E3o", "Design Digital", "Engenharia da Computa\u00E7\u00E3o", "Engenharia de Software", "Sistemas de Informa\u00E7\u00E3o", "Redes de Computadores"}));
		cbx_Curso.setSelectedIndex(4);
		cbx_Curso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cbx_Curso.setBounds(238, 117, 173, 20);
		contentPane.add(cbx_Curso);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCurso.setBounds(238, 95, 46, 14);
		contentPane.add(lblCurso);
		
		JLabel lbl_Genero = new JLabel("G\u00EAnero:");
		lbl_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Genero.setBounds(238, 43, 46, 14);
		contentPane.add(lbl_Genero);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton Genero_Masculino = new JRadioButton("Masculino");
		Genero_Masculino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Genero_Masculino.setBounds(322, 66, 89, 23);
		contentPane.add(Genero_Masculino);
		
		JRadioButton Genero_Feminino = new JRadioButton("Feminino");
		Genero_Feminino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Genero_Feminino.setBounds(234, 66, 109, 23);
		contentPane.add(Genero_Feminino);
		
		Genero_Feminino.setSelected(true);

		bg.add(Genero_Masculino);
		bg.add(Genero_Feminino);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno aluno = new Aluno();
				AlunoDAO alunoDAO = new AlunoDAO();
				
				aluno.setNome(txf_Nome.getText());
				aluno.setMatricula(txf_Matricula.getText());
				aluno.setEmail(txf_Email.getText());
				aluno.setLogin(txt_Login.getText());
				aluno.setSenha(pass_Senha.getText());
				aluno.setCurso((String)cbx_Curso.getSelectedItem());
				if(Genero_Masculino.isSelected()){
					aluno.setGenero("Masculino");
				}else{
					aluno.setGenero("Feminino");
				}
				try {
					alunoDAO.criar(aluno);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				txf_Nome.setText("");
				txf_Matricula.setText("");
				txf_Email.setText("");
				txt_Login.setText("");
				pass_Senha.setText("");
				
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setBounds(45, 191, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_Nome.setText("");
				txf_Matricula.setText("");
				txf_Email.setText("");
				txt_Login.setText("");
				pass_Senha.setText("");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(176, 191, 89, 23);
		contentPane.add(btnCancelar);
		
		setLocationRelativeTo(null);
	}
}
