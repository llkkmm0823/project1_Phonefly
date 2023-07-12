package pf.controller.action.admin.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pf.controller.action.Action;
import pf.dao.AdminDao;
import pf.dao.ColorDao;
import pf.dto.AdminVO;
import pf.dto.ColorVO;

public class AdminColorInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		String url = "pf.do?command=adminColorList&pseq=";

		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("images/productImage");

		MultipartRequest multi = new MultipartRequest(
				request, 
				path, 
				5*1024*1024,  
				"UTF-8", 
				new DefaultFileRenamePolicy()
		);
		
		ColorDao cdao = ColorDao.getInstance();
        
        // 제품 등록
        ColorVO cvo = new ColorVO();
        cvo.setPseq(Integer.parseInt(multi.getParameter("pseq")));
        cvo.setName(multi.getParameter("name"));
        cvo.setCcode(multi.getParameter("ccode"));
        cvo.setImage( multi.getFilesystemName("image") );

		AdminDao adao = AdminDao.getInstance();
		
		
		url = url+ cvo.getPseq();
		
		adao.insertColor(cvo);
		
	}
	response.sendRedirect(url);
	}

}
