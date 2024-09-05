package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.Service;
import com.example.demo.form.SearchForm;

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
	
	@GetMapping("/admin/show")
	public String show() {
		return "/admin/show/showTop";
	}
	
	@GetMapping("/admin/show/info")
	public String showInfo(Model model) {
		
		model.addAttribute("title", "パーク情報");
		
		model.addAttribute("info", service.showInfo());
		
		return "/admin/show/showInfo";
	}
	
	@GetMapping("/admin/show/genre")
	public String showGenre(Model model) {
		
		model.addAttribute("title", "ジャンル情報");
		
		model.addAttribute("genre", service.showGenre());

		return "/admin/show/showGenre";
	}
	
	@GetMapping("/admin/show/area")
	public String showArea(Model model) {
		
		model.addAttribute("title", "エリア情報");
		
		model.addAttribute("area", service.showArea());
		
		return "/admin/show/showArea";
	}
	
	@GetMapping("/admin/edit")
	public String edit() {
		return "/admin/edit/editTop";
	}
	
	@GetMapping("/admin/edit/info")
	public String editInfo() {
		return "/admin/edit/editInfo";
	}
	
	@GetMapping("/admin/edit/genre")
	public String editGenre() {
		
		return "/admin/edit/editGenre";
	}

	@GetMapping("/admin/edit/area")
	public String editArea() {
		return "/admin/edit/editArea";
	}
	
	@GetMapping("/user")
	public String userTop(){
		return "/tds/top";
	}
	
	@GetMapping("/user/today")
	public String today() {
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
