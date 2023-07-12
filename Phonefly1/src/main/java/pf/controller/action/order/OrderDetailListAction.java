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

public class OrderDetailListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int odseq = Integer.parseInt(request.getParameter("odseq"));
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String url = "";
		if(loginUser == null) {
			url = "pf.do?command=loginForm";
		}else {
			url = "order/orderDetail.jsp";
			OrderDetailDao odao = OrderDetailDao.getInstance();
			OrderDetailVO ovo = odao.getOrderDetails(odseq);
			
			request.setAttribute("orderDetail", ovo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);    
    }
		

}
