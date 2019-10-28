package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDAO {
	public static Connection getConnection()  throws Exception{
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pim?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "123456";
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}
