package pf.controller.action.admin.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.NoticeDao;
import pf.dto.AdminVO;

public class AdminNoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nseq=Integer.parseInt(request.getParameter("nseq"));
		
		// 수정 : bhs
		//String url="admin/notice/adminNoticeList.jsp";
		String url="pf.do?command=adminNoticeList";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo==null) {
			url="pf.do?command=admin";
		}else {
			NoticeDao ndao = NoticeDao.getInstance();
			ndao.deleteNotice(nseq);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
