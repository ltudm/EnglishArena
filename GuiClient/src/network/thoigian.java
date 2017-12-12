package network;
import java.io.*;
import GUI.*;


public class thoigian extends Thread {
	public int dauvao=0;
	//0 thoi gian san sang
	// 1 thoi gian 5giay load cau hoi
	public static int tic=0;
	public static int sec=0;
	boolean is_running=true;
	boolean is_running2=true;
	public thoigian(int n)
	{
		this.dauvao=n;
	}
	@Override
	public void run()
	{
		if(dauvao==1)
		{
			int result=5;   	
			mainclient.tc.lbcd2.setVisible(true);
			sec=0;tic=0;
			try {
			 while(is_running2)
			  {
				 tic++;
				 if(tic==100)
				 {
					 sec+=1;					
					 result--;					 
					 tic=0;
				 }	
				 mainclient.tc.lbcd2.setText(String.valueOf(result));
				 if(result==0)
				 {
					 is_running2=false;
					 mainclient.tc.lbcd2.setVisible(false);
				 }					 
					Thread.sleep(10);				
			  }
			}
			 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else
		if(dauvao==0)
		{
			int result=20; 
			mainclient.tc.lbcd.setVisible(true);
			try {
				sec=0;tic=0;
			 while(is_running)
			  {
				 tic++;
				 if(tic==100)
				 {
					 sec+=1;					
					 result--;					 
					 tic=0;
				 }	
				 mainclient.tc.lbcd.setText(String.valueOf(result));
				 if(result==0)
				 {
					 mainclient.tc.lbcd.setVisible(false);
					 is_running=false;
					 if(mainclient.tc.ready==2)
					 {
						 mainclient.tc.huybo();
					 }
				 }				 
					Thread.sleep(10);				
			  }			 
			}
			 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}


