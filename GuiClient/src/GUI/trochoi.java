package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class trochoi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static JLabel lbemail1;
	public static JLabel lbdct ;
	public static JLabel lbemail2;
	public static JLabel lbdnt;
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
	
	public trochoi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				mainclient.mf.setVisible(true);
			}
		});
		setBounds(100, 100, 628, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 612, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblimCaTui = new JLabel("Điểm của tui:");
		lblimCaTui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimCaTui.setBounds(10, 35, 81, 26);
		panel.add(lblimCaTui);
		
		JLabel label = new JLabel("Điểm người ta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(382, 35, 91, 26);
		panel.add(label);
		
		JLabel lbs = new JLabel("0");
		lbs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbs.setBounds(251, 35, 20, 26);
		panel.add(lbs);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(269, 35, 20, 26);
		panel.add(label_1);
		
		JLabel lbms = new JLabel("0");
		lbms.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbms.setBounds(283, 35, 20, 26);
		panel.add(lbms);
		
		JLabel tclb = new JLabel("Email:");
		tclb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tclb.setBounds(437, 11, 91, 26);
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
		lbemail2.setBounds(483, 11, 119, 26);
		panel.add(lbemail2);
		
		lbdnt = new JLabel("0");
		lbdnt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbdnt.setBounds(483, 35, 91, 26);
		panel.add(lbdnt);
	}
}
