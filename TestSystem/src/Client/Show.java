
package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Command.ShowPageCommand;
import Control.IO;
import Paper.PType;
import invoker.Invoker;

public class Show extends JFrame{
  public Show(PType ptype,String name,String full,boolean is){
	  setLayout(null);
	  IO io = new IO();
	  
	  Invoker invoke = new Invoker();
	  ShowPageCommand spc = new ShowPageCommand(io,ptype,name,full,is);
	  invoke.setInforCommand(spc);
	  List<String> question = (List<String>)invoke.getFirstInfor();
	  List<String> answer =(List<String>)invoke.getSecondInfor();
	  List<Integer> score=(List<Integer>)invoke.getThirdInfor();
	  List<List<String>>[] items =(List<List<String>>[])invoke.getFouthInfor();
	  //时间显示
	  int height = 20;
	  if(ptype!=PType.SURVEY){
	  int[] time =(int[])invoke.getFifthInfor();
	  JLabel stime = new JLabel("时间为：   "+time[0]+"  分钟");
	  stime.setBounds(20,20,200,30);
	  JLabel sall = new JLabel("总分为：   "+time[1]+"  分");
	  sall.setBounds(20,60,200,30);
	  add(stime);
	  add(sall);
	  height =100;
	  if(is){
		  JLabel sd = new JLabel("得分：   "+time[2]+"  分");
		  stime.setBounds(20,90,200,30);
		  height = 140;
	  }
	 
	  }
	  int size = question.size();
	  System.out.println(size);
	  for(int i=0;i<size;i++){
		  JLabel no = new JLabel((i+1)+"、");
		  no.setBounds(0,height,20,30);
		  add(no);
		  JLabel sq = new JLabel(question.get(i));  
		  sq.setBounds(20,height,150,30);
		  add(sq);
		  if(ptype!=PType.SURVEY){
			  JLabel ss = new JLabel("分数为： "+score.get(i).toString());
			  ss.setBounds(200,height,100,30);
			  add(ss);
		  }
		  height+=30;
		 if(items[0].get(i)!=null){
			  int n = items[0].get(i).size();
			  String str="";
			  for(int j=0;j<n;j++){
				  str+=j+1+") "+items[0].get(i).get(j)+"     ";
			  }
			  JLabel si = new JLabel(str);
			  si.setBounds(20,height,300,30);
			  add(si);
			  height+=30;
			  if(items[1].get(i)!=null){
				  int n1 = items[0].get(i).size();
				  String str1="";
				  for(int j=0;j<n1;j++){
					  str1+=j+1+") "+items[1].get(i).get(j)+"     ";
				  }
				  JLabel sar = new JLabel(str1);
				  sar.setBounds(20,height,300,30);
				  add(sar);
				  height+=30;
			  }
			  
		 }
		 if(ptype!=PType.SURVEY){
			 JLabel sa = new JLabel("答案为： "+answer.get(i));
			 sa.setBounds(20,height,300,30);
			 add(sa);
		 }
		 
		       
	  }
	  JButton button = new JButton("关闭");
	  button.setBounds(380,500,100,50);
	  button.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	setVisible(false);
	        }});
	  add(button);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	  
	  
  }
}
