package Question;

public class RankQuestion extends ItemQuestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RankQuestion() {
		super(QType.RANK);
	}
	public String getQuestion(){
		String ret = "Rank: "+prompt + "\n";
		for(int i=0; i<items.size(); i++){
			ret += items.get(i)+"\n";
		}
		return ret;
	}
}
