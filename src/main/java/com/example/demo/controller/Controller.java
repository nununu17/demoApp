package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.example.demo.Service.Service;
import com.example.demo.form.AreaEditForm;
import com.example.demo.form.GenreEditForm;
import com.example.demo.form.InfoEditForm;
import com.example.demo.form.SearchForm;

import jakarta.validation.Valid;

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
	public String editInfo(Model model) {

		if (!model.containsAttribute(BindingResult.MODEL_KEY_PREFIX + "infoEditForm")) {
			model.addAttribute("infoEditForm", new InfoEditForm());
		}
		
		return "/admin/edit/editInfo";
	}

	@PostMapping("/admin/edited/info")
	public String editedInfo(@ModelAttribute @Valid InfoEditForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute(
					BindingResult.MODEL_KEY_PREFIX + "infoEditForm", bindingResult);
			redirectAttributes.addFlashAttribute("infoEditForm", form);

			return "redirect:/admin/edit/info";
		}

		model.addAttribute("edited", service.editInfo(form.getId(), form.getName(), form.getGenre(), form.getArea()));

		this.showInfo(model);

		return "/admin/show/showInfo";
	}

	@GetMapping("/admin/edit/genre")
	public String editGenre(Model model) {
		
		if (!model.containsAttribute(BindingResult.MODEL_KEY_PREFIX + "genreEditForm")) {
			model.addAttribute("genreEditForm", new GenreEditForm());
		}

		//model.addAttribute("genre", service.getGenre());

		return "/admin/edit/editGenre";
	}

	@PostMapping("/admin/edited/genre")
	public String editedGenre(@Valid @ModelAttribute GenreEditForm form, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute(
					BindingResult.MODEL_KEY_PREFIX + "genreEditForm", bindingResult);
			redirectAttributes.addFlashAttribute("genreEditForm", form);

			return "redirect:/admin/edit/genre";
		}

		model.addAttribute("edited", service.editGenre(form.getNum(), form.getName(), form.getDispName()));

		this.showGenre(model);

		return "/admin/show/showGenre";
	}

	@GetMapping("/admin/edit/area")
	public String editArea(Model model) {
		//@modelAttributeは自動でaddAttribute=初期化してしまうので
		//ここで引数に指定しているとflashAttributeが上書きされます。。。。
		//解消にありえん時間かかったぞ、、、、

		if (!model.containsAttribute(BindingResult.MODEL_KEY_PREFIX + "areaEditForm")) {
			model.addAttribute("areaEditForm", new AreaEditForm());
		}

		return "/admin/edit/editArea";
	}

	@PostMapping("/admin/edited/area")
	public String editedArea(@Valid @ModelAttribute AreaEditForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		if (bindingResult.hasErrors()) {

			redirectAttributes.addFlashAttribute(
					BindingResult.MODEL_KEY_PREFIX + "areaEditForm", bindingResult);
			redirectAttributes.addFlashAttribute("areaEditForm", form);

			return "redirect:/admin/edit/area";
		}

		model.addAttribute("edited",
				service.editArea(form.getNum(), form.getName(), form.getDispName()));

		this.showArea(model);

		return "/admin/show/showArea";
	}

@GetMapping("/user")
	public String userTop(Model model) {

		//		model.addAttribute("food", service.getFood());
		//		model.addAttribute("show", service.getShow());
		//		model.addAttribute("attract", service.getAttract());
		//		model.addAttribute("shop", service.getShop());
		//		model.addAttribute("greet", service.getGreet());

		return "/user/top";
	}

	@GetMapping("/user/today")
	public String today(Model model) {

		model.addAttribute("today", service.getToday());
		model.addAttribute("recommend", service.getRecommend());

		return "/user/today0908";
	}

	@GetMapping("/user/search")
	public String search(Model model) {

		model.addAttribute("searchForm", new SearchForm());

		return "/user/searching";
	}

	@GetMapping("/user/search/done")
	public String searched(@ModelAttribute SearchForm form, BindingResult bindignResult, Model model) {

		model.addAttribute("resultList",
				service.search(
						form.getName(), form.getGenre(), form.getArea(), form.isHaltFlag(), form.isMyRecommend(), form.isToday()));
		
		model.addAttribute(model.addAttribute("terms", form));
		
		return "/user/searched";
	}

}
