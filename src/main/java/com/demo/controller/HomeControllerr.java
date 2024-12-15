package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.MyEntity;
import com.demo.repository.MyEntityRepo;

@Controller
public class HomeControllerr {
	private  final MyEntityRepo repo;


	public HomeControllerr(MyEntityRepo repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/")
	public String getPage(Model model) {

		model.addAttribute("welcome", "Hi User!!");
		model.addAttribute("entity",new MyEntity());
		return "Welcome";
	}

	@GetMapping("/takeInput")
	public String takeInput(Model model) {
		model.addAttribute("entity", new MyEntity());

		return "inputPage";
	}

	@PostMapping("/submit")
	public String handleSubmit(@ModelAttribute("entity") MyEntity entity,Model model) {
		repo.save(entity);
		model.addAttribute("submittedEntries",repo.findAll());

		return "inputPage";
	}
}
