package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.dao.IAdminDao;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class AdminService {
	@Autowired
	IAdminDao adao;

	public int workerCheck(String workId, String workPwd) {
			
		System.out.println("id : " + workId);
		String pwd = adao.getPwd( workId );
		System.out.println("pwd : " + pwd);
		int result=0;
			
		if(pwd == null) result = -1;   // 아이디가 없습니다
		else if( workPwd.equals(pwd)) result =  1;   // 정상 로그인
		else if( !workPwd.equals(pwd)) result =  0;  // 비번이 틀립니다
			
		return result;
		
	}


	public HashMap<String, Object> getAdminProductList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		// 다른 메뉴에서 현재 메뉴로 이동했을때, 세션에 저장된 page와 key 값을 모두 삭제합니다
		if( request.getParameter("first")!=null ) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}
		
		// 현재 페이지를 설정합니다.  파라미터로 전달된 값의 유무에 따라  이동할 페이지를 결정합니다.
		// 파라미터로 전달된 페이지가 있다면 그 페이지로, 
		// 파라미터에 전달된 페이지가 없다면 세션에 저장된 페이지로, 
		// 세션에 저장된 페이지도 없다면 1페이지로 이동합니다.
		int page = 1;
		if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}
		
		// 페이지와 비슷한 방식으로 검색어(key)도 설정합니다
		String key = "";
		if( request.getParameter("key") != null ) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if( session.getAttribute("key")!= null ) {
			key = (String)session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		} 
		
		// Paging 객체를 설정합니다
		Paging paging = new Paging();
		paging.setPage(page);
		
		int count = adao.getAllCount( "product", "name", key );
		paging.setTotalCount(count);
		paging.paging();
		
		List<ProductVO> productList = adao.listProduct( paging , key );
		result.put("AdminProductList" , productList);
		result.put("paging", paging);
		result.put("key", key);
		
		return result;
	}


	public HashMap<String, Object> getMemberList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
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

	    // 회원 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("member", "name", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    // 페이징 처리된 회원 목록을 가져옵니다.
	    List<MemberVO> list = adao.listMember(paging, key);
	    result.put("memberList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}

	public HashMap<String, Object> getQnaList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if( request.getParameter("first")!=null ) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}		
		int page = 1;
		if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}
		String key = "";
		if( request.getParameter("key") != null ) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if( session.getAttribute("key")!= null ) {
			key = (String)session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		} 
		Paging paging = new Paging();
		paging.setPage(page);		
		int count = adao.getAllCount( "qna", "subject", key );
		paging.setTotalCount(count);
		paging.paging();	
		
		List<QnaVO> list = adao.listQna( paging , key );
		result.put("qnaList" , list);
		result.put("paging", paging);
		result.put("key", key);
	
		return result;
	
}

	public HashMap<String, Object> getNoticeList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();
	    
	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
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
	    
	    // 공지사항 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("notice", "subject", key);
	    paging.setTotalCount(count);
	    paging.paging();
	    
	    // 페이징 처리된 공지사항 목록을 가져옵니다.
	    List<NoticeVO> list = adao.listNotice(paging, key);
	    result.put("noticeList", list);
	    result.put("paging", paging);
	    result.put("key", key);
	    
	    return result;
	}


	public HashMap<String, Object> getEventList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
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

	    // 이벤트 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("event", "subject", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    // 페이징 처리된 이벤트 목록을 가져옵니다.
	    List<EventVO> list = adao.listEvent(paging, key);
	    result.put("eventList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}


	public HashMap<String, Object> getOrderList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
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

	    // 주문 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("ORDER_DETAIL_VIEW2", "id", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    // 페이징 처리된 주문 목록을 가져옵니다.
	    List<OrderDetailVO> list = adao.listOrder(paging, key);
	    result.put("orderList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}

	
	public Object getBannerList() {
		return adao.getBannerList();
	}

	public void insertBanner(BannerVO bannervo) {
		adao.insertBanner( bannervo );	
	}
	
	public void updateSeq(int changeval, String useyn, int bseq) {
		adao.updateSeq( changeval, useyn, bseq);		
	}


	public void deleteBanner(int bseq) {
		adao.deleteBanner(bseq);
		
	}


	


	
	
}
