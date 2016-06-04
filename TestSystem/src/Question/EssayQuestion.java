package Question;

import Anwser.TextAnswer;

public class EssayQuestion extends Question {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public String getQuestion(){
		return "Essay: "+prompt;
	}
}
