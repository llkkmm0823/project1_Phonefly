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

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/orderDetail.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
			url = "pf.do?command=loginForm";
		} else {
			int odseq = Integer.parseInt( request.getParameter("odseq") );
			OrderDetailDao odao = OrderDetailDao.getInstance();
			OrderDetailVO odvo = new OrderDetailVO();
			odvo = odao.getOrderDetail(odseq, mvo.getId());
			request.setAttribute("orderVO", odvo);	
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
