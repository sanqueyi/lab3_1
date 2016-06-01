package Anwser;

public interface Answer {
	
	
	public String getAnswer();  //相当于得到答案的完整版本，带有题目当中的字符串
	public void setAnswer(String aswser);
	public String writeAnswer();  //就是将之前的setAnswer的字符串还原回来，用于比较答案
	public int getType();
	public boolean match(Answer answer);
}
