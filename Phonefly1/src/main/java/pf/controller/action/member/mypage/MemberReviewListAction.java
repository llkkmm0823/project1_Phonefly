package pf.controller.action.member.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ReviewDao;
import pf.dto.MemberVO;
import pf.dto.ReviewVO;
import pf.util.Paging;

public class MemberReviewListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "review/reviewList.jsp";
		
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url = "pf.do?command=loginForm";
	    } else {
	    	
	    	String loggedInId = mvo.getId();
	    	
	    	ReviewDao rdao = ReviewDao.getInstance();
	    	
	    	int page = 1;
	    	if( request.getParameter("page") != null )
	    		page = Integer.parseInt( request.getParameter("page") );
	    	
	    	Paging paging = new Paging();
	    	paging.setPage(page);
	    	
	    	int count = rdao.getAllCount(loggedInId);
	    	paging.setTotalCount(count);
	    	
	    	ArrayList<ReviewVO> list = rdao.selectReview( paging, loggedInId );
	    	
	    	request.setAttribute("reviewList", list);
	    	request.setAttribute("paging", paging);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	    
	}

}
