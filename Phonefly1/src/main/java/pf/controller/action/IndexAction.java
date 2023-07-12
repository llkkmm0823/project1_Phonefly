package pf.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.dao.ProductDao;
import pf.dto.ProductVO;


public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = ProductDao.getInstance();

		ArrayList<ProductVO> mainBestList = dao.getMainBestList();
		ArrayList<ProductVO> mainEventList = dao.getMainEventList();

		request.setAttribute("mainBestList", mainBestList);
		request.setAttribute("mainEventList", mainEventList);

		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
