package design_19;

public class OrExpression implements Expression {

	//双目运算,所以有两个Expression
	private Expression expr1=null;
	private Expression expr2=null;
	
	public OrExpression(Expression expr1,Expression expr2) {
		this.expr1=expr1;
		this.expr2=expr2;
	}
	@Override
	public boolean interpret(String context) {
		// TODO 自动生成的方法存根
		//或运算,可根据自己的需求进行定义
		return expr1.interpret(context)||expr2.interpret(context);
	}

}
