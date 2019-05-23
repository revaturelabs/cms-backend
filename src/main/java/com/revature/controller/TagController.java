package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Tag;


public interface TagController {

	List<Tag> findAllTags();
	ResponseEntity<Tag> findTagById(long tagId);
	ResponseEntity<Tag> deleteTag(Tag tag);
	ResponseEntity<Tag> findTagByName(String tagName);
	long saveTag(Tag tag);
}
