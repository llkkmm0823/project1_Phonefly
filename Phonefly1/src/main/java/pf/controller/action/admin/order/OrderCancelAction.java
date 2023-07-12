package pf.controller.action.admin.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.OrderDetailDao;
import pf.dto.MemberVO;

public class OrderCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pf.do?command=orderList";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
			url = "pf.do?command=loginForm";
		} else {
			int odseq = Integer.parseInt( request.getParameter("odseq") );
			OrderDetailDao odao = OrderDetailDao.getInstance();
			odao.deleteOrder(odseq);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
