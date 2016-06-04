package Paper;

public enum PType implements java.io.Serializable{
	TEST("test") , SURVEY("survey");
	private String indexs;
	private PType(String is){
		indexs=is;
	}
	public String getTypeIndex(){
		return indexs;
	}
}
