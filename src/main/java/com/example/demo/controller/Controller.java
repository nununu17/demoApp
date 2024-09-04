package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.Service;
import com.example.demo.form.SearchForm;
import com.example.demo.model.TdsInfoEntity;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
	
	@Autowired
	private Service service;

	//コンストラクタ
	public Controller(Service service){
		this.service = service;
	}
	
	@GetMapping("/admin")
	public String adminTop() {
		return "/admin/top";
	}
	
	@GetMapping("/admin/showAll")
	public String showAllInfo(Model model) {
		
		model.addAttribute("title", "all data in tds_info");
		
		List<TdsInfoEntity> allInfo = service.showAllInfo();
		model.addAttribute("allInfo", allInfo);
		
		return "/admin/allInfomation";
		
	}
	
	@GetMapping("/user")
	public String showTop(){
		return "/tds/top";
	}
	
	@GetMapping("/user/today")
	public String showToday() {
		return "/tds/planPage";
	}
	
	@GetMapping("/user/search")
	public String search(Model model) {
		
		model.addAttribute("searchForm", new SearchForm());
		
		return "/tds/searching";
	}
	
	@GetMapping("/user/search/done")
	public String searched(@ModelAttribute SearchForm form, BindingResult bindignResult,  Model model) {

		System.out.println(form);
		
		if(!model.containsAttribute("searchForm")) {
			model.addAttribute("searchForm", form);
		}
		
		model.addAttribute("resultList", service.search(form.getName(), form.getGenre(), form.getArea(), form.isHaltFlag()));
		return "tds/searched";
	}
}
