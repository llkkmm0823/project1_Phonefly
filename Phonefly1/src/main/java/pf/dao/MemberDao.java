package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pf.dto.AddressVO;
import pf.dto.MemberVO;
import pf.util.DBM;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertMember(MemberVO mvo) {
		String sql = "insert into member( id, pwd, name, zipnum, address1, address2, phone, email) "
				+ " values( ? , ? , ? , ? , ? , ? , ? , ?)";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZipnum());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getEmail());
	       
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
	}

	public MemberVO getMember(String id) {
		
		MemberVO mvo = null;
		con = DBM.getConnection();
		String sql = "select * from member where id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mvo = new MemberVO();
				mvo.setId( rs.getString("id") );
				mvo.setPwd( rs.getString("pwd") );
				mvo.setName( rs.getString("name") );
				mvo.setEmail( rs.getString("email") );
				mvo.setZipnum( rs.getString("zipnum") );
				mvo.setAddress1( rs.getString("address1") );
				mvo.setAddress2( rs.getString("address2") );
				mvo.setPhone( rs.getString("phone") );
				mvo.setUseyn( rs.getString("useyn") );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		return mvo;
	}



	public ArrayList<AddressVO> selectAddress(String dong) {
		ArrayList<AddressVO> list = new ArrayList<>();
		String sql = "select*from address where dong like '%'||?||'%'";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setZipnum(  rs.getString("zipnum") );
				avo.setSido(  rs.getString("sido") );
				avo.setGugun(  rs.getString("gugun") );
				avo.setDong(  rs.getString("dong") );
				avo.setZipcode(  rs.getString("zipcode") );
				avo.setBunji(  rs.getString("bunji") );
				list.add(avo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		return list;
	}



	public int updateMember(MemberVO mvo) {
		int result = 0;
		String sql = "Update member set  pwd=?, name=?, email=?, zipnum=?, address1=?, address2=?, "
				+ " phone=? where id=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getEmail());
			pstmt.setString(4, mvo.getZipnum());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs); 
	}
		return result;		
	}



	public MemberVO selectId(String name, String phone) {
		MemberVO mvo = null;
		String sql = "SELECT ID FROM member WHERE name = ? AND phone = ?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
		    while( rs.next() ) {
		    	mvo = new MemberVO();
				mvo.setId( rs.getString("id") );
		    }
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		return mvo;
	}

	public MemberVO selectPwd(String id, String newPwd) {
	    MemberVO mvo = null;
	    String sql = "UPDATE member SET pwd = ? WHERE id = ?";
	    con = DBM.getConnection();
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, newPwd);
	        pstmt.setString(2, id);		
	        rs = pstmt.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBM.close(con, pstmt, rs);
	    }
	    return mvo;
	}
	
	
	public void deleteMember(String id) {
		con = DBM.getConnection();
		String sql="update member set useyn='N' where id=?";
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
	}

	public int findMember(String id, String name, String phone) {
		// author : bhs
		int count = 0;
		con = DBM.getConnection();
		String sql="SELECT COUNT(*) cnt FROM member WHERE id = ? AND name = ? AND phone = ?";
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, phone);
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

	public void setNewPwd(String id, String pwd) {
		// author : bhs
		con = DBM.getConnection();
		String sql="UPDATE member SET pwd = ? WHERE id = ?";
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pwd);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
	}

}



