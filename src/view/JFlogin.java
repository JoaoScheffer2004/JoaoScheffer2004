package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class JFlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFlogin frame = new JFlogin();
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
	public JFlogin() {
		setTitle(" SisRodovi\u00E1ria - Tela de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISRODOVIARIA- BEM VINDO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(30, 11, 256, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe suas credenciais de acesso:");
		lblNewLabel_1.setBounds(30, 51, 394, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		lblNewLabel_2.setBounds(30, 79, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(83, 76, 362, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setBounds(30, 115, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 112, 362, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Acessar");
		btnNewButton.setBounds(83, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(83, 198, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
