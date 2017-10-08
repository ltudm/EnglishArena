package BUS;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import gui.login;
import gui.main;



public class connectserver {
	public static int port = 1995;
    public static String ip_server = "27.3.125.179";
    public static Socket socket = null;
    public static void main(String[] args) {
		connectserver cnsv=new connectserver();
		cnsv.init();
	}
    public void init(){
    	try
    	{
    		cnsv.socket=new Socket(ip_server,port);

            System.out.println("conected");
    	}
    	catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "socket error");
        }
    	
    }

}
