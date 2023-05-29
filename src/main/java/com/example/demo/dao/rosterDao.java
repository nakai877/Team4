package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm2;


@Repository
public class rosterDao {
	private final JdbcTemplate db;

	@Autowired
	public rosterDao(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(EntForm2 ent) {
		db.update("INSERT INTO form (name,comment,yakusyoku,busyo,syumi) VALUES(?,?,?,?,?)", ent.getName(), ent.getComment(),ent.getYakusyoku(),ent.getBusyo(),ent.getSyumi());
	}
		//検索処理
		public List<EntForm2> searchDb() {
			String sql = "SELECT * FROM form";

			//データベースから取り出したデータをresultDB1に入れる
			List<Map<String, Object>> resultDb1 = db.queryForList(sql);

			//画面に表示しやすい形のList(resultDB2)を用意
			List<EntForm2> resultDb2 = new ArrayList<EntForm2>();

			//1件ずつピックアップ
			for (Map<String, Object> result1 : resultDb1) {

				//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
				EntForm2 entformdb = new EntForm2();

				//id、nameのデータをentformdbに移す
				entformdb.setId((int) result1.get("id"));
				entformdb.setName((String) result1.get("name"));
				entformdb.setComment((String) result1.get("comment"));
				entformdb.setYakusyoku((String) result1.get("yakusyoku"));
				entformdb.setBusyo((String) result1.get("busyo"));
				entformdb.setSyumi((String) result1.get("syumi"));


				//移し替えたデータを持ったentformdbを、resultDB2に入れる
				resultDb2.add(entformdb);
			}

			//Controllerに渡す
			return resultDb2;
		}

//		//削除(DELETE)
//		public void deleteDb(Long id) {
//			//コンソールに表示
//			System.out.println("削除しました");
//			//DBからデータを削除
//			db.update("delete from form where id=?", id);
//		}

	public List<EntForm2> selectOne(String name) {
	
		//コンソールに表示
				System.out.println("編集画面を出します");
				//データベースから目的の1件を取り出して、そのままresultDB1に入れる
				List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM form where name=?", name);
				//画面に表示しやすい形のList(resultDB2)を用意
				List<EntForm2> resultDb2 = new ArrayList<EntForm2>();

				//1件ずつピックアップ
				for (Map<String, Object> result1 : resultDb1) {
					//データ1件分を1つのまとまりとするので、EntForm型の「entformdb」を生成
					EntForm2 entformdb = new EntForm2();
					//id、nameのデータをentformdbに移す
					entformdb.setId((int) result1.get("id"));
					entformdb.setName((String) result1.get("name"));
					entformdb.setComment((String) result1.get("comment"));
					entformdb.setYakusyoku((String) result1.get("yakusyoku"));
					entformdb.setBusyo((String) result1.get("busyo"));
					entformdb.setSyumi((String) result1.get("syumi"));
					//移し替えたデータを持ったentformdbを、resultDB2に入れる
					resultDb2.add(entformdb);
				}

				//Controllerに渡す
				return resultDb2;
			}

//			//更新の実行(UPDATE)
//			public void updateDb(Long id, EntForm2 ent) {
//				//コンソールに表示
//				System.out.println("編集の実行");
//				//UPDATEを実行
//				db.update("UPDATE form SET name = ?  WHERE id = ?", ent.getName(), id);
//				db.update("UPDATE form SET comment = ?  WHERE id = ?", ent.getComment(), id);
//				db.update("UPDATE form SET yakusyoku = ?  WHERE id = ?", ent.getYakusyoku(), id);
//				db.update("UPDATE form SET busyo = ?  WHERE id = ?", ent.getBusyo(), id);
//				db.update("UPDATE form SET syumi = ?  WHERE id = ?", ent.getSyumi(), id);
//
//			}
}
