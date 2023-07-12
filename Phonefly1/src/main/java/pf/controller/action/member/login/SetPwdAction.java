package pf.controller.action.member.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.MemberDao;

public class SetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// author : bhs
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDao mdao = MemberDao.getInstance();
		mdao.setNewPwd(id, pwd);
		request.setAttribute("result", 3);
		request.getRequestDispatcher("member/findPwd.jsp").forward(request, response);
	}
}
