package pf.controller.action.board.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.EventVO;
import pf.util.Paging;

public class EventListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "event/eventList.jsp";

		EventDao edao = EventDao.getInstance();

		int page = 1;
		if(request.getParameter("page")!=null)
			page=Integer.parseInt(request.getParameter("page"));

		Paging paging = new Paging();
		paging.setPage(page);

		int count = edao.getAllCount();
		paging.setTotalCount(count);
		
		ArrayList<EventVO>list = edao.selectNotice(paging);
		request.setAttribute("eventList", list);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
