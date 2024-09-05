package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.Dao;
import com.example.demo.model.AreaEntity;
import com.example.demo.model.GenreEntity;
import com.example.demo.model.TdsInfoEntity;

@org.springframework.stereotype.Service
@Transactional
public class Service {
	
	private Dao dao;
	
	@Autowired
	public Service(Dao dao) {
		this.dao = dao;
	}
	
	public List<TdsInfoEntity> showInfo(){
		return dao.showInfo();
	}

	public List<GenreEntity> showGenre(){
		return dao.showGenre();
	}
	
	public List<AreaEntity> showArea(){
		return dao.showArea();
	}
	
	public List<TdsInfoEntity> search(String name, String genre, String area, boolean isHaltFlag){
		return dao.search(name, genre, area, isHaltFlag);
	}
}
