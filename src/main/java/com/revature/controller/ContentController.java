package com.revature.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.revature.dto.CreateContentDto;
import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentController {
	
	ResponseEntity<Content> createContent(CreateContentDto contentDto);
	ResponseEntity<Content> findByUrl(String url);
	ResponseEntity<Set<Content>> findByTagsIgnoreCase(Tag[] tags);
	ResponseEntity<Content> findByCategory(String category);
	ResponseEntity<List<Content>> findByTagsAndCategory(Tag[] tags, String category);
	public void deleteContent(long contentId);
	ResponseEntity<List<Content>> findAllContent();
	//ResponseEntity<Content> updateContent(Content content);
}
