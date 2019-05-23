package com.revature.service;

import java.util.List;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentService {

	public Content newContent(Content content);
	public Content findByContentId(long contentId);
	public Content findByURL(String url);
	public List<Content> findByTag(Tag tag);
	public Content findByTagsAndCategory(Tag tag, String category);
	public void delete();
	public Content updateContent(Content content);
	public Content findByCategory(String category);
}