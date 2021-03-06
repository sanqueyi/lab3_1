package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Command.DecideQuestionCommand;
import Command.EssayQuestionCommand;
import Command.ItemQuestionCommand;
import Command.MapQuestionCommand;
import Command.SavePageCommand;
import Command.ShortEssayQuestionCommand;
import Control.IO;
import Paper.PType;
import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.MapQuestion;
import Question.QType;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import invoker.Invoker;

public class Change extends JFrame {

	public Change(PType ptype, QType qtype, int n, String string, List<String> list, List<String> list2, String string2,
			Integer integer,Page paper) {
		Invoker invoke = new Invoker();
		setLayout(null);
		if (qtype == QType.DECIDE) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,100,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			JRadioButton radioButton1 = new JRadioButton("T");// 创建单选按钮
			radioButton1.setFont(new java.awt.Font("Dialog", 1, 18));
			radioButton1.setBounds(20, 60, 100, 30);
			add(radioButton1);// 应用单选按钮
			JRadioButton radioButton2 = new JRadioButton("F");// 创建单选按钮
			radioButton2.setFont(new java.awt.Font("Dialog", 1, 18));
			radioButton2.setBounds(130, 60, 100, 30);
			add(radioButton2);// 应用单选按钮
			ButtonGroup group = new ButtonGroup();// 创建单选按钮组
			group.add(radioButton1);
			group.add(radioButton2);
			if (string2.equals("T")) {
				radioButton1.setSelected(true);
			} else {
				radioButton2.setSelected(true);
			}
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, 120, 150, 30);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, 250, 50, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ans;
					if (radioButton1.isSelected()) {
						ans = radioButton1.getText();
					} else {
						ans = radioButton2.getText();
					}
					DecideQuestion newquestion=new DecideQuestion();
					DecideQuestionCommand dqc = new DecideQuestionCommand(paper,newquestion,n,question.getText(),Integer.parseInt(score.getText()),ans);
		        	invoke.setQestionCommand(dqc);
		        	invoke.modifyQustion();
		        	 setVisible(false);
				}
			});
			add(submit);
			add(question);
			add(sco);
			add(score);
		} else if (qtype == QType.CHOICE) {
			ArrayList<JTextField> list0  = new ArrayList();
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,100,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			add(item);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 90+35*(list.size()+1);
			
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, height, 150, 30);
			add(sco);
			
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			JLabel  jl0= new JLabel("答案：");
			jl0.setBounds(0,height+80,100,30);
			add(jl0);
			JTextField answer = new JTextField(string2);
			answer.setBounds(100, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list0.add(new JTextField(str));

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list0.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			int number = list0.size();
			String[] items = new String[number];
			for(int i=0;i<number;i++){
				items[i]=list0.get(i).getText();
			}
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChoiceQuestion newQuestion=new ChoiceQuestion();
					ItemQuestionCommand iqc = new ItemQuestionCommand(paper,newQuestion,n,question.getText(),items,Integer.parseInt(score.getText()),answer.getText());
		            invoke.setQestionCommand(iqc);
		            invoke.modifyQustion();
		            setVisible(false);
				}
			});
			add(add);
			add(delete);
			add(submit);
			add(question);
			add(item);
			add(sco);
			add(score);
			
			
			

		} else if (qtype == QType.SHORTESSAY) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel  jl0= new JLabel("答案：");
			jl0.setBounds(0,60,100,30);
			add(jl0);
			JTextField answer = new JTextField(string2);
			answer.setBounds(100, 60, 200, 30);
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, 100, 150, 30);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, 100, 50, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShortEssayQuestion newquestion=new ShortEssayQuestion();
					ShortEssayQuestionCommand seqc = new ShortEssayQuestionCommand(paper,newquestion,n,question.getText(),Integer.parseInt(score.getText()), answer.getText());
		             invoke.setQestionCommand(seqc);
		             invoke.modifyQustion();
			         setVisible(false);

				}
			});
			add(submit);
			add(question);
			add(answer);
			add(sco);
			add(score);
		} else if (qtype == QType.ESSAY) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel  jl0= new JLabel("答案：");
			jl0.setBounds(0,60,100,30);
			add(jl0);
			JTextField answer = new JTextField(string2);
			answer.setBounds(100, 60, 200, 30);
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, 100, 150, 30);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, 100, 100, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EssayQuestion newQuestion=new EssayQuestion();
					EssayQuestionCommand seqc = new EssayQuestionCommand(paper,newQuestion,n,question.getText(),Integer.parseInt(score.getText()),answer.getText());
		             invoke.setQestionCommand(seqc);
		      
			        	 invoke.modifyQustion();
			        	 setVisible(false);

				}
			});
			add(submit);
			add(question);
			add(answer);
			add(sco);
			add(score);

		} else if (qtype == QType.RANK) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 90+35*(list.size()+1);
			
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, height, 150, 30);
			
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			JLabel  jl0= new JLabel("答案：");
			jl0.setBounds(0,height+80,100,30);
			add(jl0);
			JTextField answer = new JTextField(string2);
			answer.setBounds(100, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list0.add(new JTextField(str));

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list0.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = list0.size();
					String[] items = new String[number];
					for(int i=0;i<number;i++){
						items[i]=list0.get(i).getText();
					}
					RankQuestion newQuestion=new RankQuestion();
					ItemQuestionCommand seqc = new ItemQuestionCommand(paper,newQuestion,n,question.getText(),items,Integer.parseInt(score.getText()),answer.getText());
	                invoke.setQestionCommand(seqc);
	              
	    	        
	    	        	invoke.modifyQustion();
	    	        
	               setVisible(false);
	    		}

				
			});
			add(question);
			add(item);
			add(sco);
			add(score);
			add(add);
			add(delete);
			add(submit);

		} else if (qtype == QType.MAP) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			ArrayList<JTextField> list0  = new ArrayList();
			ArrayList<JTextField> list3  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			add(question);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			add(item);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			for(int i=0;i<list2.size();i++){
				JTextField opt2 = new JTextField(list2.get(i));
				opt2.setBounds(280, 90+35*i, 200, 30);
				add(opt2);
				list3.add(opt2);
			}
			int height = 90+35*(list.size()+1);
			
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, height, 150, 30);
			add(sco);
			JLabel  jl0= new JLabel("答案：");
			jl0.setBounds(0,height+80,100,30);
			add(jl0);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			add(score);
			JTextField answer = new JTextField(string2);
			answer.setBounds(100, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入左选项");
					list0.add(new JTextField(str));
					String str1 = JOptionPane.showInputDialog("输入右选项");
					list3.add(new JTextField(str1));
                    
				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+150,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除左边的序号1~");
					list0.remove(Integer.parseInt(str)-1);
					String str2 = JOptionPane.showInputDialog("输入想要删除右边的序号1~");
					list3.remove(Integer.parseInt(str2)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = list0.size();
					String[] items = new String[number];
					String[] items0 = new String[number];
					for(int i=0;i<number;i++){
						items[i]=list0.get(i).getText();
						items0[i]=list3.get(i).getText();
					}
					MapQuestion newQuestion=new MapQuestion();
					MapQuestionCommand seqc = new MapQuestionCommand(paper,newQuestion,n,question.getText(),items,items0,Integer.parseInt(score.getText()),answer.getText());
	                invoke.setQestionCommand(seqc);
	               
	    	        
	    	        	invoke.modifyQustion();
	    	        
	               setVisible(false);

				}
			});
			add(add);
			add(delete);
			add(submit);

		}

		setSize(500, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

	public Change(PType ptype, QType qtype, int m, String string, List<String> list, List<String> list2,Page paper) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		Invoker invoke =new Invoker();
		if (qtype == QType.DECIDE) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			
			JButton submit = new JButton("提交");
			submit.setBounds(200, 60, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecideQuestion newQuestion=new DecideQuestion();
					DecideQuestionCommand dqc = new DecideQuestionCommand(paper,newQuestion,m,question.getText());
		        	invoke.setQestionCommand(dqc);
		        	invoke.modifyQustion();
		        	 setVisible(false);
				}
			});
			add(submit);
			add(question);
		} else if (qtype == QType.CHOICE) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			add(question);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 150, 30);
			add(item);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 90+35*(list.size()+1);
			
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list0.add(new JTextField(str));

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list0.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			int number = list0.size();
			String[] items = new String[number];
			for(int i=0;i<number;i++){
				items[i]=list0.get(i).getText();
			}
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChoiceQuestion newQuestion=new ChoiceQuestion();
					ItemQuestionCommand iqc = new ItemQuestionCommand(paper,newQuestion,m,question.getText(),items);
		            invoke.setQestionCommand(iqc);
		            invoke.modifyQustion();
                    setVisible(false);
				}
			});
			add(add);
			add(delete);
			add(submit);

		} else if (qtype == QType.SHORTESSAY) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 300, 30);
			
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShortEssayQuestion newQuestion=new ShortEssayQuestion();
					ShortEssayQuestionCommand seqc = new ShortEssayQuestionCommand(paper,newQuestion,m,question.getText());
		             invoke.setQestionCommand(seqc);
		             invoke.modifyQustion();
			         setVisible(false);

				}
			});
			add(submit);
			add(question);
			

		} else if (qtype == QType.ESSAY) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EssayQuestion newQuestion=new EssayQuestion();
					EssayQuestionCommand seqc = new EssayQuestionCommand(paper,newQuestion,m,question.getText());
		             invoke.setQestionCommand(seqc);
		      
			        	 invoke.modifyQustion();
			        	 setVisible(false);

				}
			});
			add(submit);
			add(question);

		} else if (qtype == QType.RANK) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			add(item);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 90+35*(list.size()+1);
			
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list0.add(new JTextField(str));

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list0.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = list0.size();
					String[] items = new String[number];
					for(int i=0;i<number;i++){
						items[i]=list0.get(i).getText();
					}
					RankQuestion newQuestion=new RankQuestion();
					ItemQuestionCommand seqc = new ItemQuestionCommand(paper,newQuestion,m,question.getText(),items);
	                invoke.setQestionCommand(seqc);
	              
	    	        
	    	        	invoke.modifyQustion();
	    	        
	               setVisible(false);

				}
			});
			add(question);
			add(add);
			add(delete);
			add(submit);

		} else if (qtype == QType.MAP) {
			JLabel  jl= new JLabel("问题：");
			jl.setBounds(0,20,80,30);
			add(jl);
			ArrayList<JTextField> list0  = new ArrayList();
			ArrayList<JTextField> list3  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(100, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			add(item);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80, 90+35*i, 200, 30);
				add(opt);
				list0.add(opt);
			}
			for(int i=0;i<list2.size();i++){
				JTextField opt2 = new JTextField(list2.get(i));
				opt2.setBounds(280, 90+35*i, 200, 30);
				add(opt2);
				list3.add(opt2);
			}
			int height = 90+35*(list.size()+1);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,100,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入左选项");
					list0.add(new JTextField(str));
					String str1 = JOptionPane.showInputDialog("输入右选项");
					list3.add(new JTextField(str1));

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除左边的序号1~");
					list0.remove(Integer.parseInt(str)-1);
					String str2 = JOptionPane.showInputDialog("输入想要删除右边的序号1~");
					list3.remove(Integer.parseInt(str2)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = list0.size();
					String[] items = new String[number];
					String[] items0 = new String[number];
					for(int i=0;i<number;i++){
						items[i]=list0.get(i).getText();
						items0[i]=list3.get(i).getText();
					}
					MapQuestion newQuestion=new MapQuestion();
					MapQuestionCommand seqc = new MapQuestionCommand(paper,newQuestion,m,question.getText(),items,items0);
	                invoke.setQestionCommand(seqc);
	               
	    	        
	    	        	invoke.modifyQustion();
	    	        
	               setVisible(false);

				}
			});
			add(question);
			add(add);
			add(delete);
			add(submit);

		}
		setSize(500, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

}
