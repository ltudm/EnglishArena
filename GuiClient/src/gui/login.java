package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.connectserver;
import BUS.data_socket;
import BUS.receive;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField emailf;
	private JPasswordField pswdf;

	/**
	 * Launch the application.
	 */
	ObjectInputStream din = null;
    ObjectOutputStream dout = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 338, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Đăng nhập");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(123, 11, 105, 33);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Email:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(49, 56, 46, 20);
		panel.add(label_1);
		
		emailf = new JTextField();
		emailf.setColumns(10);
		emailf.setBounds(101, 58, 147, 20);
		panel.add(emailf);
		
		JLabel label_2 = new JLabel("Mật khẩu:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(25, 87, 70, 22);
		panel.add(label_2);
		
		pswdf = new JPasswordField();
		pswdf.setBounds(101, 90, 147, 20);
		panel.add(pswdf);
		
		JButton dnbt = new JButton("Đăng nhập");
		dnbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tendn=emailf.getText();
				String pass=pswdf.getText();
				 if(tendn.equalsIgnoreCase("")){		            
			            JOptionPane.showMessageDialog(null,
			        		    "Chưa nhập tên đăng nhập.",
			        		    "warning",
			        		    JOptionPane.WARNING_MESSAGE);
			            emailf.requestFocus();	
			            return;
			        }
				 if(pass.equalsIgnoreCase("")){		            
			            JOptionPane.showMessageDialog(null,
			        		    "Chưa nhập tên mật khẩu.",
			        		    "warning",
			        		    JOptionPane.WARNING_MESSAGE);
			            emailf.requestFocus();	
			            return;
			        }
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
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi",
		            	    "Lỗi phát sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
			}
		});
		dnbt.setBounds(49, 129, 101, 23);
		panel.add(dnbt);
		
		JButton dkbt = new JButton("Đăng ký");
		dkbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dangky dkf=new dangky();
				dkf.setVisible(true);
			}
		});
		dkbt.setBounds(190, 129, 89, 23);
		panel.add(dkbt);
	}
}
