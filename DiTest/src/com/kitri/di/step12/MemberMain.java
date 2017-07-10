package com.kitri.di.step12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.net.jdbc.TNSAddress.Address;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/di/step12/applicationContext.xml");
		
		MemberDto mc1 = context.getBean("mc1", MemberDto.class);
		System.out.println("----------- MemberDto1 ------------\n" + mc1);
		
		MemberDto mc2 = context.getBean("mc2", MemberDto.class);
		System.out.println("----------- MemberDto2 ------------\n" + mc2);
//		
		MemberDto mc3 = context.getBean("mc3", MemberDto.class);
		System.out.println("----------- MemberDto3 ------------\n" + mc3);
//		
//		MemberDto mc4 = context.getBean("mc4", MemberDto.class);
//		System.out.println("----------- MemberDto4 ------------\n" + mc4);
//	
//		MemberDto mc5 = context.getBean("mc5", MemberDto.class);
//		System.out.println("----------- MemberDto5 ------------\n" + mc5);
//	
//		MemberDto mc6 = context.getBean("mc6", MemberDto.class);
//		System.out.println("----------- MemberDto6 ------------\n" + mc6  );
//
		MemberDto mp1 = context.getBean("mp1", MemberDto.class);
		System.out.println("----------- MemberDto7 ------------\n" + mp1  );
//
//		MemberDto mp2 = context.getBean("mp2", MemberDto.class);
//		System.out.println("----------- MemberDto ------------\n" + mp2  );
		
		
	}
	
}
