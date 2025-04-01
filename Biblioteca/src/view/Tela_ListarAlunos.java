package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import controller.AlunoDAO;
import model.Aluno;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Tela_ListarAlunos extends JFrame {

	private JPanel contentPane;
	private JTable J_table;
	private JButton btn_Voltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListarAlunos frame = new Tela_ListarAlunos();
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
	public Tela_ListarAlunos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 184);
		contentPane.add(scrollPane);
		
		J_table = new JTable();
		scrollPane.setViewportView(J_table);
		J_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "Matricula:", "Email:", "G\u00EAnero:", "Curso:"
			}
		));
		J_table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Voltar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Voltar.setBounds(165, 227, 89, 23);
		contentPane.add(btn_Voltar);
		
		readJTable();
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) J_table.getModel();
		modelo.setNumRows(0);
		AlunoDAO alunoDAO = new AlunoDAO();
		try {
			for(Aluno aluno:alunoDAO.read()){
				modelo.addRow(new Object[]{
						aluno.getNome(),
						aluno.getMatricula(),
						aluno.getEmail(),
						aluno.getGenero(),
						aluno.getCurso()
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	setLocationRelativeTo(null);
	
	}
}
