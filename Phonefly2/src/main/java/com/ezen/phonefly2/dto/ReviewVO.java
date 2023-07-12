package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReviewVO {
	private int rvseq;
	private String id;
	private String subject;
	private String content;
	private Timestamp indate;
	private int pseq;
	private String name;
	private String pname;
}
