package com.example.demo.form;

import lombok.Data;

@Data
public class SearchForm {
	
	private String name;
	
	private String genre;
	
	private String area;
	
	private boolean haltFlag;
	
	private boolean myRecommendation;
	
	private boolean today;

}
