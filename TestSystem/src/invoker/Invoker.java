package invoker;

import Command.ExecuteCommand;
import Command.InforCommand;
import Command.QuestionCommand;

public class Invoker {	
	private QuestionCommand qcommand;
	private InforCommand icommand;
	private ExecuteCommand ecommand;
	public Invoker(){
		
	}
	public void setQestionCommand(QuestionCommand qcommand){
		this.qcommand=qcommand;
	}
	public void setInforCommand(InforCommand icommand){
		this.icommand=icommand;
	}
	public void setExecuteCommand(ExecuteCommand ecommand){
		this.ecommand=ecommand;
		
	}
	public void addQuestion(){
		qcommand.addQuestion();
	}
	public void modifyQustion(){
		qcommand.modifyQuestion();
	}
	public void execute(){
		ecommand.execute();
	}
	public Object getFirstInfor(){
		return icommand.returnInfor();
	}
	public Object getSecondInfor(){
		return icommand.returnAnotherInfor();
	}
	public Object getThirdInfor(){
		return icommand.returnThirdInfor();
	}
	public Object getFouthInfor(){
		return icommand.returnFouthInfor();
	}
	public Object getFifthInfor(){
		return icommand.returnFifthInfor();
	}
	public Object getsixthInfor(){
		return icommand.returnsixthInfor();
	}
}
