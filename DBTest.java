package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
	public static void main(String[] args) throws Exception{
		System.out.println(ConPool.getIntance().toString());
		MyCon con = null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pim?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "123456";
		Class.forName(driverName);
		long time1= System.currentTimeMillis();
		for(int i = 0; i<5000; i++){
			con = ConPool.getIntance().getCon();
			ConPool.getIntance().setFree(con);
		}
		long time2= System.currentTimeMillis();
		System.out.println("程序运行时间：" + (time2 - time1) + "ms"); //输出程序运行时间
		System.out.println(ConPool.getIntance().toString());
		for(int i=0;i<50;i++) {
			Connection con1 = DriverManager.getConnection(url, userName, password);
			con1.close();
		}
		long time3= System.currentTimeMillis();
		System.out.println("程序运行时间：" + (time3 - time2) + "ms"); //输出程序运行时间
	}	
}
