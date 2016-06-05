package Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Control.IO;
import Paper.PType;
import Paper.Page;
import Paper.Record;
import Question.QType;

public class LookOutComeCommand extends InforCommand{
	PType type;
	String pageName;
	IO io;
	public LookOutComeCommand(IO io,PType type,String pageName){
		this.io=io;
		this.type=type;
		this.pageName=pageName;
	}
	@Override
	public String returnInfor() {
		// TODO Auto-generated method stub
		List<Record> records=io.getAllRecordbyPage(pageName,type);
		Page page=IO.readPage(pageName, type);
		int size=page.getQuestionSize();
		int length=records.size();
		String result="Page name:"+page.getPageName()+"\nCreator name:"+page.getPersonName()+"\n";
		for(int i=0;i<size;i++){
			if(page.getQuestion(i).getType()==QType.ESSAY);
			else{
				Map<String, Integer> map = new HashMap<String, Integer>();
				for(int j=0;j<length;j++){
					String key=records.get(j).getAnswer(i).getAnswer();
					if(map.containsKey(key)){
						int value=map.get(key);
						map.put(key, value+1);
					}
					else map.put(key, 1);	
			    }			
				result +=(i+1)+"、"+page.getQuestion(i).getQuestion()+"\n";
				for(String key: map.keySet()){
					result +="Answer: " + key+"\t"+map.get(key)+"\n";
				}
			}
		}
		
		return result;
	}
}
