package com.lightsoft.hospital.interfaces.hello.dto;

public class Account {
	
	private String userName;
	
	private String password;
	
	private int balance;
	
	public Account() {
		super();
	}

	public Account(String userName, String password, int balance) {
		super();
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password
				+ ", balance=" + balance + "]";
	}
	
}
