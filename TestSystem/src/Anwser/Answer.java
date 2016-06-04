package Anwser;

public abstract class Answer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String answer;
	
	public String getAnswer(){
		return answer;
	}
	
	public abstract void setAnswer(String ans);
	
	public abstract boolean match(String ans);
}
