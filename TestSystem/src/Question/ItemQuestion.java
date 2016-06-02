package Question;

import java.util.LinkedList;
import java.util.List;
import Anwser.NumAnswer;
import Paper.Iterator;

public abstract class ItemQuestion extends Question{
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
	
	public int getItemSize(){
		return items.size();
	}
	
	public Iterator<String> iteratorItem(){  
		return new IteratorItem();
	}
	
	class IteratorItem implements Iterator<String>{
		int itemIndex=0;

		@Override
		public boolean hasNext() {
			if(items.size() > itemIndex)
				return true;
			return false;
		}

		@Override
		public String next() {
			return items.get(itemIndex++);
		}
	}
}
