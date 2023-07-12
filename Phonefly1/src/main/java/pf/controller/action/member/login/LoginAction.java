package pf.controller.action.member.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		String url = "member/loginForm.jsp";
		
		if( mvo == null)
			request.setAttribute("message", "없는 아이디입니다");
		else if( mvo.getUseyn().equals("N") )
			request.setAttribute("message", "회원가입후 탈퇴이력이 있습니다. 관리자에 문의하세요");
		else if( mvo.getPwd() == null)
			request.setAttribute("message", "데이터 오류. 관리자에 문의하세요");
		else if( !mvo.getPwd().equals(pwd) )
			request.setAttribute("message", "비밀번호가 틀렸습니다");
		else if( mvo.getPwd().equals(pwd) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "pf.do?command=index";
		}else
			request.setAttribute("message", "로그인 실패. 관리자에게 문의하세요");
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}