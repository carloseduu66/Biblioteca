package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_DeletarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txf_Matricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_DeletarAluno frame = new Tela_DeletarAluno();
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
	public Tela_DeletarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ExcluirAluno = new JLabel("Excluir Aluno");
		lbl_ExcluirAluno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_ExcluirAluno.setBounds(170, 11, 118, 14);
		contentPane.add(lbl_ExcluirAluno);
		
		JLabel lbl_Matricula = new JLabel("Matr\u00EDcula:");
		lbl_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbl_Matricula.setBounds(27, 38, 65, 14);
		contentPane.add(lbl_Matricula);
		
		txf_Matricula = new JTextField();
		txf_Matricula.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txf_Matricula.setBounds(89, 36, 86, 20);
		contentPane.add(txf_Matricula);
		txf_Matricula.setColumns(10);
		
		JButton btn_Excluir = new JButton("Excluir");
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoDAO alunoDAO = new AlunoDAO();
				try {
					alunoDAO.deletar(txf_Matricula.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso.");
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Excluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Excluir.setBounds(27, 87, 89, 23);
		contentPane.add(btn_Excluir);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txf_Matricula.setText("");
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Cancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Cancelar.setBounds(170, 87, 89, 23);
		contentPane.add(btn_Cancelar);
		
		setLocationRelativeTo(null);
		
	}
}
