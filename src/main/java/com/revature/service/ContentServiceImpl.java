package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.repository.ContentRepository;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	public Content newContent(Content content) {
		Content addedContent = new Content(content.getContentId(), content.getTags(), content.getDescription(), content.getCategory(), content.getCreator(), content.getUrl());
		return contentRepository.newContent(addedContent);
	}

	@Override
	public Content findByURL(String url) {
		return contentRepository.findByUrl(url);
	}

	@Override
	public List<Content> findByTag(Tag tag) {
		return contentRepository.findByTags(tag);
	}

	@Override
	public Content findByTagsAndCategory(Tag tag, String category) {
		return contentRepository.findByTagsAndCategory(tag, category);
	}

	@Override
	public void delete() {
		contentRepository.delete();
	}
}
