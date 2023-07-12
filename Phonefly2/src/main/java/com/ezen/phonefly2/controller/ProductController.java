package com.ezen.phonefly2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;
import com.ezen.phonefly2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;

	@RequestMapping("/productDetail")
	public ModelAndView productDetail(@RequestParam("pseq") int pseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = ps.getProduct(pseq);

		ProductVO pvo = (ProductVO) result.get("productVO");
		List<ColorVO> colorList = (List<ColorVO>) result.get("colorList");
		List<RplanVO> rplanList = (List<RplanVO>) result.get("rplanList");

		mav.addObject("productVO", pvo);
		mav.addObject("colorList", colorList);
		mav.addObject("rplanVO", rplanList);

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int countOrderPseq = ps.countProductOrders(pseq);
		int countOrderById = 0;
		if (mvo != null) {
			countOrderById = ps.countOrderById(mvo.getId(), pseq);
		}
		if (countOrderPseq > 0) {
			ArrayList<ReviewVO> reviewList = ps.getReviews(pseq);
			mav.addObject("reviewList", reviewList);
		}

		mav.addObject("countOrderById", countOrderById);
		mav.addObject("countOrderPseq", countOrderPseq);
		mav.setViewName("product/productDetail");

		return mav;

	}

	@RequestMapping("/productList")
	public ModelAndView productList(@RequestParam("mfc") String mfc) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", ps.getMfcList(mfc));
		mav.setViewName("product/productList");
		return mav;
	}

	@RequestMapping("/productCompare")
	public ModelAndView productCompare(@RequestParam("pseq") int[] pseqArr) {
		ModelAndView mav = new ModelAndView();

		for (int pseq : pseqArr) {
			HashMap<String, Object> result = ps.getProduct(pseq);
			ProductVO pvo = (ProductVO) result.get("productVO");

			mav.addObject("productList", pvo);
		}

		mav.setViewName("product/productCompare");
		return mav;
	}

}
