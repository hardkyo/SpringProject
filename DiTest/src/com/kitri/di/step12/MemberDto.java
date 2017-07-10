package com.kitri.di.step12;

public class MemberDto {
	
	private String id;
	private String name;
	private double money;
	private int age;
	private AddressDto addressDto;
	
	public MemberDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public MemberDto(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}

	public MemberDto(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}
	public MemberDto(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public MemberDto(String id, String name, double money, int age) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.age = age;
	}
	public MemberDto(String id, String name, double money, int age, AddressDto addressDto) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.age = age;
		this.addressDto = addressDto;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t아이디 : " + id + "\t나이" 
					+ age + "\t재산 : " + money + "\n주소 : " + addressDto;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public MemberDto() {}
	
	
	
	
}
