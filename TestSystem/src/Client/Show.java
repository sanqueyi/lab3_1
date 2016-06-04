package Client;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Command.ShowPageCommand;
import Control.IO;
import Paper.PType;
import invoker.Invoker;

public class Show extends JFrame{
  public Show(PType ptype,String name,boolean is){
	  IO io = new IO();
	  Invoker invoke = new Invoker();
	  ShowPageCommand spc = new ShowPageCommand(io,ptype,name,is);
	  invoke.setInforCommand(spc);
	  List<String> question = (List<String>)invoke.getFirstInfor();
	  List<String> answer =(List<String>)invoke.getSecondInfor();
	  List<Integer> score =(List<Integer>)invoke.getThirdInfor();
	  List<List<String>>[] items =(List<List<String>>[])invoke.getFouthInfor();
	  int[] time =(int[])invoke.getFifthInfor();
	  //时间显示
	  int height = 20;
	  if(ptype!=PType.SURVEY){
	  JLabel stime = new JLabel("时间为：   "+time[0]+"  分钟");
	  stime.setBounds(20,20,200,30);
	  JLabel sall = new JLabel("总分为：   "+time[2]+"  分");
	  sall.setBounds(20,60,200,30);
	  add(stime);
	  add(sall);
	  height =100;
	  if(is){
		  JLabel sd = new JLabel("得分：   "+time[1]+"  分");
		  stime.setBounds(20,90,200,30);
		  height = 140;
	  }
	 
	  }
	  int size = question.size();
	  
	  for(int i=0;i<size;i++){
		  JLabel sq = new JLabel(question.get(i));
		  JLabel ss = new JLabel(score.get(i).toString());
		  sq.setBounds(20,height,150,30);
		  add(sq);
		  if(ptype!=PType.SURVEY){
			  ss.setBounds(200,height,100,30);
			  add(ss);
		  }
		  height+=30;
		 if(items[0].get(i)!=null){
			  int n = items[0].get(i).size();
			  String str="";
			  for(int j=0;j<n;j++){
				  str+=items[0].get(i).get(j)+" ";
			  }
			  JLabel si = new JLabel(str);
			  si.setBounds(20,height,300,30);
			  add(si);
			  height+=30;
			  if(items[1].get(i)!=null){
				  JLabel sar = new JLabel(str);
				  sar.setBounds(20,height,300,30);
				  add(sar);
				  height+=30;
			  }
			  
		 }
		 if(ptype!=PType.SURVEY){
			 JLabel sa = new JLabel(answer.get(i));
			 add(sa);
		 }
		 
		       
	  }
	  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	  
	  
  }
}
