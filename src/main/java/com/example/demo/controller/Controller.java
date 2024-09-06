package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.example.demo.Service.Service;
import com.example.demo.form.AreaEditForm;
import com.example.demo.form.GenreEditForm;
import com.example.demo.form.InfoEditForm;
import com.example.demo.form.SearchForm;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {

	private static final String REDIRECT_URL_FORMAT = UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/%s";

	@Autowired
	private Service service;

	//コンストラクタ
	public Controller(Service service) {
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

		model.addAttribute("info", service.getInfo());

		return "/admin/show/showInfo";
	}

	@GetMapping("/admin/show/genre")
	public String showGenre(Model model) {

		model.addAttribute("title", "ジャンル情報");

		model.addAttribute("genre", service.getGenre());

		return "/admin/show/showGenre";
	}

	@GetMapping("/admin/show/area")
	public String showArea(Model model) {

		model.addAttribute("title", "エリア情報");

		model.addAttribute("area", service.getArea());

		return "/admin/show/showArea";
	}

	@GetMapping("/admin/edit")
	public String edit() {
		return "/admin/edit/editTop";
	}

	@GetMapping("/admin/edit/info")
	public String editInfo(@ModelAttribute InfoEditForm form, Model model) {
		
		model.addAttribute("infoEditForm", form);
		
		return "/admin/edit/editInfo";
	}

	@PostMapping("/admin/edited/info")
	public String editedInfo(@ModelAttribute InfoEditForm form, Model model) {
		
		if(!model.containsAttribute("infoEditForm")) {
			model.addAttribute("infoEditForm", form);
		}
		
		model.addAttribute("edited", service.editInfo(form.getId(), form.getName(), form.getGenre(), form.getArea()));
		
		this.showInfo(model);
		
		return "/admin/show/showInfo";
	}
	
	@GetMapping("/admin/edit/genre")
	public String editGenre(@ModelAttribute GenreEditForm form, Model model) {
		
		model.addAttribute("genreEditForm", form);

		return "/admin/edit/editGenre";
	}
	
	@PostMapping("/admin/edited/genre")
	public String editedGenre(@ModelAttribute GenreEditForm form, Model model) {
		
		if(!model.containsAttribute("genreEditForm")) {
			model.addAttribute("genreEditForm", form);
		}
		
		model.addAttribute("edited", service.editGenre(form.getNum(), form.getName(), form.getDispName()));
		
		this.showGenre(model);
		
		return "/admin/show/showGenre";
	}
	
	@GetMapping("/admin/edit/area")
	public String editArea(@ModelAttribute AreaEditForm form, Model model) {

		model.addAttribute("areaEditForm", form);

		return "/admin/edit/editArea";
	}

	@PostMapping("/admin/edited/area")
	public String editedArea(@ModelAttribute AreaEditForm form, Model model, BindingResult bindingResult) {

		if (!model.containsAttribute("areaEditForm")) {
			model.addAttribute("areaEditForm", form);
		}

		//		if(bindingResult.hasErrors()) {
		//			
		//			redirectAttributes.addFlashAttribute(
		//					bindingResult.MODEL_KEY_PREFIX + "areaEditForm",bindingResult);
		//			redirectAttributes.addFlashAttribute("areaEditForm", form);
		//			
		//			return String.format(REDIRECT_URL_FORMAT, "/admin/edited/area");
		//		}

		model.addAttribute("edited", service.editArea(form.getNum(), form.getName(), form.getDispName()));

		this.showArea(model);

		return "/admin/show/showArea";
	}

	@GetMapping("/user")
	public String userTop() {
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
	public String searched(@ModelAttribute SearchForm form, BindingResult bindignResult, Model model) {

		if (!model.containsAttribute("searchForm")) {
			model.addAttribute("searchForm", form);
		}

		model.addAttribute("resultList",
				service.search(form.getName(), form.getGenre(), form.getArea(), form.isHaltFlag()));
		return "tds/searched";
	}

}
