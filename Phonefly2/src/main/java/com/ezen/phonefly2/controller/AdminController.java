package com.ezen.phonefly2.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.service.AdminService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
	//관리자 로그인
	@RequestMapping("adminLogin")
	public ModelAndView admin_login(
						@RequestParam(value="workId", required=false) String workId,
						@RequestParam(value="workPwd", required=false) String workPwd, 
						HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		if( workId == null ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workId.equals("") ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workPwd == null) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}else if( workPwd.equals("")) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/admin");
			return mav;
		}	
		int result = as.workerCheck( workId, workPwd );
		
		if(result == 1) { 
	    		HttpSession session = request.getSession();
	    		session.setAttribute("workId", workId);
	    		mav.setViewName("redirect:/adminProductList");
		} else if (result == 0) {
	        	mav.addObject("message", "비밀번호를 확인하세요.");
	        	mav.setViewName("admin/admin");
		} else if (result == -1) {
	    		mav.addObject("message", "아이디를 확인하세요.");
	    		mav.setViewName("admin/admin");
		}	
		
		return mav;
	}
	
	@RequestMapping("/adminProductList")
	public ModelAndView admin_product_list( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/admin");
		else {
			HashMap<String, Object> result =  as.getAdminProductList( request );
			mav.addObject("adminproductList",  (List<ProductVO>)result.get("AdminProductList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/product/adminProductList");
			// Controller 는 Service 가 작업해서 보내준 결과들을 mav 에 잘 넣어서 목적지로 이동만 합니다.
		}
		return mav;
	}

	
	@RequestMapping("/adminMemberList")
	public ModelAndView adminMemberList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getMemberList(request);
	        mav.addObject("memberList", (List<MemberVO>) result.get("memberList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/member/adminMemberList");
	    }
	    return mav;
	}
	
	
	@RequestMapping("/adminQnaList")
	public ModelAndView admin_Qna_List( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/admin");
		else {
			HashMap<String, Object> result =  as.getQnaList( request );
			mav.addObject("qnaList",  (List<QnaVO>)result.get("qnaList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/qna/adminQnaList");
			// Controller 는 Service 가 작업해서 보내준 결과들을 mav 에 잘 넣어서 목적지로 이동만 합니다.
		}
		return mav;
	}

	@RequestMapping("/adminNoticeList")
	public ModelAndView adminNoticeList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getNoticeList(request);
	        mav.addObject("noticeList", (List<NoticeVO>) result.get("noticeList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/notice/adminNoticeList");
	    }
	    return mav;
	}

	
	@RequestMapping("/adminEventList")
	public ModelAndView adminEventList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getEventList(request);
	        mav.addObject("eventList", (List<EventVO>) result.get("eventList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/event/adminEventList");
	    }
	    return mav;
	}

	
	@RequestMapping("/adminOrderList")
	public ModelAndView adminOrderList(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView();
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("workId");
	    if (id == null) {
	        mav.setViewName("redirect:/admin");
	    } else {
	        HashMap<String, Object> result = as.getOrderList(request);
	        mav.addObject("orderList", (List<OrderDetailVO>) result.get("orderList"));
	        mav.addObject("paging", (Paging) result.get("paging"));
	        mav.addObject("key", (String) result.get("key"));
	        mav.setViewName("admin/order/adminOrderList");
	    }
	    return mav;
	}
	
	@RequestMapping("/adminBannerList")
	public ModelAndView adminBannerList( ) {
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("bannerList", as.getBannerList() );
		mav.setViewName("admin/banner/adminBannerList");
		
		return mav;
	}
	
	@RequestMapping("/newBannerWrite")
	public String newBannerWrite() {
		return "admin/banner/adminBannerWrite";
	}
	
	
	@RequestMapping("adminBannerWrite" )
	public String adminBannerWrite(  @ModelAttribute BannerVO bannervo, Model model, HttpServletRequest request	) {
		String url = "admin/banner/adminBannerWrite";
		
		if( bannervo.getSubject()==null ) {
			model.addAttribute("message","제목을 입력하세요" );
		}else if(bannervo.getImage()==null)
			model.addAttribute("message", "이미지를 추가하세요" );
		
		if( bannervo.getOrder_seq() == 6 ) bannervo.setUseyn("N");
		else bannervo.setUseyn("Y");
		
		as.insertBanner( bannervo );
			
		return "redirect:/adminBannerList";
		}

	@RequestMapping("/change_order")
	public String change_order(
			HttpServletRequest request,
			@RequestParam("bseq") int bseq,
			@RequestParam("changeval") int changeval  	) {
		
		String useyn;
		if( changeval > 5) useyn="N";
		else useyn="Y";
		
		as.updateSeq( changeval, useyn, bseq);
		
		return "redirect:/adminBannerList";
	}
	
	@RequestMapping("bannerDelete")
	public String bannerDelete(Model model, HttpServletRequest request) {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		as.deleteBanner(bseq);	
		return "redirect:/adminBannerList";
	}
	
	@RequestMapping("/updateBanner")
	public String updateBanner(
			HttpServletRequest request,BannerVO bannervo) {
		
		String useyn;
		if( bannervo.getOrder_seq() > 5) useyn="N";
		else useyn="Y";
		
		as.updateSeq( bannervo.getOrder_seq(), useyn, bannervo.getBseq());
		
		return "redirect:/adminBannerList";
	} 
	
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="fileup", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> fileup( 
			@RequestParam("fileimage") MultipartFile file,
			HttpServletRequest request, Model model	) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String path = context.getRealPath("/images/productImage");	
		Calendar today = Calendar.getInstance();
 		long t = today.getTimeInMillis();
 		String filename = file.getOriginalFilename(); // 파일이름 추출
 		String fn1 = filename.substring(0, filename.indexOf(".") );  // 파일이름과 확장장 분리
 		String fn2 = filename.substring(filename.indexOf(".")+1 );
 		
 		if (!file.isEmpty()) {   // 업로드할 파일이 존재한다면
            String uploadPath = path + "/" + fn1 + t +  "." + fn2;
            System.out.println("파일 저장 경로 = " + uploadPath);
            try {
				file.transferTo( new File(uploadPath) );
			} catch (IllegalStateException e) { e.printStackTrace();
			} catch (IOException e) { e.printStackTrace();
			}
 		}
		result.put("STATUS", 1);
		result.put("FILENAME", fn1 + t +  "." + fn2 );
		return result;
	}
	
}
