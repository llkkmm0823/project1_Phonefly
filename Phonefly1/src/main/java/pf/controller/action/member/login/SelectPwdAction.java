package pf.controller.action.member.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.MemberDao;

public class SelectPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 수정 : bhs
		String id = request.getParameter("id");
		String newPwd = request.getParameter("newPwd");
		
		if (id != null && !id.isEmpty()) {
			 MemberDao mdao = MemberDao.getInstance();
			 MemberVO member = mdao.selectPwd(id, newPwd);
			request.setAttribute("member", member);
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("member/findPwd.jsp");
		dp.forward(request, response);
		*/

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.findMember(id, name, phone);
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		request.getRequestDispatcher("member/findPwd.jsp").forward(request, response);
	}

}
