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
import com.example.demo.entity.EntForm;

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
	
	private SampleDao sampledao = null;

	@Autowired
	public void FormController(SampleDao sampledao) {
		this.sampledao = sampledao;
	}
	
	//完了の処理
	@RequestMapping("/complete")
	public String complete(Model model, Input form) {
	
		EntForm entform = new EntForm();
		entform.setName(form.getName());
		entform.setList(form.getList());
		sampledao.insertDb(entform);
		
			return "complete";
	}
	
	//削除(DELETE)
		@RequestMapping("/del/{id}")
		public String destory(@PathVariable Long id) {
			sampledao.deleteDb(id);
				return "redirect:/form";
		}
	
}
