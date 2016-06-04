package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Command.EssayQuestionCommand;
import Command.ShortEssayQuestionCommand;
import Paper.Page;
import Question.EssayQuestion;
import Question.ShortEssayQuestion;
import invoker.Invoker;

public class EssayQ extends JFrame{
	Page paper;
	Invoker invoke = new Invoker();
	JTextField question;
	public EssayQ(Page paper){
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
    	EssayQ  frame = new EssayQ(paper);
    	JLabel an = new JLabel("答案为：");
 		an.setFont(new   java.awt.Font("Dialog",   1,   18)); 
   	    an.setBounds(20,150,150,30);
 		JTextField answer = new JTextField();
 		answer.setBounds(170,150,200,30);
 		JLabel sco = new JLabel("问题分数:");
		sco.setBounds(20,190,100,30);
		JTextField score = new JTextField();
		score.setBounds(130, 190, 200, 30);
 		JButton submit = new JButton("提交");
 		submit.setBounds(380,400,100,50);
 		submit.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){                 
	        	EssayQuestion seq = new EssayQuestion();
	        	try{
	        		 int score1=Integer.parseInt(score.getText());
	        		 EssayQuestionCommand seqc = new EssayQuestionCommand(paper,seq,question.getText(),score1,answer.getText());
		             invoke.setQestionCommand(seqc);
			         invoke.addQuestion();
		             frame.setVisible(false);
        		}
        		catch(Exception e2){
        			JOptionPane.showMessageDialog(null, "分数必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
        		}
	             
	       }
	  });
 		frame.add(submit);
		frame.add(an);
		frame.add(answer);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,800);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void survey(){
		EssayQ frame = new EssayQ (paper);
		JButton submit = new JButton("提交");
 		submit.setBounds(380,400,100,50);
 		submit.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){                 
	        	EssayQuestion seq = new EssayQuestion();
	            EssayQuestionCommand seqc = new EssayQuestionCommand(paper,seq,question.getText());
	             invoke.setQestionCommand(seqc);
		         invoke.addQuestion();
		         frame.setVisible(false);
	       }
	  });
 		frame.add(submit);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,800);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
