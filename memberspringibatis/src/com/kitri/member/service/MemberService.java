package com.kitri.member.service;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipDto;

public interface MemberService {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int register(MemberDetailDto memberDetailDto);
	
	MemberDto login(Map<String, String> map);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberDetailDto);
	int delete(String id);
	
}
