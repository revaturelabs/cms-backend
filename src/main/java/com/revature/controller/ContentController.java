package com.revature.controller;

import org.springframework.http.ResponseEntity;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentController {
	
	ResponseEntity<ClientMessage> createContent(Content content);
	ResponseEntity<ContentList> findByTags(Tag[] tags);
	ResponseEntity<ContentList> findByLabel(String url);
	ResponseEntity<ContentList> findByTagsAndLabel(Tag[] tags, String url);
	ResponseEntity<ClientMessage> updateContent();
	ResponseEntity<ClientMessage> deleteContent();


}
