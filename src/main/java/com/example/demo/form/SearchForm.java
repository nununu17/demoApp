package com.example.demo.form;

import lombok.Data;

@Data
public class SearchForm {
	
	private int id;
	
	private String name;
	
	private String genre;
	
	private String area;
	
	private boolean haltFlag;
	
	private boolean myRecommend;
	
	private boolean today;

}
