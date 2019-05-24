package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

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
	public Content findByUrl(String url) {
		return contentRepository.findByUrl(url);
	}
	
	@ReadOnlyProperty
	@Override
	public List<Content> findByTags(Tag[] tag) {
		List<Content> contentList = new ArrayList<>();
		for(Tag t : tag) {
			contentList.addAll(contentRepository.findByTags(t.getTagName()));
		}
		return contentList;
	}
	
	@ReadOnlyProperty
	@Override
	public List<Content> findByTagsAndCategory(Tag[] tag, String category) {
		List<Content> contentList = new ArrayList<>();
		for(Tag t : tag) {
			contentList.addAll(contentRepository.findByTagsAndCategory(t, category));
		}
		return contentList;
	}
	
	@Override
	public Content findByCategory(String category) {
		return contentRepository.findByCategory(category);
	}
	
	@Override
	public Content findByContentId(long contentId) {
		return contentRepository.findByContentId(contentId);
	}

	@Override
	public void deleteContent(long contentId) {
		// TODO Auto-generated method stub
		
	}
}