package Command;

import Control.IO;
import Paper.Page;

public  class SavePageCommand implements ExecuteCommand{
	private IO io;
	private Page page;
	private int time;
	public SavePageCommand(IO io,Page page,String time){
		this.io=io;
		this.page=page;
		this.time=Integer.parseInt(time);
	}
	public SavePageCommand(IO io,Page page){
		this.io=io;
		this.page=page;
	}
	public void execute(){
		page.setTime(time);
		io.writePage(page);
	}

}
