package Client;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Command.ItemQuestionCommand;
import Paper.Page;
import Question.ChoiceQuestion;
import invoker.Invoker;

public class ChoiceS extends JFrame{
	Page paper;
	Invoker invoke = new Invoker();
	JTextField question;
	boolean isc;
	public ChoiceS(Page paper,boolean isc){
		this.paper = paper;
		this.isc = isc;
		setLayout(null);
		JLabel pro = new JLabel("问题题目：");
		pro.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		pro.setBounds(20,50,150,30);
		question = new JTextField();
		question.setBounds(170,90,200,30);
		JLabel item = new JLabel("选项数目：");
		item.setFont(new   java.awt.Font("Dialog",   1,   18)); 
		item.setBounds(20,130,150,30);
		JTextField number = new JTextField();
		number.setBounds(170, 130, 50, 30);
		JButton sub = new JButton("提交");
		sub.setBounds(420,180,70,30);
		sub.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	try{
            		int num=Integer.parseInt(number.getText());
                    add0(num);
                    sub.setEnabled(false);
        		}
        		catch(Exception e2){
        			JOptionPane.showMessageDialog(null, "选项数目必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
        		}
           }
      });
		
		add(pro);
		add(question);
		add(item);
		add(number);
		add(sub);
		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}
	public void add0(int num){
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		String[] items =new String[num];
		
		for(int i=0;i<num;i++){
			
			String str = JOptionPane.showInputDialog("输入选项");
			items[i]=str;
			//JLabel jlabel = new JLabel(str);
			//jlabel.setBounds(20,220+30*i,100,30);
			//panel.add(jlabel);
		    
		}
        
		JButton submit = new JButton();
		submit.setBounds(220, 280, 50, 50);
		ImageIcon icon = new ImageIcon("submit.jpg");
		submit.setIcon(icon);
		submit.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){                 
	        	ChoiceQuestion cq = new ChoiceQuestion();
	            ItemQuestionCommand iqc = new ItemQuestionCommand(paper,cq,-1,question.getText(),items);
	            invoke.setQestionCommand(iqc);	           
	            invoke.addQuestion();
	             setVisible(false);
	       }
	  });
		panel.add(submit);
		panel.setBounds(0,300,500,500);
		add(panel);
		
		
	}
	
	
}
