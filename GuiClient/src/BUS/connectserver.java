package BUS;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.main;

import javax.swing.JOptionPane;

import gui.login;
import gui.main;



public class connectserver {
	public static int port = 1995;
    public static String ip_server = "115.72.248.27";
    public static Socket socket = null;
    public static main mainf=null;
    public connectserver()
    {
    	try
    	{		
			socket=new Socket(ip_server,port);
            
    	}
    	catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "socket error");
        }
    }
     

}
