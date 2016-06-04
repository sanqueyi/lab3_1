package Command;

import javax.swing.JTextField;

import Control.IO;
import Paper.PType;
import Paper.Page;
import Question.DecideQuestion;
import Question.EssayQuestion;

public class EssayQuestionCommand implements QuestionCommand{
	private Page paper;
	private EssayQuestion question;
	private String prompt;
	private String answer;
	private int score;
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
	}
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt,int score,String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
	}
	public EssayQuestionCommand(IO io,String pageName,PType type,int index,String prompt){
		this.paper=IO.readPage(pageName, type);
		this.question=(EssayQuestion)paper.getQuestion(index);
		this.prompt=prompt;
	}
	public EssayQuestionCommand(IO io,String pageName,PType type,int index,String prompt,int score,String answer){
		this.paper=IO.readPage(pageName, type);
		this.question=(EssayQuestion)paper.getQuestion(index);
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
	}
	public void modifyQuestion(){
		question.setPrompt(prompt);
		question.setScore(score);
		question.setAnswer(answer);
	}
	public void addQuestion(){
		modifyQuestion();
		paper.addQuestion(question);
	}

}
