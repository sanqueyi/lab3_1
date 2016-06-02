package Anwser;

public class TextAnswer extends Answer{
	public TextAnswer(String ans){
		answer=ans;
	}

	@Override
	public void setAnswer(String ans) {
		answer=ans;
	}

	@Override
	public boolean match(String ans) {
		return ans.equals(answer);
	}
}
