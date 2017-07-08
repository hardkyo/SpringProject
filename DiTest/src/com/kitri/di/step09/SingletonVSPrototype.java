package com.kitri.di.step09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kitri.di.step08.*;

public class SingletonVSPrototype {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberDaoFactory.class);
		MemberDao m1 = context.getBean("membeDao", MemberDao.class);
		MemberDao m2 = context.getBean("mdao", MemberDao.class);
		System.out.println("m1 : " + m1);
		System.out.println("m2 : " + m2);
		//싱글톤
		
		MemberDao m3 = new MemberDao(new OraDBConnection());
		MemberDao m4 = new MemberDao(new OraDBConnection());
		System.out.println("m3 : " + m3);
		System.out.println("m4 : " + m4);
		//prototype
	}
	
}









