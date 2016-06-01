package Question;

import Anwser.Answer;


public abstract class Question {
	String prompt; //题目
	int score;
	int type;
	
	public Question(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
	
	public String getQuestion(){
		return null;
	}
	
	public String getPrompt(){
		return prompt;
	}
	
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public abstract void setAnswer(String answer); //设置正确答案
	
	public abstract Answer getAnswer(); //得到正确答案
	public abstract boolean match(Answer answer); //与正确答案比较
}
