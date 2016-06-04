package Paper;

import Question.Question;

public class Test extends Page {
	public Test(){
		type=PType.TEST;
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
