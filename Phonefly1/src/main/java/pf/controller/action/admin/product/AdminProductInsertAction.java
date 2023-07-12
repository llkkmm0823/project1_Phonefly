package pf.controller.action.admin.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pf.controller.action.Action;
import pf.dao.AdminDao;
import pf.dto.AdminVO;
import pf.dto.ProductVO;

public class AdminProductInsertAction implements Action {

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pf.do?command=adminColorInsertForm&pseq=";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			
			ProductVO pvo = new ProductVO();
			pvo.setName( request.getParameter("name") );
			pvo.setPrice1( Integer.parseInt( request.getParameter("price1")) );
			pvo.setPrice2( Integer.parseInt( request.getParameter("price2")) );
			pvo.setPrice3( Integer.parseInt( request.getParameter("price3")) );
			pvo.setContent( request.getParameter("content") );
			pvo.setUseyn(request.getParameter("useyn"));
			pvo.setBestyn(request.getParameter("bestyn"));
			pvo.setEventyn(request.getParameter("eventyn"));
			pvo.setMfc( request.getParameter("mfc") );

			AdminDao adao = AdminDao.getInstance();
	        adao.insertProduct(pvo);
	        int pseq = adao.getPseq(pvo);
	        System.out.println(pseq);
	        url="pf.do?command=adminColorInsertForm&pseq=" +pseq;
		}
		
		response.sendRedirect(url);
    }
}
