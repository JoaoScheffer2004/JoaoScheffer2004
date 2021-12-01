package view;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.passageiro;
import model.dao.passageiroDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFListarPassageiros extends JFrame {

	private JPanel contentPane;
	private JTable JTPassageiros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarPassageiros frame = new JFListarPassageiros();
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
	public JFListarPassageiros() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				readJTable();
			}
		});
		setTitle(" Listar Passageiros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Passageiros");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 23, 287, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 64, 480, 152);
		contentPane.add(scrollPane);
		
		JTPassageiros = new JTable();
		JTPassageiros.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"IDPassageiro", "Nome", "Genero", "RG", "CPF", "Endereco", "E-mail", "Telefone"
			}
		));
		scrollPane.setViewportView(JTPassageiros);
		
		JButton btnCadastrarPassageiro = new JButton("Cadastrar");
		btnCadastrarPassageiro.setBounds(28, 250, 140, 23);
		contentPane.add(btnCadastrarPassageiro);
		
		JButton btnAlterarPassageiro = new JButton("Alterar");
		btnAlterarPassageiro.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 

				 if(JTPassageiros.getSelectedRow()!= -1) {
						JFAtualizarPassageiro af = new JFAtualizarPassageiro((int)JTPassageiros.getValueAt(JTPassageiros.getSelectedRow(),0));
						af.setVisible(true);	
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um Passageiro!");
					}
				 readJTable();
			}		 
		});
		btnAlterarPassageiro.setBounds(178, 250, 140, 23);
		contentPane.add(btnAlterarPassageiro);
		
		JButton btnExcluirPassageiro = new JButton("Excluir");
		btnExcluirPassageiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JTPassageiros.getSelectedRow() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o passageiro selecionado?","Excluso", JOptionPane.YES_NO_OPTION);
						if(opcao == 0) {
					
						passageiroDAO dao = new passageiroDAO();
						passageiro f = new passageiro();
						f.setId_passageiro((int)JTPassageiros.getValueAt(JTPassageiros.getSelectedRow(), 0));
						dao.delete(f);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um Passageiro!");
				}
				readJTable();  
			}
		});
		btnExcluirPassageiro.setBounds(328, 250, 140, 23);
		contentPane.add(btnExcluirPassageiro);
		readJTable(); 
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTPassageiros.getModel();
		modelo.setNumRows(0);
		passageiroDAO fdao = new passageiroDAO();
		for(passageiro f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getId_passageiro(),
					f.getNome(),
					f.getGenero(),
					f.getRg(),
					f.getCpf(),
					f.getEndereco(),
					f.getEmail(),
					f.getTelefone()
			});
		}
	}
}
