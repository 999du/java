package design_21;
//中介者模式
//AbstractChatroom设置一些调停规则,而A,B,C成员在这些这些规则下进行成员之间的交流
//Member定义自己的交流方式,在这些方式中使用/遵循AbstractChatroom的规则
//Member发送给中介者,由中介者发送给目标,Member从中介者接收消息
//在[发送member].sendText()中调用chatroom.sendText(),再在chatroom.sendText()中调用[目标member].receiveText();
//ChatGroup中的sendText()应命名为directMember();sendText()在本例中使用有点困惑,
/*
 * [发送member].sendText()
 * {
 *	 	chatroom.directMember()
 *		{
 * 			[目标member].receiveText();
 * 		}
 * }
 */
public class Client {
	public static void main(String[] args) {
		AbstractChatroom happyChat=new ChatGroup();
		Member member1,member2,member3,member4,member5;
		member1=new DiamondMember("张三");
		member2=new DiamondMember("李四");
		member3=new CommonMember("王五");
		member4=new CommonMember("小芳");
		member5=new CommonMember("小红");
		
		happyChat.register(member1);
		happyChat.register(member2);
		happyChat.register(member3);
		happyChat.register(member4);
		happyChat.register(member5);
		
		member1.sendText("李四","李四,你好!");//本条语句中的from为member1.name--拿取hashtable中的元素,to 为"李四",message为"李四,你好!"
																			//这些参数满足了member1的sendText()中的chatroom.sendText();
		member2.sendText("张三", "张三,你好!");
		member1.sendText("李四","今天天气不错,可以出去郊游了!");
		member2.sendImage("张三", "一个很大很大的太阳!");
		member2.sendImage("张三", "太阳");
		member3.sendText("小芳","还有问题吗?");
		member3.sendText("小红","还有问题吗?");
		member4.sendText("王五","没有问题了,谢谢!" );
		member5.sendText("王五","我也没有了!" );
		member5.sendImage("王五", "谢谢!");
	}
}
