package Question;

public class RankQuestion extends ItemQuestion {

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
