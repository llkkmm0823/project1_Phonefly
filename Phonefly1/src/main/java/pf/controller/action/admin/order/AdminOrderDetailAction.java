package pf.controller.action.admin.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.OrderDetailDao;
import pf.dto.OrderDetailVO;

public class AdminOrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/order/adminOrderDetail.jsp";
		int odseq = Integer.parseInt(request.getParameter("odseq"));

		OrderDetailDao oddao = OrderDetailDao.getInstance();
		// 수정 : bhs
		//OrderDetailVO odvo = oddao.getOrderDetails(odseq);
		OrderDetailVO odvo = oddao.getOrderDetail(odseq);
		request.setAttribute("orderVO", odvo);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
