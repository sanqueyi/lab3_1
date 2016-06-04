package Anwser;

public class NumAnswer extends Answer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumAnswer(String ans){
		setAnswer(ans);
	}

	@Override
	public void setAnswer(String ans) {
		String[] answers = ans.split(" ");
		String tmp="";
		for(int i=0; i<answers.length; i++){
			tmp=tmp+answers[i]+" ";
		}
		answer=tmp;
	}

	@Override
	public boolean match(String ans) {
		String[] answers = ans.split(" ");
		String tmp="";
		for(int i=0; i<answers.length; i++){
			tmp=tmp+answers[i]+" ";
		}
		return tmp.equals(answer);
	}
}
