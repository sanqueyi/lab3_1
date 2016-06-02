package Question;

import Anwser.NumAnswer;

public class DecideQuestion extends Question {
	public DecideQuestion() {
		super(QType.DECIDE);
	}

	@Override
	public void setAnswer(String ans) {
		answer=new NumAnswer(ans);
		
	}

	//1.right 2.false
	
}
