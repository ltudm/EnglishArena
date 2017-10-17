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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.*;



public class receive_solve extends Thread {
	
	Socket socket = null;
    ObjectInputStream din = null;
    data respon = null;
    mainform mf=new mainform();
    public static  DefaultTableModel model= new DefaultTableModel();
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
	                case "login" : 
	                	{
	                		this.check(respon); 
	                		//loaddiem(respon.data_arr);
	                		for(String[] s:respon.data_arr)
	                 		{
	                 			System.out.println(s[0]+" "+s[1]+" "+s[2]);
	                 		}
	                		this.loaddiem(respon.data_arr);
	                		break;
	                	}
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
    		mainclient.dnf.setVisible(false);
    		mf.setVisible(true);		
    		
    	}   		
    	else
    		if(a==2)
    		{
    			System.out.println("admin");
    			mainclient.dnf.setVisible(false);
        		mf.setVisible(true);       		
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
    public void loaddiem(ArrayList<String[]> data){
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(null, "Không có data");
            return;
        }
        String[] column = new String[4];
        column[0] = "Email";
        column[1] = "Ngày";
        column[2] = "Điểm số";
        column[3] = "Kết quả";
        int n = data.size();
        Object[][] table = new Object[n][4];
        for(int i = 0; i < n; i++){
            table[i][0] = data.get(i)[0];
            table[i][1] = data.get(i)[1];
            table[i][2] = data.get(i)[2];
            table[i][3] = data.get(i)[3];
            
        }
        TableModel model = new DefaultTableModel(table, column){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        mainform.bangdiem.setModel(model);

    }

}
