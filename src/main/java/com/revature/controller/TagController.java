package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Tag;


public interface TagController {

	ResponseEntity<List<Tag>> findAllTags();
	
	ResponseEntity<Tag> findTagById(long tagId);
	ResponseEntity<Tag> findTagByName(String name);

	ResponseEntity<Tag> deleteTag(Tag tag);
	
	ResponseEntity<Long> createTag(Tag tag);
	ResponseEntity<Long> updateTag(Tag tag);
}
