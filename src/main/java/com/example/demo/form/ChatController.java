package com.example.demo.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SampleDao;
import com.example.demo.dao.rosterDao;
import com.example.demo.entity.EntForm;
import com.example.demo.entity.EntForm2;

@Controller
public class ChatController {
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "予定確認一覧");
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList",list);
		return "form";
		}

	//予定入力画面！！
	@RequestMapping("/add")
	public String add(Model model, Input form) {
		model.addAttribute("title", "サンプルフォーム");
		return "add";
		}
	
	@RequestMapping("/add2")
	public String add(Model model, Input2 input2) {
		return "add2";
	}
	
	@RequestMapping("/p")
	public String form(Model model,Input2 input2) {
		model.addAttribute("title","プロフィール入力画面");
		return "profile";
	}
	
	
	//名簿一覧画面
	@RequestMapping("/roster")
	public String roster(Model model, Input2 input) {
		//Dao
		List<EntForm2> list = rosterdao.selectOne(input.getName());
		List<EntForm> list2 = sampledao.selectOne(input.getName());
		model.addAttribute("dbList",list);
		model.addAttribute("dbList2",list2);
		model.addAttribute("title","名簿詳細画面");
		return "roster";
	}
	
	
	
	
	
	//確認画面
	@RequestMapping("/confirm")
	public String confirm(@Validated Input input, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("title", "入力ページ");
			return "add";
		}

		model.addAttribute("title", "確認ページ");
			return "confirm";
		}
	@RequestMapping("/confirm2")
	public String confirm(@Validated Input2 input2, BindingResult result, Model model) {

		if(result.hasErrors()) {
		model.addAttribute("title","入力ページ");
		return "profile";
		}

		model.addAttribute("title","確認ページ");
		return "confirm2";
	}
	
	private SampleDao sampledao = null;
	private rosterDao rosterdao = null;

	@Autowired
	public void FormController(SampleDao sampledao, rosterDao rosterdao) {
		this.sampledao = sampledao;
		this.rosterdao = rosterdao;
	}
	
	//完了の処理
	@RequestMapping("/complete")
	public String complete(Model model, Input input) {
	
		EntForm entform = new EntForm();
		
		entform.setName(input.getName());
		entform.setList(input.getList());
		
		
		sampledao.insertDb(entform);
		
			return "complete";
	}
	@RequestMapping("/complete2")
	public String complete(Model model, Input2 input2) {
	
		EntForm2 entform = new EntForm2();
		
		entform.setName(input2.getName());
		entform.setComment(input2.getComment());
		entform.setYakusyoku(input2.getYakusyoku());
		entform.setBusyo(input2.getBusyo());
		entform.setSyumi(input2.getSyumi());
		
		rosterdao.insertDb(entform);
		
			return "complete2";
	}
	
	
	//削除(DELETE)
		@RequestMapping("/del/{id}")
		public String destory(@PathVariable Long id) {
			sampledao.deleteDb(id);
				return "redirect:/form";
		}
		
		//更新画面の表示(SELECT)
		@RequestMapping("/edit/{id}")
		public String editView(@PathVariable Long id, Model model) {

			//DBからデータを1件取ってくる(リストの形)
			List<EntForm> list = sampledao.selectOne(id);

			//リストから、オブジェクトだけをピックアップ
			EntForm entformdb = list.get(0);

			//スタンバイしているViewに向かって、データを投げる
			model.addAttribute("form", entformdb);
			model.addAttribute("title", "編集ページ");
				return "edit";
		}
				
		//更新処理(UPDATE)
		@RequestMapping("/edit/{id}/exe")
		public String editExe(@PathVariable Long id, Model model, Input form) {
					
			//フォームの値をエンティティに入れ直し
			EntForm entform = new EntForm();
			System.out.println(form.getName());//取得できているかの確認
			System.out.println(form.getList());
			entform.setName(form.getName());
			entform.setList(form.getList());
			
			//更新の実行
			sampledao.updateDb(id,entform);
					
			//一覧画面へリダイレクト
			return "redirect:/form";
		} 
	
}
