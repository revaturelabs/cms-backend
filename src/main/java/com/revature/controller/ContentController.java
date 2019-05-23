package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentController {
	
	ResponseEntity<Content> createContent(Content content, String[] tags);
	ResponseEntity<Content> findByUrl(String url);
	ResponseEntity<List<Content>> findByTag(String[] tags);
	ResponseEntity<Content> findByTagsAndCategory(String[] tags, String category);
	public void deleteContent(long contentId);
	//ResponseEntity<Content> updateContent(Content content);
}
