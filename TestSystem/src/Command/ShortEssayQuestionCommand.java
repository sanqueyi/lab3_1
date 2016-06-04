package Command;

import Control.IO;
import Paper.PType;
import Paper.Page;
import Question.MapQuestion;
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
	public ShortEssayQuestionCommand(Page paper,ShortEssayQuestion question,String prompt,int score,String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
	}
	public ShortEssayQuestionCommand(IO io,String pageName,PType type,int index,String prompt){
		this.paper=IO.readPage(pageName, type);
		this.question=(ShortEssayQuestion)paper.getQuestion(index);
		this.prompt=prompt;
	}
	public ShortEssayQuestionCommand(IO io,String pageName,PType type,int index,String prompt,int score,String answer){
		this.paper=IO.readPage(pageName, type);
		this.question=(ShortEssayQuestion)paper.getQuestion(index);
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
