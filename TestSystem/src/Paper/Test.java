package Paper;

import Question.Question;

public class Test extends Page {
	int totalScore;
	
	public void setTotalScore(int score){
		totalScore = score;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void computeScore(){  //得到试卷的总分
		totalScore = 0;
		for(int i=0; i<questionList.size(); i++){
			Question question = questionList.get(i);
			totalScore += question.getScore();
		}
	}
}
