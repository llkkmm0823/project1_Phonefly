package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QnaVO {
	private int qseq;
	private String id;
	private String subject;
	private String content;
	private String reply;
	private String rep;
	private Timestamp indate;
}
