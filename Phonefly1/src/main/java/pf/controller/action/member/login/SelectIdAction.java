package pf.controller.action.member.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.MemberVO;

public class SelectIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
			MemberDao mdao = MemberDao.getInstance();
			MemberVO member = mdao.selectId(name, phone);
			request.setAttribute("member", member);
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("member/findId.jsp");
		dp.forward(request, response); 

	}
}
