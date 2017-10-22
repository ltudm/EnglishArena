package GUI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import network.data;
import network.receive_solve;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;


public class mainform extends JFrame {

	private JPanel contentPane;
	public static JTable bangdiem;
    ObjectOutputStream cout = null;
    ObjectInputStream cin = null;
  
	/**
	 * Launch the application.
	 */
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
					mainform frame = new mainform();
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
	public ArrayList<String[]> data_arr = new ArrayList<>();
	public mainform() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 673, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xin chào:");
		lblNewLabel.setBounds(10, 11, 57, 15);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		JButton bttest = new JButton("test");
		bttest.setBounds(20, 64, 89, 23);
		panel.add(bttest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(381, 79, 282, 95);
		panel.add(scrollPane);
		
		bangdiem = new JTable();
		scrollPane.setViewportView(bangdiem);
		bangdiem.setBounds(432, 64, 201, 133);
		bangdiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Email", "Ng\u00E0y", "\u0110i\u1EC3m", "K\u1EBFt qu\u1EA3"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bangdiem.getColumnModel().getColumn(2).setPreferredWidth(50);
		bangdiem.getColumnModel().getColumn(2).setMinWidth(50);
		bangdiem.getColumnModel().getColumn(3).setPreferredWidth(50);
		bangdiem.getColumnModel().getColumn(3).setMinWidth(50);
		bangdiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bangdiem.getColumnModel().getColumn(0).setPreferredWidth(100);		
		bangdiem.setRowHeight(20);
		
		JButton bttd = new JButton("Thách đấu");
		bttd.setBounds(381, 203, 89, 23);
		panel.add(bttd);
		
		JButton btbd = new JButton("Bắt đầu");
		btbd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				data data_sent = new data();
				data_sent.action="ghepdoi";
				data_sent.data = mainclient.dnf.data2;
				try {
		            cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
		            cout.writeObject(data_sent);
		            cout.flush();
		            System.out.println("da gui");
		            JOptionPane.showMessageDialog(null,
		            	    "Đang tìm kiếm người dùng",
		            	    "Thông báo",
		            	    JOptionPane.ERROR_MESSAGE);
		            btbd.setEnabled(false);
		        } catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi",
		            	    "Lỗi phát sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
						  btbd.setEnabled(true);;
					  }
					}, 10*1000);
			}
		});
		btbd.setBounds(20, 134, 89, 23);
		panel.add(btbd);


		
		bttest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*data data_sent = new data();
				data_sent.action="ghepdoi";
		        data_sent.data = mainclient.dnf.data2;
		        //receive_solve.gui(data_sent);
		       try {
		            cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
		            cout.writeObject(data_sent);
		            cout.flush();
		           
		            System.out.println(data_sent.action);
		        } catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi",
		            	    "Lỗi phát sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }*/
				btbd.setEnabled(false);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
						  btbd.setEnabled(true);;
					  }
					}, 10*1000);
		   
				
			}
		});
	}
}
