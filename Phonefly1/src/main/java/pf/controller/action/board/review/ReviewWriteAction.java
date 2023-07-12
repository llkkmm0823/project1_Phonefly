package pf.controller.action.board.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ReviewDao;
import pf.dto.MemberVO;
import pf.dto.ReviewVO;



public class ReviewWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq = Integer.parseInt(request.getParameter("pseq"));
        String url = "pf.do?command=productDetail&pseq=" + pseq;
        HttpSession session = request.getSession();
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
        if (mvo == null) {
            url = "pf.do?command=loginForm";
        } else {
            ReviewDao rdao = ReviewDao.getInstance();

            /*
            boolean isPurchased = rdao.checkIfPurchased(mvo.getId(), pseq);
            if (isPurchased) {
                ReviewVO rvo = new ReviewVO();
                rvo.setContent(request.getParameter("content"));
                rvo.setId(mvo.getId());
                rvo.setPseq(pseq);
                
                rdao.insertReview(rvo);
            } else {
                url = "pf.do?command=productDetail&pseq=" + pseq;
            }
			*/

			ReviewVO rvo = new ReviewVO();
			rvo.setContent(request.getParameter("content"));
			rvo.setId(mvo.getId());
			rvo.setPseq(pseq);
			
			rdao.insertReview(rvo);


        }
        response.sendRedirect(url);
    }
}