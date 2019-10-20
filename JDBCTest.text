package test;
import java.sql.*;
public class JDBCTest {
	public static void main(String[] args) {
		//SQL Server
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PMS";
			Connection con = DriverManager.getConnection(url,"sa","123456");
			Statement state=con.createStatement();
			String s="SELECT DISTINCT NAME FROM Person";
			ResultSet rs=state.executeQuery(s);
			while(rs.next()) {
			System.out.println(rs.getString("NAME"));
			}
			con.close();
			state.close();
		}
		catch(Exception e) {
			System.out.println("数据库连接失败\n" + e.toString());
		}
		//MySQL
	     try{
	    	 String s1="jdbc:mysql://localhost:3306/PIM?useSSL=false&serverTimezone=UTC";
	    	 Connection conn = null;
	    	 Statement stmt = null;
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(s1,"root","123456");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT DISTINCT NAME FROM Person";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
    			System.out.println(rs.getString("NAME"));
    			}
    			conn.close();
    			stmt.close();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }
	}
}
