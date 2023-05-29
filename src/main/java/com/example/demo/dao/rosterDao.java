package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class rosterDao {
	private final JdbcTemplate db;

	@Autowired
	public rosterDao(JdbcTemplate db) {
		this.db = db;
	}

	public List<EntForm> selectOne(Long id) {

		//データベースから目的の1件を取り出す
		List<Map<String, Object>> resultDb1 = db.queryForList("");

		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntForm> resultDb2 = new ArrayList<EntForm>();


		//Controllerに渡す
		return resultDb2;
	}
}
