package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NoticeVO {
	private int nseq;
	private String id;
	private String subject;
	private String content;
	private Timestamp indate;
}
