package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.QnaVO;
import pf.util.DBM;
import pf.util.Paging;

public class QnaDao {
	private QnaDao() {}
	private static QnaDao instance = new QnaDao();
	public static QnaDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getAllCount() {
		int count =0;
		String sql = "select count(*) as cnt from qna";
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

	public ArrayList<QnaVO> selectQna(Paging paging, String loggedInId) {
		ArrayList<QnaVO> list= new ArrayList<>();
		String sql = " select*from( "
				+ " select*from( "
				+ " select rownum as rn, q.*from ((select*from qna where id=? order by qseq desc) q) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = DBM.getConnection();
		try {
			// 전체 게시물 수 설정
			String countsql = "SELECT COUNT(*) AS count FROM qna WHERE id=?";
			pstmt = con.prepareStatement(countsql);
			pstmt.setString(1, loggedInId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int totalCount = rs.getInt("count");
	            paging.setTotalCount(totalCount);
			}
			
	        // 시작 번호와 종료 번호 계산
	        int startNum = paging.getStartNum();
	        int endNum = paging.getEndNum();

	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, loggedInId);
	        pstmt.setInt(2, startNum);
	        pstmt.setInt(3, endNum);
	        
	        rs = pstmt.executeQuery();
			while( rs.next() ) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
	}
		return list;
	}

	public QnaVO getQna(int qseq) {
		QnaVO qvo = new QnaVO();
		String sql = "select * from qna where qseq = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qvo.setQseq(qseq);
				qvo.setId(rs.getString("id"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				qvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);}
		return qvo;
	}

	public void insertQna(QnaVO qvo) {
		
		/* 수정 : bhs
		 * String sql = "insert into qna (qseq, subject, content, id, indate) " +
		 * " values(qna_seq.nextval , ? , ? , ? , ? )";
		 */
		String sql = "INSERT INTO qna (qseq, subject, content, id) VALUES (qseq.nextval , ? , ? , ?)";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getSubject());
		    pstmt.setString(2, qvo.getContent());
		    pstmt.setString(3, qvo.getId());
			/* 수정 : bhs
			pstmt.setTimestamp(4, qvo.getIndate()); */
		    pstmt.executeUpdate();  
		} catch (SQLException e) {e.printStackTrace();
		} finally {  DBM.close(con, pstmt, rs);  }
		
	}

	public void updateQna(QnaVO qvo) {		
		String sql = "UPDATE qna SET subject = ?, content = ? WHERE qseq = ?";
		   con = DBM.getConnection();
		   try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, qvo.getSubject());
		      pstmt.setString(2, qvo.getContent());
		      pstmt.setInt(3, qvo.getQseq());
		      pstmt.executeUpdate();
		   } catch (SQLException e) {
		      e.printStackTrace();
		   } finally {
		      DBM.close(con, pstmt, rs);
		   }
		
	}

	public void deleteQna(int qseq) {
		
		String sql = "delete from qna where qseq=?";
		con = DBM.getConnection();
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, qseq);
		      pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBM.close(con, pstmt, rs); }   	
				
	}

	public ArrayList<QnaVO> qnaList(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = " select * from ("
				+ " select * from ("
				+ " select rownum as rn, q.* from "
				+ "(( select * from qna where subject like '%'||?||'%'"
				+ " or content like '%'||?||'%'  order by qseq desc ) q)"
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
				QnaVO qvo = new QnaVO();
				qvo.setContent( rs.getString("content") );
				qvo.setId( rs.getString("id"));
				qvo.setIndate( rs.getTimestamp("indate"));
				qvo.setQseq( rs.getInt("qseq"));
				qvo.setRep( rs.getString("rep"));
				qvo.setReply( rs.getString("reply"));
				qvo.setSubject( rs.getString("subject"));
				list.add(qvo);
			}
		}catch (SQLException e) { e.printStackTrace(); 
		} finally { DBM.close(con, pstmt, rs);  }
		return list;
		}
	
	public int getAllCountQna(String key) {
		int count =0;
		String sql = "select count(*) as cnt from qna "  
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

	public void updateQnaAdmin(QnaVO qvo) {
		
		String sql = "update qna set reply=?, rep='2' where qseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getReply() );
			pstmt.setInt(2,  qvo.getQseq() );
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace(); 
		} finally { DBM.close(con, pstmt, rs);  }
		
	}	
	
}
