package Client;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Command.ItemQuestionCommand;
import Command.ShortEssayQuestionCommand;
import Paper.Page;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import invoker.Invoker;

public class RankingQ extends JFrame{
	Page paper;
	Invoker invoke = new Invoker();
	ArrayList<String> list=new ArrayList();
	JTextField question;
	public RankingQ(Page paper){
		this.paper = paper;
	setLayout(null);
	JLabel pro = new JLabel("问题题目：");
	 pro.setFont(new   java.awt.Font("Dialog",   1,   18)); 
	 pro.setBounds(20,50,150,30);
	 question = new JTextField();
	question.setBounds(170,90,200,30);
	JLabel item = new JLabel("排序数目：");
	item.setBounds(20,120,100,30);
	JTextField number = new JTextField();
	number.setBounds(130,120, 100, 30);
	JButton sub = new JButton("提交");
	sub.setBounds(100,150,100,50);
	sub.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
             int num=Integer.parseInt(number.getText());
             add(num);
       }
  });
	

	add(item);
	add(number);
	add(sub);
	add(pro);
	add(question);
}
public void add(int num){
	


	for(int i=0;i<num;i++){
		
		String str = JOptionPane.showInputDialog("输入内容");
	     list.add(str);
	}


}
public void test(){
	RankingQ frame = new RankingQ(paper);
	JLabel an = new JLabel("答案为：");
	an.setFont(new   java.awt.Font("Dialog",   1,   18)); 
	an.setBounds(20,200,150,30);		
	JTextField answer = new JTextField();
	answer.setBounds(170,200,200,30);
	JLabel sco = new JLabel("问题分数:");
	sco.setBounds(20,240,100,30);
	JTextField score = new JTextField();
	score.setBounds(130, 240, 200, 30);
	JButton submit = new JButton("提交");
		submit.setBounds(380,400,100,50);
		submit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	String[] items  = new String[list.size()];
        	for(int i = 0; i<list.size(); i++){
    			items[i]=list.get(i);

    			}
        	RankQuestion seq = new RankQuestion();
            ItemQuestionCommand seqc = new ItemQuestionCommand(paper,seq,question.getText(),items,score.getText(),answer.getText());
            invoke.setQestionCommand(seqc);
	         invoke.addQuestion();
             frame.setVisible(false);
       }
  });
		
	frame.add(an);
	frame.add(answer);
	frame.add(submit);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,800);
	frame.setResizable(false);
	frame.setVisible(true);
}
public void survey(){
	RankingQ frame = new RankingQ(paper);
	JButton submit = new JButton("提交");
		submit.setBounds(380,300,100,50);
		submit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	String[] items  = new String[list.size()];
        	for(int i = 0; i<list.size(); i++){
    			items[i]=list.get(i);

    			}
        	RankQuestion seq = new RankQuestion();
            ItemQuestionCommand seqc = new ItemQuestionCommand(paper,seq,question.getText(),items);
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
