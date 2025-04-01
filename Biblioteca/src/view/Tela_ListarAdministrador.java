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
import controller.AlunoDAO;
import model.Administrador;
import model.Aluno;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_ListarAdministrador extends JFrame {

	private JPanel contentPane;
	private JTable J_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListarAdministrador frame = new Tela_ListarAdministrador();
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
	public Tela_ListarAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 29, 388, 197);
		contentPane.add(scrollPane);
		
		J_Table = new JTable();
		scrollPane.setViewportView(J_Table);
		J_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id","Nome:", "Cargo:", "G\u00EAnero:"
			}
		));
		J_Table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Administrador tela_Administrador = new Tela_Administrador();
				tela_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_Voltar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Voltar.setBounds(181, 237, 89, 23);
		contentPane.add(btn_Voltar);
		
		readJTable();
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) J_Table.getModel();
		modelo.setNumRows(0);
		AdministradorDAO administradorDAO = new AdministradorDAO();
		try {
			for(Administrador administrador:administradorDAO.read()){
				modelo.addRow(new Object[]{
						administrador.getId(),
						administrador.getNome(),
						administrador.getCargo(),
						administrador.getGenero()
				});
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	setLocationRelativeTo(null);

	}
}