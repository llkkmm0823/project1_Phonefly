package pf.controller.action.admin.board.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pf.controller.action.Action;

public class AdminNoticeInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp=request.getRequestDispatcher("admin/notice/adminNoticeInsertForm.jsp");
		dp.forward(request, response);

	}

}
