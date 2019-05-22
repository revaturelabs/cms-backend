package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Tag;
import com.revature.service.TagServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class TagControllerImpl implements TagController {
	
	@Autowired
	TagServiceImpl tagService;
	
	@GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/tags/{tagId}")
    public Tag getTag(@PathVariable("tagId") long id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/tags/{tagId}")
    public void deleteTag(@PathVariable("tagId") long id) {
        tagService.delete(id);
    }

    @PostMapping("/tags")
    public long createTag(@RequestBody Tag tag) {
        tagService.save(tag);
        return tag.getTagId();
    }
    
    @PutMapping("/tags")
    public long updateTag(@RequestBody Tag tag) {
    	tagService.save(tag);
    	return tag.getTagId();
    }

}
