package Command;
import Paper.*;
import Question.ItemQuestion;
public class ItemQuestionCommand implements QuestionCommand{
	private Page paper;
	private ItemQuestion question;
	private String prompt;
	private String[] items;
	private int score;
	private String answer="";
	public ItemQuestionCommand(Page paper){
		this.paper=paper;
	}
	public ItemQuestionCommand(Page paper,ItemQuestion question,String prompt, String[] items, String score, String answer){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.score=Integer.parseInt(score);
		this.answer=answer;
		this.items=new String[items.length];
		for(int i=0; i<items.length; i++){
			this.items[i]=items[i];
		}
	}
	public ItemQuestionCommand(Page paper,ItemQuestion question,String prompt, String[] items){
		this.paper=paper;
		this.question=question;
		this.prompt=prompt;
		this.items=new String[items.length];
		for(int i=0; i<items.length; i++){
			this.items[i]=items[i];
		}
	}
	public void modifyQuestion(){
		question.setPrompt(prompt);	
		question.setAnswer(answer);
		question.setScore(score);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
	}
	public void addQuestion(){
		modifyQuestion();
		paper.addQuestion(question);
	}
	
}
