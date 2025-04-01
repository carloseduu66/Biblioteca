package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdministradorDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_DeletarAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txf_Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_DeletarAdministrador frame = new Tela_DeletarAdministrador();
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
	public Tela_DeletarAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_DeletarAdministrador = new JLabel("Deletar Administrador");
		lbl_DeletarAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_DeletarAdministrador.setBounds(134, 11, 185, 14);
		contentPane.add(lbl_DeletarAdministrador);
		
		JLabel lbl_ID = new JLabel("ID:");
		lbl_ID.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_ID.setBounds(24, 45, 46, 14);
		contentPane.add(lbl_ID);
		
		txf_Id = new JTextField();
		txf_Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Id.setBounds(49, 42, 172, 20);
		contentPane.add(txf_Id);
		txf_Id.setColumns(10);
		
		JButton btn_Excluir = new JButton("Excluir");
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministradorDAO administradorDAO = new AdministradorDAO();
				try {
					administradorDAO.deletar(Integer.parseInt(txf_Id.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Excluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Excluir.setBounds(22, 84, 89, 23);
		contentPane.add(btn_Excluir);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_Id.setText("");
			}
		});
		btn_Cancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Cancelar.setBounds(150, 84, 89, 23);
		contentPane.add(btn_Cancelar);
		setLocationRelativeTo(null);
	}

}
