package Client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Command.ShowPageCommand;
import Command.ShowPageNameCommand;
import Control.IO;
import Paper.PType;
import Paper.Page;
import invoker.Invoker;

public class Display extends JFrame{
	
	public Display(PType ptype,String name,String dis){
		setLayout(null);
		Invoker invoke = new Invoker();
		ArrayList<JRadioButton>  button = new ArrayList();
		ArrayList<JRadioButton>  buttonr = new ArrayList();
		IO   io = new IO();
		if(name==null||((dis!=null)&&(dis.equals("take")||dis.equals("outcome")||dis.equals("modify")))){
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
		if(dis==null){
		submit.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	for(int i=0;i<button.size();i++){
        			if(button.get(i).isSelected()){
        				Show show = new Show(ptype,button.get(i).getText(),"",false);
        				show.setVisible(true);
        				setVisible(false);
        				break;
        			}
        		}
           }
      });}else if(dis.equals("take")){
    	  submit.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){                 
              	for(int i=0;i<button.size();i++){
          			if(button.get(i).isSelected()){
          				
          				Take take = new Take(button.get(i).getText(),ptype,name);
          				take.setVisible(true);
          				setVisible(false);
          				break;
          			}
          		}
             }
        });
      }else if(dis.equals("outcome")){
    	  submit.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){                 
              	for(int i=0;i<button.size();i++){
          			if(button.get(i).isSelected()){
          				Outcome outcome = new Outcome(ptype,button.get(i).getText());       
          				outcome.setVisible(true);
          				setVisible(false);
          				break;
          			}
          		}
             }
        });
    	  
    	  
      }else if(dis.equals("modify")){
    	  submit.addActionListener( new ActionListener(){
              public void actionPerformed(ActionEvent e){ 
            	  
              	for(int i=0;i<button.size();i++){
          			if(button.get(i).isSelected()){
          				Invoker invoke = new Invoker();
                  	  ShowPageCommand spc = new ShowPageCommand(io,ptype,button.get(i).getText(),"",false);
                  	  invoke.setInforCommand(spc);
                  	  Page paper = (Page) invoke.getseventhInfor();
          				Modify modify = new Modify(button.get(i).getText(),ptype,paper);
          				modify.setVisible(true);
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
			JLabel jl = new JLabel("你出的page");
			jl.setBounds(20,20,100,30);
			add(jl);
			for(int i=0;i<number;i++){
				
				JRadioButton radioButton = new JRadioButton(list[0].get(i));// 创建单选按钮
				radioButton.setBounds(20,80+40*i,300,30);
				button.add(radioButton);
				group.add(radioButton);
				radioButton.setFont(new   java.awt.Font("Dialog",   1,   18)); 
				add(radioButton);
				
			}
			JLabel jl0 = new JLabel("你做过的page");
			jl0.setBounds(20,120+40*number,100,30);
			add(jl0);
			for(int i=0;i<list[1].size();i++){
				
				JRadioButton radioButton = new JRadioButton(list[1].get(i));// 创建单选按钮
				radioButton.setBounds(20,160+40*(i+number),300,30);
				buttonr.add(radioButton);
				group.add(radioButton);
				radioButton.setFont(new   java.awt.Font("Dialog",   1,   18)); 
				add(radioButton);
				
			}
			JButton submit = new JButton("确认");
			submit.setBounds(380,700,100,50);
			
			submit.addActionListener( new ActionListener(){
	            public void actionPerformed(ActionEvent e){  
	            	
	            	 for(int i=0;i<button.size();i++){
	        			if(button.get(i).isSelected()){
	        				Show show = new Show(ptype,button.get(i).getText(),"",false);
	        				show.setVisible(true);
	        				setVisible(false);
	        				break;
	        			}
	        			
	        		}
	            	 for(int j=0;j<buttonr.size();j++){
	        				if(buttonr.get(j).isSelected()){
		        				Show show = new Show(ptype,buttonr.get(j).getText(),name,true);
		        				show.setVisible(true);
		        				setVisible(false);
		        				break ;
		        			}
	        			}
	           }
	      });
			add(submit);
		
      }

		

		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

}
