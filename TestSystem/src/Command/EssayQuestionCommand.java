package Command;

import Paper.Page;
import Question.EssayQuestion;

public class EssayQuestionCommand implements QuestionCommand{
	private Page paper;
	private EssayQuestion question;
	private String prompt;
	private int score;
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
	}
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt,int score){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
	}
	public void modifyQuestion(){
		question.setPrompt(prompt);
		question.setScore(score);
	}
	public void addQuestion(){
		question.setPrompt(prompt);
		paper.addQuestion(question);
	}

}
