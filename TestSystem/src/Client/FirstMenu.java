package Client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Paper.PType;
import invoker.Invoker;

public class FirstMenu extends JFrame{
	
	public FirstMenu(){
		
		setLayout(null);
		JButton button0 =new JButton();
		ImageIcon icon0 = new ImageIcon("button0.jpg");
		button0.setIcon(icon0);
		JButton button1 =new JButton();
		ImageIcon icon1 = new ImageIcon("button1.jpg");
		button1.setIcon(icon1);
		JButton button2 =new JButton();
		ImageIcon icon2 = new ImageIcon("button2.jpg");
		button2.setIcon(icon2);
		JButton button3 =new JButton();
		ImageIcon icon3 = new ImageIcon("button3.jpg");
		button3.setIcon(icon3);
		JButton button4 =new JButton();
		ImageIcon icon4 = new ImageIcon("button4.jpg");
		button4.setIcon(icon4);
		JButton button5 =new JButton();
		ImageIcon icon5 = new ImageIcon("button5.jpg");
		button5.setIcon(icon5);
		JButton button6 =new JButton();
		ImageIcon icon6 = new ImageIcon("button6.jpg");
		button6.setIcon(icon6);
		JButton button7 =new JButton();
		ImageIcon icon7 = new ImageIcon("button7.jpg");
		button7.setIcon(icon7);
		JButton button8 =new JButton();
		ImageIcon icon8 = new ImageIcon("button8.jpg");
		button8.setIcon(icon8);
		JButton button9 =new JButton();
		ImageIcon icon9 = new ImageIcon("button9.jpg");
		button9.setIcon(icon9);
		JButton button10 =new JButton();
		ImageIcon icon10 = new ImageIcon("button10.jpg");
		button10.setIcon(icon10);
		button0.setBounds(150,20,200,50);
		button1.setBounds(150,80,200,50);
		button2.setBounds(150,140,200,50);
		button3.setBounds(150,200,200,50);
		button4.setBounds(150,260,200,50);
		button5.setBounds(150,320,200,50);
		button6.setBounds(150,380,200,50);
		button7.setBounds(150,440,200,50);
		button8.setBounds(150,500,200,50);
		button9.setBounds(150,560,200,50);
		button10.setBounds(150,620,200,50);
		
		button0.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
                 Name name = new Name(0);
                 name.setVisible(true);
            	
                 
           }
      });
		button1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
                 Name name = new Name(1);
                name.setVisible(true);
                 
           }
      });
		button2.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	int an=JOptionPane.showConfirmDialog(null, "是否要登记查询", "choose one", JOptionPane.YES_NO_OPTION);
            	if(an==0){
            		String str = JOptionPane.showInputDialog("输入你的用户名");
            		Display display = new Display(PType.SURVEY,str,null);
            		display.setVisible(true);
            	}else{
            		Display display = new Display(PType.SURVEY,null,null);
            		display.setVisible(true);
            	}
            		
            	
                 
           }
      });
		button3.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	int an=JOptionPane.showConfirmDialog(null, "是否要登记查询", "choose one", JOptionPane.YES_NO_OPTION);
            	if(an==0){
            		String str = JOptionPane.showInputDialog("输入你的用户名");
            		Display display = new Display(PType.TEST,str,null);
            		display.setVisible(true);
            	}else{
            		Display display = new Display(PType.TEST,null,null);
            		display.setVisible(true);
            	}
                 
           }
      });
		button4.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	Display display = new Display(PType.SURVEY,null,"modify");
        		display.setVisible(true);
                 
           }
      });
		button5.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	Display display = new Display(PType.TEST,null,"modify");
            	display.setVisible(true);
                 
           }
      });
		button6.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	String str = JOptionPane.showInputDialog("输入你的用户名");
            	//Take take = new Take(str,PType.SURVEY);
            	Display display = new Display(PType.SURVEY,str,"take");
        		display.setVisible(true);
                 
           }
      });
		button7.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
            	String str = JOptionPane.showInputDialog("输入你的用户名");
            	//Take take = new Take(str,PType.TEST);
            	Display display = new Display(PType.TEST,str,"take");
        		display.setVisible(true);
                 
           }
      });
		button8.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){                 
                 Name name = new Name(8);
                 name.setVisible(true);
                 
           }
      });button9.addActionListener( new ActionListener(){
          public void actionPerformed(ActionEvent e){                 
              Name name = new Name(9);
              name.setVisible(true);
              
        }
   });
      button10.addActionListener( new ActionListener(){
          public void actionPerformed(ActionEvent e){                 
               System.exit(-1);
         }
    });
      
		
		add(button0);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button10);
		
		
	}
	public static void main(String[] args){
		FirstMenu frame = new FirstMenu();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
