package pf.controller.action.board.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.EventVO;

public class EventDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "event/eventDetail.jsp";
		int eseq = Integer.parseInt(request.getParameter("eseq"));

			EventDao edao = EventDao.getInstance();
			EventVO evo = edao.getEvent(eseq);
			request.setAttribute("EventVO", evo);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
