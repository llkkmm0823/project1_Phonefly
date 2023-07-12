package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorkerDao {
	
	private WorkerDao() {}
	private static WorkerDao instance = new WorkerDao();
	public static WorkerDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
}
