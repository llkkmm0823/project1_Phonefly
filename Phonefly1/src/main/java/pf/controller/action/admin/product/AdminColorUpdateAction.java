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
import pf.dto.AdminVO;
import pf.dto.ColorVO;

public class AdminColorUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pf.do?command=adminColorDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			ColorVO cvo = new ColorVO();
			ServletContext context = session.getServletContext();
			
			/* String path = context.getRealPath("image"); */
			// 수정 : pms
			 String path = context.getRealPath("images/productImage"); 
			
			MultipartRequest multi = new MultipartRequest(
					request, 
					path, 
					5*1024*1024,  
					"UTF-8", 
					new DefaultFileRenamePolicy()
			);
			int cseq = Integer.parseInt( multi.getParameter("cseq") );

			cvo.setCseq(cseq );
			cvo.setName( multi.getParameter("name"));
			cvo.setCcode(multi.getParameter("ccode"));		
			
			if( multi.getFilesystemName("image") == null ) 
			cvo.setImage(multi.getParameter("oldImage") );
			else 	
			cvo.setImage( multi.getFilesystemName("image") );
			    
			    AdminDao adao = AdminDao.getInstance();
			    adao.updateColor(cvo);
			    url = url + "&cseq=" + cseq;
			    // 추가 : pms
			    request.setAttribute("ColorVO", cvo);
			}
			request.getRequestDispatcher(url).forward(request, response);
	}
	}

