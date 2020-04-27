package design_19;

public class TerminalExpression implements Expression {

	private String data;
	
	public TerminalExpression(String data) {
		this.data=data;
	}
	@Override
	public boolean interpret(String context) {
		// TODO 自动生成的方法存根
		if(context.contains(data))
			return true;
		return false;
	}

}
