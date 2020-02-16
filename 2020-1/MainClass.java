import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		LoginForm loginform=new LoginForm();
		loginform.init();
		loginform.display();
		try {
			loginform.validate();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
