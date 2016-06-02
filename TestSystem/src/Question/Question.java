package Question;

import Anwser.Answer;


public abstract class Question {
	protected String prompt; //题目
	protected QType type;
	protected boolean IsScore=false;
	protected int score=0;
	protected Answer answer=null;
	
	public Question(QType type){
		this.type = type;
	}
	
	public String getPrompt(){
		return prompt;
	}
	
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}

	public QType getType(){
		return type;
	}
	
	public String getTypeIndex(){
		return type.getTypeIndex();
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		IsScore=true;
		this.score=score;
	}
	
	public String getAnswer(){
		if(answer==null){
			return null;
		}
		return answer.getAnswer();
	}
	
	public abstract void setAnswer(String ans); //设置正确答案
	
	public boolean match(String ans){  //与正确答案比较
		return answer.match(ans);
	}
}
