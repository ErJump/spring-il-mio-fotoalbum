package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cS;
	
	@GetMapping("")
	public String index(Model model) {
		List<Category> categories = cS.findAll();
		model.addAttribute("categories", categories);
		return "category-index";
	}
}
