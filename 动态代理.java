public interface PurchaseTicket{
	public void person(String message);
}


public class Machine implements PurchaseTicket{
	String id=" the Machine";
	public void person(String Message) {
		System.out.println(Message+":"+id);
	}
}


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler{
	private Object proxied;
	public MyProxy(Object proxied) {
		this.proxied=proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO 自动生成的方法存根
		Object result=method.invoke(this.proxied,args);
		return result;
	}	
}



import java.lang.reflect.Proxy;

public class TEST {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Machine machine=new Machine();
		PurchaseTicket purchase=(PurchaseTicket)Proxy.newProxyInstance(PurchaseTicket.class.getClassLoader(), new Class[] {PurchaseTicket.class}, new MyProxy(machine));
		purchase.person("Who dose sells the ticket?");
	}

}