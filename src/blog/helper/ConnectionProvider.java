package blog.helper;
import java.sql.*;

public class ConnectionProvider {

	private static Connection con;
	
	public static Connection getConnection() 
	{
		try {
			
//			if(con == null)
//			{
				Class.forName("com.mysql.cj.jdbc.Driver");				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_servlet_basic","root1","Root@132");				
//			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
}
