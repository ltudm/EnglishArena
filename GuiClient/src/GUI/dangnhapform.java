package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import GUI.dangkyform;
import network.data;
import network.receive_solve;


public class dangnhapform extends JFrame {

	private JPanel contentPane;
	private JTextField emailf;
	private JPasswordField pswdf;
	public String[] data2=new String[2];
	public JLabel lbvs3=null;

	/**
	 * Launch the application.
	 */
	ObjectInputStream cin = null;
    ObjectOutputStream cout = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhapform frame = new dangnhapform();
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
	public dangnhapform() {
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
		label_1.setBounds(44, 57, 46, 20);
		panel.add(label_1);
		
		emailf = new JTextField();
		emailf.setColumns(10);
		emailf.setBounds(101, 55, 147, 28);
		panel.add(emailf);
		
		JLabel label_2 = new JLabel("Mật khẩu:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(21, 92, 70, 22);
		panel.add(label_2);
		
		pswdf = new JPasswordField();
		pswdf.setBounds(101, 91, 147, 28);
		panel.add(pswdf);
		
		lbvs3 = new JLabel("1.0");
		lbvs3.setBounds(61, 171, 60, 14);
		panel.add(lbvs3);
		
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
				data data_sent= new data();
		        String[] data = new String[3];
		        data_sent.action = "login";
		        data[0] = emailf.getText();
		        data[1] = pswdf.getText();
		        data[2] = lbvs3.getText();
		        data_sent.data = data;		       
		        data2=data;
		        try {
		            cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
		            cout.writeObject(data_sent);
		            cout.flush();		        	
					System.out.println("conected");
		        }			
		        catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi",
		            	    "Lỗi phát sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
			}
		});
		dnbt.setBounds(62, 132, 94, 24);
		panel.add(dnbt);
		
		JButton dkbt = new JButton("Đăng ký");
		dkbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainclient.dkf=new dangkyform();
				mainclient.dkf.setVisible(true);				
				
			}
		});
		dkbt.setBounds(186, 132, 85, 24);
		panel.add(dkbt);
		
		JLabel lbvs2 = new JLabel("Phiên bản:");
		lbvs2.setBounds(0, 171, 67, 14);
		panel.add(lbvs2);
		
		
	}
}
