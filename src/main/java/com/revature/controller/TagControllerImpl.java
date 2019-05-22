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
import com.revature.service.TagServiceImpl;

@RestController
public class TagControllerImpl implements TagController {
	
	@Autowired
	TagServiceImpl tagService;
	
	@GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/tags/{id}")
    public Tag getTag(@PathVariable("tagId") int id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(@PathVariable("tagId") int id) {
        tagService.delete(id);
    }

    @PostMapping("/tags")
    public long saveTag(@RequestBody Tag tag) {
        tagService.saveOrUpdate(tag);
        return tag.getTagId();
    }

}
