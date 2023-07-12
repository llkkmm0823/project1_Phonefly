package com.ezen.phonefly2.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.MemberVO;

@Mapper
public interface IMemberDao {

	MemberVO getMember(String id);
	void joinKakao(MemberVO mvo);
	void join(MemberVO mvo);
	void memberUpdate(MemberVO mvo);
	void deleteMember(String id);
	MemberVO findId(String name, String phone);
	int findMember(String id, String name, String phone);
	void setNewPwd(String id, String pwd);

}
