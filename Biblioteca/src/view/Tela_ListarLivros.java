package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import controller.AdministradorDAO;
import controller.LivroDAO;
import model.Administrador;
import model.Livro;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_ListarLivros extends JFrame {

	private JPanel contentPane;
	private JTable J_Table;
	private JButton btn_Voltar;
	private JButton btn_RealizarEmprstimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListarLivros frame = new Tela_ListarLivros();
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
	public Tela_ListarLivros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 21, 372, 202);
		contentPane.add(scrollPane);
		
		J_Table = new JTable();
		scrollPane.setViewportView(J_Table);
		J_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "T\u00EDtulo:", "Autor:", "G\u00EAnero"
			}
		));
		J_Table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Voltar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Voltar.setBounds(249, 234, 129, 23);
		contentPane.add(btn_Voltar);
		
		btn_RealizarEmprstimo = new JButton("Realizar Empr\u00E9stimo");
		btn_RealizarEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_RealizarEmprestimo tela_RealizarEmprestimo = new Tela_RealizarEmprestimo();
				tela_RealizarEmprestimo.setVisible(true);
				setVisible(true);
			}
		});
		btn_RealizarEmprstimo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_RealizarEmprstimo.setBounds(68, 234, 158, 23);
		contentPane.add(btn_RealizarEmprstimo);
		
		readJTable();
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) J_Table.getModel();
		modelo.setNumRows(0);
		LivroDAO livroDAO = new LivroDAO();
		try {
			for(Livro livro:livroDAO.read()){
				modelo.addRow(new Object[]{
						livro.getCodigo(),
						livro.getTitulo_Livro(),
						livro.getAutor_Livro(),
						livro.getGenero(),
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	setLocationRelativeTo(null);
	}
}
