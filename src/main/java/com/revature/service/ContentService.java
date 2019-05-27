package com.revature.service;

import java.util.List;

import com.revature.model.Content;
import com.revature.model.Tag;

public interface ContentService {

	public Content newContent(Content content);
	public Content findByContentId(long contentId);
	/**
	 * Find Content By URL Method:
	 * 1. Receives url as a string.
	 * 2. If Content url is equal to the String url, returns the Content object.
	 * 3. If Content url does not equal String url, returns UrlNotRecognizedException.
	 * 
	 * @param url
	 * @return
	 */
	public Content findByUrl(String url);
	/**
	 * Delete Content Method:
	 * 1. Receives contentId as a long to specify content to be deleted.
	 * 2. Deletes all content with contentId given in the arguments.
	 * 
	 * @param contentId
	 * @return
	 * 
	 */
	public void deleteContent(long contentId);
	List<Tag> findTagsByContentId(long contentId);
	public Content updateContent(Content content);
	public Content findByCategory(String category);
	List<Content> findByTags(Tag[] tag);
	List<Content> findByTagsAndCategory(Tag[] tag, String category);
	List<Content> findAllContent();
	void delete();
}