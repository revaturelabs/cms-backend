package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.repository.ContentRepository;

public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	public Content newContent(Content content) {
		Content addedContent = new Content(content.getContentId(), content.getTags(), content.getDescription(), content.getLabel(), content.getCreator(), content.getUrl());
		return contentRepository.newContent(addedContent);
	}

	@Override
	public Content findByURL(String url) {
		return contentRepository.findByURL(url);
	}

	@Override
	public Content findByTag(Tag tag) {
		return contentRepository.findByTag(tag);
	}

	@Override
	public Content findByTagsAndCategory(Tag tag, String category) {
		return contentRepository.findByTagsAndCategory(tag, category);
	}

	@Override
	public void deleteContent() {
		contentRepository.deleteContent();
	}

	
}
