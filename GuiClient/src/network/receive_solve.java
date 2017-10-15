package network;
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
import GUI.*;


public class receive_solve extends Thread {
	
	Socket socket = null;
    ObjectInputStream din = null;
    data respon = null;
    dangnhapform logf = new dangnhapform();
    mainform mf=new mainform();
    public receive_solve(Socket sk){
        this.socket = sk;
    }
    @Override
    public void run()
    {
    	try {
			din = new ObjectInputStream(this.socket.getInputStream());
			 while(true){
	                respon = (data)din.readObject();
	                switch(respon.action){
	                case "login"             : this.check(respon); break;
	                case "dangky":
	                {
	                	this.dangky(respon);break;
	                	
	                }
	                case "fun" :
	                {
	                	String a=respon.data[0];
	                	
	                }
	                }
			 }
	        }
		 catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void check(data dtsk) {
    	int a=dtsk.login;
    	if(a==1)
    	{
    		System.out.println("da dang nhap");   		
    		mf.setVisible(true);		
    		logf.setVisible(false);
    	}   		
    	else
    		if(a==2)
    		{
    			System.out.println("admin");
        		mf.setVisible(true);
        		logf.setVisible(false);
    		}
    			
    		else
    			if(a==-1)
    			{
    				JOptionPane.showMessageDialog(null,
            			    "Tài khoản đang được đăng nhập.");

    			}
    				
    			else
    			{
    				JOptionPane.showMessageDialog(null,
            			    "Nhập sai email hoặc mật khẩu.");

    			}
    			
    		
    }
    public void dangky(data dtsk)
    {
    	int a=dtsk.dk;
    	if(a==1)
    	{
    		JOptionPane.showMessageDialog(null,
    			    "Dang ky thanh cong.");
    		mainclient.dkf.setVisible(false);
    	}
    		
    	else if(a==0)
    		JOptionPane.showMessageDialog(null,
    			    "Dang ky khong thanh cong.");
    	else if(a==-1)
    		JOptionPane.showMessageDialog(null,
    			    "email da co nguoi dang ky.");
    }

}
