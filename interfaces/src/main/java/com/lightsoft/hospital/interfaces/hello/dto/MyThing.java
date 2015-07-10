package com.lightsoft.hospital.interfaces.hello.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyThing {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyThing [name=" + name + "]";
	}
	
}