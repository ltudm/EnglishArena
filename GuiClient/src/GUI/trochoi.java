package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import network.data;
import network.receive_solve;
import network.thoigian;
import network.thoigianchuan;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class trochoi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public JLabel lbemail1;
	public JLabel lbdct ;
	public JLabel lbemail2;
	public JLabel lbdnt;
	public JLabel lbicon1;
	public JLabel lbicon2;
	public JLabel lbcd;
	public JButton btready;
	public static int ready=0;
	public JButton btcancer;
	public JLabel lbcd2;
	public JLabel lbch;
	public JLabel lbs;
	public JLabel lbms;
	thoigian tg=null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
					    // If Nimbus is not available, you can set the GUI to another look and feel.
					}
					trochoi frame = new trochoi();
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
	public trochoi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				mainclient.mf.setVisible(true);
				mainclient.tc.lbicon1.setVisible(false);
				mainclient.tc.lbicon2.setVisible(false);
				
				data data_sent = new data();
				data_sent.action="dangxuat";
				String[] data=new String[3];
				data[0]=lbemail2.getText();				
				data[1]=mainclient.dnf.data2[0];
				data[2]="huythidau";
				data_sent.data = data;
				try {
		            cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
		            cout.writeObject(data_sent);
		            cout.flush();
		            System.out.println("da gui");		            
		        } catch (IOException ex) {
		            Logger.getLogger(trochoi.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi phát sinh",
		            	    "Lỗi",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
			}
		});
		setBounds(100, 100, 696, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblimCaTui = new JLabel("Điểm của tui:");
		lblimCaTui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimCaTui.setBounds(10, 35, 81, 26);
		panel.add(lblimCaTui);
		
		JLabel label = new JLabel("Điểm người ta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(425, 35, 91, 26);
		panel.add(label);
		
		lbs = new JLabel("0");
		lbs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbs.setBounds(278, 35, 20, 26);
		panel.add(lbs);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(296, 35, 20, 26);
		panel.add(label_1);
		
		lbms = new JLabel("0");
		lbms.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbms.setBounds(310, 35, 20, 26);
		panel.add(lbms);
		
		JLabel tclb = new JLabel("Email:");
		tclb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tclb.setBounds(480, 11, 91, 26);
		panel.add(tclb);
		
		JLabel lbtc2 = new JLabel("Email:");
		lbtc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbtc2.setBounds(51, 11, 91, 26);
		panel.add(lbtc2);
		
		lbemail1 = new JLabel("0");
		lbemail1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbemail1.setBounds(93, 11, 128, 26);
		panel.add(lbemail1);
		
		lbdct = new JLabel("0");
		lbdct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbdct.setBounds(93, 35, 91, 26);
		panel.add(lbdct);
		
		lbemail2 = new JLabel("0");
		lbemail2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbemail2.setBounds(526, 11, 119, 26);
		panel.add(lbemail2);
		
		lbdnt = new JLabel("0");
		lbdnt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbdnt.setBounds(526, 35, 91, 26);
		panel.add(lbdnt);
							
		lbicon1 = new JLabel("");
		lbicon1.setBounds(0, 61, 54, 46);
		panel.add(lbicon1);
		
		lbcd = new JLabel("");
		lbcd.setHorizontalAlignment(SwingConstants.CENTER);
		lbcd.setForeground(Color.RED);
		lbcd.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbcd.setBounds(286, 61, 46, 40);
		panel.add(lbcd);
		

		lbcd2 = new JLabel("");
		lbcd2.setHorizontalAlignment(SwingConstants.CENTER);
		lbcd2.setForeground(Color.RED);
		lbcd2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbcd2.setBounds(278, 61, 46, 40);
		panel.add(lbcd2);
		
		btready = new JButton("Sẵn sàng");
		btready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbicon1.setVisible(true);
				lbicon1.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/ready-icon.png")).getImage().getScaledInstance(32,32, Image.SCALE_DEFAULT)));
				data data_sent=new data();
				String[] data = new String[3];
				data_sent.action="sansang";				
				data[0]=lbemail2.getText();				
				data[1]=mainclient.dnf.data2[0];
				data[2]="1";
				data_sent.data=data;
				if(ready==2)
				{
					lbcd.setVisible(false);
					mainclient.tc.btready.setVisible(false);
	    			mainclient.tc.btcancer.setVisible(false);
	    			thoigianchuan tg=new thoigianchuan(1);
	    			tg.start();
	    			ready=1;
	    			mainclient.tc.btready.setVisible(false);
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
	    			receive_solve.loadcauhoi();
				}
				else
				{
	    			ready=1;
	    			mainclient.tc.btready.setVisible(false);
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
				
				
			}
		});
		btready.setBounds(150, 216, 89, 23);
		panel.add(btready);
		
		btcancer = new JButton("Hủy bỏ");
		btcancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huybo();
			}
		});
		btcancer.setBounds(390, 216, 89, 23);
		panel.add(btcancer);
		
		lbicon2 = new JLabel("");
		lbicon2.setBounds(425, 61, 54, 46);
		panel.add(lbicon2);					
		
		lbch = new JLabel("");
		lbch.setBackground(SystemColor.window);
		lbch.setForeground(Color.BLACK);
		lbch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbch.setBounds(51, 107, 569, 56);
		lbch.setOpaque(true);
		panel.add(lbch);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainclient.tgc.dieukienlap(false);
			}
		});
		btnNewButton.setBounds(29, 216, 89, 23);
		panel.add(btnNewButton);
	}
	public void huybo()
	{
	data data_sent = new data();
	data_sent.action="dangxuat";
	String[] data=new String[3];
	data[0]=lbemail2.getText();				
	data[1]=mainclient.dnf.data2[0];
	data[2]="huythidau";
	data_sent.data = data;
	try {
        cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
        cout.writeObject(data_sent);
        cout.flush();		         
        System.out.println("da gui");	
        mainclient.tc.setVisible(false);
    	mainclient.mf.setVisible(true);
    } catch (IOException ex) {
        Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,
        	    "Lỗi phát sinh",
        	    "Lỗi",
        	    JOptionPane.ERROR_MESSAGE);
        
    }
    }
}
