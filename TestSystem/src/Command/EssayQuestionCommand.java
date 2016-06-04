package Command;

import javax.swing.JTextField;

import Paper.Page;
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
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt,String score,String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=Integer.parseInt(score);
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
