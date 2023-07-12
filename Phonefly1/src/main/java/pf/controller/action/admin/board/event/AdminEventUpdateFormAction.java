package pf.controller.action.admin.board.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.AdminVO;
import pf.dto.EventVO;

public class AdminEventUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// author : bhs
		String url = "admin/event/adminEventUpdateForm.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			int eseq = Integer.parseInt(request.getParameter("eseq"));
			EventDao edao = EventDao.getInstance();
			EventVO evo = edao.getEvent(eseq);
			request.setAttribute("eventVO", evo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
