package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/class")
@CrossOrigin("*")
public class CategoryApiController {
	
	@Autowired
	private PhotoService pS;
	
	@GetMapping("/by/picture/{id}")
	public List<Category> getCategoriesByPhotoId(@PathVariable("id") int id) {
		return pS.findPhotoById(id).get().getCategories();
	}
}
