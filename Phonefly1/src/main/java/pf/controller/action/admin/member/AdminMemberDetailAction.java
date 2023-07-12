package pf.controller.action.admin.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.AdminVO;
import pf.dto.MemberVO;

public class AdminMemberDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/adminMemberDetail.jsp";

		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) url="pf.do?command=admin";
		else {
			String id = request.getParameter("id");
			MemberDao mdao = MemberDao.getInstance();
			MemberVO mvo = mdao.getMember(id);
			
			request.setAttribute("MemberVO", mvo);
		}
	     request.getRequestDispatcher(url).forward(request, response);
	}

}
