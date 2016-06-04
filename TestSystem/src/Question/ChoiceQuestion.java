package Question;

public class ChoiceQuestion extends ItemQuestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
