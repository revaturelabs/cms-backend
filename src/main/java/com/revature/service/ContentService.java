package com.revature.service;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentService {

	public Content newContent(Content content);
	public Content findByURL(String url);
	public Content findByTag(Tag tag);
	public Content findByTagsAndCategory(Tag tag, String category);
	public void deleteContent();
}
