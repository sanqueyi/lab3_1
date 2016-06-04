package Command;

import java.util.List;

import Anwser.NumAnswer;
import Anwser.TextAnswer;
import Control.IO;
import Paper.Page;
import Paper.Record;
import Question.QType;
import Question.Question;

public class SubmitAnswerCommand implements ExecuteCommand{
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
	public void execute() {
		int size=page.getQuestionSize();
		Question question;
		String pageName=page.getPageName();
		Record record=new Record(name,pageName);
		int score=0;
		for(int i=0;i<size;i++){
			question=page.getQuestion(i);
			if(question.match(answer.get(i)))
				score +=question.getScore();
			if((question.getType()==QType.ESSAY)||(question.getType()==QType.SHORTESSAY)){
				TextAnswer ta=new TextAnswer(answer.get(i));
				record.addAnwser(ta);
			}
			else{	
				NumAnswer na=new NumAnswer(answer.get(i));
				record.addAnwser(na);
			}
		}
		
		record.setScore(score);
		io.writeRecord(record,page.getType());
	}
}
