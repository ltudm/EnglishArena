package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hinhnenform extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hinhnenform frame = new hinhnenform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JLabel lbhinh;
	public JLabel lbtext;

	/**
	 * Create the frame.
	 */
	public hinhnenform() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try
				{
					mainclient.mf.setVisible(true);
					mainclient.tc.lbicon1.setVisible(false);
					mainclient.tc.lbicon2.setVisible(false);
					mainclient.tgc.dieukienlap(false);
				}
				 catch (Exception ex) {
			            Logger.getLogger(trochoi.class.getName()).log(Level.SEVERE, null, ex);
			            JOptionPane.showMessageDialog(null,
			            	    "Lỗi phát sinh",
			            	    "Lỗi",
			            	    JOptionPane.ERROR_MESSAGE);			            
			        }
			}
		});
		setBounds(100, 100, 757, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 741, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbhinh = new JLabel("");
		lbhinh.setBounds(0, 0, 741, 341);
		panel.add(lbhinh);
		//lbhinh.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/ready-icon.png")).getImage().getScaledInstance(32,32, Image.SCALE_DEFAULT)));
		
		lbtext = new JLabel("New label");
		lbtext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbtext.setBounds(246, 352, 250, 30);
		panel.add(lbtext);
	}
}
