package first;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class SocketHandler implements Runnable {
	private Socket socket;
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			//处理客户端的请求
			InputStreamReader reader=new InputStreamReader(socket.getInputStream());
			BufferedReader buffer_reader=new BufferedReader(reader);
			//回应客户端的请求
			Scanner scanner=new Scanner(System.in);
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			String message=buffer_reader.readLine();
			System.out.println(message);
			System.out.println("The client say:"+message);
			if(message.equals("<register name=“xu”/>"))
			{
				System.out.println("客户端请求注册，Yes(y) or No(n)");
				String select=scanner.nextLine();
				if(select.equals("y"))writer.println("<result command=“register” state=“ok”/>");
				else if(select.equals("n")) writer.println("<result command=“register” state=“error” message=“”/>");
				else System.out.println("输入错误!!");
			}
			else if(message.equals("<login name=“xu”/>")) {
				System.out.println("客户端请求登录，Yes(y) or No(n)");
				String select=scanner.nextLine();
				if(select.equals("y"))writer.println("<result command=“login” state=“ok”/>");
				else if(select.equals("n"))writer.println("<result command=“login” state=“error” message=“”/>");
				else System.out.println("输入错误!!");
			}
			else if(message.equals("<message from=“xu” to=“zhang” message=“this is a test”/>")) {
				writer.println("<result command=“message” state=“ok”/>");
			}
			else if(message.equals("<logout name=“xu”/>")){
				System.out.println("客户端请求注销，Yes(y) or No(n)");
				String select=scanner.nextLine();
				if(select.equals("y"))writer.println("<result command=“logout” state=“ok”/>");
				else if(select.equals("n"))writer.println("<result command=“logout” state=“error” message=“”/>");
				else System.out.println("输入错误!!");
			}
			else {
				writer.println("无效指令!!");
				System.out.println("123123213");
			}
			writer.flush();
			//setclose
			socket.close();
			//reader.close();
			buffer_reader.close();
			//scanner.close();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}