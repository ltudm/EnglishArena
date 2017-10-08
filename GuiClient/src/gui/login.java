package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import BUS.*;

public class login {

	private JFrame frame;
	private JPasswordField pswdf;
	private JTextField emailf;

	/**
	 * Launch the application.
	 */
	ObjectInputStream din = null;
    ObjectOutputStream dout = null;
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
		
		pswdf = new JPasswordField();
		pswdf.setBounds(105, 79, 147, 20);
		panel.add(pswdf);
		
		emailf = new JTextField();
		emailf.setBounds(105, 47, 147, 20);
		panel.add(emailf);
		emailf.setColumns(10);
		
		JButton dnbt = new JButton("\u0110\u0103ng nh\u1EADp");
		dnbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data_socket dtsk = new data_socket();
		        String[] data = new String[2];
		        dtsk.action = "login";
		        data[0] = emailf.getText();
		        data[1] = pswdf.getText();
		        dtsk.data = data;
		        try {
		        	connectserver cnsv = new connectserver();
		            dout = new ObjectOutputStream(cnsv.socket.getOutputStream());
		            dout.writeObject(dtsk);
		            dout.flush();
					Thread receive=new receive(cnsv.socket);
					receive.start();
					System.out.println("conected");
								
		        } catch (IOException ex) {
		            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(frame,
		            	    "Lỗi",
		            	    "Lỗi phát sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
				
			}
		});
		dnbt.setBounds(53, 118, 101, 23);
		panel.add(dnbt);
		
		JButton dkbt = new JButton("\u0110\u0103ng k\u00FD");
		dkbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dangky dkf=new dangky();
				dkf.setVisible(true);
			}
		});
		dkbt.setBounds(194, 118, 89, 23);
		panel.add(dkbt);
		
		JButton btnHy = new JButton("H\u1EE7y");
		btnHy.setBounds(194, 152, 89, 23);
		panel.add(btnHy);
	}
}
