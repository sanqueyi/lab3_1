package Question;

import java.util.LinkedList;
import java.util.List;
import Anwser.NumAnswer;

public class MapQuestion extends Question {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public String getQuestion(){
		String ret = "Map: "+prompt+"\n";
		for(int i=0; i<sidel.size(); i++){
			ret += i+1+")"+sidel.get(i)+"\t"+i+1+")"+sider.get(i)+"\n";
		}
		return ret;
	}
}
