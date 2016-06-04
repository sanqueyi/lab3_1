package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Command.SavePageCommand;
import Control.IO;
import Paper.Page;
import invoker.Invoker;

public class Create extends JFrame{
	Page paper;
	public Create(int i,Page paper){
		this.paper=paper;
	setLayout(null);
	
     JLabel ti= new JLabel("时间：");
     ti.setBounds(100,440,100,30);
     JTextField time = new JTextField();
     time.setBounds(200,440,150,30);
	JButton button0 = new JButton();
	ImageIcon icon0 = new ImageIcon("q0.jpg");
	button0.setIcon(icon0);
	JButton button1 = new JButton();
	ImageIcon icon1 = new ImageIcon("q1.jpg");
	button1.setIcon(icon1);
	JButton button2 = new JButton();
	ImageIcon icon2 = new ImageIcon("q2.jpg");
	button2.setIcon(icon2);
	JButton button3 = new JButton();
	ImageIcon icon3 = new ImageIcon("q3.jpg");
	button3.setIcon(icon3);
	JButton button4 = new JButton();
	ImageIcon icon4 = new ImageIcon("q4.jpg");
	button4.setIcon(icon4);
	JButton button5 = new JButton();
	ImageIcon icon5 = new ImageIcon("q5.jpg");
	button5.setIcon(icon5);
	JButton button6 = new JButton("提交 ");
	button6.setBounds(150,380,200,50);
	button0.setBounds(150,20,200,50);
	button1.setBounds(150,80,200,50);
	button2.setBounds(150,140,200,50);
	button3.setBounds(150,200,200,50);
	button4.setBounds(150,260,200,50);
	button5.setBounds(150,320,200,50);
	button0.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	TF tf = new TF(paper);
             if(i==0){
            	 
            	 tf.survey();
             }else{
            	 tf.test();
            	 
             }
             
       }
  });
	button1.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
             if(i==0){
            	 ChoiceS choices = new ChoiceS(paper);
            	 choices.setVisible(true);
            	 
             }else{
            	 Choice choice = new Choice(paper);
            	 choice.setVisible(true);
            	 
             }
             
       }
  });
	button2.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){   
        	ShortQ sho = new ShortQ(paper);
             if(i==0){
            	 sho.survey();
             }else{
            	 sho.test();
             }
             
       }
  });
	button3.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
        	EssayQ essay = new EssayQ(paper);
        	if(i==0){
           	 essay.survey();
            }else{
           	 essay.test();
            }
             
       }
  });
	button4.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
             RankingQ ranking = new RankingQ(paper);
             if(i==0){
            	 ranking.survey();
             }else{
            	 ranking.test();
             }
             
       }
  });
	button5.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
            MapingQ map = new MapingQ(paper);
            if(i==0){
            	map.survey();
            }else{
            	map.test();
            }
             
       }
  });
	button6.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){                 
           Invoker invoke = new Invoker();
           IO io = new IO();
           try{
   			int time1=Integer.parseInt(time.getText());
   			SavePageCommand spc = new SavePageCommand(io,paper,time1);
            invoke.setExecuteCommand(spc);
            invoke.execute();
            setVisible(false);
   		  }
   		  catch(Exception e1){
   			JOptionPane.showMessageDialog(null, "时间必须是数字！", "错误",JOptionPane.ERROR_MESSAGE); 
   		  }
           
             
       }
  });
	add(button0);
	add(button1);
	add(button2);
	add(button3);
	add(button4);
	add(button5);
	add(button6);
	add(ti);
	add(time);
	
	
	
		setLocationRelativeTo(null);
		setSize(500,500);
		setResizable(false);
		setVisible(false);
	}}


