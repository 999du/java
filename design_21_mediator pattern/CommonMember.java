package design_21;
//普通会员
public class CommonMember extends Member {
	public CommonMember(String name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void sendText(String to, String message) {
		// TODO 自动生成的方法存根
		System.out.println("普通会员发送信息:");
		chatroom.sendText(name,to,message);//调停者帮助发送信息
	}

	@Override
	public void sendImage(String to, String message) {
		// TODO 自动生成的方法存根
		System.out.println("普通会员不能发送图片!");
	}

}
