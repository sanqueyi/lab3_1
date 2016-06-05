package Client;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Command.ShowPageCommand;
import Command.SubmitAnswerCommand;
import Control.IO;
import Paper.PType;
import Question.QType;
import invoker.Invoker;

public class Take extends JFrame{
	public Take(String name,PType ptype,String userN){
		setLayout(null);
		IO io = new IO();
		  Invoker invoke = new Invoker();
		  ShowPageCommand spc = new ShowPageCommand(io,ptype,name,false);
		  invoke.setInforCommand(spc);
		  List<String> question = (List<String>)invoke.getFirstInfor();
		  List<Integer> score=new LinkedList<Integer>();
		  if(ptype==PType.TEST){
		  score =(List<Integer>)invoke.getThirdInfor();}
		  List<List<String>>[] items =(List<List<String>>[])invoke.getFouthInfor();
		  
		  List<QType> type = (List<QType>) invoke.getsixthInfor();
		  List<String>  answer = new LinkedList();
		  int numb = question.size();
		  int height=0;
		
			  if(ptype==PType.TEST){
				  int[] time =(int[])invoke.getFifthInfor();
				  JLabel stime = new JLabel("时间为：   "+time[0]+"  分钟");
				  stime.setBounds(20,20,200,30);
				  JLabel sall = new JLabel("总分为：   "+time[2]+"  分");
				  sall.setBounds(20,60,200,30);
				  add(stime);
				  add(sall);
				  height =100;
				  
			  }
			  for(int i=0;i<numb;i++){
			  JLabel sq = new JLabel(i+1+"、 "+question.get(i));
			  
			  sq.setBounds(20,height,150,30);
			  add(sq);
			  if(ptype!=PType.SURVEY){
				  JLabel ss = new JLabel(score.get(i).toString());
				  ss.setBounds(200,height,100,30);
				  add(ss);
			  }
			  height+=30;
			  if(type.get(i) == QType.DECIDE){
				  JRadioButton radioButton1 = new JRadioButton("T");// 创建单选按钮
					radioButton1.setFont(new   java.awt.Font("Dialog",   1,   18)); 
					radioButton1.setBounds(20,height,100,30);
			        add(radioButton1);// 应用单选按钮        
			        JRadioButton radioButton2 = new JRadioButton("F");// 创建单选按钮
			        radioButton2.setFont(new   java.awt.Font("Dialog",   1,   18)); 
			        radioButton2.setBounds(120,height,100,30);
			        add(radioButton2);// 应用单选按钮
			       
			        ButtonGroup group = new ButtonGroup();// 创建单选按钮组
			        group.add(radioButton1);
			        group.add(radioButton2);
			        JButton button = new JButton();
			        button.setBounds(250,height,50,30);
			        height+=30;
			        button.addActionListener( new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				        	String ans  ;
				        	 if(radioButton1.isSelected()){
				        		 ans=radioButton1.getText();
				        	 }else{
				        		 ans=radioButton2.getText();
				        	 }
				        	 answer.add(ans);
				        	 button.setEnabled(false);
				        }});
			        add(button);
			  }else if(type.get(i)==QType.CHOICE){
				  ArrayList<Checkbox> box = new ArrayList();
				  int n = items[0].get(i).size();
				  for(int j=0;j<n;j++){
					  Checkbox checkbox = new Checkbox(items[0].get(i).get(j));
					  checkbox.setBounds(20+65*j,height,60,30);
					  box.add(checkbox);
					  add(checkbox);
				  }
				  JButton button = new JButton();
			        button.setBounds(200,height,50,30);
			        height+=30;
			        button.addActionListener( new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				        	String ans="";
				        	 for(int j = 0; j<box.size(); j++){
									if(box.get(j).getState()){
										ans+=box.get(j).getLabel()+" ";
									}

									}
				        	 answer.add(ans);
				        	 button.setEnabled(false);
				        }});
			        add(button);
				 
				  
				  
			  }else if(type.get(i)==QType.SHORTESSAY||type.get(i)==QType.ESSAY){
				  JLabel pro = new JLabel("答案 ");
				  JTextField a = new JTextField();
				  pro.setBounds(20,height,65,30);
				  a.setBounds(80, height, 150, 30);
				  JButton button = new JButton();
			        button.setBounds(400,height,50,30);
			        height+=30;
			        button.addActionListener( new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				        	String ans=a.getText();
				           
				        	 answer.add(ans);
				        	 button.setEnabled(false);
				        }});
			  }else if(type.get(i)==QType.RANK){
				  int n = items[0].get(i).size();
				 
				  String str = "";
				  for(int j=0;j<n;j++){
					  str+=j+1+") "+items[0].get(i).get(j)+"   ";
					  
				  }
				  JLabel q = new JLabel(str);
				  q.setBounds(20,height,500,30);
				  height+=30;
				  JLabel pro = new JLabel("答案 ");
				  JTextField a = new JTextField();
				  pro.setBounds(20,height,65,30);
				  a.setBounds(80, height, 150, 30);
				  JButton button = new JButton();
			        button.setBounds(400,height,50,30);
			        height+=30;
			        button.addActionListener( new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				        	
				           
				        	 answer.add(a.getText());
				        	 button.setEnabled(false);
				        }});
			  }else{
				  int n = items[0].get(i).size();
				  int nr= items[1].get(i).size();
				  String str = "";
				  String st="";
				  for(int j=0;j<n;j++){
					  str+=j+1+") "+items[0].get(i).get(j)+"   ";
					  
				  }
				  for(int j=0;j<n;j++){
					  st+=j+1+") "+items[1].get(i).get(j)+"   ";
					  
				  }
				  JLabel q = new JLabel(str);
				  q.setBounds(20,height,500,30);
				  height+=40;
				  JLabel p = new JLabel(st);
				  p.setBounds(20,height,500,30);
				  height+=30;
				  JLabel pro = new JLabel("答案 ");
				  JTextField a = new JTextField();
				  pro.setBounds(20,height,65,30);
				  a.setBounds(80, height, 150, 30);
				  JButton button = new JButton();
			        button.setBounds(400,height,50,30);
			        height+=30;
			        button.addActionListener( new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				        	
				           
				        	 answer.add(a.getText());
				        	 button.setEnabled(false);
				        }});
			  }
			 
			 if(ptype!=PType.SURVEY){
				 JLabel sa = new JLabel(answer.get(i));
				 add(sa);
			 }
		  }
			  JButton submit  = new JButton("提交");
			  submit.setBounds(400,700,80,30);
		        submit.addActionListener( new ActionListener(){
			        public void actionPerformed(ActionEvent e){
			        	//SubmitAnswerCommand sac = new SubmitAnswerCommand(io,name,ptype,answer,userN);
			        	SubmitAnswerCommand sac = new SubmitAnswerCommand(io,userN,ptype,answer,name);
			        	invoke.setInforCommand(sac);
			        	if(ptype==PType.TEST){
			        	int grade = (int)invoke.getFirstInfor();
			        	JOptionPane.showMessageDialog(null, "你的分数为："+grade, "成绩",JOptionPane.PLAIN_MESSAGE);}
			        	setVisible(false);

			           
			        	 
			        }});
		        add(submit);
			  setSize(500,800);
				setLocationRelativeTo(null);
				setResizable(false);
				setVisible(false);
	}

}
