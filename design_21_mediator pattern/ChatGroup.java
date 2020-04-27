package design_21;

import java.util.Hashtable;
//具体的中介者
public class ChatGroup extends AbstractChatroom{

	private Hashtable members=new Hashtable();
	
	@Override
	public void register(Member member) {
		// TODO 自动生成的方法存根
		if(!members.contains(member)) {
			members.put(member.getName(),member);
			member.setChatroom(this);
		}
		
	}

	@Override
	public void sendText(String from, String to, String message) {
		// TODO 自动生成的方法存根
		Member member=(Member)members.get(to);
		String newMessage=message;
		newMessage=message.replaceAll("打", "*");
		member.receiveText(from,newMessage);
	}

	@Override
	public void sendImage(String from, String to, String image) {
		// TODO 自动生成的方法存根
		Member member=(Member)members.get(to);
		//模拟图片大小判断
		if(image.length()>5)
		{
			System.out.println("图片太大,发送不出去!");
		}
		else {
			member.receiveImage(from,image);
		}
		
	}

}
