package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdministradorDAO;
import model.Administrador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class Tela_Cadastro_Administrador extends JFrame {

	private JPanel contentPane;
	private JTextField txf_NomeFuncionario;
	private JTextField txf_Login;
	private JPasswordField pass_Senha;
	private JTextField txf_Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Administrador frame = new Tela_Cadastro_Administrador();
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
	public Tela_Cadastro_Administrador() {
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroAdministrador = new JLabel("Cadastro Administrador");
		lblCadastroAdministrador.setBounds(127, 24, 197, 14);
		lblCadastroAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblCadastroAdministrador);
		
		JLabel lblNome_Funcionario = new JLabel("Nome do Funcion\u00E1rio:");
		lblNome_Funcionario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome_Funcionario.setBounds(25, 69, 132, 14);
		contentPane.add(lblNome_Funcionario);
		
		JComboBox jcb_Cargo = new JComboBox();
		jcb_Cargo.setModel(new DefaultComboBoxModel(new String[] {"Coordenador", "Diretor", "Professor"}));
		jcb_Cargo.setSelectedIndex(2);
		jcb_Cargo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jcb_Cargo.setBounds(24, 119, 121, 20);
		contentPane.add(jcb_Cargo);
		
		txf_NomeFuncionario = new JTextField();
		txf_NomeFuncionario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_NomeFuncionario.setBounds(147, 66, 264, 20);
		contentPane.add(txf_NomeFuncionario);
		txf_NomeFuncionario.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCargo.setBounds(25, 94, 46, 14);
		contentPane.add(lblCargo);
		
		JLabel lbl_Genero = new JLabel("G\u00EAnero:");
		lbl_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Genero.setBounds(204, 94, 46, 14);
		contentPane.add(lbl_Genero);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtn_Feminino = new JRadioButton("Feminino");
		rdbtn_Feminino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtn_Feminino.setBounds(200, 118, 89, 23);
		contentPane.add(rdbtn_Feminino);
		
		rdbtn_Feminino.setSelected(true);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnMasculino.setBounds(291, 118, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		bg.add(rdbtn_Feminino);
		bg.add(rdbtnMasculino);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministradorDAO administradorDAO = new AdministradorDAO();
				Administrador administrador = new Administrador();
				
				administrador.setId(Integer.parseInt(txf_Id.getText()));
				administrador.setNome(txf_NomeFuncionario.getText());
				administrador.setCargo((String)jcb_Cargo.getSelectedItem());
				
				if(rdbtn_Feminino.isSelected()){
					administrador.setGenero("Feminino");
				}else{
					administrador.setGenero("Masculino");
				}
				
				administrador.setLogin(txf_Login.getText());
				administrador.setSenha(pass_Senha.getText());
				
				try {
					administradorDAO.criar(administrador);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);	
			}
		});
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setBounds(68, 210, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_Id.setText("");
				txf_NomeFuncionario.setText("");
				txf_Login.setText("");
				pass_Senha.setText("");
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(223, 210, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lbl_Login = new JLabel("Login:");
		lbl_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Login.setBounds(25, 172, 46, 14);
		contentPane.add(lbl_Login);
		
		txf_Login = new JTextField();
		txf_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Login.setBounds(68, 169, 101, 20);
		contentPane.add(txf_Login);
		txf_Login.setColumns(10);
		
		JLabel lbl_Senha = new JLabel("Senha:");
		lbl_Senha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Senha.setBounds(204, 172, 46, 14);
		contentPane.add(lbl_Senha);
		
		pass_Senha = new JPasswordField();
		pass_Senha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pass_Senha.setBounds(248, 169, 109, 20);
		contentPane.add(pass_Senha);
		
		JLabel lbl_Id = new JLabel("ID:");
		lbl_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Id.setBounds(25, 44, 46, 14);
		contentPane.add(lbl_Id);
		
		txf_Id = new JTextField();
		txf_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Id.setBounds(51, 41, 86, 20);
		contentPane.add(txf_Id);
		txf_Id.setColumns(10);
		
		setLocationRelativeTo(null);
	}
}
