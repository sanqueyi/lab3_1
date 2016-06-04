package main;

import javax.swing.*;

import View.ComandView;

public class StartUp extends JFrame{
	
	public static void main(String[] args){
		ComandView view = new ComandView();
		while(true){
			view.printFirstMenu();
		}
		
		
		
	}
}
