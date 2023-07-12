package com.ezen.phonefly2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	private int pseq;
	private String name;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String useyn;
	private String eventyn;
	private String bestyn;
	private Timestamp indate;
	private String mfc;
	private List<ColorVO> colorList;
}
