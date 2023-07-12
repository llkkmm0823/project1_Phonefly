package pf.controller.action.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ColorDao;
import pf.dto.AdminVO;
import pf.dto.ColorVO;

public class AdminColorUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="admin/product/productColorUpdate.jsp";

		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) 
			url="pf.do?command=admin";
		else {
			int cseq = Integer.parseInt(request.getParameter("cseq"));
			ColorDao cdao=ColorDao.getInstance();
			ColorVO cvo= cdao.getColor(cseq);
			request.setAttribute("ColorVO", cvo);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
