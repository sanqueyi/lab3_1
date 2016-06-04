package Paper;

import java.util.LinkedList;
import java.util.List;

import Question.Question;

public abstract class Page {  //一张试卷或问卷
	
	protected String perName;
	protected String pageName;
	protected String personName;
	protected PType type;
	protected int time;
	protected List<Question> questionList = new LinkedList<Question>();  //page中的所有问题
	
	public Page(){
	}
	
	public void setPageName(String pn){
		pageName = pn;
	}
	
	public String getPageName(){
		return pageName;
	}
	
	public String getPersonName(){
		return perName;
	}
	
	public void setPersonName(String pn){
		perName=pn;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int tm){
		time=tm;
	}
	
	public String getTypeIndex(){  //只有io要用到
		return type.getTypeIndex();
	}
	
	public PType getType(){  //提供方法给其他模块的
		return type;
	}
	
	public void setType(PType type){
		this.type = type;
	}
	
	public void addQuestion(Question question){
		questionList.add(question);
	}
	
	public Question getQuestion(int index){  //得到具体某个下标的问题
		if(index >= questionList.size()){
			return null;
		}else{
			return questionList.get(index);
		}
	}
	
	public int getQuestionSize(){
		return questionList.size();
	}
	
	public Iterator<Question> iteratorQuestion(){  
		return new IteratorQuestion();
	}
	
	class IteratorQuestion implements Iterator<Question>{
		int questionIndex=0;

		@Override
		public boolean hasNext() {
			if(questionList.size() > questionIndex)
				return true;
			return false;
		}

		@Override
		public Question next() {
			return questionList.get(questionIndex++);
		}
	}
}
