package com.revature.service;

import java.util.List;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentService {

	public Content newContent(Content content);
	public Content findByContentId(long contentId);
	public Content findByUrl(String url);
	public List<Content> findByTag(String[] tag);
	public Content findByTagsAndCategory(String[] tag, String category);
	public void deleteContent(long contentId);
	public Content updateContent(Content content);
	public Content findByCategory(String category);
}