package com.example.demo.form;

import lombok.Data;

@Data
public class InfoEditForm {
	
	private int id;
	
	private String name;
	
	private int genre;
	
	private int area;
	
	private boolean haltFlag;
	
	private boolean myRecommendation;
	
	private boolean today;

}
