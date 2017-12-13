package network;
import java.io.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import GUI.*;
import network.receive_solve;

public class thoigianchinh extends Thread {
	int tic=0;
    int sec=0;
	boolean is_running=true;
	private ArrayList<String[]> arr_ch=null;
	private ArrayList<String[]> arr_ctl=null;
	public static int sttctl=0;
	public static int slc=0;
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
			slc=0;
			try {
			 while(is_running)
			  {
				 tic++;
				 mainclient.tc.tach.setVisible(true);
				 mainclient.tc.lbch1.setVisible(true);
				 mainclient.tc.lbch2.setVisible(true);
				 mainclient.tc.lbch3.setVisible(true);
				 mainclient.tc.lbch4.setVisible(true);		
				 mainclient.tc.btkt.setVisible(true);
				 if(result==9)
				 {
					 sttctl=slc*4;
					 mainclient.tc.resetmau();
					 mainclient.tc.tach.setText(arr_ch.get(slc)[1]);
					 mainclient.tc.lbch1.setText(arr_ctl.get(sttctl)[1]);
					 mainclient.tc.lbch2.setText(arr_ctl.get(sttctl+1)[1]);
					 mainclient.tc.lbch3.setText(arr_ctl.get(sttctl+2)[1]);
					 mainclient.tc.lbch4.setText(arr_ctl.get(sttctl+3)[1]);
					 mainclient.tc.dapan="";
					 mainclient.tc.btkt.setEnabled(true);
					 mainclient.dieukiengui_bang=0;
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
					 if(mainclient.dieukiengui==1)
					 {
						 mainclient.tc.guidapan();
						 mainclient.dieukiengui=0;
					 }		 
					 else
						 if(mainclient.dieukiengui_bang==0)
						 {
							 mainclient.tc.traloibang();
							 mainclient.dieukiengui_bang=1;
						 }
					 //else 
						 //if(mainclient.dieukiengui==0)
						// {
						//	 mainclient.tc.traloibang();
						// }
					 
				 }			
				 if(slc==arr_ch.size()-1)
				 {
					 
					 is_running=false;
					 mainclient.tc.lbs.setText("0");
					 //System.out.println(slc);
					 ketquathidau();	 
				
				 }
				 if(is_running==false)
					 break;
					Thread.sleep(10);										
			  }
			}
			 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
		public void ketquathidau()
		{
			try
			{
				 
				 mainclient.tc.tach.setVisible(false);
				 mainclient.tc.lbch1.setVisible(false);
				 mainclient.tc.lbch2.setVisible(false);
				 mainclient.tc.lbch3.setVisible(false);
				 mainclient.tc.lbch4.setVisible(false);
				 mainclient.tc.btkt.setVisible(false);
				 mainclient.tc.guidiem();
				 mainclient.dnf.gohome();
				 mainclient.tc.setVisible(false);
				 mainclient.hnf.setVisible(true);
				 if(Integer.parseInt(mainclient.tc.lbdct.getText())>Integer.parseInt(mainclient.tc.lbdnt.getText()))
				 {
					 mainclient.hnf.lbhinh.setIcon(new ImageIcon(mainform.class.getResource("/resource/phaohoa.gif")));
					 mainclient.hnf.lbtext.setText("Victoria!!!"); 
				 }
				 else
				 {
					 if(Integer.parseInt(mainclient.tc.lbdct.getText())<Integer.parseInt(mainclient.tc.lbdnt.getText()))
					 {
						 mainclient.hnf.lbhinh.setIcon(new ImageIcon(mainform.class.getResource("/resource/tenor.gif")));
						 mainclient.hnf.lbtext.setText("Lêu lêu thua rồi....."); 
					 }
				 }
				 mainclient.tc.reset();					 				 
			}
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
}
