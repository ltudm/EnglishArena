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
	private ArrayList<String[]> arr_ctl=null;
	public void dieukienlap(boolean dk)
	{
		this.is_running=dk;
	}
	@Override
	public void run()
	{
			is_running=true;
		    arr_ch=receive_solve.datach;
		    arr_ctl=receive_solve.datactl;
			int result=9;   	
			sec=0;tic=0;
			int slc=0;
			try {
			 while(is_running)
			  {
				 tic++;
				 mainclient.tc.tach.setVisible(true);
				 mainclient.tc.lbch1.setVisible(true);
				 mainclient.tc.lbch2.setVisible(true);
				 mainclient.tc.lbch3.setVisible(true);
				 mainclient.tc.lbch4.setVisible(true);
				 
				 if(result==9)
				 {
					 int sttch=slc*4;
					 mainclient.tc.tach.setText(arr_ch.get(slc)[1]);
					 mainclient.tc.lbch1.setText(arr_ctl.get(sttch)[1]);
					 mainclient.tc.lbch2.setText(arr_ctl.get(sttch+1)[1]);
					 mainclient.tc.lbch3.setText(arr_ctl.get(sttch+2)[1]);
					 mainclient.tc.lbch4.setText(arr_ctl.get(sttch+3)[1]);
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
					 mainclient.tc.lbch1.setVisible(false);
					 mainclient.tc.lbch2.setVisible(false);
					 mainclient.tc.lbch3.setVisible(false);
					 mainclient.tc.lbch4.setVisible(false);
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
