package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdministradorDAO;
import controller.AlunoDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Tela_Login extends JFrame {

	private JPanel tela_Sistema;
	private JTextField txf_Login;
	private JPasswordField pass_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		tela_Sistema = new JPanel();
		tela_Sistema.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela_Sistema);
		tela_Sistema.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Acesso ao Sistema");
		lbl_titulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_titulo.setBounds(159, 11, 189, 14);
		tela_Sistema.add(lbl_titulo);
		
		JLabel lbl_Login = new JLabel("Login:");
		lbl_Login.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_Login.setBounds(10, 42, 46, 14);
		tela_Sistema.add(lbl_Login);
		
		JLabel lbl_Senha = new JLabel("Senha:");
		lbl_Senha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_Senha.setBounds(10, 92, 46, 14);
		tela_Sistema.add(lbl_Senha);
		
		txf_Login = new JTextField();
		txf_Login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Login.setBounds(64, 40, 159, 20);
		tela_Sistema.add(txf_Login);
		txf_Login.setColumns(10);
		
		pass_Senha = new JPasswordField();
		pass_Senha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pass_Senha.setBounds(66, 90, 157, 20);
		tela_Sistema.add(pass_Senha);
		
		JComboBox jcb_Sistema = new JComboBox();
		jcb_Sistema.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Aluno"}));
		jcb_Sistema.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jcb_Sistema.setBounds(116, 131, 159, 20);
		tela_Sistema.add(jcb_Sistema);

		JButton btn_Entrar = new JButton("Entrar");
		btn_Entrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao_Sistema = (String)jcb_Sistema.getSelectedItem();
				//JOptionPane.showMessageDialog(null, opcao_Sistema);
				
				if(jcb_Sistema.getSelectedItem().equals("Administrador")){
					AdministradorDAO administradorDAO = new AdministradorDAO();
					
					if(administradorDAO.checkLogin(txf_Login.getText(), pass_Senha.getText())){
						Tela_Administrador tela_Administrador = new Tela_Administrador();
						tela_Administrador.setVisible(true);
						setVisible(false);
						
					}else{
						JOptionPane.showMessageDialog(null, "Login ou Senha Incorreta.");
						txf_Login.setText("");
						pass_Senha.setText("");
					}
				}else if(jcb_Sistema.getSelectedItem().equals("Aluno")){
					AlunoDAO alunoDAO = new AlunoDAO();
					if(alunoDAO.checkLogin(txf_Login.getText(), pass_Senha.getText())){
						Tela_ListarLivros tela_ListarLivros = new Tela_ListarLivros();
						tela_ListarLivros.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Login ou Senha Incorreta.");
						txf_Login.setText("");
						pass_Senha.setText("");
					}
				}
			}
		});
		btn_Entrar.setBounds(64, 197, 89, 23);
		tela_Sistema.add(btn_Entrar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txf_Login.setText("");
				pass_Senha.setText("");
			}
		});
		btn_Cancelar.setBounds(222, 197, 89, 23);
		tela_Sistema.add(btn_Cancelar);
		
		JList list = new JList();
		list.setBounds(197, 219, 1, 1);
		tela_Sistema.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(234, 205, 1, 1);
		tela_Sistema.add(list_1);
		
		setLocationRelativeTo(null);
	}
}
