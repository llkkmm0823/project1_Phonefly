package pf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBM {

	static String driver = "oracle.jdbc.driver.OracleDriver";
	//static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String url = "jdbc:oracle:thin:@192.168.0.91:1521:xe";
	static String id = "phonefly";
	static String pw = "1234";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {	e.printStackTrace();
		} catch (SQLException e) {	e.printStackTrace();	}
		return con;
	}
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if( con!=null) con.close();
			if( pstmt!=null) pstmt.close();
			if( rs!=null) rs.close();
		} catch (SQLException e) {  e.printStackTrace();  }
	}
}
