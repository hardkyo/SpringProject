package com.kitri.di.step12;

public class AddressDto {
	
	private String zipcode;
	private String address;
	private String addressDetail;
	public AddressDto(String zipcode, String address, String addressDetail) {
		super();
		this.zipcode = zipcode;
		this.address = address;
		this.addressDetail = addressDetail;
	}
	
	@Override
	public String toString() {
		return zipcode + ""	+ address + "" + addressDetail;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public AddressDto() {}
	
	
	
}
