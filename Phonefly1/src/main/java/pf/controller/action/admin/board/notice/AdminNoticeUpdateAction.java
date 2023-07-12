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

public class AdminNoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pf.do?command=adminNoticeDetail";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			NoticeVO nvo = new NoticeVO();
	    	nvo.setSubject(request.getParameter("subject"));
	    	nvo.setContent(request.getParameter("content"));
	    	nvo.setId( avo.getId() );
	    	nvo.setNseq(Integer.parseInt(request.getParameter("nseq")));
	    	
			NoticeDao ndao = NoticeDao.getInstance();
			ndao.updateNotice(nvo);
			}
			request.getRequestDispatcher(url).forward(request, response);
		
	}
}
