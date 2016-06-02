package Paper;

public enum PType {
	TEST("1") , SURVEY("2");
	private String indexs;
	private PType(String is){
		indexs=is;
	}
	public String getTypeIndex(){
		return indexs;
	}
}
