package pf.controller.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.OrderDetailDao;
import pf.dto.MemberVO;
import pf.dto.OrderDetailVO;

public class OrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 수정 : bhs
		/*
		int odseq = Integer.parseInt( request.getParameter("odseq") );	
		int pseq = Integer.parseInt( request.getParameter("pseq") );		
		int rseq = Integer.parseInt( request.getParameter("rseq") );
		String id = request.getParameter("id");
		int mseq = Integer.parseInt( request.getParameter("mseq") );
		int charge = Integer.parseInt( request.getParameter("charge") );
		int discount = Integer.parseInt( request.getParameter("discount") );
		int buyplan = Integer.parseInt( request.getParameter("buyplan") );
		int dcmonth = Integer.parseInt( request.getParameter("dcmonth") );
		int dctotal = Integer.parseInt( request.getParameter("dctotal") );
		int mmonth = Integer.parseInt( request.getParameter("mmonth") );
		int mtotal = Integer.parseInt( request.getParameter("mtotal") );
		int cseq = Integer.parseInt( request.getParameter("cseq") );
		String cc = request.getParameter("cc");
		*/
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "";

		
		if (mvo == null) {
			url = "pf.do?command=loginForm";
		} else {
			OrderDetailVO odvo = new OrderDetailVO();
			odvo.setPseq(Integer.parseInt(request.getParameter("pseq")));
			odvo.setRseq(Integer.parseInt(request.getParameter("rseq")));
			odvo.setCseq(Integer.parseInt(request.getParameter("cseq")));
			odvo.setDiscount(Integer.parseInt(request.getParameter("discount")));
			odvo.setBuyplan(Integer.parseInt(request.getParameter("buyplan")));
			odvo.setDcmonth(Integer.parseInt(request.getParameter("dcmonth")));
			odvo.setDctotal(Integer.parseInt(request.getParameter("dctotal")));
			odvo.setMmonth(Integer.parseInt(request.getParameter("mmonth")));
			odvo.setMtotal(Integer.parseInt(request.getParameter("mtotal")));
			odvo.setCc(request.getParameter("cc"));
			odvo.setId(mvo.getId());
			
			OrderDetailDao odao = OrderDetailDao.getInstance();
			// 수정 : bhs
			//odao.insertOrder( pseq, rseq, id, mseq, charge, discount, 
			//		buyplan, dcmonth, dctotal, mmonth, mtotal, cc, cseq );
			//url = "pf.do?command=orderList&odseq=" + odseq;
			
			odao.insertOrder(odvo);
			url = "pf.do?command=orderList";
		}
		response.sendRedirect(url);
	}

}