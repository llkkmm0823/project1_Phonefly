package pf.controller.action.admin.board.event;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pf.controller.action.Action;
import pf.dao.EventDao;
import pf.dto.AdminVO;
import pf.dto.EventVO;

public class AdminEventUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "pf.do?command=adminEventDetail";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "pf.do?command=admin"; 
		} else {
			System.out.println("process .... adminEvnetUpdate");
			EventVO evo = new EventVO();
			ServletContext context = session.getServletContext();
			// 수정 : bhs
			//String path = context.getRealPath("image");
			String path = context.getRealPath("images/event");
			
			MultipartRequest multi = new MultipartRequest(
					request, 
					path, 
					5*1024*1024,  
					"UTF-8", 
					new DefaultFileRenamePolicy()
			);
			evo.setEseq(Integer.parseInt( multi.getParameter("eseq") ) );
			evo.setSubject(multi.getParameter("subject"));
			// 수정 bhs : if part
			// evo.setImage(multi.getFilesystemName("image"));
			if (multi.getFilesystemName("image") == null) {
				evo.setImage(multi.getParameter("oldImage"));
			} else {
				evo.setImage(multi.getFilesystemName("image"));
			}
			System.out.println(Integer.parseInt( multi.getParameter("eseq") ) + "" + multi.getParameter("subject"));
			EventDao adao = EventDao.getInstance();
			adao.updateEvent(evo);
			url = url + "&eseq=" + evo.getEseq();
			// 추가 bhs : request.setAttribute("eventVO", evo);
			request.setAttribute("eventVO", evo);
		}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
