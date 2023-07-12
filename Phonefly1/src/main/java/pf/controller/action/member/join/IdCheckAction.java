package pf.controller.action.member.join;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.MemberVO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);

		int result = 1;
		if( mvo == null ) request.setAttribute("result", -1);
		else request.setAttribute("result", 1);

		request.setAttribute("id", id);


		RequestDispatcher rd = request.getRequestDispatcher("member/idCheck.jsp");
		rd.forward(request, response);
	}

}
