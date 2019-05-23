package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.revature.exception.UrlNotRecognizedException;
import com.revature.model.Content;
import com.revature.model.Tag;
import com.revature.repository.ContentRepository;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
//	@Override
//	public Content newContent(Content content) {
//		Content addedContent = new Content(content.getContentId(), content.getDescription(), content.getTags(), content.getDescription(), content.getCategory(), content.getUrl(), null, null);
//		return contentRepository.newContent(addedContent);
//	}
//
//	@Override
//	public Content findByURL(String url) {
//		return contentRepository.findByUrl(url);
//	}
//
//	@Override
//	public List<Content> findByTag(Tag tag) {
//		return contentRepository.findByTags(tag);
//	}
//
//	@Override
//	public Content findByTagsAndCategory(Tag tag, String category) {
//		return contentRepository.findByTagsAndCategory(tag, category);
//	}

	/**
	 * Delete Content Method:
	 * 1. Receives contentId as a long to specify content to be deleted.
	 * 2. Deletes all content with contentId given in the arguments.
	 */
	@Override
	public void deleteContent(long contentId) {
		contentRepository.deleteById(contentId);
	}
	
	/**
	 * Update Content Method:
	 * 1. Receives Content object with required changes to be updated.
	 * 2. Saves the object replacing and updating the object.
	 */
	@Override
	public Content updateContent(Content content) {
		
		return contentRepository.save(content);
	}
	
	/**
	 * Create New Content Method:
	 * 1. Receives Content object with new information.
	 * 2. Saves the object creating it in contentRepository.
	 */
	@Override
	public Content newContent(Content content) {
		
		return contentRepository.save(content);
	}
	
	/**
	 * Find Content By URL Method:
	 * 1. Receives url as a string.
	 * 2. If Content url is equal to the String url, returns the Content object.
	 * 3. If Content url does not equal String url, returns UrlNotRecognizedException.
	 */
	@Override
	public Content findByUrl(String url) {
		//only used for testing
//		try {
//			throw new UrlNotRecognizedException("url: ssssssss");
//		} catch(UrlNotRecognizedException e) {
//			e.printStackTrace();
//		}
		return contentRepository.findByUrl(url);
	}
	
	/**
	 * Find Content By Tag Method:
	 * 1. Receives Tag objects to search by.
	 * 2. If Content has requested tags, returns the Content object.
	 * 3. If Content does not have requested tags, returns a ContentNotFoundException.
	 */
	@Override
	public List<Content> findByTag(Tag tag) {
		return contentRepository.findByTags(tag);
	}
	
	/**
	 * Find Content By Tags And Category Method:
	 * 1. Receives Tag object and String category.
	 * 2. If Content has 
	 */
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