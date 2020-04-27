package design_21;
//基类
//抽象的中介者
public abstract class AbstractChatroom {
	//定义自发行为和依赖行为
	public abstract void register(Member member);//注册
	public abstract void sendText(String from,//发送文本
			String to,String message);
	public abstract void sendImage(String from,//发送图片
			String to,String Image);
}
