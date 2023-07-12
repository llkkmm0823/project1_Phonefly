package pf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pf.dto.ColorVO;
import pf.dto.ProductVO;
import pf.dto.ReviewVO;
import pf.dto.RplanVO;
import pf.util.DBM;

public class ProductDao {
	
	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() { return itc; }

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection con2 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs2 = null;


	public ArrayList<ProductVO> getMainBestList() {
		// author : BHS
		ArrayList<ProductVO> list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM main_best_pro_view";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));

				// 컬러 리스트 추가
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<ProductVO> getMainEventList() {
		// author : BHS
		ArrayList<ProductVO> list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM main_event_pro_view";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));

				// 컬러 리스트 추가
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	}

	private ArrayList<ColorVO> getColorList(int pseq) {
		// author : BHS
		ArrayList<ColorVO> list = new ArrayList<>();
		con2 = DBM.getConnection();
		String sql = "SELECT * FROM color WHERE pseq = ? ORDER BY cseq DESC";
		try {
			pstmt2 = con2.prepareStatement(sql);
			pstmt2.setInt(1, pseq);
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				ColorVO cvo = new ColorVO();
				cvo.setCseq(rs2.getInt("cseq"));
				cvo.setPseq(pseq);
				cvo.setName(rs2.getString("name"));
				cvo.setCcode(rs2.getString("ccode"));
				cvo.setImage(rs2.getString("image"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con2, pstmt2, rs2);
		}
		return list;
	}

	public ProductVO getProduct(int pseq) {
		ProductVO pvo = null;
		String sql = "SELECT * FROM product WHERE pseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));
				
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);  }
		return pvo;
	}

	public ArrayList<RplanVO> getRplanList() {
		ArrayList<RplanVO>list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM rplan ORDER BY mseq, rseq";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RplanVO rvo = new RplanVO();
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setMseq(rs.getInt("mseq"));
				rvo.setName(rs.getString("name"));
				rvo.setCharge(rs.getInt("charge"));
				rvo.setDataplan(rs.getString("dataplan"));
				rvo.setTimeplan(rs.getString("timeplan"));
				rvo.setTextplan(rs.getString("textplan"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	}

	public int insertProduct(ProductVO pvo) {
		   int generatedPseq = 0; // 생성된 pseq 값을 저장할 변수

		   String sql = "INSERT INTO product(pseq, name, price1, price2, price3, content, useyn, eventyn, bestyn, indate, mfc) "
		         + "VALUES(pseq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		   con = DBM.getConnection();
		   try {
		      pstmt = con.prepareStatement(sql, new String[]{"pseq"}); // 자동 생성된 pseq 값을 가져오기 위해 수정
		      pstmt.setString(1, pvo.getName());
		      pstmt.setInt(2, pvo.getPrice1());
		      pstmt.setInt(3, pvo.getPrice2());
		      pstmt.setInt(4, pvo.getPrice3());
		      pstmt.setString(5, pvo.getContent());
		      pstmt.setString(6, pvo.getUseyn());
		      pstmt.setString(7, pvo.getEventyn());
		      pstmt.setString(8, pvo.getBestyn());
		      pstmt.setTimestamp(9, pvo.getIndate());
		      pstmt.setString(10, pvo.getMfc());   

		      pstmt.executeUpdate();

		      // 자동 생성된 pseq 값을 가져옴
		      ResultSet generatedKeys = pstmt.getGeneratedKeys();
		      if (generatedKeys.next()) {
		         generatedPseq = generatedKeys.getInt(1);
		      }

		      // 컬러 정보를 개별적으로 삽입
		      ArrayList<ColorVO> colorList = pvo.getColorList();
		      if (colorList != null && !colorList.isEmpty()) {
		         insertColors(generatedPseq, colorList);
		      }
		   } catch (SQLException e) {
		      e.printStackTrace();
		   } finally {
		      DBM.close(con, pstmt, rs);
		   }
		   
		   return generatedPseq; // 생성된 pseq 값을 반환
		}

		private void insertColors(int pseq, ArrayList<ColorVO> colorList) {
		   con2 = DBM.getConnection();
		   String sql = "INSERT INTO color(cseq, pseq, name, ccode, image) VALUES(cseq.nextVal, ?, ?, ?, ?)";
		   try {
		      pstmt2 = con2.prepareStatement(sql);
		      for (ColorVO cvo : colorList) {
		         pstmt2.setInt(1, pseq);
		         pstmt2.setString(2, cvo.getName());
		         pstmt2.setString(3, cvo.getCcode());
		         pstmt2.setString(4, cvo.getImage());
		         pstmt2.executeUpdate(); // 개별적으로 컬러 정보를 삽입
		      }
		   } catch (SQLException e) {
		      e.printStackTrace();
		   } finally {
		      DBM.close(con2, pstmt2, rs2);
		   }
		}

	public void deleteProduct(int pseq) {
		String sql = "delete from product where pseq=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);
		}
	}

	public ProductVO getProduct(String mfc) {
		ProductVO pvo = null;
		String sql = "SELECT * FROM product WHERE mfc=?";
		con = DBM.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mfc);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));
				
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);  }
		return pvo;
	}

	public ArrayList<ProductVO> getProducts(String mfc) {
		ArrayList<ProductVO> list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM product where mfc=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mfc);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));

				// 컬러 리스트 추가
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	
	}

	public int countProductOrders(int pseq) {
		// author : BHS
		int count = 0;
		con = DBM.getConnection();
		String sql = "SELECT COUNT(*) cnt FROM order_detail WHERE pseq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
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

	public int countOrderById(String id, int pseq) {
		// author : BHS
		int count = 0;
		con = DBM.getConnection();
		String sql = "SELECT COUNT(*) cnt FROM order_detail WHERE id = ? AND pseq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, pseq);
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

	public ArrayList<ReviewVO> getReviews(int pseq) {
		// author : BHS
		ArrayList<ReviewVO> list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM review_view WHERE pseq = ? ORDER BY rvseq DESC";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setRvseq(rs.getInt("rvseq"));
				vo.setId(rs.getString("id"));
				vo.setContent(rs.getString("content"));
				vo.setIndate(rs.getTimestamp("indate"));
				vo.setPseq(rs.getInt("pseq"));
				vo.setName(rs.getString("name"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<ProductVO> getProductList() {
		// author : BHS
		ArrayList<ProductVO> list = new ArrayList<>();
		con = DBM.getConnection();
		String sql = "SELECT * FROM product ORDER BY pseq";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setEventyn(rs.getString("eventyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setMfc(rs.getString("mfc"));

				// 컬러 리스트 추가
				ArrayList<ColorVO> cvo = getColorList(pvo.getPseq());
				pvo.setColorList(cvo);

				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return list;
	}
}
