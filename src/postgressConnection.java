import java.sql.*;
import java.util.Properties;

import javax.script.*;
import javax.swing.JOptionPane;


public class postgressConnection {
	Connection conn = null;
	public static Connection dbconnector(String username, String password, String database)
	{
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/"+database;
			Properties props = new Properties();
			props.setProperty("user",username);
			props.setProperty("password",password);
			props.setProperty("ssl","false");
			Connection conn = DriverManager.getConnection(url, props);
			JOptionPane.showMessageDialog(null, "connection successfull");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
