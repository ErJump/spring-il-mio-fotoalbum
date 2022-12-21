package org.generation.italy.demo.repo;

import org.generation.italy.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
