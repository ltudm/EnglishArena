package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 349, 182);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblngNhp = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblngNhp.setBounds(127, 0, 105, 33);
		lblngNhp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblngNhp);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(53, 45, 46, 20);
		panel.add(lblEmail);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhu.setBounds(29, 76, 70, 22);
		panel.add(lblMtKhu);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 79, 147, 20);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(105, 47, 147, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.setBounds(65, 118, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnngK = new JButton("\u0110\u0103ng k\u00FD");
		btnngK.setBounds(194, 118, 89, 23);
		panel.add(btnngK);
		
		JButton btnHy = new JButton("H\u1EE7y");
		btnHy.setBounds(194, 152, 89, 23);
		panel.add(btnHy);
	}
}
