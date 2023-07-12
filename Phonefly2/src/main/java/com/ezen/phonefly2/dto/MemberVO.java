package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String zipnum;
	private String address1;
	private String address2;
	private String address3;
	private String phone;
	private String useyn;
	private String provider;
}
