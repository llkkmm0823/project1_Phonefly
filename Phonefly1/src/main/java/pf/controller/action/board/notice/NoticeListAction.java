package pf.controller.action.board.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.NoticeDao;
import pf.dto.NoticeVO;
import pf.util.Paging;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "notice/noticeList.jsp";

		NoticeDao ndao = NoticeDao.getInstance();

		int page = 1;
		if(request.getParameter("page")!=null)
			page=Integer.parseInt(request.getParameter("page"));

		Paging paging = new Paging();
		paging.setPage(page);

		int count = ndao.getAllCount();
		paging.setTotalCount(count);


		ArrayList<NoticeVO>list = ndao.selectNotice(paging);
		request.setAttribute("noticeList", list);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher(url).forward(request, response);

		}
	}
