package com.lightsoft.hospital.interfaces.hello.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String name;
	
	private String phone;
	
	private String sex;
	
	private String address;
	
	private Account account;
	
	public User(String name, String phone, String sex, String address,
			Account account) {
		super();
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.address = address;
		this.account = account;
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
