package pf.controller.action.member.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.QnaDao;
import pf.dto.MemberVO;
import pf.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "pf.do?command=qnaList";
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");    
	    if (mvo == null) {
	    	url = "pf.do?command=loginForm";
	    }else{
	    	QnaVO qvo = new QnaVO();
	    	qvo.setSubject(request.getParameter("subject"));
	    	qvo.setContent(request.getParameter("content"));
	    	qvo.setId( mvo.getId() );
	    	
	    	QnaDao qdao = QnaDao.getInstance();
	    	qdao.insertQna(qvo);
	    }
	    response.sendRedirect(url);

	}

}
