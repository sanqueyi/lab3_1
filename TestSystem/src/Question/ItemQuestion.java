package Question;

import java.util.List;

public abstract class ItemQuestion extends Question{

	public ItemQuestion(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void setItem(String item); //设置选项
	public abstract List<String> getItem(); //得到所有的选项
	public abstract boolean remove(int index); 
	public abstract boolean changeItem(int index, String item);
	public abstract boolean changeItemNumber(int num);
}
