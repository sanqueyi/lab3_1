package Question;

import Anwser.TextAnswer;

public class EssayQuestion extends Question {
		
	public EssayQuestion() {
		super(QType.ESSAY);
	}
	
	@Override
	public void setScore(int score){
		this.score=score;
	}

	@Override
	public void setAnswer(String ans) {
		answer=new TextAnswer(ans);
	}
}
