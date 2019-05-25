package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.repository.ContentRepository;
import com.revature.repository.TagRepository;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private TagRepository tagRepository;

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
	public List<Content> findByTags(Tag[] tags) {
		List<Content> contentList = new ArrayList<>();
		for (Tag t : tags) {
			contentList.addAll(contentRepository.findByTags(t.getTagName()));
		}
		return contentList;
	}

	@ReadOnlyProperty
	@Override
	public List<Content> findByTagsAndCategory(Tag[] tags, String category) {
		List<Content> contentList = new ArrayList<>();
		for(Tag t : tags) {
			contentList.addAll(contentRepository.findByTagsAndCategory(t.getTagName(), category));
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
		//contentRepository.delete(contentId);
	}

	
	@Override
	public List<Content> findAllContent() {
		return contentRepository.findAll();
	}

	@Override
	public List<Tag> findTagsByContentId(long contentId) {
		List<Tag> tagsList = tagRepository.findByContentId(contentId);
		return tagsList;
	}
}