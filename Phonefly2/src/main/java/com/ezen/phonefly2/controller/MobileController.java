package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.service.MainService;

@Controller
public class MobileController {

	@Autowired
	MainService ms;

	@RequestMapping("/mobileMain")
	public ModelAndView mobileMain() {
		// author : bhs
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = new HashMap<>();
		result = ms.getMainProduct();
		List<ProductVO> mainBestList = (List<ProductVO>)result.get("mainBestList");
		List<ProductVO> mainEventList = (List<ProductVO>)result.get("mainEventList");
		mav.addObject("mainBestList", mainBestList);
		mav.addObject("mainEventList", mainEventList);
		mav.setViewName("mobile/mobileMain");
		return mav;
	}

	@RequestMapping("/mobileIntro")
	public String mobileIntro() {
		return "mobile/mobileIntro";
	}
}
