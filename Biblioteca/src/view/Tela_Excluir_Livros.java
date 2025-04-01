package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LivroDAO;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_Excluir_Livros extends JFrame {

	private JPanel contentPane;
	private JTextField txf_CodigoLivro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Excluir_Livros frame = new Tela_Excluir_Livros();
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
	public Tela_Excluir_Livros() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministradorExcluir = new JLabel("Administrador - Excluir Livros");
		lblAdministradorExcluir.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdministradorExcluir.setBounds(121, 25, 279, 14);
		contentPane.add(lblAdministradorExcluir);
		
		JLabel lblCodigoDoLivro = new JLabel("C\u00F3digo do Livro:");
		lblCodigoDoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCodigoDoLivro.setBounds(10, 63, 97, 14);
		contentPane.add(lblCodigoDoLivro);
		
		txf_CodigoLivro = new JTextField();
		txf_CodigoLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_CodigoLivro.setBounds(103, 60, 207, 20);
		contentPane.add(txf_CodigoLivro);
		txf_CodigoLivro.setColumns(10);
		
		JButton btnExcluirLivro = new JButton("Excluir Livro");
		btnExcluirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroDAO livroDAO = new LivroDAO();
				try {
					livroDAO.deletar(Integer.parseInt(txf_CodigoLivro.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				JOptionPane.showMessageDialog(null, "Livro Excluído com Sucesso.");
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnExcluirLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnExcluirLivro.setBounds(59, 106, 116, 23);
		contentPane.add(btnExcluirLivro);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_CodigoLivro.setText("");
			}
		});
		btn_Cancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Cancelar.setBounds(211, 106, 116, 23);
		contentPane.add(btn_Cancelar);
		setLocationRelativeTo(null);
	}
}
