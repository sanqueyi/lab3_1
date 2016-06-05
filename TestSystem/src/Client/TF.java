package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Command.DecideQuestionCommand;
import Paper.Page;
import Question.DecideQuestion;
import invoker.Invoker;


public class TF extends JFrame {
	Page paper;
	Invoker invoke = new Invoker();
	JTextField question;
	public TF(Page paper){
		this.paper = paper;
		setLayout(null);
		JLabel pro = new JLabel("问题题目：");
		pro.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		pro.setBounds(20,50,150,30);
		question = new JTextField();
		question.setBounds(170,90,200,30);
		
		add(pro);
		add(question);
		
        
		
	}
	public void test(){
		
		TF frame = new TF(paper);
		JLabel an = new JLabel("请输入答案：");
		an.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		an.setBounds(20,120,150,30);
		JRadioButton radioButton1 = new JRadioButton("T");// 创建单选按钮
		radioButton1.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		radioButton1.setBounds(170,160,100,30);
        frame.add(radioButton1);// 应用单选按钮        
        JRadioButton radioButton2 = new JRadioButton("F");// 创建单选按钮
        radioButton2.setFont(new   java.awt.Font("Dialog",   1,   18)); 
        radioButton2.setBounds(170,200,100,30);
        frame.add(radioButton2);// 应用单选按钮
        ButtonGroup group = new ButtonGroup();// 创建单选按钮组
        group.add(radioButton1);
        group.add(radioButton2);
        JLabel sco = new JLabel("分数为：");
        sco.setFont(new   java.awt.Font("Dialog",   1,   18));
        sco.setBounds(20,250,150,30);
        JTextField score = new JTextField();
        score.setBounds(180, 250, 50, 30);
        JButton submit = new JButton();
        submit.setBounds(420, 300, 50, 50);
		ImageIcon icon = new ImageIcon("submit.jpg");
		submit.setIcon(icon);
		//
		submit.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){  
	        	 DecideQuestion dq = new DecideQuestion();
	        	 String ans ;
	        	 if(radioButton1.isSelected()){
	        		 ans=radioButton1.getText();
	        	 }else{
	        		 ans=radioButton2.getText();
	        	 }
	        	 try{
	        		 int score1=Integer.parseInt(score.getText());
	        		 DecideQuestionCommand dqc = new DecideQuestionCommand(paper,dq,frame.question.getText(),score1,ans);
		        	 invoke.setQestionCommand(dqc);
		        	 invoke.addQuestion();
		             frame.setVisible(false);
	        		}
	        		catch(Exception e2){
	        		 JOptionPane.showMessageDialog(null, "分数必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
	        		}
	        	 
	             
	       }
	  });
		frame.add(sco);
		frame.add(score);
		frame.add(submit);
        
		
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void survey(){
		TF frame = new TF(paper);
		JButton submit = new JButton();
		submit.setBounds(420, 150, 50, 50);
		ImageIcon icon = new ImageIcon("submit.jpg");
		submit.setIcon(icon);
		submit.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){  
	        	DecideQuestion dq = new DecideQuestion();
	        	DecideQuestionCommand dqc = new DecideQuestionCommand(paper,dq,frame.question.getText());
	        	invoke.setQestionCommand(dqc);
	        	invoke.addQuestion();
	            frame.setVisible(false);
	             
	       }
	  });
		frame.add(submit);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
