package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.Service;
import com.example.demo.model.TdsInfoEntity;

@org.springframework.stereotype.Controller
@RequestMapping("/tdr/tds")
public class Controller {
	
	@Autowired
	private Service service;

	//コンストラクタ
	public Controller(Service service){
		this.service = service;
	}
	
	@GetMapping("/adminTop")
	public String adminTop() {
		return "/admin/top";
	}
	
	@GetMapping("/top")
	public String showTop(){
		return "/tds/top";
	}
	
	@GetMapping("/today")
	public String showToday() {
		return "/tds/planPage";
	}
	
	@GetMapping("/showAll")
	public String showAllInfo(Model model) {
		
		model.addAttribute("title", "all data in tds_info");
		
		List<TdsInfoEntity> allInfo = service.showAllInfo();
		model.addAttribute("allInfo", allInfo);
		
		return "/tds/allInfomation";
		
	}
}
