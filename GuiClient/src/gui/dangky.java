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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class dangky extends JFrame {

	private JPanel contentPane;
	private JPasswordField pswd1;
	private JTextField tendn;
	private JPasswordField pswd2;

	/**
	 * Launch the application.
	 */
	ObjectInputStream din = null;
    ObjectOutputStream dout = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangky frame = new dangky();
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
	public dangky() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 287);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngK = new JLabel("\u0110\u0103ng k\u00FD");
		lblngK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblngK.setBounds(100, 11, 105, 33);
		contentPane.add(lblngK);
		
		pswd1 = new JPasswordField();
		pswd1.setBounds(107, 89, 147, 20);
		contentPane.add(pswd1);
		
		tendn = new JTextField();
		tendn.setColumns(10);
		tendn.setBounds(107, 57, 147, 20);
		contentPane.add(tendn);
		
		JLabel label = new JLabel("Email:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(55, 55, 46, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Mật khẩu:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(31, 86, 70, 22);
		contentPane.add(label_1);
		
		JLabel lblNhpLi = new JLabel("Nh\u1EADp l\u1EA1i:");
		lblNhpLi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpLi.setBounds(31, 120, 70, 22);
		contentPane.add(lblNhpLi);
		
		pswd2 = new JPasswordField();
		pswd2.setBounds(107, 123, 147, 20);
		contentPane.add(pswd2);
		
		JButton button = new JButton("Đăng ký");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tendn.getText();
				String pass = pswd1.getText();
				String vpass=pswd2.getText();				
				 if(username.equalsIgnoreCase("")){		            
			            JOptionPane.showMessageDialog(null,
			        		    "Tên đăng nhập để trống.",
			        		    "warning",
			        		    JOptionPane.WARNING_MESSAGE);
			            tendn.requestFocus();
			           
			        }
				 if(pass.equalsIgnoreCase("")){
					 JOptionPane.showMessageDialog(null,
			        		    "Mật khẩu để trống.",
			        		    "warning",
			        		    JOptionPane.WARNING_MESSAGE);
			            pswd1.requestFocus();
			        }
				 if(!vpass.equalsIgnoreCase(pass)){
					 JOptionPane.showMessageDialog(null,
			        		    "Mật khẩu không trùng khớp.",
			        		    "warning",
			        		    JOptionPane.WARNING_MESSAGE);			            
			        }
				 data_socket dtsk = new data_socket();
			        String[] data = new String[2];
			        dtsk.action = "dangky";
			        data[0] = tendn.getText();
			        data[1] = pswd1.getText();
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
		button.setBounds(55, 162, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Hủy");
		button_1.setBounds(178, 162, 89, 23);
		contentPane.add(button_1);
	}
}
