package Client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import Command.ShowPageCommand;
import Command.ShowPageNameCommand;
import Control.IO;
import Paper.PType;
import invoker.Invoker;

public class Display extends JFrame{
	
	public Display(PType ptype,String name,boolean dis){
		setLayout(null);
		Invoker invoke = new Invoker();
		ArrayList<JRadioButton>  button = new ArrayList();
		ArrayList<JRadioButton>  buttonr = new ArrayList();
		IO   io = new IO();
		if(name==null||dis==false){
		ShowPageNameCommand spnc = new ShowPageNameCommand(io,ptype);
		invoke.setInforCommand(spnc);
		List<String> list =(List<String>) invoke.getFirstInfor();
		for(int i=0;i<list.size();i++){
			JRadioButton radioButton = new JRadioButton(list.get(i));// 创建单选按钮
			radioButton.setBounds(20,20+40*i,100,30);
			button.add(radioButton);
			radioButton.setFont(new   java.awt.Font("Dialog",   1,   18)); 
			add(radioButton);
		}
		JButton submit = new JButton("确认");
		submit.setBounds(380,450,100,50);
		if(dis){
		submit.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	for(int i=0;i<button.size();i++){
        			if(button.get(i).isSelected()){
        				Show show = new Show(ptype,button.get(i).getText(),false);
        				show.setVisible(true);
        				setVisible(false);
        				break;
        			}
        		}
           }
      });}else{
    	  submit.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){                 
              	for(int i=0;i<button.size();i++){
          			if(button.get(i).isSelected()){
          				Take take = new Take(name,ptype);
          				take.setVisible(true);
          				setVisible(false);
          				break;
          			}
          		}
             }
        });
      }
		add(submit);}
		else{
			
			ShowPageNameCommand spnc = new ShowPageNameCommand(io,ptype,name);
			invoke.setInforCommand(spnc);
			List<String>[] list=(List<String>[])invoke.getSecondInfor();
			ButtonGroup group = new ButtonGroup();// 创建单选按钮组
			int number=list[0].size();
			for(int i=0;i<number;i++){
				JRadioButton radioButton = new JRadioButton(list[0].get(i));// 创建单选按钮
				radioButton.setBounds(20,20+40*i,100,30);
				button.add(radioButton);
				group.add(radioButton);
				radioButton.setFont(new   java.awt.Font("Dialog",   1,   18)); 
				add(radioButton);
				
			}
			
			for(int i=0;i<list[1].size();i++){
				JRadioButton radioButton = new JRadioButton(list[1].get(i));// 创建单选按钮
				radioButton.setBounds(20,20+40*(i+number),100,30);
				buttonr.add(radioButton);
				group.add(radioButton);
				radioButton.setFont(new   java.awt.Font("Dialog",   1,   18)); 
				add(radioButton);
				
			}
			JButton submit = new JButton("确认");
			submit.setBounds(380,700,100,50);
			
			submit.addActionListener( new ActionListener(){
	            public void actionPerformed(ActionEvent e){  
	            	
	            	LP: for(int i=0;i<button.size();i++){
	        			if(button.get(i).isSelected()){
	        				Show show = new Show(ptype,button.get(i).getText(),false);
	        				show.setVisible(true);
	        				setVisible(false);
	        				break;
	        			}
	        			for(int j=0;j<buttonr.size();j++){
	        				if(button.get(i).isSelected()){
		        				Show show = new Show(ptype,button.get(i).getText(),true);
		        				show.setVisible(true);
		        				setVisible(false);
		        				break LP;
		        			}
	        			}
	        		}
	           }
	      });
			add(submit);
		
      }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

}
