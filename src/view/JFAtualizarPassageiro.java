package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.passageiro;
import model.dao.passageiroDAO;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFAtualizarPassageiro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textRG;
	private JTextField textCPF;
	private JTextField textEndereo;
	private JTextField textEmail;
	private JTextField textTelefone;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarPassageiro frame = new JFAtualizarPassageiro(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id2 
	 */
	public JFAtualizarPassageiro(int id) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 405);
		contentPane = new JPanel();
		contentPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passageiroDAO fdao = new passageiroDAO();
		passageiro f = fdao.read(id);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setFont(new Font("Dialog", Font.BOLD, 12));
		lblid.setBounds(445, 17, 23, 24);
		contentPane.add(lblid);
		
		JLabel lblID = new JLabel("New label");
		lblID.setFont(new Font("Dialog", Font.BOLD, 12));
		lblID.setBounds(467, 18, 35, 22);
		contentPane.add(lblID);
		
		JLabel lblNewLabel =  new JLabel("Alterar Passageiro");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(185, 21, 212, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(35, 65, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBounds(90, 62, 212, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JList list = new JList();
		list.setBounds(90, 171, 21, -23);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Genero:");
		lblNewLabel_2.setBounds(35, 93, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setBounds(80, 89, 76, 23);
		contentPane.add(rdbMasculino);
		
		JRadioButton rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setBounds(154, 89, 102, 23);
		contentPane.add(rdbFeminino);
		
		ButtonGroup genero = new ButtonGroup();
		genero.add(rdbMasculino);
		genero.add(rdbFeminino);
		
		JLabel lblNewLabel_3 = new JLabel("RG:");
		lblNewLabel_3.setBounds(35, 117, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textRG = new JTextField();
		textRG.setBounds(90, 115, 204, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(35, 141, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textCPF = new JTextField();
		textCPF.setBounds(90, 145, 204, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Endereço:");
		lblNewLabel_5.setBounds(35, 175, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		textEndereo = new JTextField();
		textEndereo.setBounds(90, 173, 280, 20);
		contentPane.add(textEndereo);
		textEndereo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail:");
		lblNewLabel_6.setBounds(35, 199, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textEmail = new JTextField();
		textEmail.setBounds(90, 199, 280, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setBounds(35, 234, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(90, 232, 280, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		lblID.setText(String.valueOf(f.getId_passageiro()));
		textNome.setText(f.getNome());
		if(rdbMasculino.isSelected()) {
			f.setGenero(false);
		}else if(rdbFeminino.isSelected()) {
			f.setGenero(true);
		}
		
		textRG.setText(f.getRg());
		textCPF.setText(f.getCpf());
		textEndereo.setText(f.getEndereco());
		textEmail.setText(f.getEmail());
		textTelefone.setText(String.valueOf(f.getTelefone()));
		
		
		
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo0) {
				
				passageiro f = new passageiro();
				passageiroDAO dao = new passageiroDAO();
				f.setId_passageiro(Integer.parseInt(lblID.getText()));
				
				f.setNome(textNome.getText());
				if(rdbMasculino.isSelected()) {
					f.setGenero(false);
				}else if(rdbFeminino.isSelected()) {
					f.setGenero(true);
				}
				f.setRg(textRG.getText());
				f.setCpf(textCPF.getText());
				f.setEndereco(textEndereo.getText());
				f.setEmail(textEmail.getText());
				f.setTelefone(Long.parseLong(textTelefone.getText()));
				
				
				dao.create(f);
				dispose ();

				
			}
		});
		btnNewButton.setBounds(35, 289, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1 . addActionListener (new  ActionListener ()  {
			public void actionPerformed (ActionEvent e)  {
				textNome.setText(null);
				textRG.setText(null);
				textCPF.setText(null);
				textEndereo.setText(null);
				textEmail.setText(null);
				textTelefone.setText(null);
				genero.clearSelection();
			}
		});

		btnNewButton_1.setBounds(254, 289, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener (new ActionListener ()  {
			public void actionPerformed (ActionEvent e)  {
				dispose ();
			}
		});

		btnNewButton_2.setBounds(154, 289, 89, 23);
		contentPane.add(btnNewButton_2);
		
	}
}
