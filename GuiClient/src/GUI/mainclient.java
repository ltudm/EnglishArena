package GUI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import GUI.dangkyform;
import GUI.dangnhapform;
import GUI.mainform;
import network.receive_solve;
import network.thoigianchinh;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;


public class mainclient {
	public static dangkyform dkf=null;
	public static dangnhapform dnf=null;
	public static mainform mf=null;
	public static trochoi tc=null;
	public static Socket socket=null;
	public static int port = 6788;
    public static String server = "localhost";
    public static thoigianchinh tgc=null;
    // dk gui dap an 0 gui lan dau, 1 gui lan 2
    public static int dieukiengui=0;
    //de xet xem 2 client gui cung nhau ko
    public static int dieukiengui_bang=0;
	//public static ObjectInputStream in = null;
    //public static ObjectOutputStream out = null;
	
	public static void main(String[] args) {
		
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
		dnf=new dangnhapform();
		dkf=new dangkyform();
		mf=new mainform();
		tc=new trochoi();
		tc.btkt.setIcon(new ImageIcon(mainclient.class.getResource("/resource/play1.png")));
		tc.btkt.setText("  Kiểm tra");
		tc.btkt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tc.btkt.setFont(new Font("Tahoma", Font.BOLD, 13));
		tc.btkt.setBackground(new Color(255, 255, 0));
		tc.btkt.setSize(133, 40);
		tc.btkt.setLocation(183, 257);
		tc.tablediem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"email", "Th\u1EDDi gian", "\u0110i\u1EC3m"
			}
		));
		tc.tablediem.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tc.tablediem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tc.tablediem.setLocation(491, 207);
		tc.setBackground(new Color(211, 211, 211));
		tc.btcancer.setBackground(new Color(250, 128, 114));
		tc.getContentPane().setBackground(new Color(0, 128, 128));
		tc.btready.setBackground(new Color(50, 205, 50));
		tc.btcancer.setFont(new Font("Tahoma", Font.BOLD, 13));
		tc.btready.setFont(new Font("Tahoma", Font.BOLD, 13));
		tc.btcancer.setSize(101, 40);
		tc.btready.setSize(102, 40);
		tc.btcancer.setLocation(378, 257);
		tc.btready.setLocation(35, 257);
		tc.lbicon2.setBounds(419, 61, 128, 33);
		tc.lbicon2.setIcon(new ImageIcon(mainclient.class.getResource("/resource/ready.png")));
		tc.lbicon1.setBounds(0, 61, 194, 33);
		tc.lbicon1.setIcon(new ImageIcon(mainclient.class.getResource("/resource/ready.png")));
		tc.btready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tgc=new thoigianchinh();
		try {
			socket=new Socket(mainclient.server,mainclient.port);
			Thread receive=new receive_solve(socket);
			// out = new ObjectOutputStream(cnsv.socket.getOutputStream());
			receive.start();						
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
            	    "Lỗi",
            	    "Lỗi phát sinh",
            	    JOptionPane.ERROR_MESSAGE);           
        }
		dnf.setVisible(true);		
	}
	
	
}

