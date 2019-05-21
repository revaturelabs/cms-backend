package com.revature.repository;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentRepository {

	public Content newContent(Content content);
	public Content findByURL(String url);
	public Content findByTag(Tag tag);
	public Content findByTagsAndCategory(Tag tag, String category);
	public void deleteContent();
}
