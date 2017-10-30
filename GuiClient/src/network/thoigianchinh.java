package network;
import java.io.*;
import java.util.ArrayList;

import GUI.*;
import network.receive_solve;

public class thoigianchinh extends Thread {
	public  int tic=0;
	public  int sec=0;
	boolean is_running=true;
	private ArrayList<String[]> arr_ch=null;
	public void dieukienlap(boolean dk)
	{
		this.is_running=dk;
	}
	@Override
	public void run()
	{
			is_running=true;
		    arr_ch=receive_solve.datach;
			int result=9;   	
			sec=0;tic=0;
			int slc=0;
			try {
			 while(is_running)
			  {
				 tic++;
				 mainclient.tc.tach.setVisible(true);;
				 if(result==9)
				 {
					 mainclient.tc.tach.setText(arr_ch.get(slc)[1]);
				 }
				 if(tic==100)
				 {
					 sec+=1;					
					 result--;					 
					 tic=0;
				 }	
				 mainclient.tc.lbs.setText(String.valueOf(result));
				 mainclient.tc.lbms.setText(String.valueOf(tic));
				 if(result==-1)
				 {								 
					 result=9;
					 slc++;
				 }			
				 if(slc==arr_ch.size()-1)
				 {
					 
					 is_running=false;
					 mainclient.tc.lbs.setText("0");
					 System.out.println(slc);
					 mainclient.tc.tach.setVisible(false);
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
