package Question;

public class ChoiceQuestion extends ItemQuestion {

	public ChoiceQuestion() {
		super(QType.CHOICE);
	}
	public String getQuestion(){
		String ret = "ChoiceQuestion: "+prompt+"\n";
		for(int i=0; i<items.size(); i++){
			ret += items.get(i)+"\n";
		}
		return ret;
	}
}
