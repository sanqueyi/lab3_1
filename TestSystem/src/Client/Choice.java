package Client;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Command.ItemQuestionCommand;
import Paper.Page;
import Question.ChoiceQuestion;
import invoker.Invoker;

public class Choice extends JFrame {
	Page paper;
	Invoker invoke =new Invoker();
	JTextField question;
	JTextField score;
	String an="";
	public Choice(Page paper){
		this.paper = paper;
		setLayout(null);
		JLabel pro = new JLabel("问题题目：");
		pro.setBounds(20,20,100,30);
		question = new JTextField();
		question.setBounds(130, 20, 200, 30);
		JLabel sco = new JLabel("问题分数:");
		sco.setBounds(20,60,100,30);
		score = new JTextField();
		score.setBounds(130, 60, 200, 30);
		JLabel item = new JLabel("选项数目：");
		item.setBounds(20,100,100,30);
		JTextField number = new JTextField();
		number.setBounds(130, 100, 100, 30);
		JButton sub = new JButton("提交");
		sub.setBounds(100,150,100,50);
		sub.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
                 int num=Integer.parseInt(number.getText());
                 add(num);
           }
      });
		
		add(pro);
		add(question);
		add(sco);
		add(score);
		add(item);
		add(number);
		add(sub);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,800);
	  setResizable(false);
		setVisible(false);
	}
	public void add(int num){
		
		JPanel  panel = new JPanel();
		JLabel pro = new JLabel("the answer");
		String[] items = new String[num];
		ArrayList<Checkbox> list = new ArrayList();

		for(int i=0;i<num;i++){
			
			String str = JOptionPane.showInputDialog("输入选项");
			items[i]=  str;
			Checkbox checkbox = new Checkbox(items[i]);
			list.add(checkbox);
			checkbox.setBounds(0,10+60*i,100,50);
			panel.add(checkbox);
			
		}
		
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).getState()){
				an+=list.get(i).getLabel()+" ";
			}

			}
		
		JButton button =new JButton();
		button.setBounds(200,350,50,50);
		ImageIcon icon = new ImageIcon("submit.jpg");
		button.setIcon(icon);
		button.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e){                 
	        	ChoiceQuestion cq = new ChoiceQuestion();
	            ItemQuestionCommand iqc = new ItemQuestionCommand(paper,cq,question.getText(),items,score.getText(),an);
	            invoke.setQestionCommand(iqc);
	            invoke.addQuestion();
	             setVisible(false);
	       }
	  });
		panel.add(button);

		panel.setBounds(0,200,500,600);
		this.add(panel);
	
	}
	
		
		
	
	

}