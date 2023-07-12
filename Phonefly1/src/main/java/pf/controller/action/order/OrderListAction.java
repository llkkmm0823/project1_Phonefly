package pf.controller.action.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.OrderDetailDao;
import pf.dto.MemberVO;
import pf.dto.OrderDetailVO;
import pf.util.Paging;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/orderList.jsp";	
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
		    url = "pf.do?command=loginForm";
		}else {
			
			if( request.getParameter("changeMenu") != null) {
				session.removeAttribute("page");
				session.removeAttribute("key"); 
			}
			
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			
			if (request.getParameter("page")!=null) {
				paging.setPage(Integer.parseInt( request.getParameter("page")));
				session.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			} else if (session.getAttribute("page") != null){
				paging.setPage((Integer)session.getAttribute("page"));
			} else {
				paging.setPage(1);
			}
			String key="";
			if (request.getParameter("key") != null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if (session.getAttribute("key") != null) {
				key=(String)session.getAttribute("key");
			} else {
				key="";
				session.removeAttribute("key");
			}
			
			OrderDetailDao odao = OrderDetailDao.getInstance();
			int count = odao.getAllcount(mvo.getId());
			paging.setTotalCount(count);

			ArrayList<OrderDetailVO> list = odao.listOrderByOdseq(paging, mvo.getId());
			
			request.setAttribute("orderList", list);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
