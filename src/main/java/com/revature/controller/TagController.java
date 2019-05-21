package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Tag;
import com.revature.service.TagService;

@RestController
public class TagController {
	
	// Dependency
	@Autowired
	TagService tagService;
	
	
	//private static Logger logger= Logger.getLogger();
	
	
	//get all
	@GetMapping("/tags")
    private List<Tag> getAllTags() {
        return tagService.getAllTags();
    }
	
	//get by ID
    @GetMapping("/tags/{id}")
    private Tag getTag(@PathVariable("tagId") int id) {
        return tagService.getTagById(id);
    }
    
    //delete
    @DeleteMapping("/tags/{id}")
    private void deleteTag(@PathVariable("tagId") int id) {
        tagService.delete(id);
    }

    //create or update
    @PostMapping("/tags")
    private long saveTag(@RequestBody Tag tag) {
        tagService.saveOrUpdate(tag);
        return tag.getTagId();
    }

}
