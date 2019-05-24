package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.dto.CreateContentDto;
import com.revature.model.Content;

public interface ContentController {
	
	ResponseEntity<Content> createContent(CreateContentDto contentDto);
	ResponseEntity<Content> findByUrl(String url);
	ResponseEntity<List<Content>> findByTag(String[] tags);
	ResponseEntity<Content> findByCategory(String category);
	ResponseEntity<Content> findByTagsAndCategory(String[] tags, String category);
	public void deleteContent(long contentId);
	//ResponseEntity<Content> updateContent(Content content);
}
