package com.ezen.phonefly2.dto;


import lombok.Data;

@Data
public class RplanVO {
	private int rseq;
	private int mseq;
	private String name;
	private int charge;
	private String dataplan;
	private String timeplan;
	private String textplan;
}
