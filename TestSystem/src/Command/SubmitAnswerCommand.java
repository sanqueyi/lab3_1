package Command;

import java.util.List;

import Anwser.NumAnswer;
import Anwser.TextAnswer;
import Control.IO;
import Paper.PType;
import Paper.Page;
import Paper.Record;
import Question.QType;
import Question.Question;

public class SubmitAnswerCommand implements InforCommand{
	IO io;
	Page page;
	List<String> answer;
	String name;
	public SubmitAnswerCommand(IO io,Page page,List<String> answer,String name){
		this.io=io;
		this.page=page;
		this.answer=answer;
		this.name=name;
	}
	@Override
	public Integer returnInfor() {
		int size=page.getQuestionSize();
		Question question;
		String pageName=page.getPageName();
		Record record=new Record(name,pageName);
		int score=0;
		if(page.getType()==PType.TEST){
			for(int i=0;i<size;i++){
				question=page.getQuestion(i);
				if(question.match(answer.get(i))){
					if(question.getType()==QType.ESSAY);
					else score +=question.getScore();
				}
				if((question.getType()==QType.ESSAY)||(question.getType()==QType.SHORTESSAY)){
					TextAnswer ta=new TextAnswer(answer.get(i));
					record.addAnwser(ta);
				}
				else{	
					NumAnswer na=new NumAnswer(answer.get(i));
					record.addAnwser(na);
				}
			}	
		}		
		record.setScore(score);
		io.writeRecord(record,page.getType());
		return score;
	}
	@Override
	public Object returnAnotherInfor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object returnThirdInfor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object returnFouthInfor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object returnFifthInfor() {
		// TODO Auto-generated method stub
		return null;
	}
}
