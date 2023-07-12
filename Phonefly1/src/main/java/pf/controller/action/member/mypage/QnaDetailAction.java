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

public class QnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaDetail.jsp";
		int qseq = Integer.parseInt( request.getParameter("qseq") );
		
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	    if (mvo == null) {
	        url = "pf.do?command=loginForm";
	    } else {	
	    	QnaDao qdao = QnaDao.getInstance();
	    	QnaVO qvo = qdao.getQna( qseq );
	    	request.setAttribute("qnaVO", qvo);
	    }
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}

