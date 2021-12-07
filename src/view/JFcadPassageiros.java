package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.passageiro;
import model.dao.passageiroDAO;

import javax.swing.SwingConstants;

public class JFcadPassageiros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textRG;
	private JTextField textTelefone;
	private JTextField textEndereo;
	private JTextField textEmail;
	private JTextField textCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFcadPassageiros frame = new JFcadPassageiros();
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
	public JFcadPassageiros() {
		setTitle("SisRodoviária - Cadastrar Passageiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Passageiros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 10, 549, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);    
		lblNewLabel_1.setBounds(30, 44, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setBounds(30, 63, 412, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JList list = new JList();
		list.setBounds(90, 171, 21, -23);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Gênero:");
		lblNewLabel_2.setBounds(247, 230, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbMasc = new JRadioButton("Masculino");
		rdbMasc.setBounds(286, 226, 71, 23);
		contentPane.add(rdbMasc);
		
		JRadioButton rdbFem = new JRadioButton("Feminino");
		rdbFem.setBounds(359, 226, 109, 23);
		contentPane.add(rdbFem);
		
		ButtonGroup genero = new ButtonGroup();
		genero.add(rdbMasc);
		genero.add(rdbFem);
		
		JLabel lblNewLabel_3 = new JLabel("RG:");
		lblNewLabel_3.setBounds(30, 171, 56, 14);
		contentPane.add(lblNewLabel_3);
		
		textRG = new JTextField();
		textRG.setBounds(30, 184, 195, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(235, 171, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(30, 228, 207, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Endereço:");
		lblNewLabel_5.setBounds(30, 93, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		textEndereo = new JTextField();
		textEndereo.setBounds(30, 106, 412, 20);
		contentPane.add(textEndereo);
		textEndereo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		lblNewLabel_6.setBounds(30, 136, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textEmail = new JTextField();
		textEmail.setBounds(31, 147, 411, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setBounds(30, 214, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textCPF = new JTextField();
		textCPF.setBounds(235, 184, 207, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnCAD = new JButton("Cadastrar");
		btnCAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo0) {
				
				passageiro f = new passageiro();
				passageiroDAO dao = new passageiroDAO();
				
				f.setNome(textName.getText());
				if(rdbMasc.isSelected()) {
					f.setGenero(false);
				}else if(rdbFem.isSelected()) {
					f.setGenero(true);
				}
				f.setRg(textRG.getText());
				f.setCpf(textCPF.getText());
				f.setEndereco(textEndereo.getText());
				f.setEmail(textEmail.getText());
				f.setTelefone(Long.parseLong(textTelefone.getText())) ;
				
				
				dao.create(f);
				dispose();

				
			}
		});
		btnCAD.setBounds(30, 282, 89, 23);
		contentPane.add(btnCAD);
		
		JButton btnLimp = new JButton("Limpar");
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText(null);
				textRG.setText(null);
				textCPF.setText(null);
				textEndereo.setText(null);
				textEmail.setText(null);
				textTelefone.setText(null);
				genero.clearSelection();
			}
		});

		btnLimp.setBounds(228, 282, 89, 23);
		contentPane.add(btnLimp);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnCancel.setBounds(129, 282, 89, 23);
		contentPane.add(btnCancel);
	}
}
