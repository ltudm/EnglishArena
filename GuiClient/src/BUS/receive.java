package BUS;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import gui.*;


public class receive extends Thread {
	
	Socket socket = null;
    ObjectInputStream din = null;
    data_socket respon = null;
    login logf = new login();
    main mf=new main();
    public receive(Socket sk){
        this.socket = sk;
    }
    @Override
    public void run()
    {
    	try {
			din = new ObjectInputStream(this.socket.getInputStream());
			 while(true){
	                respon = (data_socket)din.readObject();
	                switch(respon.action){
	                case "login"             : this.check(respon); break;
	                case "dangky":
	                {
	                	this.dangky(respon);break;
	                }
	                case "fun" :
	                {
	                	String a=respon.data[0];
	                	String b=respon.data[1];
	                	main.fun.setText(a + "\n" + b);
	                }
	                }
			 }
	        }
		 catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void check(data_socket dtsk) {
    	int a=dtsk.login;
    	if(a==1)
    	{
    		System.out.println("da dang nhap");   		
    		mf.setVisible(true);		
    		logf.setVisible(false);
    		logf.hide();
    	}   		
    	else
    		if(a==2)
    		{
    			System.out.println("admin");
        		mf.setVisible(true);
        		logf.setVisible(false);
        		logf.setEnabled(false);
    		}
    			
    		else
    			System.out.println("nhap sai");
    		
    }
    public void dangky(data_socket dtsk)
    {
    	int a=dtsk.dk;
    	mf.setVisible(false);
    	if(a==1)
    		JOptionPane.showMessageDialog(null,
    			    "Dang ky thanh cong.");
    	else if(a==0)
    		JOptionPane.showMessageDialog(null,
    			    "Dang ky khong thanh cong.");
    	else if(a==-1)
    		JOptionPane.showMessageDialog(null,
    			    "email da co nguoi dang ky.");
    }

}
