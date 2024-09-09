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

	public List<TdsInfoEntity> getInfo() {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM tds_info ");
		sbSql.append("ORDER BY area, id;");

		var rowMapper = BeanPropertyRowMapper.newInstance(TdsInfoEntity.class);

		log.debug(sbSql.toString());

		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}

	public List<GenreEntity> getGenre() {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM genre ");
		sbSql.append("ORDER BY num");

		var rowMapper = BeanPropertyRowMapper.newInstance(GenreEntity.class);

		log.debug(sbSql.toString());

		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}

	public List<AreaEntity> getArea() {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM area ");
		sbSql.append("ORDER BY num ");

		var rowMapper = BeanPropertyRowMapper.newInstance(AreaEntity.class);

		log.debug(sbSql.toString());

		return namedParameterJdbcTemplate.query(sbSql.toString(), rowMapper);
	}

	public int editInfo(TdsInfoEntity info) {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("UPDATE tds_info ");
		sbSql.append("SET name = :name, ");
		sbSql.append("genre = :genre, ");
		sbSql.append("area = :area ");
		sbSql.append("WHERE id = :id ");

		var paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", info.getId());
		paramSource.addValue("name", info.getName());
		paramSource.addValue("genre", info.getGenre());
		paramSource.addValue("area", info.getArea());

		return namedParameterJdbcTemplate.update(sbSql.toString(), paramSource);
	}

	public int editGenre(GenreEntity genre) {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("UPDATE genre ");
		sbSql.append("SET name = :name, ");
		sbSql.append("disp_name = :dispName ");
		sbSql.append("WHERE num = :num ");

		var paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", genre.getName());
		paramSource.addValue("dispName", genre.getDispName());
		paramSource.addValue("num", genre.getNum());

		log.debug(sbSql.toString());
		log.debug("{}", paramSource);

		return namedParameterJdbcTemplate.update(sbSql.toString(), paramSource);
	}

	public int editArea(AreaEntity area) {

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("UPDATE area ");
		sbSql.append("SET name = :name, ");
		sbSql.append("disp_name = :dispName ");
		sbSql.append("WHERE num = :num ");

		var paramSource = new MapSqlParameterSource();
		paramSource.addValue("num", area.getNum());
		paramSource.addValue("name", area.getName());
		paramSource.addValue("dispName", area.getDispName());

		log.debug(sbSql.toString());
		log.debug("{}", paramSource);

		return namedParameterJdbcTemplate.update(sbSql.toString(), paramSource);
	}

	public List<TdsInfoEntity> search(TdsInfoEntity info) {

		//parameterSourceは自動で''を結合してしまうので、
		//あらかじめ%%をname変数の前後に加えておくことであいまい検索を可能にする
		String name = "%" + info.getName() + "%";

		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT i.name name, g.disp_name genre, a.disp_name area, ");
		sbSql.append("i.halt_flag haltFlag, i.my_recommend myecommend, i.today today ");
		sbSql.append("FROM tds_info i, area a, genre g ");
		sbSql.append("WHERE ");

		if (name != "") {
			sbSql.append(" i.name LIKE :name AND ");
		}

		if (info.getGenre() != "") {
			sbSql.append(" g.name = :genre AND ");
		}
		
		if (info.getArea() != "") {
			sbSql.append(" a.name = :area AND ");
		}

		if (info.getHaltFlag() == 1) {
			sbSql.append(" halt_flag = 1 AND ");
		}
		
		if(info.getMyRecommend() == 1) {
			sbSql.append(" my_recommend = 1 AND ");
		}
		
		if(info.getToday() == 1) {
			sbSql.append(" today = 1 AND ");
		}
		
		sbSql.append("i.genre = g.num AND ");
		sbSql.append("i.area = a.num ");
		sbSql.append("ORDER BY area ASC, id ASC;");

		var rowMapper = BeanPropertyRowMapper.newInstance(TdsInfoEntity.class);

		var paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", name);
		paramSource.addValue("genre", info.getGenre());
		paramSource.addValue("area", info.getArea());

		log.debug(sbSql.toString());
		log.debug("{}", paramSource);

		return namedParameterJdbcTemplate.query(sbSql.toString(), paramSource, rowMapper);
	}

}
