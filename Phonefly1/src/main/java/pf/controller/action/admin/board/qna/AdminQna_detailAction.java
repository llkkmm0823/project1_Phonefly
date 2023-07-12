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

public class AdminQna_detailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/adminQnaDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {		
			QnaDao qdao = QnaDao.getInstance();
			QnaVO qvo = qdao.getQna(Integer.parseInt(request.getParameter("qseq")));
			
			request.setAttribute("qnaVO", qvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}