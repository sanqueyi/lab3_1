package Command;




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
	public EssayQuestionCommand(Page paper,EssayQuestion question,String prompt,int score,String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
	}
	public EssayQuestionCommand(Page paper,int index,String prompt){
		this.paper=paper;
		this.question=(EssayQuestion)paper.getQuestion(index);
		this.prompt=prompt;
	}
	public EssayQuestionCommand(Page paper,int index,String prompt,int score,String answer){
		this.paper=paper;
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
