package pf.controller.action.admin.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.NoticeDao;
import pf.dto.AdminVO;
import pf.dto.NoticeVO;

public class AdminNoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/notice/adminNoticeUpdateForm.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			
			int nseq = Integer.parseInt( request.getParameter("nseq") );
			NoticeDao ndao = NoticeDao.getInstance();
			NoticeVO nvo = ndao.getNotice(nseq);
			// 수정 : bhs
			//request.setAttribute("NoticeVO", nvo);
			request.setAttribute("noticeVO", nvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
