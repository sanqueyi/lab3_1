package Command;


import java.util.LinkedList;
import java.util.List;

import Control.IO;
import Paper.PType;
import Paper.Page;
import Paper.Test;
import Paper.Record;
import Question.*;

public class ShowPageCommand implements InforCommand{
	IO io;
	PType type;
	String name;
	Page page;
	boolean isRecord;
	
	public ShowPageCommand(IO io,PType type,String name,boolean isRecord){
		this.io=io;
		this.type=type;
		this.name=name;
		this.page=io.readPage(name, type);
		this.isRecord=isRecord;
		
	}
	public List<String> returnInfor(){
		int size=page.getQuestionSize();
		List<String> result=new LinkedList<String>();		
		for(int i=0;i<size;i++){
			result.set(i, page.getQuestion(i).getPrompt());
		}		
		return result;
	}
	@Override
	public List<String> returnAnotherInfor() {
		int size=page.getQuestionSize();
		List<String> answer=new LinkedList<String>();
		if(isRecord){
			Record record=io.readRecord(name, type);
			for(int i=0;i<size;i++)
				answer.set(i, record.getAnswer(i).getAnswer());		
		}
		else{
			for(int i=0;i<size;i++)
				answer.set(i, page.getQuestion(i).getAnswer());
		}
		return null;
	}
	@Override
	public List<Integer> returnThirdInfor() {
		int size=page.getQuestionSize();
		List<Integer> score=new LinkedList<Integer>();
		for(int i=0;i<size;i++)
			score.set(i, page.getQuestion(i).getScore());
		return score;
	}
	@Override
	public List<List<String>>[] returnFouthInfor() {
		int size=page.getQuestionSize();
		List<List<String>>[] items=new List[2];
		for(int i=0;i<size;i++){
			Question question=page.getQuestion(i);
			QType qtype=question.getType();
			if((qtype==QType.CHOICE)||(qtype==QType.RANK))
				items[0].set(i, ((ItemQuestion)question).getItems());
			else if	(qtype==QType.CHOICE){
				items[0].set(i, ((MapQuestion)question).getLeftItems());
				items[1].set(i, ((MapQuestion)question).getRightItems());
			}
		}
		return items;
	}
	@Override
	public Object returnFifthInfor() {
		int[] result=new int[2];
		result[0]=page.getTime();
		result[1]=((Test)page).getTotalScore();
		return null;
	}
	
}
