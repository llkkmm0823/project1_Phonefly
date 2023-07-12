package pf.controller.action.admin.board.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.AdminVO;

public class AdminEventDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eseq=Integer.parseInt(request.getParameter("eseq"));
		
		//String url="admin/Event/adminEventList.jsp";
		String url="pf.do?command=adminEventList";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo==null) {
			url="pf.do?command=admin";
		}else {
			EventDao edao = EventDao.getInstance();
			edao.deleteEvent(eseq);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
}
