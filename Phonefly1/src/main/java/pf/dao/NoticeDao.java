package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.NoticeVO;
import pf.util.DBM;
import pf.util.Paging;

public class NoticeDao {
	private NoticeDao() {}
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getAllCount() {
		int count =0;
		String sql = "select count(*) as cnt from notice";
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

	public ArrayList<NoticeVO> selectNotice(Paging paging, String key) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		
		String sql = " select * from ("
				+ " select * from ("
				+ " select rownum as rn, n.* from "
				+ "(( select * from notice where subject like '%'||?||'%'"
				+ " or content like '%'||?||'%'  order by nseq desc ) n)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  key);
			pstmt.setString(2,  key);
			pstmt.setInt(3, paging.getStartNum() );
			pstmt.setInt(4, paging.getEndNum() );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeVO nvo = new NoticeVO();
				// 추가 : bhs => nvo.setNseq(rs.getInt("nseq"));
				nvo.setNseq(rs.getInt("nseq"));
				nvo.setContent( rs.getString("content") );
				nvo.setId( rs.getString("id"));
				nvo.setIndate( rs.getTimestamp("indate"));
				nvo.setSubject( rs.getString("subject"));
				list.add(nvo);
			}
		}catch (SQLException e) { e.printStackTrace(); 
		} finally { DBM.close(con, pstmt, rs);  }
		return list;
	}

	public NoticeVO getNotice(int nseq) {
		NoticeVO nvo = null;
		String sql = "select * from notice where nseq = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				nvo = new NoticeVO();
				nvo.setNseq(nseq);
				nvo.setSubject(rs.getString("subject"));
				nvo.setContent(rs.getString("content"));
				nvo.setId(rs.getString("id"));
				nvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
	}
		return nvo;
		
	}

	public int getAllCountNotice(String key) {
		int count =0;
		String sql = "select count(*) as cnt from notice "  
				+ " where subject like '%'||?||'%' or content like '%'||?||'%' ";
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

	public ArrayList<NoticeVO> selectNotice(Paging paging) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, n.* from ((select * from notice order by nseq desc) n) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  paging.getStartNum() );
			pstmt.setInt(2,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nvo = new NoticeVO();
		    	nvo.setNseq(rs.getInt("nseq"));
		    	nvo.setSubject(rs.getString("subject"));
		    	nvo.setContent(rs.getString("content"));
		    	nvo.setId(rs.getString("id"));
		    	nvo.setIndate(rs.getTimestamp("indate"));
		    	list.add(nvo);
		    }
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);  }
		return list;
}

	public void insertNotice(NoticeVO nvo) {
		// 수정 : bhs
		//String sql = "insert into notice (nseq, subject, content, id, indate) "
				//+ " values(notice_seq.nextval , ? , ? , ? , ? )";
		String sql = "INSERT INTO notice (nseq, subject, content, id) VALUES (nseq.nextVal , ? , ? , ?)";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getSubject());
		    pstmt.setString(2, nvo.getContent());
		    pstmt.setString(3, nvo.getId());
		    // 수정 : bhs
		    //pstmt.setTimestamp(4, nvo.getIndate());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  DBM.close(con, pstmt, rs);  }
	}

	public void updateNotice(NoticeVO nvo) {
		// 수정 : bhs
		//String sql ="update set subject=?,content=?,id=? from notice where nseq=?";
		String sql ="UPDATE notice SET subject = ?, content = ?, id= ? WHERE nseq = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getSubject());
		    pstmt.setString(2, nvo.getContent());
		    pstmt.setString(3, nvo.getId());
		    pstmt.setInt(4, nvo.getNseq());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  DBM.close(con, pstmt, rs);  }
	}

	public void deleteNotice(int nseq) {
		String sql = "delete from notice where nseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nseq);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		
	}

}
