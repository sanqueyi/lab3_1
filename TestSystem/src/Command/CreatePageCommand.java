package Command;

import java.util.List;

import Control.IO;
import Paper.Page;

public class CreatePageCommand extends InforCommand{
	Page page;
	String pageName;
	String perName;
	IO io;
	public CreatePageCommand(IO io,Page page,String pageName,String perName){
		this.page=page;
		this.pageName=pageName;
		this.perName=perName;
	}
	@Override
	public Boolean returnInfor() {
		// TODO Auto-generated method stub
		List<String> paperNames=io.readAllPage(page.getType());
		int size=paperNames.size();
		for(int i=0;i<size;i++){
			if(paperNames.get(i).equals(pageName))
				return false;
		}
		page.setPageName(pageName);
		page.setPersonName(perName);
		return true;
	}
	
}
