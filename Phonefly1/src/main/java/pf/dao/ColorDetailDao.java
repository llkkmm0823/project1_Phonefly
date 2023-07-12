package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ColorDetailDao {
	private ColorDetailDao() {}
	private static ColorDetailDao instance = new ColorDetailDao();
	public static ColorDetailDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
