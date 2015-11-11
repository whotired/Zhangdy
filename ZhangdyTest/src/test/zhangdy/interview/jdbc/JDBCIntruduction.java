package test.zhangdy.interview.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCIntruduction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JDBCIntruduction().connectToAndQueryDatabase("USCATT","TEST123P");
	}

	public void connectToAndQueryDatabase(String username, String password) {
		
	    try {
	    	Connection con = DriverManager.getConnection(
			                     "jdbc:db2://mvsy.mul.ie.ibm.com:446/SPCDB2T:retrieveMessagesFromServerOnGetMessage=true;",//"jdbc:myDriver:myDatabase",
			                     username,
			                     password);
			Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM CATSWO");
		    System.out.println("ISWOID	TSWOTIT");
		    while (rs.next()) {
//		        int x = rs.getInt("a");
//		        String s = rs.getString("b");
//		        float f = rs.getFloat("c");
		    	System.out.println(rs.getString("ISWOID") + "	"+rs.getString("TSWOTIT"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	    
	}
}
