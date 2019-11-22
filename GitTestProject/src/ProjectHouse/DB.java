package ProjectHouse;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DB {
	
	public static Connection oraConn() {
		Connection conn=null;
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\mr2-2\\git\\GitTestProject\\GitTestProject\\git\\oracle.prop");
			Properties prop=new Properties();
			prop.load(fis);
			String url=prop.getProperty("url");
			String id=prop.getProperty("id");
			String password=prop.getProperty("password");
			conn=DriverManager.getConnection(url,id,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
