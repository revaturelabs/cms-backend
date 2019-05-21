package com.revature.controller;

import org.springframework.http.ResponseEntity;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentController {
	
	ResponseEntity<Content> createContent(Content content);
	ResponseEntity<Content> findByURL(String url);
	ResponseEntity<Content> findByTag(Tag tags);
	ResponseEntity<Content> findByTagsAndLabel(Tag tags, String url);
	ResponseEntity<String> updateContent(Content content);
	public void deleteContent();


}
