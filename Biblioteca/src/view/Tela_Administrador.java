	package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Administrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Administrador frame = new Tela_Administrador();
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
	public Tela_Administrador() {
		setFont(new Font("Times New Roman", Font.BOLD, 12));
		setTitle("BIBLIOTECA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdministrador.setBounds(155, 11, 181, 14);
		contentPane.add(lblAdministrador);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Cadastro_Aluno tela_Cadastro_Aluno = new Tela_Cadastro_Aluno();
				tela_Cadastro_Aluno.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarAluno.setBounds(26, 36, 143, 23);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Livro tela_Livro = new Tela_Livro();
				tela_Livro.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrarLivro.setBounds(26, 172, 143, 23);
		contentPane.add(btnCadastrarLivro);
		
		JButton btnDevolverLivro = new JButton("Devolver Livro");
		btnDevolverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_DevolucaoLivro tela_DevolucaoLivro = new Tela_DevolucaoLivro();
				tela_DevolucaoLivro.setVisible(true);
				setVisible(false);
			}
		});
		btnDevolverLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDevolverLivro.setBounds(26, 233, 143, 23);
		contentPane.add(btnDevolverLivro);
		
		JButton btnExcluirLivro = new JButton("Excluir Livro");
		btnExcluirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Excluir_Livros tela_Excluir_Livros = new Tela_Excluir_Livros();
				tela_Excluir_Livros.setVisible(true);
				setVisible(false);
			}
		});
		btnExcluirLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnExcluirLivro.setBounds(221, 204, 189, 23);
		contentPane.add(btnExcluirLivro);
		
		JButton btnCadastrarAdministrador = new JButton("Cadastrar Administrador");
		btnCadastrarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_Cadastro_Administrador tela_Cadastro_Administrador = new Tela_Cadastro_Administrador();
				tela_Cadastro_Administrador.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrarAdministrador.setBounds(221, 36, 189, 23);
		contentPane.add(btnCadastrarAdministrador);
		
		JButton btnAtualizarLivro = new JButton("Atualizar Livro");
		btnAtualizarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_AtualizarLivroCompleto tela_AtualizarLivroCompleto = new Tela_AtualizarLivroCompleto();
				tela_AtualizarLivroCompleto.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarLivro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarLivro.setBounds(221, 172, 189, 23);
		contentPane.add(btnAtualizarLivro);
		
		JButton btn_ListarLivros = new JButton("Listar Livros");
		btn_ListarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListarLivros tela_ListarLivros = new Tela_ListarLivros();
				tela_ListarLivros.setVisible(true);
				setVisible(false);
			}
		});
		btn_ListarLivros.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_ListarLivros.setBounds(26, 204, 143, 23);
		contentPane.add(btn_ListarLivros);
		
		JButton btnAtualizarAluno = new JButton("Atualizar Aluno");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_AtualizarAlunoCompleto tela_AtualizarAlunoCompleto = new Tela_AtualizarAlunoCompleto();
				tela_AtualizarAlunoCompleto.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarAluno.setBounds(26, 104, 143, 23);
		contentPane.add(btnAtualizarAluno);
		
		JButton btnDeletarAluno = new JButton("Deletar Aluno");
		btnDeletarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_DeletarAluno tela_DeletarAluno = new Tela_DeletarAluno();
				tela_DeletarAluno.setVisible(true);
				setVisible(false);
			}
		});
		btnDeletarAluno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDeletarAluno.setBounds(26, 138, 143, 23);
		contentPane.add(btnDeletarAluno);
		
		JButton btn_ListarAlunos = new JButton("Listar Alunos");
		btn_ListarAlunos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_ListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_ListarAlunos tela_ListarAlunos = new Tela_ListarAlunos();
				tela_ListarAlunos.setVisible(true);
				setVisible(false);
			}
		});
		btn_ListarAlunos.setBounds(26, 70, 143, 23);
		contentPane.add(btn_ListarAlunos);
		
		JButton btnListarAdministradores = new JButton("Listar Administradores");
		btnListarAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListarAdministrador tela_ListarAdministrador = new Tela_ListarAdministrador();
				tela_ListarAdministrador.setVisible(true);
				setVisible(false);
			}
		});
		btnListarAdministradores.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnListarAdministradores.setBounds(221, 70, 189, 23);
		contentPane.add(btnListarAdministradores);
		
		JButton btn_RelatorioDeEmprstimos = new JButton("Relat\u00F3rio De Empr\u00E9stimos");
		btn_RelatorioDeEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListarEmprestimos tela_ListarEmprestimos = new Tela_ListarEmprestimos();
				tela_ListarEmprestimos.setVisible(true);
				setVisible(true);
			}
		});
		btn_RelatorioDeEmprstimos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_RelatorioDeEmprstimos.setBounds(221, 233, 189, 23);
		contentPane.add(btn_RelatorioDeEmprstimos);
		
		JButton btn_AtualizarAdministradores = new JButton("Atualizar Administradores");
		btn_AtualizarAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_AtualizarAdministrador tela_AtualizarAdministrador = new Tela_AtualizarAdministrador();
				tela_AtualizarAdministrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_AtualizarAdministradores.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_AtualizarAdministradores.setBounds(221, 104, 189, 23);
		contentPane.add(btn_AtualizarAdministradores);
		
		JButton btn_DeletarAdministrador = new JButton("Deletar Administrador");
		btn_DeletarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_DeletarAdministrador tela_DeletarAdministrador = new Tela_DeletarAdministrador();
				tela_DeletarAdministrador.setVisible(true);
				setVisible(false);
			}
		});
		btn_DeletarAdministrador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_DeletarAdministrador.setBounds(221, 138, 189, 23);
		contentPane.add(btn_DeletarAdministrador);
		
		setLocationRelativeTo(null);
	}
}
