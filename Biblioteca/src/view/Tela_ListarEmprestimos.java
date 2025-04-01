package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AlunoDAO;
import controller.EmprestimoDAO;
import model.Aluno;
import model.Emprestimo;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_ListarEmprestimos extends JFrame {

	private JPanel contentPane;
	private JTable J_Table;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListarEmprestimos frame = new Tela_ListarEmprestimos();
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
	public Tela_ListarEmprestimos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 390, 204);
		contentPane.add(scrollPane);
		
		J_Table = new JTable();
		scrollPane.setViewportView(J_Table);
		J_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID:", "Nome Do Aluno:", "Nome Do Livro:", "Data Inicial:", "Data Final:"
			}
		));
		J_Table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnVoltar.setBounds(192, 238, 89, 23);
		contentPane.add(btnVoltar);
		
		readJTable();
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) J_Table.getModel();
		modelo.setNumRows(0);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		try {
			for(Emprestimo emprestimo:EmprestimoDAO.read()){
				modelo.addRow(new Object[]{
						emprestimo.getId(),
						emprestimo.getAluno(),
						emprestimo.getLivro(),
						emprestimo.getData_Inicial(),
						emprestimo.getData_Final(),
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	setLocationRelativeTo(null);
	
	}
}
