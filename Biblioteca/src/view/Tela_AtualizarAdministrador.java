package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdministradorDAO;
import model.Administrador;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class Tela_AtualizarAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txf_NomeFuncionario;
	private JTextField txf_Login;
	private JPasswordField pass_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_AtualizarAdministrador frame = new Tela_AtualizarAdministrador();
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
	public Tela_AtualizarAdministrador() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarAdministrador = new JLabel("Atualizar Administrador");
		lblAtualizarAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAtualizarAdministrador.setBounds(121, 23, 247, 14);
		contentPane.add(lblAtualizarAdministrador);
		
		JLabel lblNomeFuncionario = new JLabel("Nome do Funcion\u00E1rio:");
		lblNomeFuncionario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomeFuncionario.setBounds(24, 69, 135, 14);
		contentPane.add(lblNomeFuncionario);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCargo.setBounds(24, 94, 46, 14);
		contentPane.add(lblCargo);
		
		txf_NomeFuncionario = new JTextField();
		txf_NomeFuncionario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_NomeFuncionario.setBounds(157, 66, 255, 20);
		contentPane.add(txf_NomeFuncionario);
		txf_NomeFuncionario.setColumns(10);
		
		JLabel lbl_Genero = new JLabel("G\u00EAnero:");
		lbl_Genero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Genero.setBounds(214, 94, 46, 14);
		contentPane.add(lbl_Genero);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnFeminino.setBounds(201, 118, 85, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnMasculino.setBounds(288, 118, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		rdbtnFeminino.setSelected(true);
		
		bg.add(rdbtnFeminino);
		bg.add(rdbtnMasculino);
		
		JComboBox jcb_Cargo = new JComboBox();
		jcb_Cargo.setModel(new DefaultComboBoxModel(new String[] {"Coordenador", "Diretor", "Professor"}));
		jcb_Cargo.setSelectedIndex(2);
		
		jcb_Cargo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jcb_Cargo.setBounds(24, 119, 123, 20);
		contentPane.add(jcb_Cargo);
		
		JLabel lbl_Id = new JLabel("ID:");
		lbl_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Id.setBounds(24, 45, 46, 14);
		contentPane.add(lbl_Id);
		
		JTextField txf_Id = new JTextField();
		txf_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Id.setBounds(68, 42, 86, 20);
		contentPane.add(txf_Id);
		txf_Id.setColumns(10);
		
		
		JButton btnAtualizarAdministrador = new JButton("Atualizar Administrador");
		btnAtualizarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				Administrador administrador = new Administrador();
				AdministradorDAO administradorDAO = new AdministradorDAO();
				
				administrador.setId(Integer.parseInt(txf_Id.getText()));
				administrador.setNome(txf_NomeFuncionario.getText());
				administrador.setLogin(txf_Login.getText());
				administrador.setSenha(pass_Senha.getText());
				
				administrador.setCargo((String)jcb_Cargo.getSelectedItem());
				if(rdbtnFeminino.isSelected()){
					administrador.setGenero("Feminino");
				}else{
					administrador.setGenero("Masculino");
				}
				try {
					administradorDAO.alterar(administrador);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarAdministrador.setBounds(46, 205, 169, 23);
		contentPane.add(btnAtualizarAdministrador);
		
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
		btnCancelar.setBounds(245, 205, 123, 23);
		contentPane.add(btnCancelar);
		
		JLabel lbl_Login = new JLabel("Login:");
		lbl_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Login.setBounds(24, 167, 46, 14);
		contentPane.add(lbl_Login);
		
		txf_Login = new JTextField();
		txf_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Login.setBounds(68, 164, 101, 20);
		contentPane.add(txf_Login);
		txf_Login.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSenha.setBounds(201, 167, 46, 14);
		contentPane.add(lblSenha);
		
		pass_Senha = new JPasswordField();
		pass_Senha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pass_Senha.setBounds(245, 164, 95, 20);
		contentPane.add(pass_Senha);
		
		setLocationRelativeTo(null);
	}
}
