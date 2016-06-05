package Command;


import java.util.LinkedList;
import java.util.List;

import Control.IO;
import Paper.PType;
import Paper.Page;
import Paper.Test;
import Paper.Record;
import Question.*;

public class ShowPageCommand extends InforCommand{
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
			result.add(page.getQuestion(i).getPrompt());
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
				answer.add(record.getAnswer(i).getAnswer());
		}
		else{
			for(int i=0;i<size;i++)
				answer.add( page.getQuestion(i).getAnswer());
		}
		return answer;
	}
	@Override
	public List<Integer> returnThirdInfor() {
		int size=page.getQuestionSize();
		List<Integer> score=new LinkedList<Integer>();
		for(int i=0;i<size;i++)
			score.add(page.getQuestion(i).getScore());
		return score;
	}
	@Override
	public List<List<String>>[] returnFouthInfor() {
		int size=page.getQuestionSize();
		List<List<String>>[] items=new List[2];
		items[0]=new LinkedList<List<String>>();
		items[1]=new LinkedList<List<String>>();
		for(int i=0;i<size;i++){
			Question question=page.getQuestion(i);
			QType qtype=question.getType();
			if((qtype==QType.CHOICE)||(qtype==QType.RANK)){
				items[0].add(((ItemQuestion)question).getItems());
				items[1].add(null);
			}	
			else if (qtype==QType.DECIDE){
				List<String> item=new LinkedList<String>();
				item.add("T");
				item.add("F");
				items[0].add(item);
				items[1].add(null);
			}
			else if	(qtype==QType.MAP){
				items[0].add(((MapQuestion)question).getLeftItems());
				items[1].add(((MapQuestion)question).getRightItems());
			}
			else{
				items[0].add(null);
				items[1].add(null);
			}
		}
		return items;
	}

	@Override
	public int[] returnFifthInfor() {
		int[] result=new int[3];
		result[0]=page.getTime();
		result[1]=((Test)page).getTotalScore();
		if(isRecord){
			Record record=io.readRecord(name, type);
			result[2]=record.getScore();
		}
		return result;
	}
	public List<QType> returnsixthInfor() {
		List<QType> type=new LinkedList<QType>();
		int size=page.getQuestionSize();
		for(int i=0;i<size;i++)
			type.add(page.getQuestion(i).getType());
		return type;
	}

	
}
