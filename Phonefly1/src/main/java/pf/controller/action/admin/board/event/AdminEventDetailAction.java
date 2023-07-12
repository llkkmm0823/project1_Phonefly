package pf.controller.action.admin.board.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.EventVO;

public class AdminEventDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/event/adminEventDetail.jsp";
		int eseq = Integer.parseInt(request.getParameter("eseq"));

			EventDao edao = EventDao.getInstance();
			EventVO evo = edao.getEvent(eseq);
			// 수정 : bhs EventVO -> eventVO
			request.setAttribute("eventVO", evo);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
