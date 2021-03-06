package com.kitri.di.step08;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kitri.di.model.MemberDto;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberDaoFactory.class);
		MemberDao memberDao = context.getBean("membeDao", MemberDao.class); 
		//메소드의 이름이 bean의 이름이 됨
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId("hardkyo");
		memberDto.setName("강상국");
		
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








