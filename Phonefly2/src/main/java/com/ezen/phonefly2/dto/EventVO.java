package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EventVO {
	private int eseq;
	private String id;
	private String subject;
	private String image;
	private Timestamp indate;
}
