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
import Paper.PType;
import Question.DecideQuestion;
import Question.QType;

public class Change extends JFrame {

	public Change(PType ptype, QType qtype, int n, String string, List<String> list, List<String> list2, String string2,
			Integer integer) {
		setLayout(null);
		if (qtype == QType.DECIDE) {
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
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
			submit.setBounds(200, 300, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ans;
					if (radioButton1.isSelected()) {
						ans = radioButton1.getText();
					} else {
						ans = radioButton2.getText();
					}

				}
			});
			add(submit);
			add(question);
			add(sco);
			add(score);
		} else if (qtype == QType.CHOICE) {
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80+35*i, 90, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 80+35*(list.size()+1);
			
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, height, 150, 30);
			
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			JTextField answer = new JTextField(string2);
			answer.setBounds(20, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,50,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list.add(str);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,50,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

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
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JTextField answer = new JTextField(string2);
			answer.setBounds(20, 60, 200, 30);
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, 100, 150, 30);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, 100, 50, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(submit);
			add(question);
			add(answer);
			add(sco);
			add(score);
		} else if (qtype == QType.ESSAY) {
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JTextField answer = new JTextField(string2);
			answer.setBounds(20, 60, 200, 30);
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, 100, 150, 30);
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, 100, 50, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(submit);
			add(question);
			add(answer);
			add(sco);
			add(score);

		} else if (qtype == QType.RANK) {
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80+35*i, 90, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 80+35*(list.size()+1);
			
			JLabel sco = new JLabel("分数为：");
			sco.setFont(new java.awt.Font("Dialog", 1, 18));
			sco.setBounds(20, height, 150, 30);
			
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			JTextField answer = new JTextField(string2);
			answer.setBounds(20, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,50,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list.add(str);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,50,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

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
			JTextField score = new JTextField(integer.toString());
			score.setBounds(180, height+40, 50, 30);
			add(score);
			JTextField answer = new JTextField(string2);
			answer.setBounds(20, height+80, 200, 30);
			add(answer);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,50,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入左选项");
					list.add(str);
					String str1 = JOptionPane.showInputDialog("输入右选项");
					list2.add(str1);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+150,50,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除左边的序号1~");
					list.remove(Integer.parseInt(str)-1);
					String str2 = JOptionPane.showInputDialog("输入想要删除右边的序号1~");
					list2.remove(Integer.parseInt(str2)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

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

	public Change(PType ptype, QType qtype, int m, String string, List<String> list, List<String> list2) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		if (qtype == QType.DECIDE) {
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(submit);
			add(question);
		} else if (qtype == QType.CHOICE) {
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
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
					list.add(str);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,100,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 100, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(add);
			add(delete);
			add(submit);

		} else if (qtype == QType.SHORTESSAY) {
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(submit);
			add(question);
			

		} else if (qtype == QType.ESSAY) {
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JButton submit = new JButton("提交");
			submit.setBounds(200, 300, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(submit);
			add(question);

		} else if (qtype == QType.RANK) {
			ArrayList<JTextField> list0  = new ArrayList();
			JTextField question = new JTextField(string);
			question.setBounds(20, 20, 200, 30);
			JLabel item = new JLabel("选项为：");
			item.setFont(new java.awt.Font("Dialog", 1, 18));
			item.setBounds(20, 60, 60, 30);
			for(int i=0;i<list.size();i++){
				JTextField opt = new JTextField(list.get(i));
				opt.setBounds(80+35*i, 90, 200, 30);
				add(opt);
				list0.add(opt);
			}
			int height = 80+35*(list.size()+1);
			
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,50,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入选项");
					list.add(str);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,50,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除的序号1~");
					list.remove(Integer.parseInt(str)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			add(question);
			add(add);
			add(delete);
			add(submit);

		} else if (qtype == QType.MAP) {
			ArrayList<JTextField> list0  = new ArrayList();
			ArrayList<JTextField> list3  = new ArrayList();
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
			for(int i=0;i<list2.size();i++){
				JTextField opt2 = new JTextField(list2.get(i));
				opt2.setBounds(280, 90+35*i, 200, 30);
				add(opt2);
				list3.add(opt2);
			}
			int height = 90+35*(list.size()+1);
			JButton add = new JButton("添加");
			add.setBounds(200,height+120,50,20);
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入左选项");
					list.add(str);
					String str1 = JOptionPane.showInputDialog("输入右选项");
					list2.add(str1);

				}
			});
			JButton delete = new JButton("删除");
			delete.setBounds(200,height+140,50,20);
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = JOptionPane.showInputDialog("输入想要删除左边的序号1~");
					list.remove(Integer.parseInt(str)-1);
					String str2 = JOptionPane.showInputDialog("输入想要删除右边的序号1~");
					list2.remove(Integer.parseInt(str2)-1);

				}
			});
			JButton submit = new JButton("提交");
			
			submit.setBounds(200, height+180, 50, 20);
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

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
