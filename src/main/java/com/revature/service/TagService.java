package com.revature.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Tag;
import com.revature.repository.TagRepository;

@Service
public class TagService {
	
	// Dependency
	@Autowired
	TagRepository tagRepository;
	
		
	//private static Logger logger= Logger.getLogger();
	
	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<Tag>();
		tagRepository.findAll().forEach(tag -> tags.add(tag));
		return tags;
	}
		
	public Tag getTagById(long id) {
        return tagRepository.findById(id).get();
    }

    public void saveOrUpdate(Tag tag) {
    	tag.setUpdated(new Date());
        tagRepository.save(tag);
    }

    public void delete(long id) {
        tagRepository.deleteById(id);
    }

}
