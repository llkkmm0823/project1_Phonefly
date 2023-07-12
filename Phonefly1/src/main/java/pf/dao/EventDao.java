package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.EventVO;
import pf.util.DBM;
import pf.util.Paging;

public class EventDao {
	private EventDao() {}
	private static EventDao instance = new EventDao();
	public static EventDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int getAllCount() {
		int count =0;
		String sql = "select count(*) as cnt from event";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() ) count=rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
	}
		return count;
	}


	public ArrayList<EventVO> selectEvent(Paging paging, String key) {
		ArrayList<EventVO> list = new ArrayList<EventVO>();
		
		String sql = " select * from ("
				+ " select * from ("
				+ " select rownum as rn, e.* from "
				+ "(( select * from event where subject like '%'||?||'%' "
				+ " order by eseq desc ) e)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setInt(2, paging.getStartNum() );
			pstmt.setInt(3, paging.getEndNum() );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EventVO evo = new EventVO();
				// eseq 추가 : bhs
				evo.setEseq(rs.getInt("eseq"));
				evo.setImage( rs.getString("image") );
				evo.setId( rs.getString("id"));
				evo.setIndate( rs.getTimestamp("indate"));
				evo.setSubject( rs.getString("subject"));
				list.add(evo);
			}
		}catch (SQLException e) { e.printStackTrace(); 
		} finally { DBM.close(con, pstmt, rs);  }
		return list;
	}
	
	public EventVO getEvent(int eseq) {
		EventVO evo = new EventVO();
		String sql = " select*from event where eseq = ? ";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				evo.setEseq(eseq);
				evo.setSubject(rs.getString("subject"));
				evo.setImage(rs.getString("image"));
				evo.setId(rs.getString("id"));
				evo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
	}
		return evo;
	}


	public int getAllCountEvent(String key) {
		int count =0;
		String sql = "select count(*) as cnt from Event "  
				+ " where subject like '%'||?||'%' or image like '%'||?||'%' ";
		con =DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setString(2,  key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {DBM.close(con, pstmt, rs); }
		return count;
	}

	

	public void insertEvent(EventVO evo) {
		// 수정 : bhs
		//String sql = "insert into event (eseq, subject, image, id, indate) "
				//+ " values(Event_seq.nextval , ? , ? , ? , ? )";
		String sql = "INSERT INTO event (eseq, subject, image, id) VALUES (eseq.nextval , ? , ? , ?)";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, evo.getSubject());
		    pstmt.setString(2, evo.getImage());
		    pstmt.setString(3, evo.getId());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  DBM.close(con, pstmt, rs);  }
	}

	public void updateEvent(EventVO evo) {
		// 수정 : bhs
		//String sql ="update set subject=?,image=?,id=? from event where eseq=?";
		String sql ="UPDATE event SET subject = ?, image = ? WHERE eseq = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, evo.getSubject());
		    pstmt.setString(2, evo.getImage());
		    // 수정 : bhs
		    //pstmt.setString(3, evo.getId());
		    //pstmt.setInt(4, evo.getEseq());
		    pstmt.setInt(3, evo.getEseq());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  DBM.close(con, pstmt, rs);  }
	}

	public void deleteEvent(int eseq) {
		String sql = "delete from event where eseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eseq);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}

	}


	public ArrayList<EventVO> selectNotice(Paging paging) {
		ArrayList<EventVO> list= new ArrayList<EventVO>();
		String sql = " select*from( "
				+ " select*from( "
				+ " select rownum as rn, e.*from ((select*from event order by eseq desc) e) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2,paging. getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				EventVO evo = new EventVO();
				evo.setEseq(rs.getInt("eseq"));
				evo.setSubject(rs.getString("subject"));
				evo.setImage(rs.getString("Image"));
				evo.setId(rs.getString("id"));
				evo.setIndate(rs.getTimestamp("indate"));
				list.add(evo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
	}
		return list;
	}
}
