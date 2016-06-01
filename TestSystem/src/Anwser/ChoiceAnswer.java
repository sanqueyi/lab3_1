package Anwser;

import java.util.List;

public class ChoiceAnswer implements Answer{
	
	int[] anwser;  //数组的每一项记录着正确答案的下标
	List<String> item;  //所有的选项
	
	@Override
	public String getAnswer() { //得到选择题的答案
		// TODO Auto-generated method stub
		String ret = "";
		for(int i=0; i<anwser.length; i++){
			ret += item.get(anwser[i]);
		}
		return ret;
	}
	
	@Override
	public String writeAnswer(){ //将答案下标合并成一个string
		String ret = "";
		for(int i=0; i<anwser.length; i++){
			ret += anwser[i] + " ";
		}
		return ret;
	}
	
	@Override
	public void setAnswer(String anwser) {  //设置正确答案，输入的是正确答案的下标
		// TODO Auto-generated method stub
		String[] anwsers = anwser.split(" ");
		this.anwser = new int[anwsers.length];
		for(int i=0; i<anwser.length(); i++){
			this.anwser[i] = Integer.parseInt(anwsers[i]);
		}
	}
	
	public void setItem(List<String> item){
		this.item = item;
	}

	@Override
	public int getType() {
		return 1;
	}

	@Override
	public boolean match(Answer answer) {
		return answer.writeAnswer().equals(this.writeAnswer());
	}
	
	
}
