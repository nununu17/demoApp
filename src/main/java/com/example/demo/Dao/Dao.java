package com.example.demo.Dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AreaEntity;
import com.example.demo.model.GenreEntity;
import com.example.demo.model.TdsInfoEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Dao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<TdsInfoEntity> showInfo() {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM tds_info ");
		sbSql.append("ORDER BY area, id;");

		var rowMapper = BeanPropertyRowMapper.newInstance(TdsInfoEntity.class);

		log.debug(sbSql.toString());

		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}
	
	public List<GenreEntity> showGenre(){
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM genre ");
		
		var rowMapper = BeanPropertyRowMapper.newInstance(GenreEntity.class);
		
		log.debug(sbSql.toString());
		
		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}
	
	public List<AreaEntity> showArea(){
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM area ");
		
		var rowMapper = BeanPropertyRowMapper.newInstance(AreaEntity.class);
		
		log.debug(sbSql.toString());
		
		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}

	public List<TdsInfoEntity> search(String name, String genre, String area, boolean isHaltFlag) {
		
		//parameterSourceは自動で''を結合してしまうので、
		//あらかじめ%%をname変数の前後に加えておくことであいまい検索を可能にする
		name = "%" + name + "%";
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT i.name name, g.disp_name genre, a.disp_name area ");
		sbSql.append("FROM tds_info i ");
		sbSql.append("LEFT OUTER JOIN genre g ON i.genre = g.num ");
		sbSql.append("LEFT OUTER JOIN area a ON i.area = a.num ");
		
		if(name != "") {
			sbSql.append("WHERE i.name LIKE :name ");
			if(genre != "") {
				sbSql.append("and g.name = :genre ");
				if(area != "") {
					sbSql.append("and a.name = :area ");
				}
			}
			if(area != "") {
				sbSql.append("and a.name = :area ");
			}
		}else if(genre != "") {
			sbSql.append("WHERE g.name = :genre ");
			if(area != "") {
				sbSql.append("and a.name = :area ");
			}
		}else if(area != "") {
			sbSql.append("WHERE a.name = :area ");
		}
		
		if(isHaltFlag) {
			sbSql.append("WHERE halt_flag = 1 ");
		}
		
		sbSql.append("ORDER BY area ASC, id ASC;");
		
		var rowMapper = BeanPropertyRowMapper.newInstance(TdsInfoEntity.class);

		var paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", name);
		paramSource.addValue("genre", genre);
		paramSource.addValue("area", area);

		log.debug(sbSql.toString());
		log.debug("{}", paramSource);

		return namedParameterJdbcTemplate.query(sbSql.toString(), paramSource, rowMapper);
	}

}
