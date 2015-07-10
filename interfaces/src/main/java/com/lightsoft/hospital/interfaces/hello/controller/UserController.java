package com.lightsoft.hospital.interfaces.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lightsoft.hospital.interfaces.hello.dto.Account;
import com.lightsoft.hospital.interfaces.hello.dto.User;

@RestController
@RequestMapping("api")
public class UserController {

	@RequestMapping("userInfo")
	public User userInfo() {
		Account account = new Account("account", "password", 20);
		User user = new User("张三", "13333333333", "男", "中南海", account);
		return user;
	}

}
