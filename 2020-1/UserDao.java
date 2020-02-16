import java.sql.*;
public class UserDao {
	private DBUtil dbutil=new DBUtil();
	public boolean finduser(String userName,String passWord) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt=null;
		String sql="select * from user where name= ? and password= ? ";
		pstmt=dbutil.getConnection().prepareStatement(sql);//预编译sql
		pstmt.setString(1, userName);
		pstmt.setString(2, passWord);
		ResultSet result=pstmt.executeQuery();
		if(false==result.next()) 
			return false;
		else 
			return true;
	}
}
