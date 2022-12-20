package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo cR;
	
	public void save(Category c) {
		cR.save(c);
	}
	
	public List<Category> findAll() {
		return cR.findAll();
	}
	
	public Optional<Category> findCategoryById(int id) {
		return cR.findById(id);
	}
	
	public void deleteCategoryById(int id) {
		cR.deleteById(id);
	}
}
