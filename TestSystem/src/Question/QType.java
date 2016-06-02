package Question;

public enum QType {
	DECIDE("0") , CHOICE("1") , SHORTESSAY("2") , ESSAY("3") , RANK("4") , MAP("5");
	
	private String indexs;
	private QType(String is){
		indexs=is;
	}
	
	public String getTypeIndex(){
		return indexs;
	}
}
