package db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class db_connect {
	
java.sql.Connection con=null;
	
	public java.sql.Connection getconnect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/selenium?createDatabaseIfNotExist=true"; 
		    con = DriverManager.getConnection(url,"root",""); 
		    createTable();
			System.out.print("Database is connected !");
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
		}
		return con;
		
	}
	
	public void write_db(String operation_name,String result,String date) throws SQLException {
		PreparedStatement st = (PreparedStatement) con.prepareStatement("INSERT INTO `results`(`id`, `operation_name`, `result`, `date`) VALUES (null,'"+operation_name+"','"+result+"','"+date+"');");
	    st.executeUpdate();
	}
	
	private void createTable() throws SQLException {
	    String sqlCreate = "CREATE TABLE IF NOT EXISTS results"
	            + "  (id   			  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
	            + "   operation_name  VARCHAR(500),"
	            + "   result          VARCHAR(500),"
	            + "   date            VARCHAR(500))";

	    Statement stmt = (Statement) con.createStatement();
	    stmt.execute(sqlCreate);
	}
}
