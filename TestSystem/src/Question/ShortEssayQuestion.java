package Question;

import Anwser.TextAnswer;

public class ShortEssayQuestion extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShortEssayQuestion() {
		super(QType.SHORTESSAY);
	}

	@Override
	public void setAnswer(String ans) {
		answer=new TextAnswer(ans);
	}

	@Override
	public String getQuestion() {
		return "ShortEssay:"+prompt+"\n";
	}
}
