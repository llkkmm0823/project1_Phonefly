package pf.controller.action.admin.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pf.controller.action.Action;
import pf.dao.AdminDao;
import pf.dto.AdminVO;
import pf.dto.ColorVO;
import pf.dto.ProductVO;
import pf.util.Paging;

public class AdminColorListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
	
		String url = "admin/product/productColorList.jsp";

		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) url="pf.do?command=admin";
		else {
			
			if(request.getParameter("changeMenu")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}

			Paging paging = new Paging();
			paging.setDisplayRow(10);
			paging.setDisplayPage(10);

		if(request.getParameter("page")!=null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			session.setAttribute("page",Integer.parseInt(request.getParameter("page")));
		}else if(session.getAttribute("page") != null){
			paging.setPage((Integer)session.getAttribute("page"));
		}else {
			paging.setPage(1);
		}
			
			String key="";
			if(request.getParameter("key") != null ) {
				key=request.getParameter("key");
				session.setAttribute("key",key);
			}else if(session.getAttribute("key")!=null) {
				key=(String)session.getAttribute("key");
			}else {
				key="";
				session.removeAttribute("key");
			}
			
			AdminDao adao = AdminDao.getInstance();
			
			int count = adao.getAllcount("color","name",key);
			
			paging.setTotalCount(count);

			ArrayList<ColorVO> ProductColorList = adao.productColorList(paging, key, pseq);
			request.setAttribute("ProductColorList", ProductColorList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);


		}
	     request.getRequestDispatcher(url).forward(request, response);

	}

}
