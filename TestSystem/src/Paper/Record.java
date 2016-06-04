package Paper;

import java.util.LinkedList;
import java.util.List;
import Anwser.Answer;

public class Record {
	private List<Answer> answerList = new LinkedList<Answer>();
	private String personName;
	private String pageName;
	private int score;
	public Record(String pern,String pagn){
		personName=pern;
		pageName=pagn;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getPageName(){
		return pageName;
	}
	
	public void setPageName(String pn){
		pageName=pn;
	}
	
	public void addAnwser(Answer answer){  //添加答案
		answerList.add(answer);
	}
	
	public Answer getAnswer(int index){
		if(index < answerList.size()){
			return answerList.get(index); 
		}
		return null;
	}
	
	public int getScore(){
		return score;
	}
	public void setScore(int score){
		this.score=score;
	}
}
