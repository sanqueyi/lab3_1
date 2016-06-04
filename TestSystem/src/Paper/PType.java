package Paper;

public enum PType {
	TEST("test") , SURVEY("survey");
	private String indexs;
	private PType(String is){
		indexs=is;
	}
	public String getTypeIndex(){
		return indexs;
	}
}
