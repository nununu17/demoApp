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
	
	public List<TdsInfoEntity> getInfo(){
		return dao.getInfo();
	}

	public List<GenreEntity> getGenre(){
		return dao.getGenre();
	}
	
	public List<AreaEntity> getArea(){
		return dao.getArea();
	}
	
	@Transactional
	public int editInfo(int id, String name, int genre, int area) {
		
		TdsInfoEntity info = new TdsInfoEntity();
		info.setId(id);
		info.setName(name);
		info.setGenreNum(genre);
		info.setAreaNum(area);
		
		return dao.editInfo(info);
	}
	
	@Transactional
	public int editGenre(int num, String name, String dispName) {
		
		GenreEntity genre = new GenreEntity();
		genre.setNum(num);
		genre.setName(name);
		genre.setDispName(dispName);
		
		return dao.editGenre(genre);
	}
	
	@Transactional
	public int editArea(int num, String name, String dispName) {
		
		AreaEntity area = new AreaEntity();
		area.setNum(num);
		area.setName(name);
		area.setDispName(dispName);
		
		return dao.editArea(area);
	}
	
	public List<TdsInfoEntity> search(String name, String genre, String area, boolean isHaltFlag, boolean isMyRecomendation, boolean isToday){
		
		TdsInfoEntity info = new TdsInfoEntity();
		info.setName(name);
		info.setGenre(genre);
		info.setArea(area);
		info.setHaltFlag(isHaltFlag ? 1 : 0);
		info.setMyRecommend(isMyRecomendation ? 1 : 0);
		info.setToday(isToday ? 1 : 0);
		
		return dao.search(info);
	}
}
