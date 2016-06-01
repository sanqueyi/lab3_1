package Question;

import java.util.LinkedList;
import java.util.List;

import Anwser.Answer;
import Anwser.ChoiceAnswer;

public class ChoiceQuestion extends ItemQuestion {
	List<String> items = new LinkedList<String>();//所有的选项
	ChoiceAnswer answer;
	
	public ChoiceQuestion(){
		super(1);
	}
	
	@Override
	public void setItem(String item) {//添加选项
		this.items.add(item);
	}

	@Override
	public void setAnswer(String answer) {//设置正确答案
		this.answer = new ChoiceAnswer();
		this.answer.setItem(items);
		this.answer.setAnswer(answer);
	}

	@Override
	public Answer getAnswer() {//得到正确答案
		return answer;
	}

	public boolean match(String answer) {//判断答案是否相同（正确）
		// TODO Auto-generated method stub
		return this.answer.equals(answer);
	}
	
	@Override
	public String getQuestion(){ //得到题目字符串（包括题目和选项）
		String ret = "ChoiceQuestion: "+prompt+"\n";
		for(int i=0; i<items.size(); i++){
			ret += items.get(i)+"\n";
		}
		return ret;
	}

	@Override
	public List<String> getItem() {
		return items;
	}

	@Override
	public boolean remove(int index) {
		if(items.size() > index){
			items.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public boolean changeItem(int index, String item) {
		if(items.size() > index){
			items.remove(index);
			items.add(index, item);
			return true;
		}
		return false;
	}

	@Override
	public boolean changeItemNumber(int num) { //把num下标后面的选项都去掉？隔一个去掉？
		if(items.size() > num){
			for(int i=num; i<items.size(); i++){
				items.remove(i);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean match(Answer answer) {
		return this.answer.match(answer);
	}

}
