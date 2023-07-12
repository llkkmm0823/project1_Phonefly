package pf.controller.action.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.ProductDao;
import pf.dto.AdminVO;

public class AdminProductDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq=Integer.parseInt(request.getParameter("pseq"));
		
		String url="pf.do?command=adminProductList";
		
		HttpSession session = request.getSession();
		AdminVO mvo = (AdminVO) session.getAttribute("loginAdmin");
		if(mvo==null) {
			url="pf.do?command=admin";
		}else {
			ProductDao pdao = ProductDao.getInstance();
			pdao.deleteProduct(pseq);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
