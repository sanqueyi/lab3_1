package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Command.EssayQuestionCommand;
import Paper.Page;
import Paper.Survey;
import Question.ChoiceQuestion;
import Question.EssayQuestion;


public class Test {
	public static void main(String[] args){
		/*BufferedReader b;
		try {
			b = new BufferedReader(new FileReader("train.conll"));
			String xx;
			int id = 10;
			while((xx = b.readLine())!=null && id > 0){
				System.out.println(xx+"\tlength"+xx.length());
				id--;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		EssayQuestion cq=new EssayQuestion();
		cq.setPrompt("hi");
		Survey page=new Survey("test");
		page.addQuestion(cq);
		EssayQuestionCommand c=new EssayQuestionCommand(page,cq,"hello");
		c.modifyQuestion();
		System.out.println(cq.getPrompt());
	}
	
}
