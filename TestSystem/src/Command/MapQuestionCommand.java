package Command;

import Paper.Page;
import Question.MapQuestion;

public class MapQuestionCommand implements QuestionCommand{
	private Page paper;
	private MapQuestion question;
	private String prompt;
	private String[] lside;
	private String[] rside;
	private int score;
	private String answer="";
	public MapQuestionCommand(Page paper,MapQuestion question,String prompt,String[] lside, String[] rside){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.lside=new String[lside.length];
		this.rside=new String[rside.length];
		for(int i=0;i<lside.length;i++)
			this.lside[i]=lside[i];
		for(int i=0;i<rside.length;i++)
			this.rside[i]=rside[i];
	}
	public MapQuestionCommand(Page paper,MapQuestion question,String prompt,String[] lside, String[] rside,int score,String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
		this.lside=new String[lside.length];
		this.rside=new String[rside.length];
		for(int i=0;i<lside.length;i++)
			this.lside[i]=lside[i];
		for(int i=0;i<rside.length;i++)
			this.rside[i]=rside[i];
	}
	public MapQuestionCommand(Page paper,int index,String prompt,String[] lside, String[] rside){
		this.paper=paper;
		this.question=(MapQuestion)paper.getQuestion(index);
		this.prompt=prompt;
		this.lside=new String[lside.length];
		this.rside=new String[rside.length];
		for(int i=0;i<lside.length;i++)
			this.lside[i]=lside[i];
		for(int i=0;i<rside.length;i++)
			this.rside[i]=rside[i];
	}
	public MapQuestionCommand(Page paper,int index,String prompt,String[] lside, String[] rside,int score,String answer){
		this.paper=paper;
		this.question=(MapQuestion)paper.getQuestion(index);
		this.prompt=prompt;
		this.score=score;
		this.answer=answer;
		this.lside=new String[lside.length];
		this.rside=new String[rside.length];
		for(int i=0;i<lside.length;i++)
			this.lside[i]=lside[i];
		for(int i=0;i<rside.length;i++)
			this.rside[i]=rside[i];
	}
	public void modifyQuestion(){
		question.setPrompt(prompt);
		for(int i=0;i<lside.length;i++)
			question.setLeftItem(lside[i]);
		for(int i=0;i<rside.length;i++)
			question.setRightItem(rside[i]);
		if(answer.equals(null));
		else{
			question.setAnswer(answer);
			question.setScore(score);
		}
	}
	public void addQuestion(){
		modifyQuestion();
		paper.addQuestion(question);
	}
}
