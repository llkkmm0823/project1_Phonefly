package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.OrderDetailVO;
import pf.util.DBM;
import pf.util.Paging;

public class OrderDetailDao {
	private OrderDetailDao() {}
	private static OrderDetailDao instance = new OrderDetailDao();
	public static OrderDetailDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertOrder(int pseq, int rseq, String id, int mseq, int charge, int discount, 
			int buyplan, int dcmonth, int dctotal, int mmonth, int mtotal, String cc, int cseq) {
		con = DBM.getConnection();
		String sql = "insert into order_detail(odseq, pseq, rseq, id, mseq, charge, discount,"
				+ " buyplan, dcmonth, dctotal, mmonth, mtotal, cc, cseq) "
				+ " values(odseq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  pseq);
			pstmt.setInt(2,  rseq);
			pstmt.setString(3,  id);
			pstmt.setInt(4,  mseq);
			pstmt.setInt(5,  charge);
			pstmt.setInt(6,  discount);
			pstmt.setInt(7,  buyplan);
			pstmt.setInt(8,  dcmonth);
			pstmt.setInt(9,  dctotal);
			pstmt.setInt(10,  mmonth);
			pstmt.setInt(11,  mtotal);
			pstmt.setString(12,  cc);
			pstmt.setInt(13,  cseq);
			pstmt.executeUpdate();		
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);		}		
	}

	public ArrayList<OrderDetailVO> listOrderByOdseq(Paging paging, String id) {
		ArrayList<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		// 수정 : bhs
		//String sql = "select * from order_detail where id=?";
		//String sql = "SELECT * FROM order_detail_view2 WHERE id = ? ORDER BY odseq DESC";
		/* 수정 : bhs
		String sql="select * from ( "
				+ " select * from ( "
				+ " select rownum as rn,o.*from "
				+ " ((select*from order_detail_view2 where id like'%'||?||'%'order by odseq desc) o)"
				+ " ) where rn>=? "
				+ " ) where rn<=?";*/
		String sql="SELECT * FROM (SELECT * FROM (SELECT ROWNUM rn, O.* FROM (SELECT * FROM order_detail_view2 WHERE id = ? ORDER BY odseq DESC) O) WHERE rn >= ?) WHERE rn <= ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDetailVO ovo = new OrderDetailVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setRseq(rs.getInt("rseq"));
				ovo.setId(rs.getString("id"));
				ovo.setResult(rs.getString("result"));
				ovo.setDiscount(rs.getInt("discount"));
				ovo.setBuyplan(rs.getInt("buyplan"));
				ovo.setDcmonth(rs.getInt("dcmonth"));
				ovo.setDctotal(rs.getInt("dctotal"));
				ovo.setMmonth(rs.getInt("mmonth"));
				ovo.setMtotal(rs.getInt("mtotal"));
				ovo.setCc(rs.getString("cc"));
				ovo.setIndate(rs.getTimestamp("indate"));
				// 추가 : bhs
				ovo.setPname(rs.getString("pname"));
				ovo.setCname(rs.getString("cname"));
				ovo.setCcname(rs.getString("ccname"));
				ovo.setRname(rs.getString("rname"));
				ovo.setCseq(rs.getInt("cseq"));
				ovo.setPrice(rs.getInt("price"));
				ovo.setMfc(rs.getString("mfc"));
				ovo.setCharge(rs.getInt("charge"));
				ovo.setDataplan(rs.getString("dataplan"));
				ovo.setTimeplan(rs.getString("timeplan"));
				ovo.setTextplan(rs.getString("textplan"));

				list.add(ovo);
			} 
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		return list;
	}

	public OrderDetailVO getOrderDetails(int odseq) {
		con = DBM.getConnection();
		OrderDetailVO ovo = null;
		String sql = "SELECT * FROM order_detail_view WHERE odseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			rs = pstmt.executeQuery();	
			if (rs.next()) {
				ovo = new OrderDetailVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setId(rs.getString("id"));
				ovo.setResult(rs.getString("result"));
				ovo.setDiscount(rs.getInt("discount"));
				ovo.setBuyplan(rs.getInt("buyplan"));
				ovo.setDcmonth(rs.getInt("dcmonth"));
				ovo.setDctotal(rs.getInt("dctotal"));
				ovo.setMmonth(rs.getInt("mmonth"));
				ovo.setMtotal(rs.getInt("mtotal"));
				ovo.setCc(rs.getString("cc"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setPname(rs.getString("pname"));
				ovo.setCname(rs.getString("cname"));
				ovo.setRname(rs.getString("rname"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBM.close(con, pstmt, rs);
		    }
		    return ovo;
		}

	public void insertOrder(OrderDetailVO odvo) {
		con = DBM.getConnection();
		String sql = "INSERT INTO order_detail (odseq, pseq, rseq, discount, buyplan, dcmonth, dctotal, mmonth, mtotal, cc, id, cseq) VALUES (odseq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odvo.getPseq());
			pstmt.setInt(2, odvo.getRseq());
			pstmt.setInt(3, odvo.getDiscount());
			pstmt.setInt(4, odvo.getBuyplan());
			pstmt.setInt(5, odvo.getDcmonth());
			pstmt.setInt(6, odvo.getDctotal());
			pstmt.setInt(7, odvo.getMmonth());
			pstmt.setInt(8, odvo.getMtotal());
			pstmt.setString(9, odvo.getCc());
			pstmt.setString(10, odvo.getId());
			pstmt.setInt(11, odvo.getCseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
	}

	public OrderDetailVO getOrderDetail(int odseq, String id) {
		// author : bhs
		OrderDetailVO ovo = null;
		String sql = "SELECT * FROM order_detail_view2 WHERE odseq =? AND id = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ovo = new OrderDetailVO();	
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setRseq(rs.getInt("rseq"));
				ovo.setId(rs.getString("id"));
				ovo.setResult(rs.getString("result"));
				ovo.setDiscount(rs.getInt("discount"));
				ovo.setBuyplan(rs.getInt("buyplan"));
				ovo.setDcmonth(rs.getInt("dcmonth"));
				ovo.setDctotal(rs.getInt("dctotal"));
				ovo.setMmonth(rs.getInt("mmonth"));
				ovo.setMtotal(rs.getInt("mtotal"));
				ovo.setCc(rs.getString("cc"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setCseq(rs.getInt("cseq"));
				ovo.setPname(rs.getString("pname"));
				ovo.setCname(rs.getString("cname"));
				ovo.setCcname(rs.getString("ccname"));
				ovo.setRname(rs.getString("rname"));
				ovo.setImage(rs.getString("image"));
				ovo.setPrice(rs.getInt("price"));
				ovo.setMfc(rs.getString("mfc"));
				ovo.setCharge(rs.getInt("charge"));
				ovo.setDataplan(rs.getString("dataplan"));
				ovo.setTimeplan(rs.getString("timeplan"));
				ovo.setTextplan(rs.getString("textplan"));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return ovo;
	}

	public OrderDetailVO getOrderDetail(int odseq) {
		// author : bhs
		OrderDetailVO ovo = null;
		String sql = "SELECT * FROM order_detail_view2 WHERE odseq =?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ovo = new OrderDetailVO();	
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setRseq(rs.getInt("rseq"));
				ovo.setId(rs.getString("id"));
				ovo.setResult(rs.getString("result"));
				ovo.setDiscount(rs.getInt("discount"));
				ovo.setBuyplan(rs.getInt("buyplan"));
				ovo.setDcmonth(rs.getInt("dcmonth"));
				ovo.setDctotal(rs.getInt("dctotal"));
				ovo.setMmonth(rs.getInt("mmonth"));
				ovo.setMtotal(rs.getInt("mtotal"));
				ovo.setCc(rs.getString("cc"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setCseq(rs.getInt("cseq"));
				ovo.setPname(rs.getString("pname"));
				ovo.setCname(rs.getString("cname"));
				ovo.setCcname(rs.getString("ccname"));
				ovo.setRname(rs.getString("rname"));
				ovo.setImage(rs.getString("image"));
				ovo.setPrice(rs.getInt("price"));
				ovo.setMfc(rs.getString("mfc"));
				ovo.setCharge(rs.getInt("charge"));
				ovo.setDataplan(rs.getString("dataplan"));
				ovo.setTimeplan(rs.getString("timeplan"));
				ovo.setTextplan(rs.getString("textplan"));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return ovo;
	}


	public void deleteOrder(int odseq) {
		String sql = "DELETE FROM order_detail WHERE odseq =?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
	}

	public int getAllcount(String id) {
		int count = 0;
		String sql = "SELECT COUNT(*) cnt FROM order_detail WHERE id = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return count;
	}

}