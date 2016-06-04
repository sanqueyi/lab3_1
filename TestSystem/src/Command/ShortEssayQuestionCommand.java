package Command;

import Paper.Page;
import Question.ShortEssayQuestion;

public class ShortEssayQuestionCommand implements QuestionCommand{
	private Page paper;
	private ShortEssayQuestion question;
	private String prompt;
	private int score;
	private String answer;
	public ShortEssayQuestionCommand(Page paper,ShortEssayQuestion question,String prompt){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
	}
	public ShortEssayQuestionCommand(Page paper,ShortEssayQuestion question,String prompt,String score,String answer){
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
