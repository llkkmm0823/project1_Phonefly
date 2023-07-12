package pf.controller.action.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.NoticeDao;
import pf.dto.NoticeVO;

public class NoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "notice/noticeDetail.jsp";
		int nseq = Integer.parseInt(request.getParameter("nseq"));

			NoticeDao ndao = NoticeDao.getInstance();
			NoticeVO nvo = ndao.getNotice(nseq);
			request.setAttribute("NoticeVO", nvo);

		request.getRequestDispatcher(url).forward(request, response);

	}

}
