package Question;

import Anwser.NumAnswer;

public class DecideQuestion extends Question {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DecideQuestion() {
		super(QType.DECIDE);
	}

	@Override
	public void setAnswer(String ans) {
		answer=new NumAnswer(ans);
		
	}
	public String getQuestion(){
		String ret = "T/F: "+prompt+"\n"+"1) T\n2) F\n";
		return ret;
	}
	//1.right 2.false
	
}
