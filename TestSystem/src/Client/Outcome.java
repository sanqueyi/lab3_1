package Client;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Command.LookOutComeCommand;
import Control.IO;
import Paper.PType;
import invoker.Invoker;

public class Outcome extends JFrame{
	public Outcome(PType type,String pageName){
		Invoker invoke=new Invoker();
		IO io=new IO();
		LookOutComeCommand locc=new LookOutComeCommand(io,type,pageName);
		invoke.setInforCommand(locc);
		String content=(String)invoke.getFirstInfor();
		JTextArea text=new JTextArea(content);
		text.setWrapStyleWord(true);  
	    text.setLineWrap(true); 
	    text.setEditable(false);
	    add(text);
	    setLocationRelativeTo(null);
		setSize(500,500);
		setResizable(false);
		setVisible(true);
	}

}
