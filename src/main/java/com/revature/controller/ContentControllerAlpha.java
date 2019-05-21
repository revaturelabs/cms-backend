package com.revature.controller;

import org.springframework.http.ResponseEntity;

import com.revature.model.Content;

public class ContentControllerAlpha implements ContentController {

	@Override
	public ResponseEntity<ClientMessage> createContent(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContentList> findByTags(Tag[] tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContentList> findByLabel(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContentList> findByTagsAndLabel(Tag[] tags, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ClientMessage> updateContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ClientMessage> deleteContent() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
