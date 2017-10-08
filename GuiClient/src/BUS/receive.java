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
import gui.login;


public class receive extends Thread {
	
	Socket socket = null;
    ObjectInputStream din = null;
    data_socket respon = null;
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
    		System.out.println("da dang nhap");
    	else
    		if(a==2)
    			System.out.println("admin");
    		else
    			System.out.println("nhap sai");
    		
    }

}
