package Client;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Command.ItemQuestionCommand;
import Command.MapQuestionCommand;
import Paper.Page;
import Question.MapQuestion;
import Question.RankQuestion;
import invoker.Invoker;

public class MapingQ extends JFrame{
	Page paper;
	Invoker invoke = new Invoker();
	ArrayList<String> list=new ArrayList();
	ArrayList<String> list0=new ArrayList();
	JTextField question;
	boolean isc; 
	public MapingQ(Page paper,boolean isc){
		this.paper = paper;
		setLayout(null);
		JLabel pro = new JLabel("问题题目：");
		 pro.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		 pro.setBounds(20,50,150,30);
		 question = new JTextField();
		question.setBounds(170,50,200,30);
		JLabel item = new JLabel("排序数目：");
		item.setBounds(20,100,150,30);
		JTextField number = new JTextField();
		number.setBounds(170, 100, 60, 30);
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
			
			String str = JOptionPane.showInputDialog("输入左侧内容");
			list.add(str);
			JLabel jl  = new JLabel(str);
		     jl.setBounds(20,280+30*i,150,30);
		     add(jl);
		}
	   
for(int i=0;i<num;i++){
			
			String str = JOptionPane.showInputDialog("输入右侧内容");
			list0.add(str);
			JLabel jl  = new JLabel(str);
		     jl.setBounds(20,280+30*(i+num),150,30);
		     add(jl);
		}
		
	}
public void test(){
	MapingQ frame = new MapingQ(paper,isc);
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
		submit.setBounds(380,500,100,50);
		submit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
        	String[] items  = new String[frame.list.size()];
        	
        	for(int i = 0; i<frame.list.size(); i++){
    			items[i]=frame.list.get(i);

    			}
String[] items0  = new String[frame.list0.size()];
        	
        	for(int i = 0; i<frame.list0.size(); i++){
    			items0[i]=frame.list0.get(i);

    			}
        	try{
        		MapQuestion seq = new MapQuestion();
        		int score1=Integer.parseInt(score.getText());
                MapQuestionCommand seqc = new MapQuestionCommand(paper,seq,-1,frame.question.getText(),items,items0,score1,answer.getText());
                invoke.setQestionCommand(seqc);
               
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
	frame.add(an);
	frame.add(answer);
	frame.add(submit);

	frame.setSize(500,800);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
}
public void survey(){
	MapingQ frame = new MapingQ(paper,isc);
	JButton submit = new JButton("提交");
	submit.setBounds(380,300,100,50);
	submit.addActionListener( new ActionListener(){
    public void actionPerformed(ActionEvent e){                 
    	String[] items  = new String[frame.list.size()];
    	
    	for(int i = 0; i<frame.list.size(); i++){
			items[i]=frame.list.get(i);

			}
String[] items0  = new String[frame.list0.size()];
    	
    	for(int i = 0; i<frame.list0.size(); i++){
			items0[i]=frame.list0.get(i);

			}
    	MapQuestion seq = new MapQuestion();
        MapQuestionCommand seqc = new MapQuestionCommand(paper,seq,-1,frame.question.getText(),items,items0);
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
