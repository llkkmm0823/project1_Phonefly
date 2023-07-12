package com.ezen.phonefly2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMemberDao;
import com.ezen.phonefly2.dto.MemberVO;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String id) {
		return mdao.getMember(id);
	}

	public void joinKakao(MemberVO mvo) {
		mdao.joinKakao(mvo);
	}

	public void join(MemberVO mvo) {
		mdao.join(mvo);
	}

	public void memberUpdate(MemberVO mvo) {
		mdao.memberUpdate(mvo);
	}

	public void deleteMember(String id) {
		mdao.deleteMember(id);
	}

	public MemberVO findId(String name, String phone) {
		return mdao.findId(name, phone);
	}

	public int findMember(String id, String name, String phone) {
		return mdao.findMember(id, name, phone);
	}

	public void setNewPwd(String id, String pwd) {
		mdao.setNewPwd(id, pwd);
	}

}
