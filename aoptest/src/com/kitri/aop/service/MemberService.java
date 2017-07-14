package com.kitri.aop.service;

import java.util.ArrayList;
import java.util.List;

import com.kitri.aop.dao.MemberDao;
import com.kitri.aop.model.MemberDto;

public class MemberService {
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public int registerMember(MemberDto memberDto){
		System.out.println("service registerMember");
		return memberDao.registerMember(memberDto);
	}
	
	public List<MemberDto> listMember(){
		System.out.println("service ListMember");
		return memberDao.listMember();
 	}

	public MemberDto searchMember(String id) {
		System.out.println("service searchMember");
		return memberDao.searchMember(id);
	}
	
}
