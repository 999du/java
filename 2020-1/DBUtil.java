import java.sql.*;
public class DBUtil {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String jdbc="jdbc:mysql://localhost:3306/PIM?useSSL=false&serverTimezone=UTC";
    	Connection connection = null;
        //注册 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //打开链接
        connection = DriverManager.getConnection(jdbc,"root","123456");
		return connection;
	}
}
