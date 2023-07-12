package pf.controller.action.admin.board.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.AdminVO;
import pf.dto.EventVO;
import pf.util.Paging;

public class AdminEventListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/event/adminEventList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) {
			url = "pf.do?command=admin";
		}else {				
			
			if( request.getParameter("changeMenu") != null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			
			if(request.getParameter("page")!=null) {
				paging.setPage( Integer.parseInt( request.getParameter("page") ) );
				session.setAttribute("page", Integer.parseInt( request.getParameter("page") ) );
			}else if(session.getAttribute("page") != null){
				paging.setPage( (Integer)session.getAttribute("page") );
			}else {
				paging.setPage(1);
			}			
			String key="";
			if ( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else  if( session.getAttribute("key") != null ) {
				key=(String)session.getAttribute("key");
			}else {
				key="";
				session.removeAttribute("key");
			}
			
			EventDao edao = EventDao.getInstance();
			int count = edao.getAllCountEvent( key );
			paging.setTotalCount(count);
			
			ArrayList<EventVO> eventList = edao.selectEvent(paging, key);
			request.setAttribute("eventList", eventList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);

		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
