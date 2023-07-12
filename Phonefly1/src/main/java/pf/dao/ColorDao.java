package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.ColorVO;
import pf.dto.ProductVO;
import pf.util.DBM;

public class ColorDao {
	private ColorDao() {}
	private static ColorDao instance = new ColorDao();
	public static ColorDao getInstance() { return instance;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void insertColor(ColorVO cvo) {
		String sql = "insert into color(cseq,pseq,name,ccode,image) "
				+ " values(cseq.nextVal, ? , ?, ?, ?)";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cvo.getPseq());
			pstmt.setString(2, cvo.getName());
			pstmt.setString(3, cvo.getCcode());
			pstmt.setString(4, cvo.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
	}


	public ArrayList<ColorVO> getColorListByPseq(int pseq) {
	    ArrayList<ColorVO> list = new ArrayList<ColorVO>();
	    String sql = "select * from color where pseq=?";
	    con = DBM.getConnection();
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, pseq);
	        
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            ColorVO cvo = new ColorVO();
	            cvo.setPseq(rs.getInt("pseq"));
	            cvo.setName(rs.getString("name"));
	            list.add(cvo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBM.close(con, pstmt, rs);
	    }
	    return list;
	}


	public ColorVO getColor(int cseq) {
        ColorVO cvo = null;
        String sql = "SELECT * FROM color WHERE cseq=?";
        con = DBM.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cseq);
            rs = pstmt.executeQuery();
            if( rs.next() ) {
                cvo = new ColorVO();
                cvo.setPseq(rs.getInt("pseq"));
                cvo.setCseq(rs.getInt("cseq"));
                cvo.setName(rs.getString("name"));
                cvo.setCcode(rs.getString("ccode"));
                cvo.setImage(rs.getString("image"));
            }
        } catch (SQLException e) { e.printStackTrace();
        } finally { DBM.close(con, pstmt, rs);  }
        return cvo;
    }

	public void deleteColor(int cseq) {
		String sql = "delete from color where cseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
		
	}

		
		
	}

