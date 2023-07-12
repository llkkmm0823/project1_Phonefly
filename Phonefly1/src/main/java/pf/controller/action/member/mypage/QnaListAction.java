package pf.controller.action.member.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.QnaDao;
import pf.dto.MemberVO;
import pf.dto.QnaVO;
import pf.util.Paging;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaList.jsp";
		
		//로그인 확인
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url="pf.do?command=loginForm";
		}else {
		
			String loggedInId = mvo.getId();
			
			QnaDao qdao = QnaDao.getInstance();
		
			//페이지
			int page = 1;
			if(request.getParameter("page")!=null)
				page=Integer.parseInt(request.getParameter("page"));
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			int count = qdao.getAllCount();
			paging.setTotalCount(count);
			
			
			ArrayList<QnaVO>list = qdao.selectQna(paging, loggedInId);
			
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
