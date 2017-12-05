package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import network.data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class thachdauform extends JFrame {

	private JPanel contentPane;
	private JTextField tftd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thachdauform frame = new thachdauform();
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
	ObjectInputStream cin=null;
	public ObjectOutputStream cout=null;
	public thachdauform() {
		setBounds(100, 100, 403, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 387, 142);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(28, 38, 46, 14);
		panel.add(lblEmail);
		
		tftd = new JTextField();
		tftd.setBounds(71, 32, 217, 30);
		panel.add(tftd);
		tftd.setColumns(10);
		
		JButton bttd1 = new JButton("Thách đấu");
		bttd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				String[] data=new String[2];
				data[0]=tftd.getText();		
				data[1]=mainclient.dnf.data2[0];
				data data_sent=new data();
				data_sent.action="thachdau";
				data_sent.data=data;
				try
				{
					cout=new ObjectOutputStream(mainclient.socket.getOutputStream());
					cout.writeObject(data_sent);
					cout.flush();					    			
					System.out.println(data[0]);
				}
				catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Không gửi được tín hiệu",
		            	    "Lỗi",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
			}
		});
		bttd1.setBounds(114, 88, 102, 23);
		panel.add(bttd1);
	}
	public void guiaccept(String[] s)
	{
		data data_sent=new data();
		data_sent.action="ketquatd";
		data_sent.data=s;
		try
		{			
			cout=new ObjectOutputStream(mainclient.socket.getOutputStream());
			cout.writeObject(data_sent);
			cout.flush();					    			
		}
		catch (IOException ex) {
            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
            	    "Không gửi được tín hiệu",
            	    "Lỗi",
            	    JOptionPane.ERROR_MESSAGE);
            
        }
	}
}
