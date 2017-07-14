package com.kitri.aop.controller;

import java.util.ArrayList;
import java.util.List;

import com.kitri.aop.model.MemberDto;
import com.kitri.aop.service.MemberService;

public class MemberController {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	//Di Setter 이용
	

	public int registerMember(){
		System.out.println("controller registerMember");
		MemberDto memberDto = new MemberDto();
		memberDto.setId("hardkyo6");
		memberDto.setName("상국6");
		
		return memberService.registerMember(memberDto);
	}
	
	public List<MemberDto> listMember(){
		System.out.println("controller ListMember");
		return memberService.listMember();
 	}
	
	public MemberDto searchMember(String id){
		System.out.println("controller searchMember");
		return memberService.searchMember(id);
	}
	
}
