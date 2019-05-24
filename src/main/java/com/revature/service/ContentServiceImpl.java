package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.UrlNotRecognizedException;
import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.repository.ContentRepository;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	public void delete() {
		
	}
	@Override
	public Content updateContent(Content content) {
		
		return contentRepository.save(content);
	}
	@Override
	public Content newContent(Content content) {
		
		return contentRepository.save(content);
	}
	
	@Override
	public Content findByURL(String url) {
		//only used for testing
//		try {
//			throw new RuntimeException("url: ssssssss");
//		} catch(UrlNotRecognizedException e) {
//			e.printStackTrace();
//		}
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
	public Content findByCategory(String category) {
		return contentRepository.findByCategory(category);
	}
	@Override
	public Content findByContentId(long contentId) {
		return contentRepository.findByContentId(contentId);
	}
}