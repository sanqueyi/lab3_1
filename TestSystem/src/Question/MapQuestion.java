package Question;

import java.util.LinkedList;
import java.util.List;
import Anwser.NumAnswer;
import Paper.Iterator;

public class MapQuestion extends Question {
	
	List<String> sidel = new LinkedList<String>();
	List<String> sider = new LinkedList<String>();
	
	public MapQuestion() {
		super(QType.MAP);
	}

	@Override
	public void setAnswer(String ans) {
		answer=new NumAnswer(ans);
		
	}
	
	public void setLeftItem(String item){
		sidel.add(item);
	}
	
	public void setRightItem(String item){
		sider.add(item);
	}
	
	public List<String> getLeftItems() {
		return sidel;
	}
	
	public List<String> getRightItems() {
		return sider;
	}
	
	public boolean removeLeftItem(int index) {
		if(sidel.size() > index){
			sidel.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean removeRightItem(int index) {
		if(sider.size() > index){
			sider.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean changeLeftItem(int index, String item) {
		if(sidel.size() > index){
			sidel.remove(index);
			sidel.add(index, item);
			return true;
		}
		return false;
	}
	
	public boolean changeRightItem(int index, String item) {
		if(sider.size() > index){
			sider.remove(index);
			sider.add(index, item);
			return true;
		}
		return false;
	}
	
	public int getLeftSize(){
		return sidel.size();
	}
	
	public int getRightSize(){
		return sider.size();
	}
	
	public Iterator<String> iteratorLeftItem(){  
		return new IteratorItem(sidel);
	}
	
	public Iterator<String> iteratorRightItem(){  
		return new IteratorItem(sider);
	}
	
	class IteratorItem implements Iterator<String>{
		int itemIndex=0;
		List<String> items=null;
		IteratorItem(List<String> side){
			items=side;
		}
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
