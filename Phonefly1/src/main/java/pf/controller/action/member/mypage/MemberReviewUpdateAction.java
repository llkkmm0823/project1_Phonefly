package pf.controller.action.member.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ReviewDao;
import pf.dto.MemberVO;
import pf.dto.ReviewVO;

public class MemberReviewUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "pf.do?command=memberReviewList";
		
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO) session.getAttribute("loginUser");    
	    if (mvo == null) {
	    	url = "pf.do?command=loginForm";
	    }else{
	    	ReviewVO rvo = new ReviewVO();
	    	rvo.setRvseq(Integer.parseInt(request.getParameter("rvseq")));
	    	rvo.setId( mvo.getId() );
	    	rvo.setSubject(request.getParameter("subject"));
	    	rvo.setContent(request.getParameter("content"));
	    	
	    	ReviewDao rdao = ReviewDao.getInstance();
	    	rdao.updateReview(rvo);
	    }
	    response.sendRedirect(url);
		

	}

}
