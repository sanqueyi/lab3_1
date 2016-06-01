package Question;

import Anwser.Answer;
import Anwser.DecideAnswer;

public class DecideQuestion extends PromptQuestion {
	DecideAnswer answer;
	
	public DecideQuestion(){
		super(0);
	}

	
	@Override
	public String getQuestion(){ //得到判断题的题目和tf选项
		String ret = "T/F: "+prompt+"\n"+"1. right\n2. false";
		return ret;
	}
	
	@Override
	public void setAnswer(String anwser){ 
		answer = new DecideAnswer();
		answer.setAnswer(anwser);
	}
	
	@Override
	public Answer getAnswer(){
		return answer;
	}

	public boolean match(String answer) {
		// TODO Auto-generated method stub
		return this.answer.getAnswer().equals(answer);
	}


	@Override
	public boolean match(Answer answer) {
		return this.answer.match(answer);
	}
}
