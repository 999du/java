package design_19;
//解释器模式
public class Client {
	
	public static void main(String[] args) {
		Expression isMale=getMaleExpression();
		Expression isMarriedWoman=getMarriedWomanExpression();
		System.out.println("John is male?"+
				isMale.interpret("John"));
		System.out.println("Julie is a marreid woman?"+
				isMarriedWoman.interpret("Married Julie"));	
	}
	//规则:Robert和John是男性
	public static Expression getMaleExpression() {
		Expression robert=new TerminalExpression("Robert");
		Expression john=new TerminalExpression("John");
		return new OrExpression(robert,john);
	}
	
	//规则:Julie是一个已婚女性
		public static Expression getMarriedWomanExpression() {
			Expression julie=new TerminalExpression("Julie");
			Expression married=new TerminalExpression("Married Julie");
			return new AndExpression(julie,married);
		}
}
