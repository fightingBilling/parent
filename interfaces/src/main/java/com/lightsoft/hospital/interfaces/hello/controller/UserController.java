package com.lightsoft.hospital.interfaces.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lightsoft.hospital.interfaces.hello.dto.Account;
import com.lightsoft.hospital.interfaces.hello.dto.User;

@Controller
@RequestMapping("api")
public class UserController {

	@RequestMapping("userInfo")
	public String userInfo(Model model) {
		Account account = new Account("account", "password", 20);
		User user = new User("张三", "13333333333", "男", "中南海", account);
		model.addAttribute("userInfo",user);
		model.addAttribute("myinfo",user);
		return "userInfo";
	}

}
