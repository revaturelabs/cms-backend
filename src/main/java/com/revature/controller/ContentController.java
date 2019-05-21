package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentController {
	
	ResponseEntity<Content> createContent(Content content);
	ResponseEntity<Content> findByURL(String url);
	ResponseEntity<List<Content>> findByTag(Tag tags);
	ResponseEntity<Content> findByTagsAndLabel(Tag tags, String url);
	public void deleteContent();


}
