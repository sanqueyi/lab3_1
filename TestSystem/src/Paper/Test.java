package Paper;

import Question.Question;

public class Test extends Page {
	private int time=0;
	public Test(){
		type=PType.TEST;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int t){
		time=t;
	}
	
	public int getTotalScore(){
		int totalScore = 0;
		for(int i=0; i<questionList.size(); i++){
			Question question = questionList.get(i);
			totalScore += question.getScore();
		}
		return totalScore;
	}
}
