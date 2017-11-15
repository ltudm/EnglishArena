package network;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.*;



public class receive_solve extends Thread {
	
	Socket socket = null;
   // mainform mf=new mainform();  
    public static  DefaultTableModel model= null;
	ObjectInputStream in = null;
    //static ObjectOutputStream out = null;
	thoigian tg=null;
	//load cau hoi 
	public static ArrayList<String[]> datach=null;
	public static ArrayList<String[]> datactl=null;
	//chua du lieu gui ve
	public static String[] data_client=new String[5];
	//so dong cuatable diem
    public receive_solve(Socket sk){
        this.socket = sk;              
    }
    @Override
    public void run()
    {
    	data respon = null;
    	try {   		 
    		in  = new ObjectInputStream(this.socket.getInputStream());    	
    
			 while(true){		
				    respon = (data) in.readObject();
	                System.out.println(respon.action);
	                switch(respon.action){	                
	                case "login" : 
	                	{
	                		this.check(respon); 
	                		//loaddiem(respon.data_arr);
	                		/*for(String[] s:respon.data_arr)
	                 		{
	                 			System.out.println(s[0]+" "+s[1]+" "+s[2]);
	                 		}*/
	                		break;
	                	}
	                case "dangky":
	                {
	                	this.dangky(respon);
	                	break;
	                	
	                }
	                case "ghepdoi":
	                {
	                	this.ghepdoi(respon);break;
	                }
	                case "fun" :
	                {
	                	System.out.println("hello");break;
	                	
	                }
	                case "sansang":
	                {
	                	this.sansang(respon);
	                	break;
	                }
	                case "loadcauhoi":
	                {
	                	this.datach=respon.data_arr;
	                	/*for(int i=0;i<13;i++)
	                	{
	                		System.out.println(respon.data_arr.get(i)[1]);
	                	}*/
	                	this.taotable();// table hien thi diem moi luot choi
	                	break; 
	                }
	                case "loadcautl":
	                {
	                	this.datactl=respon.data_arr;break;
	                }
	                case "huythidau":
	                {
	                	this.huythidau(respon);break;
	                }
	                case "traloitruoc":
	                {
	                	this.data_client=respon.data;
	                	mainclient.dieukiengui=1;
	                	mainclient.dieukiengui_bang=1;
	                	break;
	                }
	                case "traloisau":
	                {
	                	this.traloisau(respon.data_arr,1);
	                	/*for(int j=0;j<2 ;j++)
	                    {
	                  	  System.out.println(respon.data_arr.get(j)[0]+ respon.data_arr.get(j)[1]+respon.data_arr.get(j)[2]);                  	  
	                    }    */
	                	mainclient.dieukiengui=0;
	                	mainclient.dieukiengui_bang=1;
	                	respon.data_arr=null;
	                	break;
	                }
	                case "traloibang":
	                {
	                	this.traloisau(respon.data_arr,0);
	                	break;
	                }
	                default:
	                {
	                	System.out.println("hanh dong khong ro rang: "+respon.action);
	                }
	                
	               }
	          }
	      }
		 catch (IOException | ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			System.exit(0);
		}
    }
    public void check(data datat) {
    	int a=datat.login;
    	if(a==1)
    	{ 
    		mainclient.dnf.setVisible(false);
    		mainclient.mf.setVisible(true);		
    		this.loaddiem(datat.data_arr);
    		mainclient.mf.lbemailmf.setText(mainclient.dnf.data2[0]);
    	}   		
    	else
    		if(a==2)
    		{
    			System.out.println("admin");
    			mainclient.dnf.setVisible(false);
    			mainclient.mf.setVisible(true); 
        		this.loaddiem(datat.data_arr);
        		mainclient.mf.lbemailmf.setText(mainclient.dnf.data2[0]);
    		}
    			
    		else
    			if(a==-1)
    			{
    				JOptionPane.showMessageDialog(null,
            			    "Tài khoản đang được đăng nhập.");
    			}
    			else 
    				if(a==-2)
    				{
        				JOptionPane.showMessageDialog(null,
                			    "Phiên bản hiện tại đã cũ.");
        			}   				
    			else
    			{
    				JOptionPane.showMessageDialog(null,
            			    "Nhập sai email hoặc mật khẩu.");

    			}
    			
    		
    }
    public void dangky(data datat)
    {
    	int a=datat.dk;
    	System.out.println(a);
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
    private void loaddiem(ArrayList<String[]> data){
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
    private void ghepdoi(data datat)
    {
    	if(datat.data[0]==null)
    	{
    		JOptionPane.showMessageDialog(null,
    				datat.data[1],
            	    "Thông báo",
            	    JOptionPane.INFORMATION_MESSAGE);
    	}
    	else
    		if(datat.data[0]!=null)
    		{
    			mainclient.tc.lbemail1.setText(datat.data[1]);
    			mainclient.tc.lbemail2.setText(datat.data[0]);
    			System.out.println(datat.data[1]);
    			mainclient.mf.setVisible(false);
    			mainclient.tc.setVisible(true);
    			mainclient.tc.lbicon1.setVisible(false);
    			mainclient.tc.lbicon2.setVisible(false);
    			mainclient.tc.btready.setVisible(true);
    			mainclient.tc.btcancer.setVisible(true);mainclient.tc.ready=0;
    			tg=new thoigian(0);
    			tg.start();
    		}
    }
    private void sansang(data datat)
    {
    	if(datat.data[0].equals("dasansang"))
    	{
    		mainclient.tc.lbicon2.setVisible(true);
    		mainclient.tc.lbicon2.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("resource/ready-icon.png")).getImage().getScaledInstance(32,32, Image.SCALE_DEFAULT)));
    		if(mainclient.tc.ready==1)
    		{
    			mainclient.tc.lbcd.setVisible(false);
    			mainclient.tc.btready.setVisible(false);
    			mainclient.tc.btcancer.setVisible(false);  			
    			thoigianchuan tg=new thoigianchuan(1);
    			tg.start();
    			//khi bam button chay dung
    		}
    		else
    		{   			    		
    			// =2 để nhận biết hien tai chua ss
    			mainclient.tc.ready=2;
    		}
    	}
    	else
    		JOptionPane.showMessageDialog(null,
    				"Lỗi trong quá trình nhận",
            	    "Thông báo",
            	    JOptionPane.ERROR_MESSAGE);
    }
    //load cau hoi sau khi 1 trong 2 san sang
    public static void loadcauhoi()
    {
    	data data_sent = new data();
		data_sent.action="loadcauhoi";
		String[] data = new String[1];
		data[0]=mainclient.tc.lbemail2.getText();
		data_sent.data=data;
		try {
            mainclient.tc.cout = new ObjectOutputStream(mainclient.socket.getOutputStream());
            mainclient.tc.cout.writeObject(data_sent);
            mainclient.tc.cout.flush();
            //System.out.println("da gui");		            
        } catch (IOException ex) {
            Logger.getLogger(trochoi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
            	    "Lỗi phát sinh",
            	    "Lỗi",
            	    JOptionPane.ERROR_MESSAGE);
            
        }
    }
    private void taotable()
    {
    	String[] column = new String[3];
        column[0] = "Email";
        column[1] = "Thời gian";
        column[2] = "Điểm số";
        Object[][] table = new Object[2][3];
        model = new DefaultTableModel(table, column);
    }
    public void traloisau(ArrayList<String[]> data,int i)
    {
    	if(i==1)
    	{
    		if(data.get(0)[0].equals(mainclient.mf.lbemailmf.getText()))
    		{
    			congdiem(Integer.parseInt(data.get(0)[2]),Integer.parseInt(data.get(1)[2]));
    			messout("th1");
    			messout(data.get(1)[2]);
    			messout(data.get(0)[2]);
    		}  		 
    		else
    		{
    			congdiem(Integer.parseInt(data.get(1)[2]),Integer.parseInt(data.get(0)[2]));
    			messout(data.get(1)[0]);
    			messout(data.get(1)[2]);
    			messout(data.get(0)[2]);
    		}
    			
    		 for(int j=0;j<2 ;j++)
             {
           	  ((DefaultTableModel) model).addRow(new Object[]{data.get(j)[0], data.get(j)[1],data.get(j)[2]});
             }                       
             mainclient.tc.tablediem.setModel(model);
    	}
    	else 
    		if(i==0)
    		{
    			for(int j=0;j<2 ;j++)
                {
              	  ((DefaultTableModel) model).addRow(new Object[]{data.get(j)[0], data.get(j)[1],data.get(j)[2]});
                }  
    			mainclient.tc.tablediem.setModel(model);
    		}   			          
    }
    //tra loi truoc diem1, traloisau diem2
    private void congdiem(int diem1, int diem2)
    {
    	int diema=Integer.parseInt(mainclient.tc.lbdct.getText());
    	int diemb=Integer.parseInt(mainclient.tc.lbdnt.getText());
    	diema+=diem1;
    	diemb+=diem2;
    	mainclient.tc.lbdct.setText(String.valueOf(diema));
    	mainclient.tc.lbdnt.setText(String.valueOf(diemb));
    }
    private void huythidau(data datat)
    {
    	JOptionPane.showMessageDialog(null,
				datat.data[0],
        	    "Thông báo",
        	    JOptionPane.ERROR_MESSAGE);
    	mainclient.tc.setVisible(false);
    	mainclient.mf.setVisible(true);
    }
    private void messout(String mess)
    {
    	System.out.println("mess: "+mess);
    }



}
