package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Command.CreatePageCommand;
import Control.IO;
import Paper.Page;
import Paper.Survey;
import Paper.Test;
import invoker.Invoker;

public class Name extends JFrame{
	public Name(int i){
		setLayout(null);
		JLabel name = new JLabel("your name");
		name.setBounds(20,50,150,30);
		name.setFont(new   java.awt.Font("Dialog",   1,   18));   
		JTextField login = new JTextField();
		login.setBounds(180, 50, 200, 30);		
		JLabel name0 = new JLabel("the page name");
		name0.setBounds(20,100,150,30);
		name0.setFont(new   java.awt.Font("Dialog",   1,   18));   
		JTextField login0 = new JTextField();
		login0.setBounds(180, 100, 200, 30);	
		JButton submit = new JButton();
		submit.setBounds(380, 200, 50, 50);
		ImageIcon icon = new ImageIcon("submit.jpg");
		submit.setIcon(icon);
		submit.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){  
            	Invoker invoke= new Invoker();
            	
            	IO io = new IO();
            	
            	
                 switch(i){
                case 0:
                	 Survey page=new Survey();
                	 CreatePageCommand cpc = new CreatePageCommand(io,page,login0.getText(),login.getText());
                	 invoke.setInforCommand(cpc);
                	 if((boolean)invoke.getFirstInfor()){
                	 Create create = new Create(0,page);
                	 setVisible(false);
                	 create.setVisible(true);}else{
                		 JOptionPane.showMessageDialog(null, "该名字已存在，请重命名！");
                	 }
                	 break;
                case 1:
                	 Test test = new Test();
                	 CreatePageCommand cpc0 = new CreatePageCommand(io,test,login0.getText(),login.getText());
                	 invoke.setInforCommand(cpc0);
                	 if((boolean)invoke.getFirstInfor()){
                	 Create create0 = new Create(1,test);
                	 setVisible(false);
                	 create0.setVisible(true);}else{
                		 JOptionPane.showMessageDialog(null, "该名字已存在，请重命名！");
                	 }
                	 break;
               
                	
                	
                	
                 
           }}
      });
		add(name);
		add(login);
		add(name0);
		add(login0);
		add(submit);
		setLocationRelativeTo(null);
		setSize(450,500);
		setResizable(false);
		setVisible(false);
	}

}
