package pf.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.MemberVO;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url="pf.do?command=index";
		if(mvo==null) {
			url="pf.do?command=loginForm";
		}else {
			MemberDao mdao = MemberDao.getInstance();
			mdao.deleteMember(mvo.getId());
			// 추가 : bhs
			session.removeAttribute("loginUser");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
