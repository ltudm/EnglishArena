package network;
import java.io.*;
import GUI.*;


public class thoigianchuan extends Thread {
	public int dauvao=0;
	//0 thoi gian san sang
	// 1 thoi gian 5giay load cau hoi
	public  int tic=0;
	public  int sec=0;
	boolean is_running=true;
	boolean is_running2=true;
	public thoigianchuan(int n)
	{
		this.dauvao=n;
	}
	public void dieukienlap(boolean dk)
	{
		this.is_running=dk;
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
					 mainclient.tc.lbcd2.setVisible(false);
					 is_running2=false;				 
				 }					 
					Thread.sleep(10);										
			  }
			 mainclient.tgc.start();
			}
			 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
		
	}
}


