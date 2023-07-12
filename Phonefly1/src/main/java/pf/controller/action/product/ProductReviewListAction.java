package pf.controller.action.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.ReviewDao;
import pf.dto.ReviewVO;

public class ProductReviewListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		String url = "pf.do?command=productDetail&pseq="+pseq;
		
		ReviewDao rdao = ReviewDao.getInstance();
		
		ArrayList<ReviewVO> list = rdao.listReviewBypseq(pseq);
		
		request.setAttribute("productReviewList", list);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	

}
