package Command;

import Paper.Page;
import Question.DecideQuestion;


public class DecideQuestionCommand implements QuestionCommand{
	private Page paper;
	private DecideQuestion question;
	private String prompt;
	private int score;
	private String answer="";
	DecideQuestionCommand(Page paper,DecideQuestion question,String prompt, int score, String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
	}
	DecideQuestionCommand(Page paper,DecideQuestion question,String prompt){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
	}
	public void modifyQuestion(){
		question.setPrompt(prompt);
		question.setAnswer(answer);
		question.setScore(score);
	}
	public void addQuestion(){	
		modifyQuestion();
		paper.addQuestion(question);
	}
	
}
