package Question;

import java.util.LinkedList;
import java.util.List;
import Anwser.NumAnswer;

public abstract class ItemQuestion extends Question{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> items = new LinkedList<String>();//所有的项
	
	public ItemQuestion(QType type) {
		super(type);
	}

	public void setItem(String item){
		items.add(item);
	}
	
	public boolean removeItem(int index) {
		if(items.size() > index){
			items.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean changeItem(int index, String item) {
		if(items.size() > index){
			items.remove(index);
			items.add(index, item);
			return true;
		}
		return false;
	}

	@Override
	public void setAnswer(String ans) {
		answer=new NumAnswer(ans);
		
	}
	
	public List<String> getItems(){
		return items;
	}
}
