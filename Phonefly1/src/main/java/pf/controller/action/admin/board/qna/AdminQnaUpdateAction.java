package pf.controller.action.admin.board.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.QnaDao;
import pf.dto.AdminVO;
import pf.dto.QnaVO;

public class AdminQnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "pf.do?command=adminQnaDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) {
			url = "pf.do?command=admin";
		}else {
			QnaDao qdao = QnaDao.getInstance();
			QnaVO qvo = new QnaVO();
			
			qvo.setQseq( Integer.parseInt( request.getParameter("qseq") ) );
			qvo.setReply( request.getParameter("reply") );
			qdao.updateQnaAdmin( qvo );
			
			url = url + "&qseq=" + qvo.getQseq();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
