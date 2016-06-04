package Question;

import Anwser.TextAnswer;

public class ShortEssayQuestion extends Question {

	public ShortEssayQuestion() {
		super(QType.SHORTESSAY);
	}

	@Override
	public void setAnswer(String ans) {
		answer=new TextAnswer(ans);
	}

	@Override
	public String getQuestion() {
		return "ShortEssay:"+prompt;
	}
}
