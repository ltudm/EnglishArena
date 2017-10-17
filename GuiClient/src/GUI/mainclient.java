package GUI;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import GUI.dangkyform;
import GUI.dangnhapform;
import GUI.mainform;

public class mainclient {
	public static dangkyform dkf=null;
	public static dangnhapform dnf=null;
	public static mainform mf=null;
	
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
		dnf.setVisible(true);		
	}
	
}
