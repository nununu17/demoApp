package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.Service;
import com.example.demo.form.SearchForm;
import com.example.demo.model.TdsInfoEntity;

@RequestMapping("/user/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	Service service;
	
	public RestController(Service service) {
		this.service = service;
	}
	
	@GetMapping("/search")
	public List<TdsInfoEntity> searchByApi (SearchForm form, BindingResult bindingResult) throws BindException{

		List<TdsInfoEntity> result = new ArrayList<>();
		
		if(bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}else {
			//var resultList = service.search(form.getGenre());
//			for(TdsInfoEntity entity: resultList) {
//				result.add(entity);
//			}
		}
		
		return result;
	}

}
