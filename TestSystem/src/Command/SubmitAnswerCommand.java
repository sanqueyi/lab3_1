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

public class SubmitAnswerCommand extends InforCommand{
	IO io;
	String pageName;
	PType type;
	List<String> answer;
	String name;
	Page page;
	public SubmitAnswerCommand(IO io,String pageName,PType type,List<String> answer,String name){
		this.io=io;
		this.pageName=pageName;
		this.type=type;
		this.answer=answer;
		this.name=name;
		page=io.readPage(pageName, type);
	}
	@Override
	public Integer returnInfor() {
		int size=page.getQuestionSize();
		Question question;
		Record record=new Record(name,pageName);
		int score=0;
		if(type==PType.TEST){
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
		io.writeRecord(record,type);
		return score;
	}
}
