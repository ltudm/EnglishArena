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

public class trochoi extends JFrame {

	private JPanel contentPane;

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
		lblimCaTui.setBounds(10, 11, 81, 26);
		panel.add(lblimCaTui);
		
		JLabel label = new JLabel("Điểm người ta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(464, 11, 91, 26);
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
	}
}
