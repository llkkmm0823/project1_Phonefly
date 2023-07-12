package pf.controller.action.member.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.QnaDao;

public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String qseq = request.getParameter("qseq");
		QnaDao qdao = QnaDao.getInstance();
		
		qdao.deleteQna( Integer.parseInt(qseq) );
		
		// 수정 bhs : response.sendRedirect("pf.do?command=QnaList"); 
		response.sendRedirect("pf.do?command=qnaList"); 
		
	}

}
