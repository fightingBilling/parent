package com.lightsoft.hospital.interfaces.hello.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lightsoft.hospital.interfaces.hello.dto.MyThing;

@RestController
public class MyController {
	
	private static Logger logger = Logger.getLogger(MyController.class);
	
	@RequestMapping("/thing")
	@ResponseBody
	public MyThing thing() {
		MyThing m = new MyThing();
		m.setName("hello");
		logger.info("======================nihao======================");
		return m;
	}
}
