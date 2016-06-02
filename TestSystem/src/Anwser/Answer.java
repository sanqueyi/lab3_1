package Anwser;

public abstract class Answer {
	protected String answer;
	
	public String getAnswer(){
		return answer;
	}
	
	public abstract void setAnswer(String ans);
	
	public abstract boolean match(String ans);
}
