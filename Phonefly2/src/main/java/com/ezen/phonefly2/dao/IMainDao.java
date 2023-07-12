package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;

@Mapper
public interface IMainDao {
	// author : bhs
	List<ProductVO> getBestList();
	List<ProductVO> getEventList();
	List<ColorVO> getColorList(int pseq);
}
