package pf.controller.action.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ProductDao;
import pf.dto.MemberVO;
import pf.dto.ProductVO;
import pf.dto.ReviewVO;
import pf.dto.RplanVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int pseq = Integer.parseInt( request.getParameter("pseq") );
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct( pseq );
		
		ArrayList<RplanVO>rplanList = pdao.getRplanList();
		
		request.setAttribute("productVO", pvo);
		request.setAttribute("rplanVO", rplanList);
		
		//추가
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int countOrderPseq = pdao.countProductOrders(pseq);
		int countOrderById = 0;
		if (mvo != null) {
			countOrderById = pdao.countOrderById(mvo.getId(), pseq);
		}
		if (countOrderPseq > 0) {
			ArrayList<ReviewVO> reviewList = pdao.getReviews(pseq);
			request.setAttribute("reviewList", reviewList);
		}
		
		request.setAttribute("countOrderById", countOrderById);
		request.setAttribute("countOrderPseq", countOrderPseq);
		
		String url = "product/productDetail.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
}
