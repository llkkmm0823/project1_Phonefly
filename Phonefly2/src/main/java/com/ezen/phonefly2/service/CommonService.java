package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.ICommonDao;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class CommonService {
	// 수정 : bhs, 그냥 붙어넣기 하지마시고 필요한 요소 인지 파악하고 붙여 넣으세요.
	
	@Autowired
	ICommonDao cdao;

//---NOTICE-----------------------------------------------------

	public HashMap<String, Object> getNoticeList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		/*
		if (request.getParameter("first") != null) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if (session.getAttribute("page") != null) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}

		String key = "";
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if (session.getAttribute("key") != null) {
			key = (String) session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		}

		Paging paging = new Paging();
		paging.setPage(page);

		int count = cdao.getAllCount("notice", "subject", key);
		paging.setTotalCount(count);
		paging.paging();

		List<NoticeVO> noticeList = cdao.getNoticeList(paging, key);
		result.put("noticeList", noticeList);
		result.put("paging", paging);
		result.put("key", key);
		*/
		return result;
	}

	public NoticeVO getNotice(int nseq) {
		return cdao.getNotice(nseq);
	}

//---EVENT-----------------------------------------------------

	public HashMap<String, Object> getEventList(HttpServletRequest request) {

		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		/*
		if (request.getParameter("first") != null) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if (session.getAttribute("page") != null) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}

		String key = "";
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if (session.getAttribute("key") != null) {
			key = (String) session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		}

		Paging paging = new Paging();
		paging.setPage(page);

		int count = cdao.getAllCount("event", "subject", key);
		paging.setTotalCount(count);
		paging.paging();

		List<EventVO> eventList = cdao.getEventList(paging, key);
		result.put("eventList", eventList);
		result.put("paging", paging);
		result.put("key", key);
		*/

		return result;
	}

	public EventVO getEvent(int eseq) {
		return cdao.getEvent(eseq);
	}

}
