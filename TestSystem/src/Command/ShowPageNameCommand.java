package Command;

import java.util.List;

import Control.IO;
import Paper.PType;

public class ShowPageNameCommand extends InforCommand{
	IO io;
	PType type;
	String personName;
	public ShowPageNameCommand(IO io,PType type){
		this.io=io;
		this.type=type;
	}
	public ShowPageNameCommand(IO io,PType type,String personName){
		this.io=io;
		this.type=type;
		this.personName=personName;
	}
	public  List<String> returnInfor() {
		return io.readAllPage(type);
		
	}
	@Override
	public List<String>[] returnAnotherInfor() {
		// TODO Auto-generated method stub
		List<String>[] list=new List[2];
		list[0]=io.getAllPagebyPerNam(personName,type);
		list[1]=io.getAllRecordbyPerNam(personName, type);
		return list;
	}
	
}
