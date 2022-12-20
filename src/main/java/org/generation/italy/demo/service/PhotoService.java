package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.repo.PhotoRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo pR;
	
	public void save(Photo p) {
		pR.save(p);
	}
	
	public List<Photo> findAll() {
		return pR.findAll();
	}
	
	public Optional<Photo> findPhotoById(int id) {
		return pR.findById(id);
	}
	
	public void deletePhotoById(int id) {
		pR.deleteById(id);
	}
	
	@Transactional
	public List<Photo> findAllWCategory() {
		List<Photo> photos = pR.findAll();
		for (Photo p : photos)
			Hibernate.initialize(p.getCategories());
		return photos;
	}
}
