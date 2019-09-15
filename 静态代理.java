public interface PurchaseTicket{
	public void person(String message);
}

public class Machine implements PurchaseTicket{
	String id=" the Machine";
	public void person(String Message) {
		System.out.println(Message+":"+id);
	}
}

public class XiaoHong implements PurchaseTicket{
	private Machine machine;
	public XiaoHong(Machine machine){
		this.machine=machine;
	}
	@Override
	public void person(String message) {
		// TODO 自动生成的方法存根
		this.machine.person(message);
	}
}

//静态代理
//小明找小红帮忙买票
public class XiaoMing{
	public static void main(String[] args ) {
		Machine machine=new Machine();
		XiaoHong xiaohong=new XiaoHong(machine);
		xiaohong.person("Who dose sells the tickets?");
	} 
}