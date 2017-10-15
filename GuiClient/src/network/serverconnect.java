package network;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import GUI.dangnhapform;
import GUI.mainform;



public class serverconnect {
	public static int port = 6788;
    public static String ip_server = "localhost";
    public static Socket socket = null;
    public static mainform mainf=null;
    public serverconnect()
    {
    	try
    	{		
			socket=new Socket(ip_server,port);
            
    	}
    	catch (IOException ex) {
            Logger.getLogger(dangnhapform.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "socket error");
        }
    }
     

}
