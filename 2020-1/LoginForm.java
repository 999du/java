import java.sql.SQLException;
import java.util.Scanner;

public class LoginForm {
	private UserDao user=new UserDao();
	public void init(){
		System.out.println("初始化................");
	}
	public void display() {
		System.out.println("=============================用户登录=================================");
	}
	public void validate() throws ClassNotFoundException, SQLException {
		String userName;
		String passWord;
		Scanner INPUT=new Scanner(System.in);
		System.out.print("用户名:");
		userName=INPUT.nextLine();
		System.out.print("密码:");
		passWord=INPUT.nextLine();
		boolean IS_or_NOT =user.finduser(userName, passWord);
		if(false==IS_or_NOT)System.out.println("用户不存在或密码错误!");
		else System.out.println("用户登陆成功!");
	}
}
