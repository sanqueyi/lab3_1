package Control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Anwser.Answer;
/*import Anwser.ChoiceAnswer;
import Anwser.DecideAnswer;
import Anwser.MapAnswer;
import Anwser.RankAnswer;
import Anwser.TextAnswer;*/
import Command.ItemQuestionCommand;
import Paper.Iterator;
import Paper.Page;
import Paper.Record;
import Paper.Survey;
import Paper.Test;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.ItemQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;

public class Control {
	
	
	List<String>[] pageNameList;  //第0个对应servey,第1个对应test
	Page page;
	Question question;
	int index;
	Record record;
	IO io = new IO();
	List<String> recordName;
	Iterator<Question> iterator;
	
	public Control(){
		pageNameList = io.readInfo();
	}
	
	public void createPage(int type){  //创建一个page
		/*if(type == 0){
			page = new Survey();
			page.setType("survey");
		}else{
			page = new Test();
			page.setType("test");
		}*/
	}
		
	public void setPageName(String name){
		page.setPageName(name);
		if(page.getType().equals("test")){
			pageNameList[1].add(name);
		}else{
			pageNameList[0].add(name);
		}
	}
	
	public void setItem(String item){
		((ItemQuestion)question).setItem(item);
	}
	
	public void setItem(int side, String item){
		/*MapQuestion map = (MapQuestion)question;
		map.setSide(side);
		map.setItem(item);*/
	}
	
	public void setSide(int side){
		/*MapQuestion map = (MapQuestion)question;
		map.setSide(side);*/
	}
	
	public void setAnswer(String answer){
		question.setAnswer(answer);
	}
	
	public void setPrompt(String prompt){
		question.setPrompt(prompt);

	}
	
	public void setScore(int score){
		question.setScore(score);
	}
	
	public List<String> getPageName(int type){
		return pageNameList[type];
	}
	
	public List<String> displayPage(int index, int type){  //包括完整的问题和答案
		/*List<String> ret = new LinkedList<String>();
		if(pageNameList[type].size() <= index){
			return ret;
		}else{
			page = io.readPage(pageNameList[type].get(index));
			Iterator<Question> questions = page.iterator();
			while(questions.hasNext()){
				Question q = questions.next();
				int ty = q.getType();
				String answer = "";
				if(type == 1 && ty != 3){
					answer = "\nThe correct answer is " + q.getAnswer().writeAnswer();
				}
				ret.add(q.getQuestion()+answer+"\n");
			}
			return ret;
		}*/
	}
	
	public void save(){
		/*if(page.getType().equals("test")){
			Test test = (Test)page;
			test.computeScore();
		}
		io.writeInfo(pageNameList);
		io.writePage(page);*/
	}
	
	public int modify(int index){  //得到page中某个下标问题的类型
		/*if(index >= page.getQuestionList().size()){
			return -1;
		}else{
			question = page.getQuestion(index);
			return question.getType();
		}*/
		return 0;
	}
	
	public void createDecideQuestion(String prompt, int score, String answer){
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		decide.setScore(score);
		decide.setAnswer(answer);
		page.addQuestion(decide);
	}
	
	public void createDecideQuestion(String prompt){
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		page.addQuestion(decide);
	}
	
	public void createChoiceQuestion(String prompt, String[] items, int score, String answer){
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		choice.setScore(score);
		choice.setAnswer(answer);
		page.addQuestion(choice);
	}
	
	public void createChoiceQuestion(String prompt, String[] items){
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		page.addQuestion(choice);
	}
	
	public void createTextQuestion(String prompt){
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.addQuestion(text);
	}
	
	public void createTextQuestion(String prompt, int score, String answer){
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.addQuestion(text);
	}
	
	public void createEssayQuestion(String prompt){
		EssayQuestion question = new EssayQuestion();
		question.setPrompt(prompt);
		page.addQuestion(question);
	}
	
	public void createRankQuestion(String prompt, String[] items){
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		page.addQuestion(question);
	}
	
	public void createRankQuestion(String prompt, String[] items, int score, String answer){
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		question.setScore(score);
		question.setAnswer(answer);
		page.addQuestion(question);
	}
	
	public void createMapQuestion(String prompt, String[] side1, String[] side2){
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for(int i=0; i<side1.length; i++){
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for(int i=0; i<side2.length; i++){
			map.setItem(side2[i]);
		}
		page.addQuestion(map);
	}
	
	public void createMapQuestion(String prompt, String[] side1, String[] side2, int score, String answer){
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for(int i=0; i<side1.length; i++){
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for(int i=0; i<side2.length; i++){
			map.setItem(side2[i]);
		}
		map.setScore(score);
		map.setAnswer(answer);
		page.addQuestion(map);
	}		
	
	public boolean remove(int index){
		if(question.getType() == 5){
			return ((MapQuestion)question).remove(index);
		}
		return ((ItemQuestion)question).remove(index);
	}
	
	public boolean changeItem(int index, String item){
		if(question.getType() == 5){
			return ((MapQuestion)question).changeItem(index, item);		
		}
		return ((ItemQuestion)question).changeItem(index, item);
	}
	
	public boolean changeItemNumber(int num){
		if(question.getType() == 5){
			return ((MapQuestion)question).changeItemNumber(num);		
		}
		return ((ItemQuestion)question).changeItemNumber(num);
	}
	
	public void loadPage(int index, int type){  //新得到一个page，没有填答案的page
		page = io.readPage(pageNameList[type].get(index));
		record = new Record();
	}
	
	public void setRecordName(String name){
		record.setPersonName(name);
		iterator = page.iterator();
	}
	
	public String nextQuestion(){
		question = iterator.next();
		return question.getQuestion();
	}
	
	public boolean hasNextQuestion(){
		return iterator.hasNext();
	}
	
	public void answerQuestion(String answer){  //把答案加到记录里面
		switch(question.getType()){
		case 0: DecideAnswer decide = new DecideAnswer();
				decide.setAnswer(answer);
				record.addAnwser(decide);
				break;
		case 1: ChoiceAnswer choice = new ChoiceAnswer();
				choice.setAnswer(answer);
				record.addAnwser(choice);
				break;
		case 2:
		case 3:	TextAnswer text = new TextAnswer();
				text.setAnswer(answer);
				record.addAnwser(text);
				break;
		case 4: RankAnswer rank = new RankAnswer();
				rank.setAnswer(answer);
				record.addAnwser(rank);
				break;
		case 5: MapAnswer map = new MapAnswer();
				map.setAnswer(answer);
				record.addAnwser(map);
				break;
		}
	}
	
	public void saveAnswer(){
		recordName = io.readRecordInfo(page.getPageName());
		recordName.add(page.getPageName()+"-"+record.getPersonName());
		if(page.getType().equals("test")){
			this.grade();
		}
		io.writeReordInfo(page.getPageName(), recordName);
		io.writeRecord(page.getPageName()+"-"+record.getPersonName(), record);
	}
	
	public void grade(){
		Iterator<Question> questionIterator = page.iterator();
		Iterator<Answer> answerIterator = record.iterator();
		if(questionIterator.hasNext()){
			Question q = questionIterator.next();
			if(q.getType() != 3){
				if(q.match(answerIterator.next())){
					record.addScore(q.getScore());
				}
			}else{
				answerIterator.next();
			}
		}
	}
	
	public String getOutcome(int index, int type){  //统计调查结果
		this.loadPage(index, type);
		recordName = io.readRecordInfo(page.getPageName());
		List<Iterator<Answer>> recordList = new LinkedList<Iterator<Answer>>();
		for(int i=0; i<recordName.size(); i++){
			recordList.add(io.readRecord(recordName.get(i)).iterator());
		}
		Iterator<Question> questionIterator = page.iterator();
		List<String> outcome = new LinkedList<String>();
		while(questionIterator.hasNext()){
			Question question = questionIterator.next();
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int i=0; i<recordList.size(); i++){
				Answer answer = recordList.get(i).next();
				if(map.containsKey(answer.writeAnswer())){
					int value = map.get(answer.writeAnswer());
					map.put(answer.writeAnswer(), value+1);
				}else{
					map.put(answer.writeAnswer(), 1);
				}
			}
			String oneOutcome = question.getQuestion();
			for(String key: map.keySet()){
				oneOutcome +="Answer: " + key+"\t"+map.get(key)+"\n";
			}
			outcome.add(oneOutcome);
		}
		String ret = "";
		for(int i=0; i<outcome.size(); i++){
			ret += outcome.get(i)+"\n";
		}
		return ret;
	}
}
