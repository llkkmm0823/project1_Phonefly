package pf.controller.action.member.join;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.MemberDao;
import pf.dto.AddressVO;

public class FindZipnumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong=request.getParameter("dong");

		if(dong != null) {
			if(!dong.equals("")){
				MemberDao mdao = MemberDao.getInstance();
				ArrayList<AddressVO> list = mdao.selectAddress(dong);
				System.out.println(list.size());
				request.setAttribute("addressList", list);
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("member/findZipnum.jsp");
		rd.forward(request, response);
	}

}
