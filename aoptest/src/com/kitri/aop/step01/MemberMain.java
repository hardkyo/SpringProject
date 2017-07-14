package com.kitri.aop.step01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.aop.controller.MemberController;
import com.kitri.aop.model.MemberDto;

public class MemberMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/aop/step01/config/a.xml");
		MemberController controller = context.getBean("mc", MemberController.class);
		int cnt = controller.registerMember();
		System.out.println("등록" + (cnt !=0 ? "성공" : "실패"));
		
		List<MemberDto> list = controller.listMember();
		System.out.println("회원목록");
		System.out.println("아이디\t이름\t가입일");
		System.out.println("---------------------------");
		for(MemberDto memberDto : list){
			System.out.print(memberDto.getId() + "\t");
			System.out.print(memberDto.getName() + "\t");
			System.out.println(memberDto.getJoindate());
		}
		
		
		MemberDto memberDto = controller.searchMember("hardkyo6");
		System.out.println("hardkyo6 회원 가입 정보");
		System.out.println("이름 : " + memberDto.getName() );
		System.out.println("아이디 : " + memberDto.getId());
		System.out.println("가입일 : " + memberDto.getJoindate());
	} 
}
