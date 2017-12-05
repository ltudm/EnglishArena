package GUI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;


public class mainform extends JFrame {

	private JPanel contentPane;
	public static JTable bangdiem;
    ObjectOutputStream cout = null;
    ObjectInputStream cin = null;
    public static JLabel lbemailmf=null;
  
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
		setBackground(new Color(255, 255, 153));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				data data_sent = new data();
				data_sent.action="dangxuat";
				String[] data=new String[3];
				data[0]=mainclient.dnf.data2[1];				
				data[1]=mainclient.dnf.data2[0];
				data[2]="dangxuat";
				data_sent.data = data;
				try {
		            cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
		            cout.writeObject(data_sent);
		            cout.flush();
		            System.out.println("da gui");		            
		        } catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi phát sinh",
		            	    "Lỗi",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, UIManager.getColor("TabbedPane.light"), null));
		panel.setBounds(0, 0, 673, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(mainform.class.getResource("/resource/user.png")));
		lblNewLabel.setBounds(490, 11, 163, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		JButton bttest = new JButton("test");
		bttest.setBounds(29, 163, 89, 49);
		panel.add(bttest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(UIManager.getBorder("TextArea.border"));
		scrollPane.setBounds(395, 133, 258, 179);
		panel.add(scrollPane);
		
		bangdiem = new JTable();
		bangdiem.setBackground(UIManager.getColor("Table.focusCellBackground"));
		bangdiem.setEnabled(false);
		bangdiem.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(bangdiem);
		bangdiem.setBounds(432, 64, 201, 133);
		bangdiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
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
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bangdiem.getColumnModel().getColumn(0).setPreferredWidth(103);
		bangdiem.getColumnModel().getColumn(2).setPreferredWidth(73);
		bangdiem.getColumnModel().getColumn(2).setMinWidth(50);
		bangdiem.getColumnModel().getColumn(3).setPreferredWidth(69);
		bangdiem.getColumnModel().getColumn(3).setMinWidth(50);
		bangdiem.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(245, 255, 250)));
		bangdiem.setRowHeight(20);
		
		JButton bttd = new JButton(" Thách đấu");
		bttd.setBackground(new Color(135, 206, 250));
		bttd.setFont(new Font("Tahoma", Font.BOLD, 12));
		bttd.setIcon(new ImageIcon(mainform.class.getResource("/resource/multimedia.png")));
		bttd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainclient.tdf.setVisible(true);
							
			}
		});
		bttd.setBounds(266, 163, 119, 49);
		panel.add(bttd);
		
		JButton btbd = new JButton(" Bắt đầu");
		btbd.setForeground(new Color(0, 0, 0));
		btbd.setBackground(new Color(240, 128, 128));
		btbd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btbd.setIcon(new ImageIcon(mainform.class.getResource("/resource/people.png")));
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
		            	    "Đang tìm kiếm người chơi online trong 10s",
		            	    "Thông báo",
		            	    JOptionPane.INFORMATION_MESSAGE);
		            btbd.setEnabled(false);
		        } catch (IOException ex) {
		            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
		            JOptionPane.showMessageDialog(null,
		            	    "Lỗi",
		            	    "Lỗi",
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
		btbd.setBounds(128, 163, 119, 49);
		panel.add(btbd);
		
		lbemailmf = new JLabel("");
		lbemailmf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbemailmf.setBounds(519, 21, 134, 15);
		panel.add(lbemailmf);
		JLabel label_3 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/logo2.png")).getImage();
		label_3 .setIcon(new ImageIcon(image));
		label_3.setBounds(36, 12, 294, 98);
		panel.add(label_3);
		
		JLabel lblBngThnhTch = new JLabel("  B\u1EA3ng th\u00E0nh t\u00EDch");
		lblBngThnhTch.setIcon(new ImageIcon("/resource/.png"));
		lblBngThnhTch.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblBngThnhTch.setBounds(490, 95, 163, 32);
		panel.add(lblBngThnhTch);
		


		
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
		            	    "Lá»—i",
		            	    "Lá»—i phÃ¡t sinh",
		            	    JOptionPane.ERROR_MESSAGE);
		            
		        }*/
				/*btbd.setEnabled(false);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
						  btbd.setEnabled(true);;
					  }
					}, 10*1000);*/				
				
			}
		});
	}
}
