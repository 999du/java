package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] a1rgs) throws UnknownHostException, IOException {
		//向服务器发送请求
		Socket socket=new Socket("127.0.0.1",888);
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.注册\n");
		System.out.println("2.登录\n");
		System.out.println("3.测试\n");
		System.out.println("4.注销\n");
		System.out.println("请选择：\n");
		int select=0;
		select=scanner.nextInt();
		switch(select){
		case 1:writer.println("<register name=“xu”/>");break;
		case 2:writer.println("<login name=“xu”/>");break;
		case 3:writer.println("<message from=“xu” to=“zhang” message=“this is a test”/>");break;
		case 4:writer.println("<logout name=“xu”/>");break;
		default:break;
		}
		writer.flush();
		//处理服务器发送的回应
		InputStreamReader reader=new InputStreamReader(socket.getInputStream());//对输入流进行解码
		BufferedReader buffer_reader=new BufferedReader(reader);//从解码后的字符流中高效读取字符，数组等
		System.out.println("The server say:"+buffer_reader.readLine());
		//setclose
		socket.close();
		//reader.close();
		buffer_reader.close();
		writer.close();
	}
}
