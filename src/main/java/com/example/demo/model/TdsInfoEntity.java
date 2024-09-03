package com.example.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

@EntityScan
@Data
public class TdsInfoEntity {

	private Integer id;

	private String name;
	
	private String genre;
	
	private String area;
	
	private int today;
	
	private int haltFlag;
	
	private int myRecommendation;

}
