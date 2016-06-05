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
	boolean isc;
	public RankingQ(Page paper,boolean isc){
		this.paper = paper;
		this.isc=isc;
	setLayout(null);
	JLabel pro = new JLabel("问题题目：");
	 pro.setFont(new   java.awt.Font("Dialog",   1,   18)); 
	 pro.setBounds(20,50,150,30);
	 question = new JTextField();
	question.setBounds(170,50,200,30);
	JLabel item = new JLabel("排序数目：");
	item.setBounds(20,100,150,30);
	JTextField number = new JTextField();
	number.setBounds(170,100, 60, 30);
	JButton sub = new JButton("提交");
	sub.setBounds(250,100,100,50);
	sub.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
        	try{
        		int num=Integer.parseInt(number.getText());
                add(num);
                sub.setEnabled(false);
    		}
    		catch(Exception e2){
    			JOptionPane.showMessageDialog(null, "选项数目必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
    		}
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
	     JLabel jl  = new JLabel(str);
	     jl.setBounds(20,280+30*i,150,30);
	     add(jl);
	}


}
public void test(){
	RankingQ frame = new RankingQ(paper,isc);
	JLabel an = new JLabel("答案为：(以空格隔开)");
	an.setFont(new   java.awt.Font("Dialog",   1,   10)); 
	an.setBounds(20,200,150,30);		
	JTextField answer = new JTextField();
	answer.setBounds(170,200,200,30);
	JLabel sco = new JLabel("问题分数:");
	sco.setBounds(20,240,150,30);
	JTextField score = new JTextField();
	score.setBounds(170, 240, 60, 30);
	JButton submit = new JButton("提交");
		submit.setBounds(380,600,100,50);
		submit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	String[] items  = new String[frame.list.size()];
        	for(int i = 0; i<frame.list.size(); i++){
    			items[i]=frame.list.get(i);

    			}
        	try{
        		int score1=Integer.parseInt(score.getText());
        		RankQuestion seq = new RankQuestion();
                ItemQuestionCommand seqc = new ItemQuestionCommand(paper,seq,-1,frame.question.getText(),items,score1,answer.getText());
                invoke.setQestionCommand(seqc);
                
    	        invoke.addQuestion();
                 frame.setVisible(false);
    		}
    		catch(Exception e2){
    			JOptionPane.showMessageDialog(null, "分数必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
    		}
        	
       }
  });
	frame.add(score);
	frame.add(sco);	
	frame.add(an);
	frame.add(answer);
	frame.add(submit);

	frame.setSize(500,800);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
}
public void survey(){
	RankingQ frame = new RankingQ(paper,isc);
	JButton submit = new JButton("提交");
		submit.setBounds(380,500,100,50);
		submit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	String[] items  = new String[frame.list.size()];
        	for(int i = 0; i<frame.list.size(); i++){
    			items[i]=frame.list.get(i);

    			}
        	RankQuestion seq = new RankQuestion();
            ItemQuestionCommand seqc = new ItemQuestionCommand(paper,seq,-1,frame.question.getText(),items);
            invoke.setQestionCommand(seqc);
            
	         invoke.addQuestion();
             frame.setVisible(false);
       }
  });
		frame.add(submit);

	frame.setSize(500,800);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
}
}
