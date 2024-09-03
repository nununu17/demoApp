package com.example.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TdsInfoEntity {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
