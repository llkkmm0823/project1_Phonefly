package pf.controller.action.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ColorDao;
import pf.dto.AdminVO;
import pf.dto.MemberVO;

public class AdminColorDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cseq=Integer.parseInt(request.getParameter("cseq"));
		int pseq=Integer.parseInt(request.getParameter("pseq"));
		
		// 수정 : pms
		/* String url="admin/product/adminColorList.jsp"; */
		
		String url="pf.do?command=adminColorList&pseq="+ pseq;
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo==null) {
			url="pf.do?command=admin";
		}else {
			ColorDao cdao = ColorDao.getInstance();
			cdao.deleteColor(cseq);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
