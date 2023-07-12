package pf.controller.action.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;
import pf.dao.ProductDao;
import pf.dto.ProductVO;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mfc = request.getParameter("mfc");
		
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductVO> list = pdao.getProducts( mfc );
		
		request.setAttribute("productList", list);
		request.setAttribute("mfc", mfc);
		
		String url = "product/productList.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
