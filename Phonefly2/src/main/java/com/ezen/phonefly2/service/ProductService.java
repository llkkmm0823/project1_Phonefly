package com.ezen.phonefly2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMainDao;
import com.ezen.phonefly2.dao.IProductDao;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;

@Service
public class ProductService {

	@Autowired
	IProductDao pdao;
	@Autowired
	IMainDao mdao;

	public HashMap<String, Object> getProduct(int pseq) {
		
		HashMap<String, Object> result = new HashMap<>();

		ProductVO pvo = pdao.getProduct(pseq);
		List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
		pvo.setColorList(colorList);
		List<RplanVO> rplanList = pdao.getRplanList();

		result.put("productVO", pvo);
		result.put("colorList", colorList);
		result.put("rplanList", rplanList);

		return result;
	}

	public List<ProductVO> getMfcList(String mfc) {

		List<ProductVO> mfcList = pdao.getMfcList(mfc);

		for (ProductVO pvo : mfcList) {
			List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
			pvo.setColorList(colorList);
		}
		return mfcList;
	}

	public int countProductOrders(int pseq) {
        return pdao.countProductOrders(pseq);
	}

	public int countOrderById(String id, int pseq) {
        return pdao.countOrderById(id, pseq);
	}

	public ArrayList<ReviewVO> getReviews(int pseq) {
        return pdao.getReviews(pseq);
	}

}
