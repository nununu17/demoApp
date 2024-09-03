package com.example.demo.Dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TdsInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//private KeyHolderFactoryBean keyHolderFactoryBean;
	
	public Dao(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<TdsInfoEntity> showAllInfo() {
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM tds_info");
		
		var rowMapper = BeanPropertyRowMapper.newInstance(TdsInfoEntity.class);
		
		log.debug(sbSql.toString());
		
		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}

}
