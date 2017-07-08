package com.kitri.di.step04;

import java.util.List;

import com.kitri.di.model.MemberDto;

public class MemberMain {

	public static void main(String[] args) {
//		MemberDao memberDao = new MsMemberDao();
		MemberDao memberDao = new MemberDao();
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId("hardkyo2");
		memberDto.setName("강상국2");
		
		int cnt = memberDao.register(memberDto);
		System.out.println("유저 등록 " + (cnt != 0 ? "성공!!!" : "실패!!!"));
		
		List<MemberDto> list = memberDao.getList();
		System.out.println("아이디\t이름\t가입일");
		System.out.println("--------------------------------");
		for (MemberDto memberDto2 : list) {
			System.out.println(memberDto2.getId() + "\t" + memberDto2.getName() + "\t" + memberDto2.getJoindate());
		}
	}
	
}








