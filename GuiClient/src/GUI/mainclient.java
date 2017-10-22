package GUI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import GUI.dangkyform;
import GUI.dangnhapform;
import GUI.mainform;
import network.receive_solve;
import network.serverconnect;

public class mainclient {
	public static dangkyform dkf=null;
	public static dangnhapform dnf=null;
	public static mainform mf=null;
	public static trochoi tc=null;
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
		try {
        	serverconnect cnsv = new serverconnect();
			Thread receive=new receive_solve(cnsv.socket);
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
