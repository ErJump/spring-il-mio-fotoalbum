package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepo cR;
	
	public Comment save(Comment comment) {
		return cR.save(comment);
	}
	
	public List<Comment> findAll() {
		return cR.findAll();
	}
	
	public Optional<Comment> findCommentById(int id) {
		return cR.findById(id);
	}
}
